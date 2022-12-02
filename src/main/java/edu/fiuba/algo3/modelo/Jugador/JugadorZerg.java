package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.CUPO_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Devorador.SUMINISTRO_DEVORADOR;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.SUMINISTRO_GUARDIAN;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.SUMINISTRO_HIDRALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.SUMINISTRO_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.SUMINISTRO_ZANGANO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorZerg implements Jugador {

    private static final int MAX_POBLACION = 200;
    private static final int CANT_MINERAL_INICIAL = 200;

    private String nombre;
    private String color;
    private Recursos recursos;
    private int poblacion;
    private int cupo;

    private int cantidadDeAmos;
    private int cantidadDeZanganos;
    private int cantidadDeZerlings;
    private int cantidadDeHidraliscos;
    private int cantidadDeMutaliscos;
    private int cantidadDeGuardianes;
    private int cantidadDeDevoradores;

    private ArrayList<Edificio> edificios;
    private ArrayList<Unidad> unidades;

    public JugadorZerg(String unNombre, String unColor) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.poblacion = 0;
        this.cupo = 0;

        this.cantidadDeAmos = 0;
        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
        this.cantidadDeGuardianes = 0;
        this.cantidadDeDevoradores = 0;

        this.edificios = new ArrayList<Edificio>();
        this.unidades = new ArrayList<Unidad>();
    }

    // Constructor utilizado unicamente para pruebas debido a los recursos.
    public JugadorZerg(String unNombre, String unColor, Recursos unosRecursos) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = unosRecursos;
        this.poblacion = 0;
        this.cupo = 0;

        this.cantidadDeAmos = 0;
        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
        this.cantidadDeGuardianes = 0;
        this.cantidadDeDevoradores = 0;

        this.edificios = new ArrayList<Edificio>();
        this.unidades = new ArrayList<Unidad>();
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

    public Criadero crearCriadero(Ubicacion unaUbicacion) {
        Criadero criadero = new Criadero(unaUbicacion, this);
        this.edificios.add(criadero);
        return criadero;
    }

    public void crearReservaDeProduccion(Ubicacion unaUbicacion) {
        this.edificios.add(new ReservaDeProduccion(unaUbicacion, this));
    }

    public void crearExtractor(Ubicacion unaUbicacion, Volcan unVolcan) {
        this.edificios.add(new Extractor(unVolcan, unaUbicacion, this));
    }

    public void crearGuarida(Ubicacion unaUbicacion) {
        this.edificios.add(new Guarida(unaUbicacion, this));
    }

    public void crearEspiral(Ubicacion unaUbicacion) {
        this.edificios.add(new Espiral(unaUbicacion, this));
    }

    // Falta enviar el mensaje que permite instanciar Amo Supremo.
    public void crearAmoSupremo() {

        if (!this.hayCupoDisponible(CUPO_AMO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeAmos++;
        this.incrementarCupo(CUPO_AMO);
    }

    // Falta enviar el mensaje al edificio Criadero que permite instanciar Zangano.
    public void crearZangano() {

        if (!this.hayCupoDisponible(SUMINISTRO_ZANGANO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZanganos++;
        this.incrementarCupo(SUMINISTRO_ZANGANO);
    }

    // Falta enviar el mensaje al edificio ReservaDeReproduccion que permite instanciar Zerling.
    public void crearZerling() {

        if (!this.hayCupoDisponible(SUMINISTRO_ZERLING)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZerlings++;
        this.incrementarCupo(SUMINISTRO_ZERLING);
    }

    // Falta enviar el mensaje al edificio Guarida que permite instanciar Hidralisco.
    public void crearHidralisco() {

        if (!this.hayCupoDisponible(SUMINISTRO_HIDRALISCO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeHidraliscos++;
        this.incrementarCupo(SUMINISTRO_HIDRALISCO);
    }

    // Falta enviar el mensaje al edificio Espiral que permite instanciar Mutalisco.
    public void crearMutalisco() {

        if (!this.hayCupoDisponible(SUMINISTRO_MUTALISCO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeMutaliscos++;
        this.incrementarCupo(SUMINISTRO_MUTALISCO);
    }

    // Falta enviar el mensaje que permite instanciar Guardian (evolucion de Mutalisco).
    public void crearGuardian() {

        if (!this.hayCupoDisponible(SUMINISTRO_GUARDIAN)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeGuardianes++;
        this.incrementarCupo(SUMINISTRO_GUARDIAN);
    }

    // Falta enviar el mensaje que permite instanciar Devorador (evolucion de Mutalisco).
    public void crearDevorador() {

        if (!this.hayCupoDisponible(SUMINISTRO_DEVORADOR)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeDevoradores++;
        this.incrementarCupo(SUMINISTRO_DEVORADOR);
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

    // La poblacion debe ser siempre menor al valor maximo de poblacion.
    public int calcularPoblacion() {
        int poblacion = 0;

        for (Edificio edificio : this.edificios) {
            poblacion += edificio.obtenerPoblacion();
        }

        for (Unidad unidad : this.unidades) {
            poblacion += unidad.obtenerPoblacion();
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

        for (Edificio edificio : this.edificios) {
            edificio.avanzarTurno(); // Edificios: Criadero expande el moho, Extractor recolecta gas, Zangano recolecta mineral, se recuperan, pasa el tiempo de construccion.
        }

        for (Unidad unidad : this.unidades) {
            unidad.avanzarTurno(); // Unidades: Se recuperan, pasa el tiempo de construccion.
        }
    }

    @Override
    public void eliminarEdificio(Edificio unEdificio) {
        this.poblacion -= unEdificio.obtenerPoblacion();
        this.edificios.remove(unEdificio);
    }

    @Override
    public void eliminarUnidad(Unidad unaUnidad) {
        this.poblacion -= unaUnidad.obtenerPoblacion();
        this.unidades.remove(unaUnidad);
    }
}