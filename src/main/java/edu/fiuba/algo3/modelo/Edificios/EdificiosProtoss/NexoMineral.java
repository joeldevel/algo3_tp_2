package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Minero;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

public class NexoMineral extends EdificioProtoss implements Minero {

    public static final int CONSTRUCCION_NEXO = -4;
    public static final int VIDA_NEXO = 250;
    public static final int ESCUDO_NEXO = 250;

    private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 50;
	private static final int COSTO_GAS = 0;
	private static final int RECOLECTABLE = 10;
	
	private int cantidadRecolectable;
    private NodoMineral nodo;
	
    public NexoMineral(NodoMineral unNodo, Ubicacion unaubicacion, Jugador unJugador) {
        super(new Tiempo(CONSTRUCCION_NEXO), new Vida(VIDA_NEXO), new Escudo(ESCUDO_NEXO), unaubicacion, unJugador,"NexoMineral");
        
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
        this.cantidadRecolectable = RECOLECTABLE;
        this.nodo = unNodo;

        unNodo.construirRecolectorDeMineral(this);
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
    	this.jugador.guardar(0, this.recolectarMineralDe(this.nodo));
    }
    
	@Override
	public int recolectarMineralDe(Mineral unNodoMineral) {
		return (unNodoMineral.recolectarMineral(this.cantidadRecolectable));
	}
    
	@Override
    public int obtenerMineral() {
		return this.jugador.getMineral();
    }

	@Override
	public boolean tieneMinero() {
		// TODO Auto-generated method stub
		return true;
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