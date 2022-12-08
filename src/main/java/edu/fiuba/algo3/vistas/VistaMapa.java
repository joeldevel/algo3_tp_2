package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Ubicacion;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaMapa {

    private Mapa mapa;
    Canvas canvas;

    public VistaMapa(Mapa mapa, Canvas canvas) {
        this.mapa = mapa;
        this.canvas = canvas;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    public void dibujarFormas() {
        this.clean();

        for(Volcan volcan: this.mapa.volcanes()) {
            Ubicacion ubicacion = volcan.ubicacion();
            this.canvas.getGraphicsContext2D().setFill(Color.RED);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 10, 10); // Posicion x, posicion y, ancho, altura
        }

        for(NodoMineral nodo: this.mapa.nodosMinerales()) {
            Ubicacion ubicacion = nodo.ubicacion();
            this.canvas.getGraphicsContext2D().setFill(Color.BLUE);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 10, 10); // Posicion x, posicion y, ancho, altura
        }
    }

    public void clean() {
        this.canvas.getGraphicsContext2D().setFill(Color.WHITE);
        this.canvas.getGraphicsContext2D().fillRect(0,0,1000,500); // Ancho, Altura
    }

    public void update() {
        this.dibujar();
    }
}