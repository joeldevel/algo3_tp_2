package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Minero;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class NexoMineral extends EdificioProtoss implements Minero {

    private final int POBLACION = 0;
	private final int COSTO_MINERAL = 50;
	private final int COSTO_GAS = 0;
	
	private int cantidadRecolectable;
    private Recursos recursosJugador;
    private NodoMineral nodo;

	
    public NexoMineral(NodoMineral unNodo, Recursos recursosJugador, Ubicacion unaubicacion, Jugador unJugador) {
        super(new Tiempo(-4), new Vida(250), new Escudo(250), unaubicacion, unJugador);
        
        recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
        this.cantidadRecolectable = 10;
        this.recursosJugador = recursosJugador;
        this.nodo = unNodo;

        unNodo.construirRecolectorDeMineral(this);
    }

    @Override
    public int obtenerPoblacion() {
        return POBLACION;
    }
    
    @Override
    public void ejecutaOperable() {
    	this.recursosJugador.guardar(0, this.recolectarMineralDe(this.nodo));
    }
    
	@Override
	public int recolectarMineralDe(Mineral unNodoMineral) {
		return (unNodoMineral.recolectarMineral(this.cantidadRecolectable));
	}
    
	@Override
    public int obtenerMineral() {
		return this.recursosJugador.obtenerMineral();
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
}