package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.eventos.BotonComenzarEventHandler;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PantallaFinal extends VBox { // 20:00

    Stage stage;

    public PantallaFinal(Stage stage) {
        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding((new Insets(25)));

        // Imagen de fondo

        Image imagen = new Image("file:src/main/resources/images/background01.png", 1950, 1100, false, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        // Etiqueta de bienvenida

        Label etiqueta = new Label();
        etiqueta.setText("¡Felicitaciones ganaste el juego!");
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiqueta.setTextFill(Color.web("#ffffff"));

        // Boton para salir

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.getStyleClass().add("btn");

        botonSalir.setOnAction(e -> Platform.exit());

        // Sonido...

        this.getChildren().addAll(etiqueta, botonSalir);
    }
}
