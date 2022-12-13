package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.AlgoStar.AlgoStar;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.vistas.eventos.BotonAtacarEventHandler;
import edu.fiuba.algo3.vistas.eventos.BotonCrearEdificioEventHandler;
import edu.fiuba.algo3.vistas.eventos.BotonDireccionEventHandler;
import edu.fiuba.algo3.vistas.eventos.BotonMoverEventHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        this.setArriba(algoStar);

        // Informacion de unidades y edificios

        /*Label vida = new Label();
        vida.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        vida.setTextFill(Color.web("#ffffff"));

        Label escudo = new Label();
        escudo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        escudo.setTextFill(Color.web("#ffffff"));

        VBox contenedorVerticalEntidad = new VBox(vida, escudo);
        contenedorVerticalEntidad.setSpacing(10);
        contenedorVerticalEntidad.setTranslateX(-25);
        contenedorVerticalEntidad.setTranslateY(30);*/

        this.canvasCentral.setOnMouseClicked(e -> {
            this.coordenadaX = (int) e.getX();
            System.out.println("x: " + e.getX());
            this.coordenadaY = (int) e.getY();
            System.out.println("y: " + e.getY() + "\n");

            this.setDerecha(algoStar);

            /*if(algoStar.obtenerMapa().verificarUnidadEnUbicacion(new Ubicacion(this.coordenadaX, this.coordenadaY))) {
                System.out.println("Entrando unidad");
                Unidad unidad = algoStar.obtenerMapa().obtenerUnidadEnUbicacion(new Ubicacion(this.coordenadaX, this.coordenadaY));

                vida.setText("Vida: " + unidad.vidaRestante());
                escudo.setText("Escudo: " + unidad.escudoRestante());
            }

            if(algoStar.obtenerMapa().verificarEdificioEnUbicacion("Criadero", new Ubicacion(this.coordenadaX, this.coordenadaY))) {
                System.out.println("Entrando edificio");
                Edificio edificio = algoStar.obtenerMapa().obtenerEdificioEn(new Ubicacion(this.coordenadaX, this.coordenadaY));

                vida.setText("Vida: " + edificio.obtenerVida());
                escudo.setText("Escudo: ");
            }*/
        });

        //this.setRight(contenedorVerticalEntidad);
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

    public void setDerecha(AlgoStar algoStar) {
        // Informacion de unidades y edificios

        Label vida = new Label();
        vida.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        vida.setTextFill(Color.web("#ffffff"));

        Label escudo = new Label();
        escudo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        escudo.setTextFill(Color.web("#ffffff"));

        VBox contenedorVerticalEntidad = new VBox(vida, escudo);
        contenedorVerticalEntidad.setSpacing(10);
        contenedorVerticalEntidad.setTranslateX(-25);
        contenedorVerticalEntidad.setTranslateY(30);

        //this.canvasCentral.setOnMouseClicked(e -> {

            if(algoStar.obtenerMapa().verificarUnidadEnUbicacion(new Ubicacion(this.coordenadaX, this.coordenadaY))) {
                System.out.println("Entrando unidad");
                Unidad unidad = algoStar.obtenerMapa().obtenerUnidadEnUbicacion(new Ubicacion(this.coordenadaX, this.coordenadaY));

                vida.setText("Vida: " + unidad.vidaRestante());
                escudo.setText("Escudo: " + unidad.escudoRestante());
            }

            if(algoStar.obtenerMapa().verificarEdificioEnUbicacion("Criadero", new Ubicacion(this.coordenadaX, this.coordenadaY))) {
                System.out.println("Entrando edificio");
                Edificio edificio = algoStar.obtenerMapa().obtenerEdificioEn(new Ubicacion(this.coordenadaX, this.coordenadaY));

                vida.setText("Vida: " + edificio.obtenerVida());
                escudo.setText("Escudo: ");
            }
        //});

        this.setRight(contenedorVerticalEntidad);
    }

    public void setArriba(AlgoStar algoStar) {
        // Boton para avanzar turno

        Button botonAvanzarTurno = new Button();
        botonAvanzarTurno.setText("Avanzar turno");
        botonAvanzarTurno.setTranslateX(-10);
        botonAvanzarTurno.setTranslateY(10);

        VBox contenedorAvanzarTurno = new VBox(botonAvanzarTurno);
        contenedorAvanzarTurno.setSpacing(5);
        contenedorAvanzarTurno.setTranslateX(1800);
        contenedorAvanzarTurno.setTranslateY(10);

        botonAvanzarTurno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                algoStar.avanzarTurno();
                setInformacion(algoStar);
                setBotonera(algoStar);
                vistaMapa.update();
            }
        });

        // Informacion del mouse sobre el canvas

        Label coordenadaX = new Label();
        coordenadaX.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        coordenadaX.setTextFill(Color.web("#ffffff"));

        Label coordenadaY = new Label();
        coordenadaY.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        coordenadaY.setTextFill(Color.web("#ffffff"));

        HBox contenedorHorizontalCoordenadas = new HBox(coordenadaX, coordenadaY);
        contenedorHorizontalCoordenadas.setSpacing(10);
        contenedorHorizontalCoordenadas.setTranslateX(-100);
        contenedorHorizontalCoordenadas.setTranslateY(10);

        this.canvasCentral.setOnMouseMoved(e -> {
            coordenadaX.setText("x: " + e.getX());
            coordenadaY.setText("y: " + e.getY());
        });

        HBox contenedorVertical = new HBox(contenedorAvanzarTurno, contenedorHorizontalCoordenadas);
        this.setTop(contenedorVertical);
    }

    // Se crea el menu donde estara la informacion del jugador: Nombre, Color, Raza, Recursos, Poblacion, Suministro.
    public void setInformacion(AlgoStar algoStar) {
        // Informacion del jugador

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

        // Contenedor de informacion

        VBox contenedorVerticalInformacion = new VBox(nombre, color, raza, gas, mineral, poblacion);
        contenedorVerticalInformacion.setSpacing(10);
        contenedorVerticalInformacion.setTranslateX(10);
        contenedorVerticalInformacion.setTranslateY(220);

        this.setLeft(contenedorVerticalInformacion);
    }

    public void setBotonera(AlgoStar algoStar) {
        Jugador jugadorActual = algoStar.obtenerJugadorTurno();

        if (jugadorActual.obtenerRaza().equals("Zerg")) {
            HBox contenedorHorizontalBotonera = new HBox(this.setBotoneraEdificiosZerg(algoStar), this.setBotoneraUnidadesZerg(algoStar), this.setBotoneraMovimiento(algoStar), this.setBotoneraAtaque(algoStar));
            contenedorHorizontalBotonera.setSpacing(50);
            this.setBottom(contenedorHorizontalBotonera);
        } else {
            HBox contenedorHorizontalBotonera = new HBox(this.setBotoneraEdificiosProtoss(algoStar), this.setBotoneraUnidadesProtoss(algoStar), this.setBotoneraMovimiento(algoStar), this.setBotoneraAtaque(algoStar));
            contenedorHorizontalBotonera.setSpacing(50);
            this.setBottom(contenedorHorizontalBotonera);
        }
    }

    // Se crea la botonera Zerg con los edificios correspondientes.
    public GridPane setBotoneraEdificiosZerg(AlgoStar algoStar) {
        // Botonera edificios

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

    // Se crea la botonera Zerg con los edificios correspondientes.
    public GridPane setBotoneraUnidadesZerg(AlgoStar algoStar) {
        Jugador jugadorZerg = algoStar.obtenerJugadorTurno();
        Jugador jugadorProtoss = algoStar.obtenerJugadorContrario(jugadorZerg);

        Button amo = new Button();
        amo.setText("   Crear Amo Supremo   ");
        amo.setMinWidth(130);

        amo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                jugadorZerg.construir("AmoSupremo", new Ubicacion(coordenadaX, coordenadaY), jugadorProtoss, algoStar.obtenerMapa());
                vistaMapa.update();
                setInformacion(algoStar);
            }
        });

        Button zangano = new Button();
        zangano.setText("     Crear Zangano     ");
        zangano.setMinWidth(177);

        zangano.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //jugadorZerg.crearZangano(new Ubicacion(coordenadaX, coordenadaY));
                vistaMapa.update();
                setInformacion(algoStar);
            }
        });

        Button zerling = new Button();
        zerling.setText("     Crear Zerling     ");
        zerling.setMinWidth(183);

        Button hidralisco = new Button();
        hidralisco.setText("   Crear Hidralisco    ");
        hidralisco.setMinWidth(130);

        hidralisco.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //jugadorZerg.crearHidralisco(new Ubicacion(coordenadaX, coordenadaY));
                vistaMapa.update();
                setInformacion(algoStar);
            }
        });

        Button mutalisco = new Button();
        mutalisco.setText("    Crear Mutalisco    ");
        mutalisco.setMinWidth(180);

        Button guardian = new Button();
        guardian.setText("Evolucionar a Guardian ");
        guardian.setMinWidth(130);

        Button devorador = new Button();
        devorador.setText("Evolucionar a Devorador");
        devorador.setMinWidth(130);

        GridPane panel = new GridPane();
        GridPane.setConstraints(amo, 0, 0);
        GridPane.setConstraints(zangano, 1, 0);
        GridPane.setConstraints(zerling, 2, 0);
        GridPane.setConstraints(hidralisco, 3, 0);
        GridPane.setConstraints(mutalisco, 0, 1);
        GridPane.setConstraints(guardian, 1, 1);
        GridPane.setConstraints(devorador, 2, 1);
        panel.getChildren().addAll(amo, zangano, zerling, hidralisco, mutalisco, guardian, devorador);

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

    // Se crea la botonera Protoss con los edificios correspondientes.
    public GridPane setBotoneraUnidadesProtoss(AlgoStar algoStar) {
        Jugador jugadorProtoss = algoStar.obtenerJugadorTurno();

        Button zealot = new Button();
        zealot.setText("Crear Zealot");
        zealot.setMinWidth(130);

        Button dragon = new Button();
        dragon.setText("Crear Dragon");
        dragon.setMinWidth(130);

        Button scout = new Button();
        scout.setText("Crear Scout ");
        scout.setMinWidth(130);

        GridPane panel = new GridPane();
        GridPane.setConstraints(zealot, 0, 0);
        GridPane.setConstraints(dragon, 1, 0);
        GridPane.setConstraints(scout, 2, 0);
        panel.getChildren().addAll(zealot, dragon, scout);

        return panel;
    }

    // Se crea la botonera de movimiento
    public HBox setBotoneraMovimiento(AlgoStar algoStar) {
        // Boton de movimiento

        Button mover = new Button();
        mover.setText("Mover");

        BotonMoverEventHandler botonMoverEventHandler = new BotonMoverEventHandler(vistaMapa, algoStar.obtenerJugadorTurno(), this);
        mover.setOnAction(botonMoverEventHandler);

        // Boton de movimiento

        Button direccion = new Button();
        direccion.setText("Cambiar de direccion");

        BotonDireccionEventHandler botonDireccionEventHandler = new BotonDireccionEventHandler(algoStar.obtenerJugadorTurno(), this);
        direccion.setOnAction(botonDireccionEventHandler);

        HBox contenedorHorizontalBMovimiento = new HBox(mover, direccion);

        return contenedorHorizontalBMovimiento;
    }

    // Se crea la botonera de movimiento
    public HBox setBotoneraAtaque(AlgoStar algoStar) {
        Mapa mapa = algoStar.obtenerMapa();

        // Boton de ataque

        Button atacar = new Button();
        atacar.setText("Atacar");

        BotonAtacarEventHandler botonAtacarEventHandler = new BotonAtacarEventHandler(this.canvasCentral, mapa, mapa.obtenerUnidadEnUbicacion(new Ubicacion(coordenadaX, coordenadaY)));
        atacar.setOnAction(botonAtacarEventHandler);

        HBox contenedorHorizontalBMovimiento = new HBox(atacar);

        return contenedorHorizontalBMovimiento;
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