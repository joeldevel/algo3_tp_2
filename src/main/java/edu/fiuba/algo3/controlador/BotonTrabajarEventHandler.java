package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import edu.fiuba.algo3.vista.PantallaJuego;
import edu.fiuba.algo3.vista.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTrabajarEventHandler implements EventHandler<ActionEvent> {

    private final AlgoStar algoStar;
    private final PantallaJuego pantalla;
    private final VistaMapa vistaMapa;

    public BotonTrabajarEventHandler(AlgoStar algoStar, PantallaJuego pantalla, VistaMapa vista) {
        this.algoStar = algoStar;
        this.pantalla = pantalla;
        this.vistaMapa = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Mapa mapa = this.algoStar.obtenerMapa();

        if ((mapa.verificarEdificioEnUbicacion("Extractor", new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())))) &&
            (mapa.verificarUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY())))) &&
                    (mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY()))).obtenerTipo() instanceof Zangano)) {

            Unidad zangano = mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY())));
            Extractor extractor = (Extractor) mapa.obtenerEdificioEnUbicacion("Extractor", new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())));
            extractor.guardarZangano(zangano);

            this.pantalla.setDerecha(this.algoStar);
            this.vistaMapa.update();
        }

        if ((mapa.verificarNodoMineralEnUbicacion( new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())))) &&
                (mapa.verificarUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY())))) &&
                (mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY()))).obtenerTipo() instanceof Zangano)) {

            Unidad zangano = mapa.obtenerUnidadEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getUnidadCoordenadaY())));
            NodoMineral nodo = (NodoMineral) mapa.nodoEnUbicacion(new Ubicacion(this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaX()), this.pantalla.convertirCoordenada(this.pantalla.getCoordenadaY())));
            zangano.trabajarEn(nodo);

            this.pantalla.setDerecha(this.algoStar);
            this.vistaMapa.update();
        }
    }
}
