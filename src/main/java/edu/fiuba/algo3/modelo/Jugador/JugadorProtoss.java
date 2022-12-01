package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.SUMINISTRO_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.SUMINISTRO_SCOUT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.SUMINISTRO_ZEALOT;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorProtoss implements Jugador {

    private static final int MAX_POBLACION = 200;
    private static final int CANT_MINERAL_INICIAL = 200;

    private String nombre;
    private String color;
    private Recursos recursos;
    private int poblacion;
    private int cupo;

    private int cantidadDeZealots;
    private int cantidadDeDragones;
    private int cantidadDeScouts;

    private ArrayList<Raza> entidades;

    public JugadorProtoss(String unNombre, String unColor) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.poblacion = 0;
        this.cupo = 0;

        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;

        this.entidades = new ArrayList<Raza>();
    }

    // Constructor utilizado unicamente para simplificar pruebas.
    public JugadorProtoss(String unNombre, String unColor, Recursos unosRecursos) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = unosRecursos;
        this.poblacion = 0;
        this.cupo = 0;

        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;

        this.entidades = new ArrayList<Raza>();
    }

    @Override
    public void guardar(int costoGas, int costoMineral) {
        this.recursos.guardar(costoGas, costoMineral);
    }

    @Override
    public void utilizar(int costoGas, int costoMineral) {
        this.recursos.utilizar(costoGas, costoMineral);
    }

    @Override
    public int obtenerGas() {
        return this.recursos.obtenerGas();
    }

    @Override
    public int obtenerMineral() {
        return this.recursos.obtenerMineral();
    }

    public void crearNexoMineral(Ubicacion unaUbicacion, NodoMineral unNodo) {
        this.entidades.add(new NexoMineral(unNodo, unaUbicacion, this));
    }

    public Pilon crearPilon(Ubicacion unaUbicacion) {
        Pilon pilon = new Pilon(unaUbicacion, this);
        this.entidades.add(pilon);
        return pilon;
    }

    public void crearAsimilador(Ubicacion unaUbicacion, Volcan unVolcan) {
        this.entidades.add(new Asimilador(unVolcan, unaUbicacion, this));
    }

    public void crearAcceso(Ubicacion unaUbicacion) {
        this.entidades.add(new Acceso(unaUbicacion, this));
    }

    public void crearPuertoEstelar(Ubicacion unaUbicacion) {
        this.entidades.add(new PuertoEstelar(unaUbicacion, this));
    }

    // Falta enviar el mensaje al edificio Acceso que permite instanciar Zealot.
    public void crearZealot() {

        if (!this.hayCupoDisponible(SUMINISTRO_ZEALOT)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZealots++;
        this.incrementarCupo(SUMINISTRO_ZEALOT);
    }

    // Falta enviar el mensaje al edificio Acceso que permite instanciar Dragon.
    public void crearDragon() {
        if (!this.hayCupoDisponible(SUMINISTRO_DRAGON)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeDragones++;
        this.incrementarCupo(SUMINISTRO_DRAGON);
    }

    // Falta enviar el mensaje al edificio PuertoEstelar que permite instanciar Scout.
    public void crearScout() {
        if (!this.hayCupoDisponible(SUMINISTRO_SCOUT)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeScouts++;
        this.incrementarCupo(SUMINISTRO_SCOUT);
    }

    public int cantidadDeUnidades(UNIDADES_PROTOSS tipoUnidad) {
        if (tipoUnidad == UNIDADES_PROTOSS.ZEALOT) {
            return this.cantidadDeZealots;
        }
        if (tipoUnidad == UNIDADES_PROTOSS.DRAGON) {
            return this.cantidadDeDragones;
        }
        if (tipoUnidad == UNIDADES_PROTOSS.SCOUT) {
            return this.cantidadDeScouts;
        }
        return 0;
    }

    // La poblacion debe ser siempre menor al valor maximo de poblacion.
    public int calcularPoblacion() {
        int poblacion = 0;

        for (Raza entidad : this.entidades) {
            poblacion += entidad.obtenerPoblacion();
        }

        if (poblacion >= MAX_POBLACION) {
            return MAX_POBLACION;
        }

        return poblacion;
    }

    // El cupo debe ser siempre menor al valor de poblacion.
    private void incrementarCupo(int unIncremento) {
        if (this.cupo + unIncremento <= this.calcularPoblacion()) {
            this.cupo += unIncremento;
        }
    }

    private boolean hayCupoDisponible(int unCupo) {
        return (this.cupo + unCupo <= this.calcularPoblacion());
    }

    public void avanzarTurno() {

        for (Raza entidad : this.entidades) {
            entidad.avanzarTurno(); // Edificios: Pilon energiza, Asimilador recolecta gas, Nexo Mineral recolecta mineral, se recuperan, pasa el tiempo de construccion. Unidades: Se recuperan, pasa el tiempo de construccion.
        }
    }

    @Override
    public void eliminar(Raza unaEntidad) {
        this.poblacion -= unaEntidad.obtenerPoblacion();
        this.entidades.remove(unaEntidad);
    }
}