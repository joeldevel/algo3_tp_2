package edu.fiuba.algo3.modelo.Recursos.Minerales;

import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinMineralParaRecolectarException;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinRecolectorDeMineralConstruidoException;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralYaTieneUnRecolectorDeMineralException;

public class NodoMineral implements Mineral {

    private Minero minero;
    private int cantidadDeMineralDisponible;
    private Ubicacion ubicacion;

    public NodoMineral(Ubicacion unaUbicacion) {
        this.minero = new SinMinero(this);
        this.cantidadDeMineralDisponible = 2000;
        this.ubicacion = unaUbicacion;
    }

    public void construirRecolectorDeMineral(Minero unMinero) {
    	if(this.minero.tieneMinero()) {
    		throw new NodoMineralYaTieneUnRecolectorDeMineralException();
    	}
    	this.minero = unMinero;
    }
    
    @Override
    public int mineralRestante() {
    	return (this.cantidadDeMineralDisponible);
    }
    
    @Override
    public int recolectarMineral(int unaCantidadDeMineralParaExtraer) {
    	
    	/* Caso borde donde por ejemplo tenemos 10 de mineral y nos piden 30. Deberiamos devolver esos 10 y dejar al Nodo Mineral en 0. */
    	if(this.mineralRestante() == 0) {
    		throw new NodoMineralSinMineralParaRecolectarException();
    	}
    	if(!this.minero.tieneMinero()) {
            throw new NodoMineralSinRecolectorDeMineralConstruidoException();
        }
    	if(this.mineralRestante() < unaCantidadDeMineralParaExtraer) {
            unaCantidadDeMineralParaExtraer = this.cantidadDeMineralDisponible;
            this.cantidadDeMineralDisponible = 0;
            return unaCantidadDeMineralParaExtraer;
        }

        this.cantidadDeMineralDisponible = this.cantidadDeMineralDisponible - unaCantidadDeMineralParaExtraer;
        return unaCantidadDeMineralParaExtraer;
    }
    
    @Override
    public boolean tieneMineral() {
        return true;
    }
    
    public boolean estaEn(Ubicacion unaUbicacion) {
    	return (this.ubicacion.esIgualA(unaUbicacion));
    }

    public Ubicacion ubicacion() {
        return this.ubicacion;
    }
}
