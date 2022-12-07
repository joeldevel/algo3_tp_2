package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Excepciones.RazaInexistenteException;
import edu.fiuba.algo3.modelo.JUGADOR_COLOR;
import edu.fiuba.algo3.modelo.JUGADOR_RAZA;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;

import java.util.ArrayList;

public class AlgoStar {

    public static final int JUGADOR_MIN_NOMBRE = 6;

    //private String nombreJugador1;
    //private String nombreJugador2;
    //private JUGADOR_COLOR colorJugador1;
    //private JUGADOR_COLOR colorJugador2;
    //private JUGADOR_RAZA razaJugador1;
    //private JUGADOR_RAZA razaJugador2;

    private AlgoStarEstado estado;
    public ArrayList<Jugador> jugadores;

    public AlgoStar() {
        //this.nombreJugador1 = "";
        //this.nombreJugador2 = "";
        //this.razaJugador1 = null;
        //this.razaJugador2 = null;
        //this.colorJugador1 = null;
        //this.colorJugador2 = null;

        this.jugadores = new ArrayList<Jugador>();
        this.estado = null;
    }

    public Jugador obtenerJugadorTurno() {
        return (this.estado.obtenerJugadorTurno());
    }

    public void crearJugador(String unNombre, String unColor, String unaRaza) {

        if(unaRaza.equals("Zerg")) {
            this.jugadores.add(new JugadorZerg(unNombre, unColor));
        }

        else if(unaRaza.equals("Protoss")) {
            this.jugadores.add(new JugadorProtoss(unNombre, unColor));
        }

        this.setComportamientoEstado(new AlgoStarIniciado(jugadores));
    }

    public boolean validarNombre(String unNombre) {

        // El nombre debe tener 6 o mas caracteres.
        if (unNombre.trim().length() < JUGADOR_MIN_NOMBRE) {
            return false;
        }

        // Los jugadores no pueden tener el mismo nombre.
        for(Jugador jugador: this.jugadores) {
            return !jugador.compararNombres(unNombre);
        }

        return true;

        /*if (nombreJugador1.length() == 0) {
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
        return false;*/
    }

    public boolean validarColor(String unColor) {

        // Los jugadores no pueden tener el mismo color.
        for(Jugador jugador: this.jugadores) {
            return !jugador.compararColores(unColor);
        }

        return true;

        /*if (colorJugador1 == null) {
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
        return false;*/
    }

    public boolean validarRaza(String unaRaza) {

        if(!(unaRaza.equals("Zerg") || unaRaza.equals("Protoss"))) {
            throw new RazaInexistenteException();
        }

        // Los jugadores no pueden tener la misma raza.
        for(Jugador jugador: this.jugadores) {
            return !jugador.compararRazas(unaRaza);
        }

        return true;

        /*if (razaJugador1 == null) {
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

        return false;*/
    }

    public void avanzarTurno() {
        this.estado.avanzarTurno();
    }

    public void setComportamientoEstado(AlgoStarEstado nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void finalizarAlgoStar() {
        this.setComportamientoEstado(new AlgoStarFinalizado());
    }
}