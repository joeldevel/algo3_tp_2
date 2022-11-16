package edu.fiuba.algo3.modelo.ReservaDeProduccion;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.SinGas;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Espiral.EspiralNoUtilizable;
import edu.fiuba.algo3.modelo.Extractor.ExtractorUtilizable;

public class ReservaDeProduccion extends EdificioZerg implements RequisitoDeConstruccion{

    private EstadoOperativoReservaDeProduccion estadoOperativo;
    
    public ReservaDeProduccion() {
    	super(new Vida(1000,10), new Tiempo(-12),
    		  new ArrayList<RequisitoDeConstruccion>() {{add(new Moho()); add(new SinGas());}},
    		  new ArrayList<CostoDeConstruccion>());
    	this.setComportamientoUtilizable(new ReservaDeProduccionNoUtilizable());
    }

    public ReservaDeProduccion(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos,
    						   ArrayList<CostoDeConstruccion> unosCostos){
        super(unaVida,unTiempo,unosRequisitos,unosCostos);
        this.setComportamientoUtilizable(new ReservaDeProduccionNoUtilizable());
    }

    public void setComportamientoUtilizable(EstadoOperativoReservaDeProduccion nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    @Override
    public void avanzarTurno() {

    	this.tiempo.pasarTiempo();
    	this.vida.recuperarse();
        if(this.tiempo.restante() == 0) {
        	this.setComportamientoUtilizable(new ReservaDeProduccionUtilizable());
        }
        
    }

	@Override
	public ArrayList<RequisitoDeConstruccion> requisitos() {
		return this.requisitos;
	}

	@Override
	public boolean esIgualA(RequisitoDeConstruccion otroRequisito) {
		return (otroRequisito instanceof ReservaDeProduccion);
	}

	public boolean evolucionarLarva() {
		return this.estadoOperativo.evolucionarLarva();
	}

	@Override
	public Moho moho() {
		// TODO Auto-generated method stub
		return null;
	}
}