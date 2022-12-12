package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import static edu.fiuba.algo3.vistas.PantallaJuego.ALTURA;
import static edu.fiuba.algo3.vistas.PantallaJuego.ANCHO;

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
            Image imagen = new Image("file:src/main/resources/images/moho.png", 50, 50, true, false);
            this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY()); // Imagen, posicion x, posicion y
        }

        for(Volcan volcan: this.mapa.volcanes()) {
            Ubicacion ubicacion = volcan.ubicacion();

            Image imagen = new Image("file:src/main/resources/images/geiser-vespeno.png", 50, 50, true, false);
            this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY()); // Imagen, posicion x, posicion y

            //System.out.println(imagen.getHeight());
            //System.out.println(imagen.getWidth());
        }

        for(NodoMineral nodo: this.mapa.nodosMinerales()) {
            Ubicacion ubicacion = nodo.ubicacion();
            //this.canvas.getGraphicsContext2D().setFill(Color.BLUE);
            //this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 10, 10); // Posicion x, posicion y, ancho, altura

            Image imagen = new Image("file:src/main/resources/images/nodo-mineral.png", 50, 50, true, false);
            this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY()); // Imagen, posicion x, posicion y
        }

        for(Edificio edificio: this.mapa.edificios()) {
            Ubicacion ubicacion = edificio.ubicacion();

            if(edificio.tiempoRestante() == 0) {
                if(edificio instanceof Criadero) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/criadero/criadero01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY());
                }

                else if (edificio instanceof ReservaDeReproduccion) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/reserva/reserva01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY());
                }

                else if (edificio instanceof Extractor) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/extractor/extractor01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY());
                }

                else if (edificio instanceof Guarida) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/guarida/guarida01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY());
                }

                else if (edificio instanceof Espiral) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/espiral/espiral01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX(), ubicacion.obtenerY());
                }
            }
        }

        for(Ubicacion ubicacion: this.mapa.areasEspaciales()) {
            this.canvas.getGraphicsContext2D().setFill(Color.BLACK);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 1, 1); // Posicion x, posicion y, ancho, altura
        }

        for(Unidad unidad: this.mapa.unidades()) {

            if(unidad.tiempoRestante() == 0) {
                Ubicacion ubicacion = unidad.ubicacion();
                this.canvas.getGraphicsContext2D().setFill(Color.ORANGE);
                this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 5, 5); // Posicion x, posicion y, ancho, altura
            }
        }
    }

    public void clean() {
        Image imagen = new Image("file:src/main/resources/images/field2.png", ANCHO, ALTURA, false, false);
        this.canvas.getGraphicsContext2D().drawImage(imagen, 0, 0);

        //this.canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
        //this.canvas.getGraphicsContext2D().fillRect(0,0,1000,500); // Ancho, Altura
    }

    public void update() {
        this.dibujar();
    }
}