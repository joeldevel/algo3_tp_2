package edu.fiuba.algo3.vistas.eventos;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.vistas.PantallaJuego;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCrearEntidadEventHandler implements EventHandler<ActionEvent> {

    String entidad;
    AlgoStar juego;
    VistaMapa vistaMapa;
    PantallaJuego pantalla;

    // Si le pasamos la ubicacion por parametro es un problema ya que el boton se crea al correr App.
    // Para crear la ubicacion entonces le pedimos a la pantalla que nos devuelva sus coordenadas donde se clickeo.
    public BotonCrearEntidadEventHandler(String unaEntidad, AlgoStar unJuego, VistaMapa unaVista, PantallaJuego unaPantalla) {
        this.entidad = unaEntidad;
        this.juego = unJuego;
        this.vistaMapa = unaVista;
        this.pantalla = unaPantalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // Obtenemos los jugadores y el mapa
        Jugador jugadorTurno = this.juego.obtenerJugadorTurno();
        Jugador jugadorContrario = this.juego.obtenerJugadorContrario(jugadorTurno);
        Mapa mapa = this.juego.obtenerMapa();

        // Creamos el edificio
        jugadorTurno.construir(this.entidad, new Ubicacion(this.pantalla.getCoordenadaX(), this.pantalla.getCoordenadaY()), jugadorContrario, mapa);
        // Actualizamos el mapa y la informacion en la pantalla
        this.vistaMapa.update();
        this.pantalla.setInformacion(this.juego);
    }
}
