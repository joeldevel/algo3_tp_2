package edu.fiuba.algo3.modelo;

public class Extractor implements RefineriaDeGas {

    private EstadoOperativoExtractor estadoOperativoExtractor;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;

    public Extractor(){
        this.tiempoDeConstruccion = -6;
        this.costoMineral = 100;
        this.costoGas = 0;
        this.estadoOperativoExtractor = new ExtractorNoUtilizable();
    }

    public void guardarZangano(Zangano zangano) {
        this.estadoOperativoExtractor.guardarZangano(zangano);
    }

    public void avanzarTurno() {

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.estadoOperativoExtractor = new ExtractorUtilizable(750,10);
        }
    }

    @Override
    public int extraerGasUsandoRefineria(Volcan unVolcan) {
         return unVolcan.extraerGas(estadoOperativoExtractor.extraerGas());
    }
}