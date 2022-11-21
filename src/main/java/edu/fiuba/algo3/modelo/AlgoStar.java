package edu.fiuba.algo3.modelo;

import static edu.fiuba.algo3.util.Constantes.*;

public class AlgoStar {
    private String nombreJugador1;
    private String nombreJugador2;
    private JUGADOR_COLOR colorJugador1;
    private JUGADOR_COLOR colorJugador2;
    private JUGADOR_RAZA razaJugador1;
    private JUGADOR_RAZA razaJugador2;
    private boolean iniciado;

    public AlgoStar() {
        this.nombreJugador1 = "";
        this.nombreJugador2 = "";
        this.razaJugador1 = null;
        this.razaJugador2 = null;
        this.colorJugador1 = null;
        this.colorJugador2 = null;
        this.iniciado = false;
    }

    public boolean validarNombre(String nombre) {
        if (nombreJugador1.length() == 0) {
            if (nombre.trim().length() < JUGADOR_MIN_NOMBRE) {
                return false;
            }
            nombreJugador1 = nombre;
            return true;
        }
        // jugador 1 ya fue seteado
        if (nombreJugador2.length() == 0) {
            if (nombre.trim().length() < JUGADOR_MIN_NOMBRE) {
                return false;
            }
            if (nombreJugador1.toLowerCase().trim().equals(nombre.toLowerCase().trim())) {
                return false;
            }
            // no son iguales
            nombreJugador2 = nombre;
            return true;
        }
        return false;

    }

    public boolean validarColor(JUGADOR_COLOR color) {
        if (colorJugador1 == null) {
            for (JUGADOR_COLOR c : JUGADOR_COLOR.values()) {
                if (c == color) {
                    colorJugador1 = color;
                    return true;
                }
            }
            return false;
        }
        // jugador 1 ya fue seteado
        if (colorJugador2 == null) {
            if (color == colorJugador1) {
                return false;
            }
            for (JUGADOR_COLOR c : JUGADOR_COLOR.values()) {
                if (c == color) {
                    colorJugador2 = color;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean validarRaza(JUGADOR_RAZA raza) {
        if (razaJugador1 == null) {
            for (JUGADOR_RAZA r : JUGADOR_RAZA.values()) {
                if (r == raza) {
                    razaJugador1 = raza;
                    return true;
                }
            }
            return false;
        }
        // jugador 1 ya fue seteado
        if (razaJugador2 == null) {
            if (raza == razaJugador1) {
                return false;
            }
            for (JUGADOR_RAZA r : JUGADOR_RAZA.values()) {
                if (r == raza) {
                    razaJugador2 = raza;
                    return true;
                }
            }
            return false;
        }

        return false;
    }

    public void finalizar() {
        if(this.iniciado == false) {
            throw new RuntimeException("El juego no ha iniciado");
        }
        this.iniciado = false;
    }

    public void iniciar() {
        this.iniciado = true;
    }
}
