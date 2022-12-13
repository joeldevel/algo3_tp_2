package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.Unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonDireccionEventHandler implements EventHandler<ActionEvent> {

    private final Unidad unidad;

    public BotonDireccionEventHandler(Unidad unaUnidad) {
        this.unidad = unaUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // this.unidad.rotar();
    }
}
