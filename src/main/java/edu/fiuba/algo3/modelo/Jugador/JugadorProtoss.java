package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeRecursosException;
import edu.fiuba.algo3.modelo.Excepciones.SinCupoSuficienteException;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.util.Constantes.*;

public class JugadorProtoss implements IJugador {
    public static final int MAX_POBLACION = 200;

    private int cantidadMineral;
    private int cantidadGas;
    private int cupo;
    private int cantidadDeZealots;

    public JugadorProtoss() {
        this.cantidadMineral = 0;
        this.cantidadGas = 0;
        this.cupo = 0;
        this.cantidadDeZealots = 0;
    }

    public void crearPilon() {
        if (this.cantidadMineral < COSTO_PILON) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_PILON;
        this.cupo += 5;
    }

    public void incrementarMineral(int cantidad) {
        if (cantidad > 0) {
            this.cantidadMineral += cantidad;
        }
    }

    public void crearNexo() {
        if (this.cantidadMineral < COSTO_NEXO) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_NEXO;
    }

    public void crearAsimilador() {
        if (this.cantidadMineral < COSTO_ASIMILADOR) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_ASIMILADOR;
    }

    public void crearAcceso() {
        if (this.cantidadMineral < COSTO_ACCESO) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_ACCESO;
    }

    public void crearPuertoEstelar() {
        if (this.cantidadMineral < COSTO_MINERAL_PUERTO || this.cantidadGas < COSTO_GAS_PUERTO) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_MINERAL_PUERTO;
        this.cantidadGas -= COSTO_GAS_PUERTO;
    }

    public void incrementarGas(int cantidad) {
        if (cantidad > 0) {
            this.cantidadGas += cantidad;
        }
    }

    public void crearZealot() {
        if (this.cupo < 2) {
            throw new SinCupoSuficienteException("Se necesitan 2 cupos");
        }
        this.cupo -= 2;
        this.cantidadDeZealots++;
    }

    public int cantidadDeUnidades(UNIDADES_PROTOSS tipoUnidad) {
        if (tipoUnidad == UNIDADES_PROTOSS.ZEALOT) {
            return this.cantidadDeZealots;
        }
        return 0;
    }
}
