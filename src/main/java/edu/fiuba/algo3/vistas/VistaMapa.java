package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;
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
            this.canvas.getGraphicsContext2D().setFill(Color.GREEN);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX(), ubicacion.obtenerY(), 1, 1); // Posicion x, posicion y, ancho, altura
        }

        for(NodoMineral nodo: this.mapa.nodosMinerales()) {
            Ubicacion ubicacion = nodo.ubicacion();
            this.canvas.getGraphicsContext2D().setFill(Color.BLUE);
            this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX() - 5, ubicacion.obtenerY() - 5, 10, 10); // Posicion x, posicion y, ancho, altura
        }

        for(Volcan volcan: this.mapa.volcanes()) {
            Ubicacion ubicacion = volcan.ubicacion();

            Image imagen = new Image("file:src/main/resources/images/geiser-vespeno.png", 50, 50, true, false);
            this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX() - (imagen.getWidth()/2), ubicacion.obtenerY() - (imagen.getHeight()/2)); // Imagen, posicion x, posicion y
        }

        for(Edificio edificio: this.mapa.edificios()) {
            Ubicacion ubicacion = edificio.ubicacion();

            if(edificio.tiempoRestante() == 0) {
                if(edificio instanceof Criadero) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/criadero/criadero01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX() - (imagen.getWidth()/2), ubicacion.obtenerY() - (imagen.getHeight()/2));
                }

                else if (edificio instanceof ReservaDeReproduccion) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/reserva/reserva01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX() - (imagen.getWidth()/2), ubicacion.obtenerY() - (imagen.getHeight()/2));
                }

                else if (edificio instanceof Extractor) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/extractor/extractor01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX() - (imagen.getWidth()/2), ubicacion.obtenerY() - (imagen.getHeight()/2));
                }

                else if (edificio instanceof Guarida) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/guarida/guarida01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX() - (imagen.getWidth()/2), ubicacion.obtenerY() - (imagen.getHeight()/2));
                }

                else if (edificio instanceof Espiral) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/espiral/espiral01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX() - (imagen.getWidth()/2), ubicacion.obtenerY() - (imagen.getHeight()/2));
                }

                else if (edificio instanceof Acceso) {
                    Image imagen = new Image("file:src/main/resources/images/sprites/zerg/buildings/espiral/espiral01.png", 50, 50, true, false);
                    this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX() - (imagen.getWidth()/2), ubicacion.obtenerY() - (imagen.getHeight()/2));
                }

                else {
                    this.canvas.getGraphicsContext2D().setFill(Color.WHITE);
                    this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX() - 5, ubicacion.obtenerY() - 5, 10, 10); // Posicion x, posicion y, ancho, altura
                }
            }
        }

        for(Unidad unidad: this.mapa.unidades()) {
            Ubicacion ubicacion = unidad.ubicacion();

            if(unidad.tiempoRestante() == 0) {
                if(unidad.obtenerTipo() instanceof AmoSupremo) {
                    //Image imagen = new Image("file:src/main/resources/images/sprites/zerg/amo/amo-supremo.png", 50, 50, true, false);
                    //this.canvas.getGraphicsContext2D().drawImage(imagen, ubicacion.obtenerX() - (imagen.getWidth()/2), ubicacion.obtenerY() - (imagen.getHeight()/2));
                    this.canvas.getGraphicsContext2D().setFill(Color.WHITE);
                    this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX() - 5, ubicacion.obtenerY() - 5, 10, 10); // Posicion x, posicion y, ancho, altura
                }
                else {
                    this.canvas.getGraphicsContext2D().setFill(Color.ORANGE);
                    this.canvas.getGraphicsContext2D().fillOval(ubicacion.obtenerX() - 5, ubicacion.obtenerY() - 5, 10, 10); // Posicion x, posicion y, ancho, altura
                }
            }
        }
    }

    public void clean() {
        // Areas terrestres
        Image imagen = new Image("file:src/main/resources/images/backgrounddetailed5.png", ANCHO, ALTURA, false, false);
        this.canvas.getGraphicsContext2D().drawImage(imagen, 0, 0);

        // Areas espaciales
        Image imagen5 = new Image("file:src/main/resources/images/backgrounddetailed4.png", ANCHO/2, ALTURA/2, false, false);
        this.canvas.getGraphicsContext2D().drawImage(imagen5, 250, 125);
    }

    public void update() {
        this.dibujar();
    }
}