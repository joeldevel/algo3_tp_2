package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonDireccionEventHandler implements EventHandler<ActionEvent> {

    private final Jugador jugador;
    private final Ubicacion ubicacionUnidad;

    public BotonDireccionEventHandler(Jugador jugadorTurno, Ubicacion ubicacionUnidad) {
        this.jugador = jugadorTurno;
        this.ubicacionUnidad = ubicacionUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // jugador.cambiarDireccionDeUnidadEn(this.ubicacionUnidad);
    }
}
