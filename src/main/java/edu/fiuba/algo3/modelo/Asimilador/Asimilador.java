package edu.fiuba.algo3.modelo.Asimilador;

import edu.fiuba.algo3.modelo.*;

public class Asimilador implements RefineriaDeGas {

    private EstadoOperativoAsimilador estadoOperativo;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;

    public Asimilador(){
        this.tiempoDeConstruccion = -6;
        this.costoMineral = 100;
        this.costoGas = 0;
        this.estadoOperativo = new AsimiladorNoUtilizable();
    }

    public void setComportamientoUtilizable(AsimiladorUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new AsimiladorUtilizable(450, 450, 20));
        }
    }

    @Override
    public int extraerGasUsandoRefineria(Volcan unVolcan) {
        return unVolcan.extraerGas(estadoOperativo.extraerGas());
    }
}
