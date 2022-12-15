package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.vista.PantallaJuego;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {

    private final AlgoStar algoStar;
    private final PantallaJuego pantalla;
    private final VistaMapa vistaMapa;

    public BotonAtacarEventHandler(AlgoStar algoStar, PantallaJuego pantalla, VistaMapa vista) {
        this.algoStar = algoStar;
        this.pantalla = pantalla;
        this.vistaMapa = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Mapa mapa = this.algoStar.obtenerMapa();

        if (mapa.verificarUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())))) {
            Unidad atacable = mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())));

            mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY()))).atacar(atacable);

            this.pantalla.setDerecha(this.algoStar);
            this.vistaMapa.update();
        }

         if (mapa.verificarEdificioEn(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())))) {
            Edificio atacable = mapa.obtenerEdificioEn(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())));

            mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY()))).atacar(atacable);

            this.pantalla.setDerecha(this.algoStar);
            this.vistaMapa.update();
        }
    }
}