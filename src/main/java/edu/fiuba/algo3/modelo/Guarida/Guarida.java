package edu.fiuba.algo3.modelo.Guarida;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Extractor.ExtractorUtilizable;

public class Guarida extends EdificioZerg implements RequisitoDeConstruccion {

    private EstadoOperativoGuarida estadoOperativo;

    public Guarida(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos, 
    			   ArrayList<CostoDeConstruccion> unosCostos){
        super(unaVida,unTiempo,unosRequisitos,unosCostos);
    	this.setComportamientoUtilizable(new GuaridaNoUtilizable());
    }

    public void setComportamientoUtilizable(EstadoOperativoGuarida nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

    	this.tiempo.pasarTiempo();
    	this.vida.recuperarse();
        if(this.tiempo.restante() == 0) {
        	this.setComportamientoUtilizable(new GuaridaUtilizable());
        }
    }

	@Override
	public boolean esIgualA(RequisitoDeConstruccion otroRequisito) {
		return (otroRequisito instanceof Guarida);
	}

    public boolean evolucionarLarva() {
        return this.estadoOperativo.evolucionarLarva();
    }
}