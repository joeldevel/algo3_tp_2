package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.*;

import java.util.ArrayList;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorZerg implements Jugador {

    private static final int MAX_POBLACION = 200;
    private static final int CAP_POBLACION = 5;
    private static final int CANT_MINERAL_INICIAL = 200;
    private static final int CUPO_AMO = 0;
    private static final int CUPO_ZANGANO = 1;
    private static final int CUPO_ZERLING = 1;
    private static final int CUPO_HIDRALISCO = 2;
    private static final int CUPO_MUTALISCO = 4;

    private String nombre;
    private String color;
    private Recursos recursos;
    private int cupo;

    private int cantidadDeAmos;
    private int cantidadDeZanganos;
    private int cantidadDeZerlings;
    private int cantidadDeHidraliscos;
    private int cantidadDeMutaliscos;
    private int cantidadDeGuardianes;
    private int cantidadDeDevoradores;

    private ArrayList<Edificio> edificios;
    private ArrayList<Edificio> criaderos;
    private ArrayList<Unidad> amosSupremos;
    private ArrayList<Unidad> unidades;

    public JugadorZerg(String unNombre, String unColor) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.cupo = 0;

        this.cantidadDeAmos = 0;
        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
        this.cantidadDeGuardianes = 0;
        this.cantidadDeDevoradores = 0;

        this.edificios = new ArrayList<Edificio>();
        this.criaderos = new ArrayList<Edificio>();
        this.amosSupremos = new ArrayList<Unidad>();
        this.unidades = new ArrayList<Unidad>();
    }

    // Constructor utilizado unicamente para pruebas debido a los recursos.
    public JugadorZerg(String unNombre, String unColor, Recursos unosRecursos) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = unosRecursos;
        this.cupo = 0;

        this.cantidadDeAmos = 0;
        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
        this.cantidadDeGuardianes = 0;
        this.cantidadDeDevoradores = 0;

        this.edificios = new ArrayList<Edificio>();
        this.criaderos = new ArrayList<Edificio>();
        this.amosSupremos = new ArrayList<Unidad>();
        this.unidades = new ArrayList<Unidad>();
    }

    public Criadero crearCriadero(Ubicacion unaUbicacion) {
        Criadero criadero = new Criadero(this.recursos, unaUbicacion);
        this.edificios.add(criadero);
        this.criaderos.add(criadero);
        return criadero;
    }

    public void crearReservaDeProduccion(Ubicacion unaUbicacion) {
        this.edificios.add(new ReservaDeProduccion(this.recursos, unaUbicacion));
    }

    public void crearExtractor(Ubicacion unaUbicacion, Volcan unVolcan) {
        this.edificios.add(new Extractor(unVolcan, this.recursos, unaUbicacion));
    }

    public void crearGuarida(Ubicacion unaUbicacion) {
        this.edificios.add(new Guarida(this.recursos, unaUbicacion));
    }

    public void crearEspiral(Ubicacion unaUbicacion) {
        this.edificios.add(new Espiral(this.recursos, unaUbicacion));
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

        if (!this.hayCupoDisponible(CUPO_ZANGANO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZanganos++;
        this.incrementarCupo(CUPO_ZANGANO);
    }

    // Falta enviar el mensaje al edificio ReservaDeReproduccion que permite instanciar Zerling.
    public void crearZerling() {

        if (!this.hayCupoDisponible(CUPO_ZERLING)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZerlings++;
        this.incrementarCupo(CUPO_ZERLING);
    }

    // Falta enviar el mensaje al edificio Guarida que permite instanciar Hidralisco.
    public void crearHidralisco() {

        if (!this.hayCupoDisponible(CUPO_HIDRALISCO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeHidraliscos++;
        this.incrementarCupo(CUPO_HIDRALISCO);
    }

    // Falta enviar el mensaje al edificio Espiral que permite instanciar Mutalisco.
    public void crearMutalisco() {

        if (!this.hayCupoDisponible(CUPO_MUTALISCO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeMutaliscos++;
        this.incrementarCupo(CUPO_MUTALISCO);
    }

    // Falta enviar el mensaje que permite instanciar Guardian (evolucion de Mutalisco).
    public void crearGuardian() {

        if (!this.hayCupoDisponible(CUPO_MUTALISCO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeGuardianes++;
        this.incrementarCupo(CUPO_MUTALISCO);
    }

    // Falta enviar el mensaje que permite instanciar Devorador (evolucion de Mutalisco).
    public void crearDevorador() {

        if (!this.hayCupoDisponible(CUPO_MUTALISCO)) {
            throw new CupoSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeDevoradores++;
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

    // La poblacion debe ser siempre menor al valor maximo de poblacion.
    public int calcularPoblacion() {
        int poblacion = (this.criaderos.size() * CAP_POBLACION) + (this.amosSupremos.size() * CAP_POBLACION);

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

        ArrayList<Edificio> edificiosABorrar = new ArrayList<Edificio>(); // Necesitamos una lista por fuera ya que no se puede modificar la lista en medio de la iteracion.

        for (Edificio edificio : this.edificios) {
            if (edificio.obtenerVida() == 0) {
                edificiosABorrar.add(edificio);
            } else {
                edificio.avanzarTurno(); // Pilon energiza, Asimilador recolecta gas, Nexo Mineral recolecta mineral, se recuperan, pasa el tiempo de construccion.
            }
        }

        this.edificios.removeAll(edificiosABorrar);
        this.criaderos.removeAll(edificiosABorrar); // Borramos los Criaderos de su lista concreta para poder calcular la poblacion correctamente.

        ArrayList<Unidad> unidadesABorrar = new ArrayList<Unidad>();

        for (Unidad unidad : this.unidades) {
            if (unidad.obtenerVida() == 0) {
                unidadesABorrar.add(unidad);
            } else {
                unidad.avanzarTurno(); // Se recuperan, pasa el tiempo de construccion.
            }
        }

        this.unidades.removeAll(unidadesABorrar);
        this.amosSupremos.removeAll(unidadesABorrar); // Borramos los Amos Supremos de su lista concreta para poder calcular la poblacion correctamente.
    }
}