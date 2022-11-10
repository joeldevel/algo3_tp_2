package edu.fiuba.algo3.modelo.Espiral;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Extractor.ExtractorUtilizable;

public class Espiral extends EdificioZerg {

    private EstadoOperativoEspiral estadoOperativo;

    public Espiral(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos,
    			   ArrayList<CostoDeConstruccion> unosCostos){
        super(unaVida,unTiempo,unosRequisitos,unosCostos);
        this.setComportamientoUtilizable(new EspiralNoUtilizable());
    }

    public void setComportamientoUtilizable(EstadoOperativoEspiral nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    @Override
    public void avanzarTurno() {

    	this.tiempo.pasarTiempo();
    	this.vida.recuperarse();
        if(this.tiempo.restante() == 0) {
        	this.setComportamientoUtilizable(new EspiralUtilizable());
        }
    }
}
