package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Gas.RefineriaDeGas;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Asimilador extends EdificioProtoss implements RefineriaDeGas {

	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
    private int cantidadExtraible;
    private Volcan volcan;
    
    public Asimilador(Volcan unVolcan, Ubicacion unaUbicacion, Jugador unJugador) {
    	super(new Tiempo(-6), new Vida(450), new Escudo(450), unaUbicacion, unJugador);
    	
    	unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.cantidadExtraible = 20;
    	this.volcan = unVolcan;
    	
    	unVolcan.construirRefineriaDeGas(this);
    }

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}
    
    @Override
    public void ejecutaOperable() {
    	this.jugador.guardar(this.extraerGasDe(this.volcan), 0);
    }
    
    @Override
	public int extraerGasDe(Volcan unVolcan) {
		return (unVolcan.extraerGas(this.cantidadExtraible));
	}
	
	@Override
    public int obtenerGas() {
		return this.jugador.obtenerGas();
    }

	@Override
	public boolean tieneRefineria() {
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
