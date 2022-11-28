package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;

import java.util.ArrayList;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorProtoss implements Jugador {

    private static final int MAX_POBLACION = 200;
    private static final int CANT_MINERAL_INICIAL = 200;
    private static final int CUPO_ZEALOT = 2;
    private static final int CUPO_DRAGON = 3;
    private static final int CUPO_SCOUT = 4;

    private String nombre;
    private String color;
    private ArrayList<Raza> unidades;
    private ArrayList<Raza> edificios;
    private Recursos recursos;
    private int poblacion;
    private int cupo;

    private int cantidadDePilones;
    private int cantidadDeZealots;
    private int cantidadDeDragones;
    private int cantidadDeScouts;

    public JugadorProtoss(String unNombre, String unColor) {
        this.nombre = unNombre;
        this.color = unColor;
        this.unidades = new ArrayList<Raza>();
        this.edificios = new ArrayList<Raza>();
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.poblacion = 0;
        this.cupo = 0;

        this.cantidadDePilones = 0;
        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;
    }

    // Constructor utilizado unicamente para simplificar pruebas.
    public JugadorProtoss(String unNombre, String unColor, Recursos unosRecursos) {
        this.nombre = unNombre;
        this.color = unColor;
        this.unidades = new ArrayList<Raza>();
        this.edificios = new ArrayList<Raza>();
        this.recursos = unosRecursos;
        this.poblacion = 0;
        this.cupo = 0;

        this.cantidadDePilones = 0;
        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;
    }

    public void crearNexoMineral(Ubicacion unaUbicacion, NodoMineral unNodo) {
        this.edificios.add(new NexoMineral(unNodo, this.recursos)); // Falta refactorizar para recibir la ubicacion.
    }

    public void crearPilon(Ubicacion unaUbicacion) {
        this.edificios.add(new Pilon(this.recursos)); // Falta refactorizar para recibir la ubicacion.
        this.cantidadDePilones++;
        this.incrementarPoblacion(5);
    }

    public void crearAsimilador(Ubicacion unaUbicacion, Volcan unVolcan) {
        this.edificios.add(new Asimilador(unVolcan, this.recursos)); // Falta refactorizar para recibir la ubicacion.
    }

    public void crearAcceso(Ubicacion unaUbicacion) {
        this.edificios.add(new Acceso(this.recursos)); // Falta refactorizar para recibir la ubicacion.
    }

    public void crearPuertoEstelar(Ubicacion unaUbicacion) {
        this.edificios.add(new PuertoEstelar(this.recursos)); // Falta refactorizar para recibir la ubicacion.
    }

    // Falta el llamado al constructor de la unidad y guardarla.
    public void crearZealot() {

        if (!this.hayCupoDisponible(CUPO_ZEALOT)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZealots++;
        this.incrementarCupo(CUPO_ZEALOT);
    }

    // Falta el llamado al constructor de la unidad y guardarla.
    public void crearDragon() {
        if (!this.hayCupoDisponible(CUPO_DRAGON)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeDragones++;
        this.incrementarCupo(CUPO_DRAGON);
    }

    // Falta el llamado al constructor de la unidad y guardarla.
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

    public int poblacion() {
        return this.poblacion;
    }

    // El cupo debe ser siempre menor al valor de poblacion.
    private void incrementarCupo(int unIncremento) {
        if (this.cupo + unIncremento <= this.poblacion) {
            this.cupo += unIncremento;
        }
    }

    // La poblacion debe ser siempre menor al valor maximo de poblacion.
    private void incrementarPoblacion(int unIncremento) {
        if (this.poblacion + unIncremento <= MAX_POBLACION) {
            this.poblacion += unIncremento;
        }
    }

    private boolean hayCupoDisponible(int unCupo) {
        return (this.cupo + unCupo <= this.poblacion);
    }

    public void destruirPilon() {
        if (this.cantidadDePilones > 0) {
            this.cantidadDePilones--;
            this.cupo-=5;
        }
    }
}