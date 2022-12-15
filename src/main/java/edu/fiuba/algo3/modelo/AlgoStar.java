package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;
import edu.fiuba.algo3.modelo.Excepciones.RazaInexistenteException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;

import java.util.ArrayList;

public class AlgoStar {

    public static final int JUGADOR_MIN_NOMBRE = 6;

    public ArrayList<Jugador> jugadores;
    public Mapa mapa;
    private Tiempo turnos;
    private Jugador jugadorTurno;

    public AlgoStar() {
        this.jugadores = new ArrayList<Jugador>();
        this.mapa = new Mapa();
        this.turnos = new Tiempo(1);
        this.jugadorTurno = null;
    }

    public void setJugador(Jugador unJugador) {
        this.jugadorTurno = unJugador;
    }

    // Getter para obtener de quien es el turno y poder elegir acciones.
    public Jugador obtenerJugadorTurno() {
        return (this.jugadorTurno);
    }

    public Jugador obtenerJugadorContrario(Jugador jugadorTurno) {
        if (this.jugadores.get(0).compararRazas(this.jugadorTurno.obtenerRaza())) {
            return this.jugadores.get(1);
        } else {
            return this.jugadores.get(0);
        }
    }

    public Mapa obtenerMapa() {
        return this.mapa;
    }

    public void crearJugador(String unNombre, String unColor, String unaRaza) {

        if(unaRaza.equals("Zerg")) {
            this.jugadores.add(new JugadorZerg(unNombre, unColor, this.mapa));
            this.jugadorTurno = this.jugadores.get(0);
        }

        else if(unaRaza.equals("Protoss")) {
            this.jugadores.add(new JugadorProtoss(unNombre, unColor, this.mapa));
        }
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

        if(this.turnos.transcurrido() > 9  && ((!this.jugadores.get(0).tieneEdificios()) || (!this.jugadores.get(1).tieneEdificios()))) {
            throw new AlgoStarFinalizadoException();
        }

        if (this.jugadores.get(0) == jugadorTurno) {
            this.setJugador(jugadores.get(1));
        } else {
            this.setJugador(jugadores.get(0));
        }

        for(Jugador actual: this.jugadores) {
            actual.avanzarTurno();
        }

        this.mapa.avanzarTurno();
        this.turnos.pasarTiempo();
    }
}