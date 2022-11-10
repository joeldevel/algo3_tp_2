package edu.fiuba.algo3.modelo.Extractor;

import edu.fiuba.algo3.modelo.*;

public class Extractor extends EdificioZerg implements RefineriaDeGas {

    private EstadoOperativoExtractor estadoOperativo;
    private int cantidadExtraible;

    public Extractor(int unaVida, int unTiempoDeConstruccion, int unCostoMineral, int unCostoGas, int unaCantidadExtraible){
        this.vidaMaxima = unaVida;
        this.vidaRestante = unaVida;
        this.tiempoDeConstruccion = unTiempoDeConstruccion;
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

        if(this.vidaRestante < this.vidaMaxima) {
            this.recuperarVida();
        }

        if(this.tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(this.tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new ExtractorUtilizable(this.cantidadExtraible));
        }

    }

    @Override
    public int extraerGasUsandoRefineria(Volcan unVolcan) {
        return unVolcan.extraerGas(this.estadoOperativo.extraerGas());
    }
}