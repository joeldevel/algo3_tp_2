package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.vistas.PantallaJuego;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private final VistaMapa vista;
    private final Jugador jugador;
    private final PantallaJuego pantalla;

    public BotonMoverEventHandler(VistaMapa unaVista, Jugador jugadorTurno, PantallaJuego pantalla) {
        this.vista = unaVista;
        this.jugador = jugadorTurno;
        this.pantalla = pantalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.moverUnidadEn(new Ubicacion(pantalla.getCoordenadaX(), pantalla.getCoordenadaY()));
        this.vista.update();
    }
}