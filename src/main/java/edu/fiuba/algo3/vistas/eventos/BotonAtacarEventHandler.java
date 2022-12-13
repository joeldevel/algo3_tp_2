package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {

    private final Canvas canvas;
    private final Mapa mapa;
    private final Unidad atacante;

    public BotonAtacarEventHandler(Canvas unCanvas, Mapa unMapa, Unidad unidadAtacante) {
        this.canvas = unCanvas;
        this.mapa = unMapa;
        this.atacante = unidadAtacante;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Vida atacante: " + this.atacante.vidaRestante());

        this.canvas.setOnMouseClicked(e -> {
            System.out.println("Ataque en x: " + e.getX());
            System.out.println("Ataque en y: " + e.getY() + "\n");
            Unidad atacable = this.mapa.obtenerUnidadEnUbicacion(new Ubicacion((int) e.getX(), (int) e.getY()));

            System.out.println("Vida antes: " + atacable.vidaRestante());

            this.atacante.atacar(atacable);

            System.out.println("Vida despues: " + atacable.vidaRestante());
        });
    }
}