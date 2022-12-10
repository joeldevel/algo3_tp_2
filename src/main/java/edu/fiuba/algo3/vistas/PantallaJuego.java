package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.AlgoStar.AlgoStar;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vistas.eventos.BotonCrearEdificioEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PantallaJuego extends BorderPane { // 24:47

    public static int ANCHO = 1000;
    public static int ALTURA = 500;

    private int coordenadaX;
    private int coordenadaY;

    VistaMapa vistaMapa;
    Canvas canvasCentral;

    public PantallaJuego(Stage stage, AlgoStar algoStar) {
        this.setFondo();
        this.setCentro(algoStar);

        Button botonAvanzarTurno = new Button();
        botonAvanzarTurno.setText("Avanzar turno");
        botonAvanzarTurno.setTranslateX(-10);
        botonAvanzarTurno.setTranslateY(10);

        VBox contenedorVertical = new VBox(botonAvanzarTurno);
        contenedorVertical.setSpacing(5);

        this.setRight(contenedorVertical);

        botonAvanzarTurno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                algoStar.avanzarTurno();
                setInformacion(algoStar);
                setBotonera(algoStar);
                vistaMapa.update();
            }
        });

        // Se muestra por pantalla el punto sobre el canvas donde se mueve el mouse

        this.canvasCentral.setOnMouseMoved(e -> {
            Label coordenadaX = new Label();
            coordenadaX.setText("x: " + e.getX());
            coordenadaX.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
            coordenadaX.setTextFill(Color.web("#ffffff"));

            Label coordenadaY = new Label();
            coordenadaY.setText("y: " + e.getY());
            coordenadaY.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
            coordenadaY.setTextFill(Color.web("#ffffff"));

            HBox contenedorHorizontalCoordenadas = new HBox(coordenadaX, coordenadaY);
            contenedorHorizontalCoordenadas.setSpacing(10);
            contenedorHorizontalCoordenadas.setTranslateX(500);
            contenedorHorizontalCoordenadas.setTranslateY(10);

            this.setTop(contenedorHorizontalCoordenadas);
        });

        // Se muestra por consola el punto sobre el canvas donde se hace click

        this.canvasCentral.setOnMouseClicked(e -> {
            this.coordenadaX = (int) e.getX();
            System.out.println("x: " + e.getX());
            this.coordenadaY = (int) e.getY();
            System.out.println("y: " + e.getY() + "\n");
        });

        // Zoom

        /*this.canvasCentral.setOnScroll(e -> {
            if(e.getDeltaY() > 0) {
                System.out.println("Zoom arriba");
                ANCHO += 1;
                ALTURA += 1;
                vistaMapa.update();
            }

            if(e.getDeltaY() < 0) {
                System.out.println("Zoom abajo");
                ANCHO -= 1;
                ALTURA -= 1;
                vistaMapa.update();
            }
        });*/
    }

    public int getCoordenadaX() {
        return this.coordenadaX;
    }

    public int getCoordenadaY() {
        return this.coordenadaY;
    }

    public void setFondo() {
        Image imagen = new Image("file:src/main/resources/images/fondo-negro.png", 2000, 2000, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    // Se crea el menu donde estara la informacion del jugador: Nombre, Color, Raza, Recursos, Poblacion, Suministro.
    public void setInformacion(AlgoStar algoStar) {
        Jugador jugadorActual = algoStar.obtenerJugadorTurno();

        Label nombre = new Label();
        nombre.setText("Turno: " + jugadorActual.obtenerNombre());
        nombre.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        nombre.setTextFill(Color.web("#ffffff"));

        Label color = new Label();
        color.setText("Color: " + jugadorActual.obtenerColor());
        color.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        color.setTextFill(Color.web("#ffffff"));

        Label raza = new Label();
        raza.setText("Raza: " + jugadorActual.obtenerRaza());
        raza.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        raza.setTextFill(Color.web("#ffffff"));

        Label gas = new Label();
        gas.setText("Gas: " + jugadorActual.obtenerGas());
        gas.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        gas.setTextFill(Color.web("#ffffff"));

        Label mineral = new Label();
        mineral.setText("Mineral: " + jugadorActual.obtenerMineral());
        mineral.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        mineral.setTextFill(Color.web("#ffffff"));

        Label poblacion = new Label();
        poblacion.setText("Poblacion: " + jugadorActual.calcularPoblacion());
        poblacion.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        poblacion.setTextFill(Color.web("#ffffff"));

        VBox contenedorVerticalInformacion = new VBox(nombre, color, raza, gas, mineral, poblacion);
        contenedorVerticalInformacion.setSpacing(10);
        contenedorVerticalInformacion.setTranslateX(10);
        contenedorVerticalInformacion.setTranslateY(10);

        this.setLeft(contenedorVerticalInformacion);
    }

    public void setBotonera(AlgoStar algoStar) {
        Jugador jugadorActual = algoStar.obtenerJugadorTurno();

        if (jugadorActual.obtenerRaza().equals("Zerg")) {
            this.setBottom(this.setBotoneraEdificiosZerg(algoStar));
        } else {
            this.setBottom(this.setBotoneraEdificiosProtoss(algoStar));
        }
    }

    // Se crea la botonera Zerg con los edificios correspondientes.
    public GridPane setBotoneraEdificiosZerg(AlgoStar algoStar) {

        Button criadero = new Button();
        criadero.setText("Crear criadero ");
        criadero.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearCriaderoEventHandler = new BotonCrearEdificioEventHandler("Criadero", algoStar, vistaMapa, this);
        criadero.setOnAction(botonCrearCriaderoEventHandler);

        Button reserva = new Button();
        reserva.setText(" Crear reserva ");
        reserva.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearReservaEventHandler = new BotonCrearEdificioEventHandler("ReservaDeReproduccion", algoStar, vistaMapa, this);
        reserva.setOnAction(botonCrearReservaEventHandler);

        Button extractor = new Button();
        extractor.setText("Crear extractor");
        extractor.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearExtractorEventHandler = new BotonCrearEdificioEventHandler("Extractor", algoStar, vistaMapa, this);
        extractor.setOnAction(botonCrearExtractorEventHandler);

        Button guarida = new Button();
        guarida.setText(" Crear guarida ");
        guarida.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearGuaridaEventHandler = new BotonCrearEdificioEventHandler("Guarida", algoStar, vistaMapa, this);
        guarida.setOnAction(botonCrearGuaridaEventHandler);

        Button espiral = new Button();
        espiral.setText(" Crear espiral ");
        espiral.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearEspiralEventHandler = new BotonCrearEdificioEventHandler("Espiral", algoStar, vistaMapa, this);
        espiral.setOnAction(botonCrearEspiralEventHandler);

        GridPane panel = new GridPane();
        GridPane.setConstraints(criadero, 0, 0);
        GridPane.setConstraints(reserva, 1, 0);
        GridPane.setConstraints(extractor, 0, 1);
        GridPane.setConstraints(guarida, 1, 1);
        GridPane.setConstraints(espiral, 0, 2);
        panel.getChildren().addAll(criadero, reserva, extractor, guarida, espiral);

        return panel;
    }

    // Se crea la botonera Protoss con los edificios correspondientes.
    public GridPane setBotoneraEdificiosProtoss(AlgoStar algoStar) {

        Button nexo = new Button();
        nexo.setText("   Crear nexo   ");
        nexo.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearNexoEventHandler = new BotonCrearEdificioEventHandler("NexoMineral", algoStar, vistaMapa, this);
        nexo.setOnAction(botonCrearNexoEventHandler);

        Button pilon = new Button();
        pilon.setText("  Crear pilon   ");
        pilon.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearPilonEventHandler = new BotonCrearEdificioEventHandler("Pilon", algoStar, vistaMapa, this);
        pilon.setOnAction(botonCrearPilonEventHandler);

        Button asimilador = new Button();
        asimilador.setText("Crear asimilador");
        asimilador.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearAsimiladorEventHandler = new BotonCrearEdificioEventHandler("Asimilador", algoStar, vistaMapa, this);
        asimilador.setOnAction(botonCrearAsimiladorEventHandler);

        Button acceso = new Button();
        acceso.setText("  Crear acceso  ");
        acceso.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearAccesoEventHandler = new BotonCrearEdificioEventHandler("Acceso", algoStar, vistaMapa, this);
        acceso.setOnAction(botonCrearAccesoEventHandler);

        Button puerto = new Button();
        puerto.setText("  Crear puerto  ");
        puerto.setMinWidth(130);

        BotonCrearEdificioEventHandler botonCrearPuertoEventHandler = new BotonCrearEdificioEventHandler("PuertoEstelar", algoStar, vistaMapa, this);
        puerto.setOnAction(botonCrearPuertoEventHandler);

        GridPane panel = new GridPane();
        GridPane.setConstraints(nexo, 0, 0);
        GridPane.setConstraints(pilon, 1, 0);
        GridPane.setConstraints(asimilador, 0, 1);
        GridPane.setConstraints(acceso, 1, 1);
        GridPane.setConstraints(puerto, 0, 2);
        panel.getChildren().addAll(nexo, pilon, asimilador, acceso, puerto);

        return panel;
    }

    // Se crea la pantalla central donde estara el mapa
    public void setCentro(AlgoStar algostar) {

        // Se crea el canvas donde se dibujara

        this.canvasCentral = new Canvas(ANCHO, ALTURA); // Ancho, Altura

        // Se dibuja el mapa

        this.vistaMapa = new VistaMapa(algostar.obtenerMapa(), canvasCentral);
        this.vistaMapa.dibujar();

        // Se ubica el canvas en el centro del BorderPane

        this.setCenter(canvasCentral);
    }
}