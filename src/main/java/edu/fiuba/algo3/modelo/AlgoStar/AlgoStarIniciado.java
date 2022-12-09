package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;

public class AlgoStarIniciado implements AlgoStarEstado {

    private ArrayList<Jugador> jugadores;
    private Jugador jugadorTurno;
    private Mapa mapa;

    public AlgoStarIniciado(ArrayList<Jugador> unosJugadores, Mapa mapa) {
        this.jugadores = unosJugadores;
        this.jugadorTurno = unosJugadores.get(0); // Comienza el jugador 1
        this.mapa = mapa;
    }

    public void setJugador(Jugador unJugador) {
        this.jugadorTurno = unJugador;
    }

    // Getter para obtener de quien es el turno y poder elegir acciones.
    public Jugador obtenerJugadorTurno() {
        return (this.jugadorTurno);
    }

    @Override
    public Jugador obtenerJugadorContrario(Jugador jugadorTurno) {

        if (this.jugadores.get(0).compararRazas(this.jugadorTurno.obtenerRaza())) {
            return this.jugadores.get(1);
        } else {
            return this.jugadores.get(0);
        }
    }

    @Override
    public Mapa obtenerMapa() {
        return this.mapa;
    }

    @Override
    public void avanzarTurno() {

        if (this.jugadores.get(0) == jugadorTurno) {
            this.setJugador(jugadores.get(1));
        } else {
            this.setJugador(jugadores.get(0));
        }
        
        for(Jugador actual: this.jugadores) {
        	actual.avanzarTurno();
        }

        this.mapa.avanzarTurno();
    }
}
