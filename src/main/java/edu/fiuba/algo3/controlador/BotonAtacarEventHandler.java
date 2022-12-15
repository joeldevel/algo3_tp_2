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

    private final Mapa mapa;
    private final PantallaJuego pantalla;
    private final VistaMapa vistaMapa;

    public BotonAtacarEventHandler(AlgoStar algoStar, PantallaJuego pantalla, VistaMapa vista) {
        this.mapa = algoStar.obtenerMapa();
        this.pantalla = pantalla;
        this.vistaMapa = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (mapa.verificarUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())))) {
            Unidad atacable = mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())));

            System.out.println("Vida atacable antes: " + atacable.vidaRestante());

            mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY()))).atacar(atacable);

            System.out.println("Vida atacable despues: " + atacable.vidaRestante());

            vistaMapa.update();
        }

         if (mapa.verificarEdificioEn(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())))) {
            Edificio atacable = mapa.obtenerEdificioEn(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())));

            System.out.println("Vida atacable antes: " + atacable.obtenerVida());

            mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY()))).atacar(atacable);

            System.out.println("Vida atacable despues: " + atacable.obtenerVida());

            vistaMapa.update();
        }
    }
}