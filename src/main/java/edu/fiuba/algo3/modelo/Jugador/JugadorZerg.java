package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeRecursosException;

import static edu.fiuba.algo3.util.Constantes.*;

public class JugadorZerg implements IJugador {

    private int cantidadGas;
    private int cantidadMineral;

    public JugadorZerg() {
        this.cantidadMineral = 0;
        this.cantidadGas = 0;
    }

    public void crearCriadero() {
        if (this.cantidadMineral < COSTO_MINERAL_CRIADERO) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadMineral -= COSTO_MINERAL_CRIADERO;
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
}
