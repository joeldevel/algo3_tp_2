package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinMineralParaRecolectarException;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralYaTieneUnRecolectorDeMineralException;
import edu.fiuba.algo3.modelo.Unidades.Zangano;

public class NodoMineral implements Mineral {

    private Minero minero;
    private int cantidadDeMineral;

    public NodoMineral() {
        this.minero = new SinMinero(this);
        this.cantidadDeMineral = 2000;
    }

    public void construirNexo() {
    	if(this.minero.tieneMinero()) {
    		throw new NodoMineralYaTieneUnRecolectorDeMineralException();
    	}
    	this.minero = new NexoMineral(this);
    }
    
    public void asignarZangano(Zangano unZangano) {
    	unZangano.conNodo(this);
    	this.minero = unZangano;
    }

    @Override
    public int mineralRestante() {
    	return (this.cantidadDeMineral);
    }
    
    @Override
    public int recolectarMineral(int unaCantidad) {

    	/* Caso borde donde por ejemplo tenemos 10 de mineral y nos piden 30. Deberiamos devolver esos 10 y dejar al Nodo Mineral en 0. */
    	if(this.mineralRestante() == 0) {
    		throw new NodoMineralSinMineralParaRecolectarException();
    	}
    	int recolectado = 0;
    	if(unaCantidad > this.mineralRestante()) {
        	recolectado = this.mineralRestante();
        	this.cantidadDeMineral = 0;
        }
    	else {
    		recolectado = unaCantidad;
    		this.cantidadDeMineral -= unaCantidad;
    	}
    	return recolectado;
    }
}
