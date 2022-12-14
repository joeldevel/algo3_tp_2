package edu.fiuba.algo3.vista.NoUsado;

import edu.fiuba.algo3.modelo.AlgoStar;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PantallaDeJuego {
    //layouts
    private final BorderPane rootPane;
    private final BorderPane topPane;
    private final Scene scene;
    private final GridPane buttonsPane;
    private final HBox bottomContainer;
    private final VBox leftContainer;
    private final VBox rightContainer;
    private final Pane mapa;
    private final Label labelTituloJugador1;
    private final Label labelTituloJugador2;
    private final Button botonSalir;
    private final Label labelNombreJugador;
    private final GridPane buildingsPane;
    //sprites
    private final Image hidralisco;
    private final Image mutalisco;
    private final Image zerling;
    private final Image zangano;
    private final Image criadero;
    private final Image reserva;
    private final Image extractor;
    private final Image guarida;
    private final Image espiral;
    private final Button botonTurno;
    private SimpleStringProperty stringUnidadesJugador;
    private SimpleStringProperty stringGasJugador;
    private SimpleStringProperty stringMineralJugador;
    private SimpleStringProperty stringNombreJugador;
    // botones
    private Button unidad1;
    private Button unidad2;
    private Button unidad3;
    private Button unidad4;
    private Button edificio1;
    private Button edificio2;
    private Button edificio3;
    private Button edificio4;
    private BotonEntidad edificio5;

    private String unidadACrear;

    private Label labelMineralJugador;
    private Label labelGasJugador;
    private Label labelUnidadesJugador;


    public PantallaDeJuego(AlgoStar juego) {
        // strings
        this.stringNombreJugador = new SimpleStringProperty(/*juego.obtenerJugadorTurno().getNombre()*/);
        this.stringMineralJugador = new SimpleStringProperty(/*String.valueOf(juego.obtenerJugadorTurno().obtenerMineral())*/);
        this.stringGasJugador = new SimpleStringProperty(/*String.valueOf(juego.obtenerJugadorTurno().obtenerGas())*/);
        this.stringUnidadesJugador = new SimpleStringProperty("0");
        // sprites
        this.hidralisco = new Image("file:src/main/resources/images/sprites/zerg/hidralisco/hidralisco01.png");
        this.mutalisco = new Image("file:src/main/resources/images/sprites/zerg/mutalisco/mutalisco01.png");
        this.zerling = new Image("file:src/main/resources/images/sprites/zerg/zerling/zerling01.png");
        this.zangano = new Image("file:src/main/resources/images/sprites/zerg/zangano/zangano01.png");
        this.criadero = new Image("file:src/main/resources/images/sprites/zerg/buildings/criadero/criadero01.png");
        this.reserva = new Image("file:src/main/resources/images/sprites/zerg/buildings/reserva/reserva01.png");
        this.extractor = new Image("file:src/main/resources/images/sprites/zerg/buildings/extractor/extractor01.png");
        this.guarida = new Image("file:src/main/resources/images/sprites/zerg/buildings/guarida/guarida01.png");
        this.espiral = new Image("file:src/main/resources/images/sprites/zerg/buildings/espiral/espiral01.png");

//        this.onClickMenu = new MyPopUp();
        // secciones
        this.rootPane = new BorderPane();
        this.topPane = new BorderPane();
        this.leftContainer = new VBox();
        this.bottomContainer = new HBox();
        this.rightContainer = new VBox();
        this.mapa = new Pane();
        this.buttonsPane = new GridPane();
        this.buildingsPane = new GridPane();

        // labels
        this.labelTituloJugador1 = new Label("Datos Jugador 1");
        this.labelTituloJugador1.getStyleClass().add("title");
        this.labelTituloJugador2 = new Label("Datos Jugador 2");
        this.labelTituloJugador2.getStyleClass().add("title");

        // salir
        this.botonSalir = new Button("Salir");
        this.botonSalir.getStyleClass().add("btn-salir");
        // pasar turno
        this.botonTurno = new Button("Avanzar Turno");
        botonTurno.getStyleClass().add("btn-turno");
        // controles, mejora: pasar a usar una lista de botones
        this.crearBotonesUnidades();
        buttonsPane.setVgap(4);
        buttonsPane.setHgap(4);
        unidad1.setOnMouseClicked(e -> this.unidadACrear = "HIDRALISCO");
        unidad2.setOnMouseClicked(e -> this.unidadACrear = "MUTALISCO");
        unidad3.setOnMouseClicked(e -> this.unidadACrear = "ZERLING");
        unidad4.setOnMouseClicked(e -> this.unidadACrear = "ZANGANO");

        buttonsPane.add(unidad1, 1, 1);
        buttonsPane.add(unidad2, 2, 1);
        buttonsPane.add(unidad3, 3, 1);
        buttonsPane.add(unidad4, 4, 1);


        this.crearBotonesEdificios();
        buildingsPane.setHgap(4);
        buildingsPane.setVgap(4);

        edificio1.setOnMouseClicked(e -> this.unidadACrear = "CRIADERO");
        edificio2.setOnMouseClicked(e -> this.unidadACrear = "RESERVA");
        edificio3.setOnMouseClicked(e -> this.unidadACrear = "EXTRACTOR");
        edificio4.setOnMouseClicked(e -> this.unidadACrear = "GUARIDA");
        edificio5.setOnMouseClicked(e -> this.unidadACrear = "ESPIRAL");

        buildingsPane.add(edificio1, 1, 1);
        buildingsPane.add(edificio2, 2, 1);
        buildingsPane.add(edificio3, 3, 1);
        buildingsPane.add(edificio4, 4, 1);
        buildingsPane.add(edificio5, 5, 1);


        // pasar turno
        botonTurno.setOnAction(e -> {
            juego.avanzarTurno();
            stringNombreJugador.set(juego.obtenerJugadorTurno().obtenerNombre());
            stringGasJugador.set(String.valueOf(juego.obtenerJugadorTurno().obtenerGas() + (int)(Math.floor(Math.random() * 10))));
            stringMineralJugador.set(String.valueOf(juego.obtenerJugadorTurno().obtenerMineral() ));
//            System.out.println("turno despus de avanzar = " + juego.obtenerJugadorTurno().getNombre());
        });
        // boton salida
        botonSalir.setOnAction(e -> Platform.exit());

        // top
        this.labelNombreJugador = new Label();
        this.labelGasJugador = new Label();
        this.labelMineralJugador = new Label();
        this.labelUnidadesJugador = new Label();
        labelNombreJugador.textProperty().bindBidirectional(stringNombreJugador);
        labelMineralJugador.textProperty().bindBidirectional(stringMineralJugador);
        labelGasJugador.textProperty().bindBidirectional(stringGasJugador);
        labelUnidadesJugador.textProperty().bindBidirectional(stringUnidadesJugador);

        labelNombreJugador.setMinWidth(200);
        labelNombreJugador.setMaxWidth(200);
//        labelNombreJugador.getStyleClass().addAll("title", "label-light");
        topPane.setRight(botonSalir);
//        topPane.setCenter(labelNombreJugador);

        topPane.setCenter(new PanelDatosJugador(labelNombreJugador, labelMineralJugador, labelGasJugador, labelUnidadesJugador).getPanel());
        topPane.setLeft(botonTurno);
        topPane.setMinHeight(70);
        topPane.setPadding(new Insets(10));
        topPane.getStyleClass().add("panel-superior");

        // bottom

        bottomContainer.setPadding(new Insets(10));
        bottomContainer.getStyleClass().add("panel-control-inferior");
        bottomContainer.getChildren().addAll(buildingsPane, buttonsPane);
        bottomContainer.setAlignment(Pos.CENTER);

        // center
        this.mapa.getStyleClass().add("fondo-mapa");

        // poner secciones
        rootPane.setTop(topPane);
        rootPane.setBottom(bottomContainer);
        rootPane.setCenter(mapa);

        this.scene = new Scene(rootPane);
        this.scene.getStylesheets().add("file:src/main/resources/style.css");

        // para crear elementos sobre el mapa
        mapa.setOnMouseClicked(e -> {
            System.out.println("x: " + e.getX());
            System.out.println("y: " + e.getY());
            if (this.unidadACrear != null) {
                ImageView temp = this.spriteParaMapa();
                temp.relocate(e.getX(), e.getY());
                mapa.getChildren().add(temp);
                this.unidadACrear = null;
            }
        });
    }

    private ImageView spriteParaMapa() {
        if (this.unidadACrear == "MUTALISCO") {
            return new ImageView(this.mutalisco);
        }
        if (this.unidadACrear == "HIDRALISCO") {
            return new ImageView(this.hidralisco);
        }
        if (this.unidadACrear == "ZERLING") {
            return new ImageView(this.zerling);
        }
        if (this.unidadACrear == "ZANGANO") {
            return new ImageView(this.zangano);
        }
        if (this.unidadACrear == "CRIADERO") {
            return new ImageView(this.criadero);
        }
        if (this.unidadACrear == "RESERVA") {
            return new ImageView(this.reserva);
        }
        if (this.unidadACrear == "EXTRACTOR") {
            return new ImageView(this.extractor);
        }
        if (this.unidadACrear == "GUARIDA") {
            return new ImageView(this.guarida);
        }
        if (this.unidadACrear == "ESPIRAL") {
            return new ImageView(this.espiral);
        }
        return null;

    }


    private void crearBotonesEdificios() {

        ImageView imageView1 = new ImageView(this.criadero);
        ImageView imageView2 = new ImageView(this.reserva);
        ImageView imageView3 = new ImageView(this.extractor);
        ImageView imageView4 = new ImageView(this.guarida);
        ImageView imageView5 = new ImageView(this.espiral);

        this.edificio1 = new BotonEntidad("", imageView1, "btn-bicho", new Tooltip("Un criadero"));
        this.edificio2 = new BotonEntidad("", imageView2, "btn-bicho", new Tooltip("Una reserva"));
        this.edificio3 = new BotonEntidad("", imageView3, "btn-bicho", new Tooltip("Un extractor"));
        this.edificio4 = new BotonEntidad("", imageView4, "btn-bicho", new Tooltip("Una guarida"));
        this.edificio5 = new BotonEntidad("", imageView5, "btn-bicho", new Tooltip("Un espiral"));


        // para desabilitar un boton
//        this.edificio5.setDisable(true);
//        edificio5.getStyleClass().removeAll("btn-bicho");
//        edificio5.getStyleClass().add("btn-bicho-disabled");
    }

    public Scene getScene() {
        return this.scene;
    }

    private void crearBotonesUnidades() {

        ImageView imageView1 = new ImageView(this.hidralisco);
        ImageView imageView2 = new ImageView(this.mutalisco);
        ImageView imageView3 = new ImageView(this.zerling);
        ImageView imageView4 = new ImageView(this.zangano);

        this.unidad1 = new BotonEntidad("", imageView1, "btn-bicho", new Tooltip("hidralisco"));
        this.unidad2 = new BotonEntidad("", imageView2, "btn-bicho", new Tooltip("mutaliscon"));
        this.unidad3 = new BotonEntidad("", imageView3, "btn-bicho", new Tooltip("zerling"));
        this.unidad4 = new BotonEntidad("", imageView4, "btn-bicho", new Tooltip("zangano"));
    }
}


