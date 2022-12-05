package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IniciarPartidaHandler implements EventHandler<ActionEvent> {

    private final Scene proximaEscena;
    private final Stage stage;

    public IniciarPartidaHandler(Stage stage, Scene proximaEscena) {
        this.proximaEscena = proximaEscena;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        this.stage.setScene(proximaEscena);
    }
}
