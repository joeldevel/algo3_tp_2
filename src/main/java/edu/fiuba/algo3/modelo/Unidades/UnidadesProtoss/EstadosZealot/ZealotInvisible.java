package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;

public class ZealotInvisible implements EstadoDeZealot {

    public ZealotInvisible() {
    }

    public void recibirAtaque(int unDanio, Vida unaVida, Escudo unEscudo, Unidad unidadAtacante, Unidad unaUnidad, Jugador unJugador) {
        // No hace nada.
    }
}
