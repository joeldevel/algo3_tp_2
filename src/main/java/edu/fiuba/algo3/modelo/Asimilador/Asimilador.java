package edu.fiuba.algo3.modelo.Asimilador;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.*;

public class Asimilador extends EdificioProtoss implements RefineriaDeGas {

    protected EstadoOperativoAsimilador estadoOperativo;
    protected int cantidadExtraible;
    

    public Asimilador(){
    	super(new Vida(450,0),new Tiempo(-6), 
    		  new ArrayList<RequisitoDeConstruccion>() {{add(new GasVespeno());}}, 
    		  new ArrayList<CostoDeConstruccion>(), new Escudo(450,10));
        this.estadoOperativo = new AsimiladorNoUtilizable();
        this.cantidadExtraible = 20;
    }
    
    public Asimilador(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos, 
    				  ArrayList<CostoDeConstruccion> unosCostos, Escudo unEscudo) {
    	super(unaVida,unTiempo,unosRequisitos,unosCostos,unEscudo);
    	this.estadoOperativo = new AsimiladorNoUtilizable();
    	this.cantidadExtraible = 20;
    }

    public void setComportamientoUtilizable(AsimiladorUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    @Override
    public void avanzarTurno() {
    	
    	this.tiempo.pasarTiempo();
		this.recuperarse();

        if(this.tiempo.restante() == 0) {
            this.setComportamientoUtilizable(new AsimiladorUtilizable(this.cantidadExtraible));
        }
    }

    @Override
    public int extraerGasUsandoRefineria(Volcan unVolcan) {
        return unVolcan.extraerGas(estadoOperativo.extraerGas());
    }

	@Override
	public Moho moho() {
		// TODO Auto-generated method stub
		return null;
	}
}
