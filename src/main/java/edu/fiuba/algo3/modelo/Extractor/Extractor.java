package edu.fiuba.algo3.modelo.Extractor;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class Extractor extends EdificioZerg implements RefineriaDeGas {

    private int cantidadExtraible;
    private EstadoOperativoExtractor estadoOperativo;
    
    public Extractor() {
    	super(new Vida(750,10), new Tiempo(-6), 
    		  new ArrayList<RequisitoDeConstruccion>() {{ add(new Moho()); add(new GasVespeno());}},
  			  new ArrayList<CostoDeConstruccion>());
    	this.cantidadExtraible = 10;
    	this.setComportamientoUtilizable(new ExtractorNoUtilizable());
        
    }

    public Extractor(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos, 
    				 ArrayList<CostoDeConstruccion> unosCostos, int unaCantidadExtraible){
        
    	super(unaVida,unTiempo,unosRequisitos,unosCostos);
    	this.cantidadExtraible = unaCantidadExtraible;
        this.setComportamientoUtilizable(new ExtractorNoUtilizable());
        
    }

    public void guardarZangano(Zangano zangano) {
        this.estadoOperativo.guardarZangano(zangano);
    }

    public void setComportamientoUtilizable(EstadoOperativoExtractor nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    @Override
    public void avanzarTurno() {
    	
    	this.tiempo.pasarTiempo();
    	this.vida.recuperarse();
        if(this.tiempo.restante() == 0) {
            this.setComportamientoUtilizable(new ExtractorUtilizable(this.cantidadExtraible));
        }

    }

    @Override
    public int extraerGasUsandoRefineria(Volcan unVolcan) {
        return unVolcan.extraerGas(this.estadoOperativo.extraerGas());
    }

    @Override
    public ArrayList<RequisitoDeConstruccion> requisitos() {
        return this.requisitos;
    }

	@Override
	public Moho moho() {
		// TODO Auto-generated method stub
		return null;
	}
}