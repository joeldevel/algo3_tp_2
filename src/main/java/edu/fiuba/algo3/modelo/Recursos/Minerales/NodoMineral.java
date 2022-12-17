package edu.fiuba.algo3.modelo.Recursos.Minerales;

import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralYaTieneUnRecolectorDeMineralException;

public class NodoMineral implements Mineral {

    private static final int MINERAL_INICIAL = 2000;

    private Minero minero;
    private int cantidadDeMineralDisponible;
    private Ubicacion ubicacion;

    public NodoMineral(Ubicacion unaUbicacion) {
        this.minero = new SinMinero();
        this.cantidadDeMineralDisponible = MINERAL_INICIAL;
        this.ubicacion = unaUbicacion;
    }

    @Override
    public int getCantidadDeMineralDisponible() {
        return this.cantidadDeMineralDisponible;
    }

    public void construirRecolectorDeMineral(Minero unMinero) {
    	if(this.tieneMinero()) {
    		throw new NodoMineralYaTieneUnRecolectorDeMineralException();
    	}

    	this.minero = unMinero;
    }

    public boolean tieneMinero() {
        return (this.minero.tieneMinero());
    }
    
    @Override
    public int recolectarMineral(int unaCantidadDeMineralParaExtraer) {

        if (this.getCantidadDeMineralDisponible() > 0 && this.tieneMinero()) {

            if (this.getCantidadDeMineralDisponible() < unaCantidadDeMineralParaExtraer) {
                unaCantidadDeMineralParaExtraer = this.cantidadDeMineralDisponible;
                this.cantidadDeMineralDisponible = 0;
                return unaCantidadDeMineralParaExtraer;
            }

            this.cantidadDeMineralDisponible = this.cantidadDeMineralDisponible - unaCantidadDeMineralParaExtraer;
            return unaCantidadDeMineralParaExtraer;
        }

        return 0;
    }
    
    public boolean estaEn(Ubicacion unaUbicacion) {
    	return (this.ubicacion.esIgualA(unaUbicacion));
    }

    public Ubicacion ubicacion() {
        return this.ubicacion;
    }
}
