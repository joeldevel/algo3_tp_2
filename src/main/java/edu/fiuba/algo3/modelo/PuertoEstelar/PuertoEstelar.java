package edu.fiuba.algo3.modelo.PuertoEstelar;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Acceso;
import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EdificioProtoss;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Pilon.Pilon;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Moho;

public class PuertoEstelar extends EdificioProtoss {

    private EstadoOperativoPuertoEstelar estadoOperativo;
    
    public PuertoEstelar() {
    	super(new Vida(600,0), new Tiempo(-10), 
    		  new ArrayList<RequisitoDeConstruccion>() {{add(new Pilon()); add(new Acceso());}}, 
			  new ArrayList<CostoDeConstruccion>(), new Escudo(600,10));
    	this.setComportamientoUtilizable(new PuertoEstelarNoUtilizable());
    }

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
        this.recuperarse();
        if(this.tiempo.restante() == 0) {
            this.setComportamientoUtilizable(new PuertoEstelarUtilizable());
        }
    }

    public boolean transportarUnidades() {
        return this.estadoOperativo.transportarUnidades();
    }

	@Override
	public Moho moho() {
		// TODO Auto-generated method stub
		return null;
	}
}
