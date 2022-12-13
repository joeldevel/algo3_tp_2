package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.vistas.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonDireccionEventHandler implements EventHandler<ActionEvent> {

    private final Jugador jugador;
    private final PantallaJuego pantalla;

    public BotonDireccionEventHandler(Jugador jugadorTurno, PantallaJuego pantalla) {
        this.jugador = jugadorTurno;
        this.pantalla = pantalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.cambiarDireccionDeUnidadEn(new Ubicacion(pantalla.getCoordenadaX(), pantalla.getCoordenadaY()));
    }
}
