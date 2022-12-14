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

    public final int ALTO_RADIO = 21;
    public final int ANCHO_RADIO = 25;

    private final int POBLACION = 0;
	private final int COSTO_MINERAL = 50;
	private final int COSTO_GAS = 0;
	
	private int cantidadRecolectable;
    private NodoMineral nodo;

	
    public NexoMineral(NodoMineral unNodo, Ubicacion unaubicacion, Jugador unJugador) {
        super(new Tiempo(-4), new Vida(250), new Escudo(250), unaubicacion, unJugador,"NexoMineral");
        this.ubicacion.setPerimetro(ALTO_RADIO, ANCHO_RADIO);
        
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
        this.cantidadRecolectable = 10;
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
		return this.jugador.obtenerMineral();
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