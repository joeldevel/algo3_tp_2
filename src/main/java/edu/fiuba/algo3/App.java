package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.AlgoStar.AlgoStar;
import edu.fiuba.algo3.vistas.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoStar");

        AlgoStar algoStar = crearModelo();

        // Pantalla de juego
        PantallaDeJuego pantallaDeJuego = new PantallaDeJuego(algoStar);

        // Pantalla donde se ingresa la inforamacion de los jugadores
        PantallaJugadores pantallaJugadores = new PantallaJugadores(stage, pantallaDeJuego.getScene(), algoStar, pantallaDeJuego);
        Scene escenaJugadores = new Scene(pantallaJugadores, 500, 500);

        // Pantalla de bienvenida
        PantallaBienvenidos pantallaBienvenidos = new PantallaBienvenidos(stage, escenaJugadores);
        Scene escenaBienvenidos = new Scene(pantallaBienvenidos, 500, 500);
        escenaBienvenidos.getStylesheets().add("file:src/main/resources/style.css");

        stage.setScene(escenaBienvenidos);
        stage.setFullScreenExitHint("Presiona ESC para salir de pantalla completa");
        stage.setFullScreen(true);

        stage.show();
        
    }

    private AlgoStar crearModelo() {
        AlgoStar algoStar = new AlgoStar();
        return algoStar;
    }
}