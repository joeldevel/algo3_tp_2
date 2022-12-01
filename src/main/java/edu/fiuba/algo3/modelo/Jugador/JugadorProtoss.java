package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CUPO_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.CUPO_SCOUT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.CUPO_ZEALOT;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorProtoss implements Jugador {

    private static final int MAX_POBLACION = 200;
    private static final int CAP_POBLACION = 5;
    private static final int CANT_MINERAL_INICIAL = 200;

    private String nombre;
    private String color;
    private Recursos recursos;
    private int cupo;

    private int cantidadDeZealots;
    private int cantidadDeDragones;
    private int cantidadDeScouts;

    private ArrayList<Edificio> edificios;
    private ArrayList<Edificio> pilones;
    private ArrayList<Unidad> unidades;

    public JugadorProtoss(String unNombre, String unColor) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.cupo = 0;

        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;

        this.edificios = new ArrayList<Edificio>();
        this.pilones = new ArrayList<Edificio>();
        this.unidades = new ArrayList<Unidad>();
    }

    // Constructor utilizado unicamente para simplificar pruebas.
    public JugadorProtoss(String unNombre, String unColor, Recursos unosRecursos) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = unosRecursos;
        this.cupo = 0;

        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;

        this.edificios = new ArrayList<Edificio>();
        this.pilones = new ArrayList<Edificio>();
        this.unidades = new ArrayList<Unidad>();
    }

    public void crearNexoMineral(Ubicacion unaUbicacion, NodoMineral unNodo) {
        this.edificios.add(new NexoMineral(unNodo, this.recursos, unaUbicacion));
    }

    public Pilon crearPilon(Ubicacion unaUbicacion) {
        Pilon pilon = new Pilon(this.recursos, unaUbicacion);
        this.edificios.add(pilon);
        this.pilones.add(pilon);
        return pilon;
    }

    public void crearAsimilador(Ubicacion unaUbicacion, Volcan unVolcan) {
        this.edificios.add(new Asimilador(unVolcan, this.recursos, unaUbicacion));
    }

    public void crearAcceso(Ubicacion unaUbicacion) {
        this.edificios.add(new Acceso(this.recursos, unaUbicacion));
    }

    public void crearPuertoEstelar(Ubicacion unaUbicacion) {
        this.edificios.add(new PuertoEstelar(this.recursos, unaUbicacion));
    }

    // Falta enviar el mensaje al edificio Acceso que permite instanciar Zealot.
    public void crearZealot() {

        if (!this.hayCupoDisponible(CUPO_ZEALOT)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZealots++;
        this.incrementarCupo(CUPO_ZEALOT);
    }

    // Falta enviar el mensaje al edificio Acceso que permite instanciar Dragon.
    public void crearDragon() {
        if (!this.hayCupoDisponible(CUPO_DRAGON)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeDragones++;
        this.incrementarCupo(CUPO_DRAGON);
    }

    // Falta enviar el mensaje al edificio PuertoEstelar que permite instanciar Scout.
    public void crearScout() {
        if (!this.hayCupoDisponible(CUPO_SCOUT)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeScouts++;
        this.incrementarCupo(CUPO_SCOUT);
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
        int poblacion = (this.pilones.size() * CAP_POBLACION);

        if(poblacion >= MAX_POBLACION) {
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

        ArrayList<Edificio> edificiosABorrar = new ArrayList<Edificio>(); // Necesitamos una lista por fuera ya que no se puede modificar la lista en medio de la iteracion.

        for(Edificio edificio : this.edificios) {
            if(edificio.obtenerVida() == 0) {
                edificiosABorrar.add(edificio);
            } else {
                edificio.avanzarTurno(); // Pilon energiza, Asimilador recolecta gas, NexoMineral recolecta mineral, se recuperan, pasa el tiempo de construccion.
            }
        }

        this.edificios.removeAll(edificiosABorrar);
        this.pilones.removeAll(edificiosABorrar); // Borramos los pilones de su lista concreta para poder calcular la poblacion correctamente.

        ArrayList<Unidad> unidadesABorrar = new ArrayList<Unidad>();

        for(Unidad unidad : this.unidades) {
            if(unidad.obtenerVida() == 0) {
                unidadesABorrar.add(unidad);
            } else {
                unidad.avanzarTurno(); // Se recuperan, pasa el tiempo de construccion.
            }
        }

        this.unidades.removeAll(unidadesABorrar);
    }
}