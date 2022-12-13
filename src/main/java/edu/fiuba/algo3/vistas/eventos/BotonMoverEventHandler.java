package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private final VistaMapa vista;
    private final Jugador jugador;
    private final Ubicacion ubicacionUnidad;

    public BotonMoverEventHandler(VistaMapa unaVista, Jugador jugadorTurno, Ubicacion ubicacionUnidad) {
        this.vista = unaVista;
        this.jugador = jugadorTurno;
        this.ubicacionUnidad = ubicacionUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // jugador.moverUnidadEn(this.ubicacionUnidad);
        // this.vista.update();
    }
}