class PanelDatosJugador {

    private Label jugador;
    private Label gas;
    private Label mineral;
    private Label unidades;

    private HBox panel;

    // ver si los tipos de datos son correctos, tal vez usar un map para las construcciones y unidades
    PanelDatosJugador(Label jugador, Label gas, Label mineral, Label unidades) {
        this.jugador = jugador;
        this.gas = gas;
        this.mineral = mineral;
        this.unidades = unidades;
        this.panel = new HBox();


        panel.getChildren().addAll(
                this.seccionPanel("Jugador", jugador),
                this.seccionPanel("Gas:", gas),
                this.seccionPanel("Mineral: ", mineral),
                this.seccionPanel("Unidades: ", unidades)
        );
//        this.panel.setMinWidth(300);
//        this.panel.setMaxWidth(300);
        this.panel.setAlignment(Pos.CENTER);
        this.panel.getStyleClass().add("panel-lateral");// cambiar a otro estilo
    }

    public HBox getPanel() {
        return this.panel;
    }

    private VBox seccionPanel(String etiqueta, Label contenido) {
        VBox contenedor = new VBox();
        contenedor.setPadding(new Insets(6));
        contenedor.setSpacing(10);
        Label titulo = new Label(etiqueta);
        titulo.getStyleClass().addAll("title", "label-light");
        titulo.getStyleClass().add("seccion-panel-jugador-titulo");
//        Label labelContenido = new Label(contenido);
        contenido.getStyleClass().addAll("seccion-panel-jugador-contenido", "label-light");
        contenedor.getChildren().addAll(titulo, contenido);
        contenedor.setAlignment(Pos.CENTER);
        return contenedor;
    }
}

class BotonEntidad extends Button {
    public BotonEntidad(String texto, ImageView sprite, String clase, Tooltip tooltip) {
        super(texto);
        this.setTooltip(tooltip);
        this.getStyleClass().add(clase);
        this.setPrefSize(50, 50);
        this.setPadding(new Insets(6));
        sprite.setPreserveRatio(true);
        sprite.setFitHeight(40);

        this.setGraphic(sprite);
    }

}
