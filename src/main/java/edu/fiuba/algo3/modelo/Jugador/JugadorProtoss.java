package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeRecursosException;

import static edu.fiuba.algo3.util.Constantes.*;

public class Jugador implements IJugador {
    private int cantidadMineral;
    private int cantidadGas;

    public Jugador() {
        this.cantidadMineral = 0;
        this.cantidadGas = 0;
    }

    public void crearPilon() {
        if (this.cantidadMineral < COSTO_PILON) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_PILON;
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
}
