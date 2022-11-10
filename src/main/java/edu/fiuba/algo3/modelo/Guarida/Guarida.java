package edu.fiuba.algo3.modelo.Guarida;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Extractor.ExtractorUtilizable;

public class Guarida extends EdificioZerg {

    private EstadoOperativoGuarida estadoOperativo;

    public Guarida(Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos, Vida unaVida,
    		int unCostoMineral, int unCostoGas){
        super(unaVida,unosRequisitos,unTiempo);
    	this.costoMineral = unCostoMineral;
        this.costoGas = unCostoGas;
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
}