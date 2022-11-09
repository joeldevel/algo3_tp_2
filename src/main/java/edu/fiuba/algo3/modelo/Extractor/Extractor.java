package edu.fiuba.algo3.modelo.Extractor;

import edu.fiuba.algo3.modelo.*;

public class Extractor implements RefineriaDeGas {

    private EstadoOperativoExtractor estadoOperativo;
    private int vidaMaxima;
    public int vidaRestante;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;

    public Extractor(){
        this.vidaMaxima = 750;
        this.vidaRestante = 750;
        this.tiempoDeConstruccion = -6;
        this.costoMineral = 100;
        this.costoGas = 0;
        this.estadoOperativo = new ExtractorNoUtilizable();
    }

    public void guardarZangano(Zangano zangano) {
        this.estadoOperativo.guardarZangano(zangano);
    }

    public void setComportamientoUtilizable(ExtractorUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new ExtractorUtilizable(this.vidaMaxima, 10));
        }

        if(this.vidaRestante < this.vidaMaxima) {
            this.recuperarVida();
        }
    }

    @Override
    public int extraerGasUsandoRefineria(Volcan unVolcan) {
        return unVolcan.extraerGas(estadoOperativo.extraerGas());
    }

    public void recibirDanio(int unDanio) {
        this.vidaRestante = this.vidaRestante - unDanio;
    }

    public int obtenerVida() {
        return this.vidaRestante;
    }

    public void recuperarVida() {
        this.vidaRestante = this.vidaRestante + 10;
    }
}