package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;

public interface EstadoDeZealot {

    void recibirAtaque(int unDanio, Vida unaVida, Escudo unEscudo, Unidad unaUnidad, Jugador unJugador);
}
