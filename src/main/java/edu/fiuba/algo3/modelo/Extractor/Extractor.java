package edu.fiuba.algo3.modelo.Extractor;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;

public class Extractor extends EdificioZerg implements RefineriaDeGas, Edificio {

    private EstadoOperativoExtractor estadoOperativo;
    private int cantidadExtraible;

    public Extractor(Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos, Vida unaVida,
    		int unCostoMineral, int unCostoGas, int unaCantidadExtraible){
        
    	super(unaVida,unosRequisitos,unTiempo);
    	this.costoMineral = unCostoMineral;
        this.costoGas = unCostoGas;
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
    public void actualizarRequisitosDeLaUbicacion(ArrayList<RequisitoDeConstruccion> requisitos) {

    }
}