package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoError;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.CONSTRUCCION_SCOUT;

public class PuertoEstelar extends EdificioProtoss {

    public static final int CONSTRUCCION_PUERTO = -10;
    public static final int VIDA_PUERTO = 600;
    public static final int ESCUDO_PUERTO = 600;

    private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 150;
	private static final int COSTO_GAS = 150;

    public PuertoEstelar(Ubicacion unaUbicacion, Jugador unJugador){
        super(new Tiempo(CONSTRUCCION_PUERTO), new Vida(VIDA_PUERTO), new Escudo(ESCUDO_PUERTO), unaUbicacion, unJugador,"PuertoEstelar");

        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
    }

    @Override
    public ArrayList<Unidad> devolverLarvas() {
        return new ArrayList<Unidad>();
    }

    @Override
    public int obtenerPoblacion() {
        return POBLACION;
    }
    
    @Override
    public void ejecutaOperable() {
        // ...
    }
    
    public Unidad transportarScout() {
    	if(! this.estaEnergizado()) {
    		throw new EdificioNoEnergizadoError();
    	}
    	if(this.tiempoRestante() != 0) {
			throw new EdificioNoOperativoException();
		}
    	Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), this.ubicacion, new Scout(this.jugador));
    	return scout;
    }
	
    @Override
    public boolean compararSuperficie(String unTipoDeSuperficie) {
        return this.superficie.compararTipos(unTipoDeSuperficie);
    }

    @Override
    public void serRevelado() {
        // No hace nada.
    }
}
