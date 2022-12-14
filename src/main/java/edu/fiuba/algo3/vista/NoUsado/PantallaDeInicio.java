package edu.fiuba.algo3.vista.NoUsado;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PantallaDeInicio {

    private Scene scene;
    private FlowPane initialScreenRoot;
    private VBox initialTextContainer;
    private Text text;
    private Text startGame;

    public PantallaDeInicio(Stage stage, Scene proxima) {
        this.initialScreenRoot = new FlowPane();
        this.initialTextContainer = new VBox();
        initialTextContainer.setAlignment(Pos.CENTER);
        initialScreenRoot.setId("pane");
        initialScreenRoot.setAlignment(Pos.CENTER);
        this.scene = new Scene(initialScreenRoot);
        this.scene.getStylesheets().add("file:src/main/resources/style.css");

        this.text = new Text();
        text.setText("AlgoStar");
        text.setId("display-title");
        text.setFill(Color.WHITESMOKE);

        this.startGame = new Text();
        startGame.setId("start-game");
        startGame.setText("Comenzar");
        startGame.setFill(Color.WHITESMOKE);

        initialTextContainer.getChildren().add(text);
        initialTextContainer.getChildren().add(startGame);

        initialScreenRoot.getChildren().add(initialTextContainer);

        startGame.setOnMouseClicked(e -> {
            stage.setScene(proxima);
        });

    }

    public Scene getScene() {
        return this.scene;
    }
}