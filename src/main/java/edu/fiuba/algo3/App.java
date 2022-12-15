package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.scene.Scene;
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

        // Pantalla de finalizacion
        PantallaFinal pantallaFinal = new PantallaFinal(stage);
        Scene escenaFinal = new Scene(pantallaFinal, 500, 500);
        escenaFinal.getStylesheets().add("file:src/main/resources/style.css");
        
        PantallaJuego pantallaJuego = new PantallaJuego(stage, escenaFinal, algoStar);
        Scene escenaJuego = new Scene(pantallaJuego, 500, 500);
        escenaJuego.getStylesheets().add("file:src/main/resources/style.css");

        // Pantalla donde se ingresa la inforamacion de los jugadores
        PantallaJugadores pantallaJugadores = new PantallaJugadores(stage, escenaJuego, algoStar, pantallaJuego);
        Scene escenaJugadores = new Scene(pantallaJugadores, 500, 500);
        escenaJugadores.getStylesheets().add("file:src/main/resources/style.css");

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