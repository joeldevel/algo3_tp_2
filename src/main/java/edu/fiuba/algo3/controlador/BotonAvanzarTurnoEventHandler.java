package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import edu.fiuba.algo3.vista.PantallaJuego;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAvanzarTurnoEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaExcena;
    PantallaJuego pantalla;
    VistaMapa vistaMapa;
    AlgoStar algoStar;

    public BotonAvanzarTurnoEventHandler(Stage stage, Scene proximaExcena, PantallaJuego pantalla, VistaMapa vistaMapa, AlgoStar algoStar) {
        this.stage = stage;
        this.proximaExcena = proximaExcena;
        this.pantalla = pantalla;
        this.vistaMapa = vistaMapa;
        this.algoStar = algoStar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            this.algoStar.avanzarTurno();
            this.pantalla.setInformacion(algoStar);
            this.pantalla.setBotonera(algoStar);
            this.vistaMapa.update();

        } catch (AlgoStarFinalizadoException e) {
            this.stage.setScene(this.proximaExcena);
            this.stage.setFullScreenExitHint("");
            this.stage.setFullScreen(true);
        }
    }
}
