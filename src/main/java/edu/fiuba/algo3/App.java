package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.AlgoStar.AlgoStar;
import edu.fiuba.algo3.vistas.PantallaDeInicio;
import edu.fiuba.algo3.vistas.PantallaDeJuego;
import edu.fiuba.algo3.vistas.PantallaMapa;
import edu.fiuba.algo3.vistas.PantallaNombreJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    AlgoStar juego;

    @Override
    public void start(Stage stage) {
        this.juego = new AlgoStar();

        stage.setFullScreen(true);
        PantallaDeJuego pantallaDeJuego = new PantallaDeJuego();
        PantallaNombreJugadores nombreJugadores = new PantallaNombreJugadores(juego, stage, pantallaDeJuego.getScene());
        Scene scene2 = nombreJugadores.getScene();

        PantallaDeInicio inicio = new PantallaDeInicio(stage, scene2);

        stage.setScene(inicio.getScene());

        stage.setFullScreenExitHint("Presiona Esc para salir de pantalla completa");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}