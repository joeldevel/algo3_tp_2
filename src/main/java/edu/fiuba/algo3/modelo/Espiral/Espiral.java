package edu.fiuba.algo3.modelo.Espiral;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.SinGas;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Guarida.Guarida;

public class Espiral extends EdificioZerg {

    private EstadoOperativoEspiral estadoOperativo;
    
    public Espiral() {
    	super(new Vida(1300,10), new Tiempo(-10),
    		  new ArrayList<RequisitoDeConstruccion>() {{add(new Moho()); add(new SinGas()); add(new Guarida());}},
    		  new ArrayList<CostoDeConstruccion>());
    	this.setComportamientoUtilizable(new EspiralNoUtilizable());
    }

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

    public boolean crear() {
        return this.estadoOperativo.crear();
    }

	@Override
	public Moho moho() {
		// TODO Auto-generated method stub
		return null;
	}
}
