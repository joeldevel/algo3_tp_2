package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CrearJugadorHandler implements EventHandler<ActionEvent> {

    private final AlgoStar juego;
    private Button btn;
    private TextField fieldNombre;

    public CrearJugadorHandler(AlgoStar juego, Button btn, TextField field) {
        this.juego = juego;
        this.fieldNombre = field;
        this.btn = btn;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("en el event handler...");
        if (!this.juego.validarNombre(this.fieldNombre.getText())) {
            System.out.println("nombre: " + this.fieldNombre.getText() + " NO valido");
        } else {
            System.out.println("nombre: " + this.fieldNombre.getText() + " valido");
            System.out.println("CREANDO JUGADOR CON NOMBRE: " + this.fieldNombre.getText());
            this.btn.setDisable(true);
        }
    }
}
