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
    private int cantidadDePilones;

    private int cantidadMineral;
    private int cantidadGas;
    private int cupo;
    private int poblacion;
    private int cantidadDeZealots;
    private int cantidadDeDragones;
    private int cantidadDeScouts;

    public JugadorProtoss() {
        this.cantidadMineral = 0;
        this.cantidadGas = 0;
        this.cupo = 0;
        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;
        this.poblacion = 0;
        this.cantidadDePilones = 0;
    }

    public void crearPilon() {
        if (this.cantidadMineral < COSTO_PILON) {
            throw new CantidadInsuficienteDeRecursosException("No hay recursos suficientes");
        }
        this.cantidadDePilones++;
        this.cantidadMineral -= COSTO_PILON;
        this.incrementarCupo(5);
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
        if (!this.sePuedeCrearUnidad(2)) {
            return;
        }
        if (this.cupo < 2) {
            throw new SinCupoSuficienteException("Se necesitan 2 cupos");
        }
        this.cupo -= 2;
        this.cantidadDeZealots++;
        this.incrementarPoblacion(2);
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

    public void crearDragon() {
        if (!this.sePuedeCrearUnidad(3)) {
            return;
        }
        if (this.cupo < 3) {
            throw new SinCupoSuficienteException("Se necesitan 3 cupos");
        }
        this.cupo -= 3;
        this.cantidadDeDragones++;
        this.incrementarPoblacion(3);
    }

    public void crearScout() {
        if (!this.sePuedeCrearUnidad(4)) {
            return;
        }
        if (this.cupo < 4) {
            throw new SinCupoSuficienteException("Se necesitan 4 cupos");
        }
        this.cupo -= 4;
        this.cantidadDeScouts++;
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

    public void destruirPilon() {
        if (this.cantidadDePilones > 0) {
            this.cantidadDePilones--;
            this.cupo-=5;
        }
    }
}
