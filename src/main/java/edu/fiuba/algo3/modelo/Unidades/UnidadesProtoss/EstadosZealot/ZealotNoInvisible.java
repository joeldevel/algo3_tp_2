package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot;

import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class ZealotNoInvisible implements EstadoDeZealot {

    public ZealotNoInvisible() {
    }

    public void recibirAtaque(int unDanio, Vida unaVida, Escudo unEscudo, Unidad unidadAtacante, Unidad unaUnidad, Jugador unJugador) {
        if (unDanio > unEscudo.restante()) {
            int danioRestante = unEscudo.restante() - unDanio;
            unaVida.recibirDanioPor(danioRestante, unidadAtacante, unaUnidad, unJugador);
        }
        unEscudo.recibirDanioPor(unDanio);
    }
}
