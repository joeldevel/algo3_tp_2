package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PantallaMapa {

    private final ImageView camel;
    private final StackPane root;
    private Scene scene;
    private Scene proxima;
    private Image tile;
    private double W;
    private double H;
    private Canvas canvas;
    private GraphicsContext gc;

    public PantallaMapa(Stage stage) {
        this.tile = new Image("file:src/main/resources/images/tile.png");
        this.W = tile.getWidth();
        this.H = tile.getHeight();
        this.canvas = new Canvas(1300, 640); // w x h
        this.gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setGlobalBlendMode(BlendMode.SCREEN);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gc.drawImage(tile, (i - j) * (W / 2) + canvas.getWidth() / 2 - W / 2, (i + j) * (H / 4) - canvas.getHeight() / 2);
            }
        }

        this.camel = new ImageView("file:src/main/resources/images/camel-metal-slug.png");

        this.root = new StackPane();
        root.setBorder(Border.EMPTY);
        camel.toBack();
        root.getChildren().addAll(canvas, camel);
        this.scene = new Scene(root);
    }

    public Scene getScene() {
        return this.scene;
    }

}
