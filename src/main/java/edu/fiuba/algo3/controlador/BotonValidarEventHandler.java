package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BotonValidarEventHandler implements EventHandler<ActionEvent> {

    private AlgoStar algoStar;
    private Button validar;

    private Label etiquetaNombre;
    private TextField textoNombre;

    private Label etiquetaColor;
    private ComboBox colores;

    private Label etiquetaRaza;
    private ComboBox razas;

    public BotonValidarEventHandler(Label etiquetaNombre, TextField textoNombre, Label etiquetaColor, ComboBox colores, Label etiquetaRaza, ComboBox razas, Button validar, AlgoStar algoStar) {
        this.algoStar = algoStar;
        this.validar = validar;

        this.etiquetaNombre = etiquetaNombre;
        this.textoNombre = textoNombre;

        this.etiquetaColor = etiquetaColor;
        this.colores = colores;

        this.etiquetaRaza = etiquetaRaza;
        this.razas = razas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (textoNombre.getText().trim().equals("")) {
            etiquetaNombre.setText("Debe ingresar un texto");
            etiquetaNombre.setTextFill(Color.RED);
            textoNombre.requestFocus();
        }

        else {

            if(algoStar.validarNombre(textoNombre.getText()) & algoStar.validarColor((String) this.colores.getValue()) & algoStar.validarRaza((String) this.razas.getValue())) {
                etiquetaNombre.setText("Nombre correcto");
                etiquetaNombre.setTextFill(Color.DARKGREEN);

                etiquetaColor.setText("Color correcto");
                etiquetaColor.setTextFill(Color.DARKGREEN);

                etiquetaRaza.setText("Raza correcta");
                etiquetaRaza.setTextFill(Color.DARKGREEN);

                algoStar.crearJugador(this.textoNombre.getText(), (String) this.colores.getValue(), (String) this.razas.getValue());

                this.validar.setDisable(true);

                System.out.println("Cantidad de jugadores: " + algoStar.jugadores.size());
            }

            else {
                etiquetaNombre.setText("Datos incorrectos");
                etiquetaNombre.setTextFill(Color.DARKRED);

                etiquetaColor.setText("Datos incorrectos");
                etiquetaColor.setTextFill(Color.DARKRED);

                etiquetaRaza.setText("Datos incorrectos");
                etiquetaRaza.setTextFill(Color.DARKRED);
            }
        }
    }
}
