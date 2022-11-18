package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;

public class NexoMineral extends EdificioProtoss implements Minero {

	private final int COSTO_MINERAL = 50;
	private final int COSTO_GAS = 0;
	
	private int maxRecolectable;
    public int recolectado;
    private NodoMineral nodo;

	
    public NexoMineral(NodoMineral unNodo) {
        super(new Tiempo(-4),new Vida(250), new Escudo(250));
        this.maxRecolectable = 10;
        this.recolectado = 0;
        this.nodo = unNodo;
    }
    
	@Override
	public int extraerMineralDe(NodoMineral unNodoMineral) {
		return (unNodoMineral.recolectarMineral(this.maxRecolectable));
	}

	@Override
	public void ejecutaOperable() {
		this.recolectado += this.extraerMineralDe(nodo);
	}
    
	@Override
    public int obtenerMineral() {
		int cantidadRecolectada = this.recolectado;
        this.recolectado = 0;
        return cantidadRecolectada;
    }

	@Override
	public boolean tieneMinero() {
		// TODO Auto-generated method stub
		return true;
	}
}