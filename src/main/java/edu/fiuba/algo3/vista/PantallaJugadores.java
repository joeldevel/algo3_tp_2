package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.controlador.BotonComenzarEventHandler;
import edu.fiuba.algo3.controlador.BotonValidarEventHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PantallaJugadores extends VBox {

    Stage stage;

    public PantallaJugadores(Stage stage, Scene proximaEscena, AlgoStar algoStar, PantallaJuego proximaPantalla) {
        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding((new Insets(25)));

        Image imagen = new Image("file:src/main/resources/images/background-bienvenidos.png", 2000, 2000, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        String tiposColores[] = {"Rojo", "Azul", "Verde", "Amarillo"};
        ComboBox coloresJ1 = new ComboBox(FXCollections.observableArrayList(tiposColores));
        ComboBox coloresJ2 = new ComboBox(FXCollections.observableArrayList(tiposColores));

        coloresJ1.setValue("Rojo"); // Inicializamos las opciones de colores porque no deben estar vacias. De forma contraria tendremos un error de NullPointerException si el jugador valida la informacion con las opciones vacias.
        coloresJ2.setValue("Azul");

        String tiposRazas[] = {"Zerg", "Protoss"};
        ComboBox razasJ1 = new ComboBox(FXCollections.observableArrayList(tiposRazas));
        ComboBox razasJ2 = new ComboBox(FXCollections.observableArrayList(tiposRazas));

        razasJ1.setValue("Zerg"); // Inicializamos las opciones de razas porque no deben estar vacias. De forma contraria tendremos un error de NullPointerException si el jugador valida la informacion con las opciones vacias.
        razasJ2.setValue("Protoss");

        TextField textoNombreJ1 = new TextField();
        textoNombreJ1.setPromptText("Ingrese el nombre deseado");
        textoNombreJ1.getStyleClass().add("btn");

        Label etiquetaNombreJ1 = new Label();
        etiquetaNombreJ1.setText("Ingrese el nombre del Jugador 1");
        etiquetaNombreJ1.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiquetaNombreJ1.setTextFill(Color.web("#ffffff"));

        Label etiquetaColorJ1 = new Label();
        etiquetaColorJ1.setText("Ingrese el color del Jugador 1");
        etiquetaColorJ1.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiquetaColorJ1.setTextFill(Color.web("#ffffff"));

        Label etiquetaRazaJ1 = new Label();
        etiquetaRazaJ1.setText("Ingrese la raza del Jugador 1");
        etiquetaRazaJ1.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiquetaRazaJ1.setTextFill(Color.web("#ffffff"));

        TextField textoNombreJ2 = new TextField();
        textoNombreJ2.setPromptText("Ingrese el nombre deseado");
        textoNombreJ2.getStyleClass().add("btn");

        Label etiquetaNombreJ2 = new Label();
        etiquetaNombreJ2.setText("Ingrese el nombre del Jugador 2");
        etiquetaNombreJ2.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiquetaNombreJ2.setTextFill(Color.web("#ffffff"));

        Label etiquetaColorJ2 = new Label();
        etiquetaColorJ2.setText("Ingrese el color del Jugador 2");
        etiquetaColorJ2.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiquetaColorJ2.setTextFill(Color.web("#ffffff"));

        Label etiquetaRazaJ2 = new Label();
        etiquetaRazaJ2.setText("Ingrese la raza del Jugador 2");
        etiquetaRazaJ2.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiquetaRazaJ2.setTextFill(Color.web("#ffffff"));

        Button botonValidarJ1 = new Button();
        botonValidarJ1.setText("Validar informacion");
        botonValidarJ1.getStyleClass().add("btn");

        Button botonValidarJ2 = new Button();
        botonValidarJ2.setText("Validar informacion");
        botonValidarJ2.getStyleClass().add("btn");

        VBox contenedorVerticalJ1 = new VBox(etiquetaNombreJ1, textoNombreJ1, etiquetaColorJ1, coloresJ1, etiquetaRazaJ1, razasJ1, botonValidarJ1);
        contenedorVerticalJ1.setSpacing(5);

        VBox contenedorVerticalJ2 = new VBox(etiquetaNombreJ2, textoNombreJ2, etiquetaColorJ2, coloresJ2, etiquetaRazaJ2, razasJ2, botonValidarJ2);
        contenedorVerticalJ2.setSpacing(5);

        HBox contenedorPrincipal = new HBox(contenedorVerticalJ1, contenedorVerticalJ2);
        contenedorPrincipal.setSpacing(50);
        contenedorPrincipal.setPadding(new Insets(10));
        contenedorPrincipal.setAlignment(Pos.CENTER);

        BotonValidarEventHandler botonValidarEventHandlerJ1 = new BotonValidarEventHandler(etiquetaNombreJ1, textoNombreJ1, etiquetaColorJ1, coloresJ1, etiquetaRazaJ1, razasJ1, botonValidarJ1, algoStar);
        botonValidarJ1.setOnAction(botonValidarEventHandlerJ1);

        BotonValidarEventHandler botonValidarEventHandlerJ2 = new BotonValidarEventHandler(etiquetaNombreJ2, textoNombreJ2, etiquetaColorJ2, coloresJ2, etiquetaRazaJ2, razasJ2, botonValidarJ2, algoStar);
        botonValidarJ2.setOnAction(botonValidarEventHandlerJ2);

        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.getStyleClass().add("btn");

        BotonComenzarEventHandler botonComenzarEventHandler = new BotonComenzarEventHandler(stage, proximaEscena);
        botonContinuar.setOnAction(botonComenzarEventHandler);
        botonContinuar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                proximaPantalla.setInformacion(algoStar);
                proximaPantalla.setBotonera(algoStar);
                stage.setScene(proximaEscena);
                stage.setFullScreenExitHint("");
                stage.setFullScreen(true);
            }
        });

        this.getChildren().addAll(contenedorPrincipal, botonContinuar);
    }
}
