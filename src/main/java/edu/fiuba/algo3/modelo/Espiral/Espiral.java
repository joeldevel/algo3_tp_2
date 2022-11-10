package edu.fiuba.algo3.modelo.Espiral;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Extractor.ExtractorUtilizable;

public class Espiral extends EdificioZerg {

    private EstadoOperativoEspiral estadoOperativo;

    public Espiral(Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos, Vida unaVida,
    		int unCostoMineral, int unCostoGas){
        super(unaVida,unosRequisitos,unTiempo);
        this.costoMineral = unCostoMineral;
        this.costoGas = unCostoGas;
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
