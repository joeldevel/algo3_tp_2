package edu.fiuba.algo3.modelo.PuertoEstelar;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EdificioProtoss;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Escudo;

public class PuertoEstelar extends EdificioProtoss {

    private EstadoOperativoPuertoEstelar estadoOperativo;

    public PuertoEstelar(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos,
                   ArrayList<CostoDeConstruccion> unosCostos, Escudo unEscudo){
        super(unaVida,unTiempo,unosRequisitos,unosCostos, unEscudo);
        this.setComportamientoUtilizable(new PuertoEstelarNoUtilizable());
    }

    public void setComportamientoUtilizable(EstadoOperativoPuertoEstelar nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    @Override
    public void avanzarTurno() {

        this.tiempo.pasarTiempo();
        /* this.vida.recuperarse(); Escudo iria aquí. */
        if(this.tiempo.restante() == 0) {
            this.setComportamientoUtilizable(new PuertoEstelarUtilizable());
        }
    }

    public boolean transportarUnidades() {
        return this.estadoOperativo.transportarUnidades();
    }
}
