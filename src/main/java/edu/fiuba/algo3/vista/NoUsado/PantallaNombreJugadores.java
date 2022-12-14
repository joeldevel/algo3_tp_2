package edu.fiuba.algo3.vista.NoUsado;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.controlador.CrearJugadorHandler;
import edu.fiuba.algo3.controlador.IniciarPartidaHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PantallaNombreJugadores {
    private final Button continuar;
    private final Button jugador1Listo;
    private final Button jugador2Listo;
    private final TextField textFieldJ1;
    private final Label label1;
    private final Label label2;
    private final TextField textFieldJ2;
    private final Label labelColor1;
    private final Label labelColor2;
    private final Label labelRaza1;
    private final Label labelRaza2;
    private final HBox nombreJugadoresContainer;
    private VBox nombreJugador2Container;
    private VBox nombreJugador1Container;
    private VBox nombreJugadoresPane;
    private GridPane selectPlayerRoot;
    private HBox selectPlayersPane;
    private FlowPane screenRoot;

    private VBox nombreJ1Grupo;
    private VBox colorJ1Grupo;
    private VBox razaJ1Grupo;
    private VBox nombreJ2Grupo;
    private VBox colorJ2Grupo;
    private VBox razaJ2Grupo;

    private ComboBox<Color> jugador1Color;
    private ComboBox<Color> jugador2Color;

    private Scene scene;

    public PantallaNombreJugadores(AlgoStar juego, Stage stage, Scene proxima) {
        this.screenRoot = new FlowPane();
        this.selectPlayerRoot = new GridPane();
        this.selectPlayersPane = new HBox();

        this.nombreJ1Grupo = new VBox();
        this.colorJ1Grupo = new VBox();
        this.razaJ1Grupo = new VBox();
        this.nombreJ2Grupo = new VBox();
        this.colorJ2Grupo = new VBox();
        this.razaJ2Grupo = new VBox();
        // color picker
        this.jugador1Color = new ComboBox<>();
        this.jugador2Color = new ComboBox<>();
        this.jugador1Color.getItems().addAll(Color.RED, Color.BLUE, Color.GREEN);
        this.jugador2Color.getItems().addAll(Color.RED, Color.BLUE, Color.GREEN);

        this.nombreJugadoresPane = new VBox();
        nombreJugadoresPane.setSpacing(100);
        //nombreJugadoresPane.setId("select-player-pane"); //cambiar a clase
        this.nombreJugador1Container = new VBox();
        nombreJugador1Container.setSpacing(50);
        this.nombreJugador2Container = new VBox();
        nombreJugador2Container.setSpacing(50);
        this.continuar = new Button("Continuar");
        continuar.getStyleClass().add("btn");

        this.jugador1Listo = new Button("Listo");
        this.jugador2Listo = new Button("Listo");
        jugador1Listo.setMinWidth(400);
        jugador2Listo.setMinWidth(400);

        jugador2Listo.getStyleClass().add("btn");
        jugador2Listo.getStyleClass().add("btn-aceptar");
        jugador1Listo.getStyleClass().add("btn");
        jugador1Listo.getStyleClass().add("btn-aceptar");

        this.label1 = new Label("Nombre jugador 1:");
        this.textFieldJ1 = new TextField();
        textFieldJ1.getStyleClass().add("input-text");
        label1.getStyleClass().add("title");
        label1.getStyleClass().add("nombre-jugador");
        jugador1Listo.setOnAction(e -> System.out.println(textFieldJ1.getText()));

        this.label2 = new Label("Nombre jugador 2:");
        this.textFieldJ2 = new TextField();
        textFieldJ2.getStyleClass().add("input-text");
        label2.getStyleClass().add("title");
        label2.getStyleClass().add("nombre-jugador");
        jugador2Listo.setOnAction(e -> System.out.println(textFieldJ2.getText()));

        // colores
        this.labelColor1 = new Label("Elige el color ");
        labelColor1.getStyleClass().add("title");
        labelColor1.getStyleClass().add("nombre-jugador");

        this.labelColor2 = new Label("Elige el color ");
        labelColor2.getStyleClass().add("title");
        labelColor2.getStyleClass().add("nombre-jugador");
        // razas

        this.labelRaza1 = new Label("Elige la raza ");
        labelRaza1.getStyleClass().add("title");
        labelRaza1.getStyleClass().add("nombre-jugador");
        this.labelRaza2 = new Label("Elige la raza ");
        labelRaza2.getStyleClass().add("title");
        labelRaza2.getStyleClass().add("nombre-jugador");


        this.nombreJugadoresContainer = new HBox();
        // agrupar nombre
        nombreJ1Grupo.getChildren().addAll(label1, textFieldJ1);
        nombreJ2Grupo.getChildren().addAll(label2, textFieldJ2);
        // agrupar color
        colorJ1Grupo.getChildren().addAll(labelColor1, jugador1Color);
        colorJ2Grupo.getChildren().addAll(labelColor2, jugador2Color);
        // agrupar raza
        razaJ1Grupo.getChildren().addAll(labelRaza1);
        razaJ2Grupo.getChildren().addAll(labelRaza2);

        nombreJugador1Container.getChildren().addAll(nombreJ1Grupo, colorJ1Grupo, razaJ1Grupo, jugador1Listo);
        nombreJugador2Container.getChildren().addAll(nombreJ2Grupo, colorJ2Grupo, razaJ2Grupo, jugador2Listo);
        nombreJugadoresContainer.getChildren().addAll(nombreJugador1Container, nombreJugador2Container);
        nombreJugadoresContainer.setSpacing(10);
        nombreJugadoresPane.getChildren().addAll(nombreJugadoresContainer, continuar);
        nombreJugadoresPane.setAlignment(Pos.CENTER);
        nombreJugadoresContainer.setAlignment(Pos.CENTER);
        screenRoot.setAlignment(Pos.CENTER);

        selectPlayersPane.setAlignment(Pos.CENTER);
        screenRoot.setId("select-player-pane");

        selectPlayerRoot.setStyle("-fx-padding: 50px;");
        selectPlayersPane.setStyle("-fx-padding: 50px;");

        this.screenRoot.getChildren().add(nombreJugadoresPane);
        this.scene = new Scene(screenRoot);
        this.scene.getStylesheets().add("file:src/main/resources/style.css");

        // eventos
        CrearJugadorHandler crearJugador1Handler = new CrearJugadorHandler(juego, jugador1Listo, textFieldJ1);
        CrearJugadorHandler crearJugador2Handler = new CrearJugadorHandler(juego, jugador2Listo, textFieldJ2);
        jugador1Listo.setOnAction(crearJugador1Handler);
        jugador2Listo.setOnAction(crearJugador2Handler);

        IniciarPartidaHandler iniciarPartidaHandler = new IniciarPartidaHandler(stage, proxima);
        this.continuar.setOnAction(iniciarPartidaHandler);

    }

    public Scene getScene() {
        return this.scene;
    }
}
