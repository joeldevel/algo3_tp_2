package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.vista.PantallaJuego;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearEntidadEventHandler implements EventHandler<ActionEvent> {

    String entidad;
    AlgoStar juego;
    VistaMapa vistaMapa;
    PantallaJuego pantalla;

    public BotonCrearEntidadEventHandler(String unaEntidad, AlgoStar unJuego, VistaMapa unaVista, PantallaJuego unaPantalla) {
        this.entidad = unaEntidad;
        this.juego = unJuego;
        this.vistaMapa = unaVista;
        this.pantalla = unaPantalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorTurno = this.juego.getJugadorTurno();
        Jugador jugadorContrario = this.juego.obtenerJugadorContrario(jugadorTurno);
        Mapa mapa = this.juego.getMapa();

        jugadorTurno.construir(this.entidad, new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())), jugadorContrario, mapa);

        this.vistaMapa.update();
        this.pantalla.setInformacion(this.juego);
    }
}
