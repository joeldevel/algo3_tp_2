package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.eventos.BotonComenzarEventHandler;

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

import java.nio.file.Paths;

public class PantallaBienvenidos extends VBox { // 20:00

    Stage stage;

    public PantallaBienvenidos(Stage stage, Scene proximaEscena) {
        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding((new Insets(25)));

        // Imagen de fondo

        Image imagen = new Image("file:src/main/resources/images/intro-min.png", 2000, 2000, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        // Etiqueta de bienvenida

        Label etiqueta = new Label();
        etiqueta.setText("Bienvenidos al juego AlgoStar");
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiqueta.setTextFill(Color.web("#ffffff"));

        // Boton para comenzar

        Button botonComenzar = new Button();
        botonComenzar.setText("Comenzar AlgoStar");
        botonComenzar.getStyleClass().add("btn");

        BotonComenzarEventHandler botonComenzarEventHandler = new BotonComenzarEventHandler(stage, proximaEscena);
        botonComenzar.setOnAction(botonComenzarEventHandler);

        // Sonido

        this.getChildren().addAll(etiqueta, botonComenzar);
    }
}