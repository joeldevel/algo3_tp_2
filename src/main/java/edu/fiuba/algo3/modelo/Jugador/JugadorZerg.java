package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeRecursosException;
import edu.fiuba.algo3.modelo.Excepciones.SinCupoSuficienteException;

import static edu.fiuba.algo3.util.Constantes.*;

public class JugadorZerg implements IJugador {

    private static final int MAX_POBLACION = 200;
    private int cantidadGas;
    private int cantidadMineral;
    private int cupo;
    private int cantidadDeZanganos;
    private int cantidadDeZerlings;
    private int cantidadDeHidraliscos;
    private int cantidadDeMutaliscos;
    private int poblacion;

    public JugadorZerg() {
        this.cantidadMineral = 0;
        this.cantidadGas = 0;
        this.cupo = 0;
        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
        this.poblacion = 0;
    }

    public void crearCriadero() {
        if (this.cantidadMineral < COSTO_MINERAL_CRIADERO) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_MINERAL_CRIADERO;
        this.incrementarCupo(5);
    }

    public void incrementarMineral(int cantidad) {
        if (cantidad > 0) {
            this.cantidadMineral += cantidad;
        }
    }

    public void crearExtractor() {
        if (this.cantidadMineral < COSTO_MINERAL_EXTRACTOR) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_MINERAL_EXTRACTOR;
    }

    public void crearReservaDeProduccion() {
        if (this.cantidadMineral < COSTO_MINERAL_RESERVA_PRODUCCION) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_MINERAL_RESERVA_PRODUCCION;
    }

    public void crearGuarida() {
        if (this.cantidadMineral < COSTO_MINERAL_GUARIDA || this.cantidadGas < COSTO_GAS_GUARIDA) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_MINERAL_GUARIDA;
        this.cantidadGas -= COSTO_GAS_GUARIDA;
    }

    public void incrementarGas(int cantidad) {
        if (cantidad > 0) {
            this.cantidadGas += cantidad;
        }
    }

    public void crearEspiral() {
        if (this.cantidadMineral < COSTO_MINERAL_ESPIRAL || this.cantidadGas < COSTO_GAS_ESPIRAL) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_MINERAL_ESPIRAL;
        this.cantidadGas -= COSTO_GAS_ESPIRAL;
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
