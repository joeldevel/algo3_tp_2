package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Mineral;
import edu.fiuba.algo3.modelo.Minero;
import edu.fiuba.algo3.modelo.NodoMineral;
import edu.fiuba.algo3.modelo.SinNodo;

public class Zangano implements TipoDeUnidad,Minero {

	private int cantidadRecolectableDeMineral;
    private int cantidadRecolectada;
    private Mineral nodo;
    
    public Zangano() {
        this.cantidadRecolectableDeMineral = 10;
        this.cantidadRecolectada = 0;
        this.nodo = new SinNodo();
    }
    
    public void conNodo(NodoMineral unNodo) {
    	this.nodo = unNodo;
    }

	@Override
	public int extraerMineralDe(NodoMineral unNodoMineral) {
		return (unNodoMineral.recolectarMineral(cantidadRecolectableDeMineral));
	}

	@Override
	public int obtenerMineral() {
		int recolectado = this.cantidadRecolectada;
		this.cantidadRecolectada = 0;
		return recolectado;
	}

	@Override
	public boolean tieneMinero() {
		// TODO Auto-generated method stub
		return true;
	}

}