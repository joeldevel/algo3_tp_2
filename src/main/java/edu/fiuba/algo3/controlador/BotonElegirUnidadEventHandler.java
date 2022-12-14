package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.vista.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonElegirUnidadEventHandler implements EventHandler<ActionEvent> {

    private final Mapa mapa;
    private final PantallaJuego pantalla;

    public BotonElegirUnidadEventHandler(AlgoStar algoStar, PantallaJuego pantalla) {
        this.mapa = algoStar.getMapa();
        this.pantalla = pantalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if(mapa.verificarUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())))) {
            this.pantalla.setUnidadCoordenadas(this.pantalla.getCoordenadaX(), this.pantalla.getCoordenadaY());
        }
    }
}