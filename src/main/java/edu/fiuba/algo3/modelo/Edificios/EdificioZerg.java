package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;

public abstract class EdificioZerg extends Edificio {

    protected EdificioZerg(Tiempo unTiempo,Vida unaVida, Ubicacion unaUbicacion, Jugador unJugador) {
    	super(unTiempo, unaVida, unaUbicacion, unJugador);
    }
    
    @Override
    public void recuperarse() {
    	this.vida.recuperarse();
    }
    
    @Override
    public void recibirAtaque(int unAtaque, Unidad unidadAtacante) {
    	this.vida.recibirDanioPor(unAtaque, unidadAtacante, this, this.jugador);
    }
}