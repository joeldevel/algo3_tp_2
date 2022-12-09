package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Ubicacion;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
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

        for(Ubicacion ubicacion: this.mapa.ubicacionesConMoho()) {
            this.canvas.getGraphicsContext2D().setFill(Color.GREEN);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 10, 10); // Posicion x, posicion y, ancho, altura
        }

        for(Volcan volcan: this.mapa.volcanes()) {
            Ubicacion ubicacion = volcan.ubicacion();
            this.canvas.getGraphicsContext2D().setFill(Color.RED);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 10, 10); // Posicion x, posicion y, ancho, altura

            //Image imagen = new Image("file:src/main/resources/images/geiser-vespeno.png", 50, 50, true, false);
            //this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY());
        }

        for(NodoMineral nodo: this.mapa.nodosMinerales()) {
            Ubicacion ubicacion = nodo.ubicacion();
            this.canvas.getGraphicsContext2D().setFill(Color.BLUE);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 10, 10); // Posicion x, posicion y, ancho, altura
        }

        for(Edificio edificio: this.mapa.edificios()) {
            Ubicacion ubicacion = edificio.ubicacion();
            this.canvas.getGraphicsContext2D().setFill(Color.BLACK);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 5, 5); // Posicion x, posicion y, ancho, altura
        }
    }

    public void clean() {
        Image imagen = new Image("file:src/main/resources/images/field2.png", 1000, 500, true, false);
        this.canvas.getGraphicsContext2D().drawImage(imagen, 0, 0);

        //this.canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        //this.canvas.getGraphicsContext2D().fillRect(0,0,1000,500); // Ancho, Altura
    }

    public void update() {
        this.dibujar();
    }
}