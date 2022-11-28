package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;

import java.util.ArrayList;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorZerg implements Jugador {

    private static final int MAX_POBLACION = 200;
    private static final int CANT_MINERAL_INICIAL = 200;
    private static final int CUPO_ZANGANO = 1;
    private static final int CUPO_ZERLING = 1;
    private static final int CUPO_HIDRALISCO = 2;
    private static final int CUPO_MUTALISCO = 4;

    private String nombre;
    private String color;
    private ArrayList<Raza> unidades;
    private ArrayList<Raza> edificios;
    private Recursos recursos;
    private int poblacion;
    private int cupo;

    private int cantidadDeZanganos;
    private int cantidadDeZerlings;
    private int cantidadDeHidraliscos;
    private int cantidadDeMutaliscos;

    public JugadorZerg(String unNombre, String unColor) {
        this.nombre = unNombre;
        this.color = unColor;
        this.unidades = new ArrayList<Raza>();
        this.edificios = new ArrayList<Raza>();
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.poblacion = 0;
        this.cupo = 0;

        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
    }

    // Constructor utilizado unicamente para pruebas debido a los recursos.
    public JugadorZerg(String unNombre, String unColor, Recursos unosRecursos) {
        this.nombre = unNombre;
        this.color = unColor;
        this.unidades = new ArrayList<Raza>();
        this.edificios = new ArrayList<Raza>();
        this.recursos = unosRecursos;
        this.poblacion = 0;
        this.cupo = 0;

        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
    }

    public void crearCriadero(Ubicacion unaUbicacion) {
        this.edificios.add(new Criadero(this.recursos, unaUbicacion));
        this.incrementarPoblacion(5);
    }

    public void crearReservaDeProduccion(Ubicacion unaUbicacion) {
        this.edificios.add(new ReservaDeProduccion(this.recursos)); // Falta refactorizar para recibir la ubicacion.
    }

    public void crearExtractor(Ubicacion unaUbicacion, Volcan unVolcan) {
        this.edificios.add(new Extractor(unVolcan, this.recursos)); // Falta refactorizar para recibir la ubicacion.
    }

    public void crearGuarida(Ubicacion unaUbicacion) {
        this.edificios.add(new Guarida(this.recursos)); // Falta refactorizar para recibir la ubicacion.
    }

    public void crearEspiral(Ubicacion unaUbicacion) {
        this.edificios.add(new Espiral(this.recursos)); // Falta refactorizar para recibir la ubicacion.
    }

    // Falta el llamado al constructor de la unidad y guardarla.
    public void crearZangano() {

        if (!this.hayCupoDisponible(CUPO_ZANGANO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZanganos++;
        this.incrementarCupo(CUPO_ZANGANO);
    }

    // Falta el llamado al constructor de la unidad y guardarla.
    public void crearZerling() {

        if (!this.hayCupoDisponible(CUPO_ZERLING)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZerlings++;
        this.incrementarCupo(CUPO_ZERLING);
    }

    // Falta el llamado al constructor de la unidad y guardarla.
    public void crearHidralisco() {

        if (!this.hayCupoDisponible(CUPO_HIDRALISCO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeHidraliscos++;
        this.incrementarCupo(CUPO_HIDRALISCO);
    }

    // Falta el llamado al constructor de la unidad y guardarla.
    public void crearMutalisco() {

        if (!this.hayCupoDisponible(CUPO_MUTALISCO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeMutaliscos++;
        this.incrementarCupo(CUPO_MUTALISCO);
    }

    public int cantidadDeUnidades(UNIDADES_ZERG tipoUnidad) {
        if (tipoUnidad == UNIDADES_ZERG.ZANGANO) {
            return this.cantidadDeZanganos;
        }
        if (tipoUnidad == UNIDADES_ZERG.ZERLING) {
            return this.cantidadDeZerlings;
        }
        if (tipoUnidad == UNIDADES_ZERG.HIDRALISCO) {
            return this.cantidadDeHidraliscos;
        }
        if (tipoUnidad == UNIDADES_ZERG.MUTALISCO) {
            return this.cantidadDeMutaliscos;
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
}