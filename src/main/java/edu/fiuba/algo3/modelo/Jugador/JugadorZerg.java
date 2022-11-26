package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.SinCupoSuficienteException;
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

    public void crearZangano() {
        if (!this.sePuedeCrearUnidad(1)) {
            return;
        }
        if (this.cupo < 1) {
            throw new SinCupoSuficienteException("Se necesita 1 cupo");
        }
        this.cupo -= 1;
        this.cantidadDeZanganos++;
        this.incrementarPoblacion(1);
    }

    public void crearZerling() {
        if (!this.sePuedeCrearUnidad(1)) {
            return;
        }
        if (this.cupo < 1) {
            throw new SinCupoSuficienteException("Se necesita 1 cupo");
        }
        this.cupo -= 1;
        this.cantidadDeZerlings++;
        this.incrementarPoblacion(1);
    }

    public void crearHidralisco() {
        if (!this.sePuedeCrearUnidad(2)) {
            return;
        }
        if (this.cupo < 2) {
            throw new SinCupoSuficienteException("Se necesita 2 cupos");
        }
        this.cupo -= 2;
        this.cantidadDeHidraliscos++;
        this.incrementarPoblacion(2);
    }

    public void crearMutalisco() {
        if (!this.sePuedeCrearUnidad(4)) {
            return;
        }
        if (this.cupo < 4) {
            throw new SinCupoSuficienteException("Se necesita 4 cupos");
        }
        this.cupo -= 4;
        this.cantidadDeMutaliscos++;
        this.incrementarPoblacion(4);
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

    public int cupo() {
        return this.cupo;
    }

    private void incrementarCupo(int incremento) {
        if (this.cupo + incremento <= 200) {
            this.cupo += incremento;
        }
    }

    private void incrementarPoblacion(int incremento) {
        if (this.poblacion + incremento <= 200) {
            this.poblacion += incremento;
        }
    }

    private boolean sePuedeCrearUnidad(int cupo) {
        return this.poblacion + cupo <= MAX_POBLACION;
    }
}