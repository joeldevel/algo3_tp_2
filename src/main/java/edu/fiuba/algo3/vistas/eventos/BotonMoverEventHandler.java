package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private final VistaMapa vista;
    private final Unidad unidad;

    public BotonMoverEventHandler(VistaMapa unaVista, Unidad unaUnidad) {
        this.vista = unaVista;
        this.unidad = unaUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // this.unidad.mover();
        // this.vista.update();
    }
}
