package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonComenzarEventHandler;

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

public class PantallaBienvenidos extends VBox {

    Stage stage;

    public PantallaBienvenidos(Stage stage, Scene proximaEscena) {
        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding((new Insets(25)));

        Image imagen = new Image("file:src/main/resources/images/background-bienvenidos.png", 2000, 2000, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Label etiqueta = new Label();
        etiqueta.setText("Bienvenidos al juego AlgoStar");
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiqueta.setTextFill(Color.web("#ffffff"));

        Label materia = new Label();
        materia.setText("Algoritmos y Programacion III - FIUBA");
        materia.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        materia.setTextFill(Color.web("#ffffff"));

        Label tp = new Label();
        tp.setText("Trabajo practico N° 2 - Segundo cuatrimestre 2022");
        tp.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        tp.setTextFill(Color.web("#ffffff"));

        Label grupo = new Label();
        grupo.setText("Grupo N° 8");
        grupo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grupo.setTextFill(Color.web("#ffffff"));

        VBox trabajo = new VBox(materia, tp, grupo);
        trabajo.setTranslateY(-550);

        Label corrector = new Label();
        corrector.setText("Corrector: Santiago Valdez");
        corrector.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        corrector.setTextFill(Color.web("#ffffff"));

        Label integrantes = new Label();
        integrantes.setText("Integrantes: Alan Valdevenito, Brian Lahuta, Leonardo Duchen, Cristian Leith");
        integrantes.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        integrantes.setTextFill(Color.web("#ffffff"));

        VBox nombres = new VBox(corrector, integrantes);
        nombres.setTranslateY(450);

        Button botonComenzar = new Button();
        botonComenzar.setText("Comenzar AlgoStar");
        botonComenzar.getStyleClass().add("btn");

        BotonComenzarEventHandler botonComenzarEventHandler = new BotonComenzarEventHandler(stage, proximaEscena);
        botonComenzar.setOnAction(botonComenzarEventHandler);

        this.getChildren().addAll(etiqueta, botonComenzar, nombres, trabajo);
    }
}