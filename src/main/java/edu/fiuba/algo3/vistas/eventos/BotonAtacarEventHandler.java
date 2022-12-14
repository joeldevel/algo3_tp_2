package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.vistas.PantallaJuego;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {

    private final Canvas canvas;
    private final Mapa mapa;
    private final PantallaJuego pantalla;
    private final VistaMapa vistaMapa;

    public BotonAtacarEventHandler(Canvas unCanvas, Mapa unMapa, PantallaJuego pantalla, VistaMapa vista) {
        this.canvas = unCanvas;
        this.mapa = unMapa;
        this.pantalla = pantalla;
        this.vistaMapa = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Unidad atacante = this.mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.getCoordenadaX(), this.pantalla.getCoordenadaY()));

        System.out.println("Vida atacante: " + atacante.vidaRestante());

        this.canvas.setOnMouseClicked(e -> {
            Unidad atacable = this.mapa.obtenerUnidadEnUbicacion(new Ubicacion((int) e.getX(), (int) e.getY()));

            System.out.println("Vida atacable antes: " + atacable.vidaRestante());

            atacante.atacar(atacable);

            System.out.println("Vida atacable despues: " + atacable.vidaRestante());

            vistaMapa.update();
            return;
        });
    }
}