package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaExcena;

    public BotonComenzarEventHandler(Stage stage, Scene proximaExcena) {
        this.stage = stage;
        this.proximaExcena = proximaExcena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaExcena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
