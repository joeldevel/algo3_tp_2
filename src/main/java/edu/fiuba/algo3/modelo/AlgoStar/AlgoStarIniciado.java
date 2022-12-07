package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;

public class AlgoStarIniciado implements AlgoStarEstado {

    private ArrayList<Jugador> jugadores;
    private Jugador jugadorTurno;

    public AlgoStarIniciado(ArrayList<Jugador> unosJugadores) {
        this.jugadores = unosJugadores;
        this.jugadorTurno = unosJugadores.get(0); // Comienza el jugador 1
    }

    public void setJugador(Jugador unJugador) {
        this.jugadorTurno = unJugador;
    }

    // Getter para obtener de quien es el turno y poder elegir acciones.
    public Jugador obtenerJugadorTurno() {
        return (this.jugadorTurno);
    }

    @Override
    public void avanzarTurno() {

        // Iteramos los jugadores y como se avanza el turno seteamos al jugador correspondiente.
//        for(Jugador jugador: this.jugadores) {
//            System.out.println("jugador actual es: " + jugadorTurno.getNombre());
//            if(!jugador.compararRazas(this.jugadorTurno.obtenerRaza())) {
//                this.setJugador(jugador);
//            }
//        }
        if(this.jugadores.get(0) == jugadorTurno ) {
            this.setJugador(jugadores.get(1));
        } else {
            this.setJugador(jugadores.get(0));
        }
    }
}
