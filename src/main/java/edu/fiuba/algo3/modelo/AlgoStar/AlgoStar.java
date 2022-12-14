package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Excepciones.RazaInexistenteException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;

import java.util.ArrayList;

public class AlgoStar {

    public static final int JUGADOR_MIN_NOMBRE = 6;

    private AlgoStarEstado estado;
    public ArrayList<Jugador> jugadores;
    public Mapa mapa;

    public AlgoStar() {
        this.jugadores = new ArrayList<Jugador>();
        this.mapa = new Mapa();
        this.setComportamientoEstado(new AlgoStarNoIniciado(mapa));
    }

    public Jugador obtenerJugadorContrario(Jugador jugadorTurno) {
        return this.estado.obtenerJugadorContrario(jugadorTurno);
    }

    public Mapa obtenerMapa() {
        return this.estado.obtenerMapa();
    }

    public Jugador obtenerJugadorTurno() {
        return (this.estado.obtenerJugadorTurno());
    }

    public void crearJugador(String unNombre, String unColor, String unaRaza) {

        if(unaRaza.equals("Zerg")) {
            this.jugadores.add(new JugadorZerg(unNombre, unColor, this.mapa));
        }

        else if(unaRaza.equals("Protoss")) {
            this.jugadores.add(new JugadorProtoss(unNombre, unColor, this.mapa));
        }

        this.setComportamientoEstado(new AlgoStarIniciado(this.jugadores, this.mapa));
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
    }

    public boolean validarColor(String unColor) {

        // Los jugadores no pueden tener el mismo color.
        for(Jugador jugador: this.jugadores) {
            return !jugador.compararColores(unColor);
        }

        return true;
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