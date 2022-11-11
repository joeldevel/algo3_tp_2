package edu.fiuba.algo3.Criadero;

import java.util.*;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.Larva;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.SinGas;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Zangano;

public class Criadero extends EdificioZerg {

	private EstadoOperativoCriadero estado;
	

	public Criadero() {
		
		super(new Vida(500,10), new Tiempo(-4),new ArrayList<RequisitoDeConstruccion>() {{ add(new SinGas());}},
			  new ArrayList<CostoDeConstruccion>());
		this.estado = new CriaderoNoUtilizable(3,new Moho(),
					  new ArrayList<Larva>() {{ add(new Larva()); add(new Larva()); add(new Larva());}});
	}
	
	public Criadero(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos,
					ArrayList<CostoDeConstruccion> unosCostos, EstadoOperativoCriadero unEstado, Moho unMoho, 
					ArrayList<Larva> unasLarvas) {
		
		super(unaVida, unTiempo, unosRequisitos, unosCostos);
		this.estado = unEstado;
	}

	public boolean sePuedeUtilizar() {
		return (this.estado.estaOperativo());
	}

	public int tiempoDeEspera() {
		return (this.tiempo.restante());
	}

	@Override
	public void avanzarTurno() {
		
		this.tiempo.pasarTiempo();
		this.vida.recuperarse();
		if(this.sePuedeUtilizar()) {
			this.estado.actualizar();
		}
		if((this.tiempoDeEspera() == 0) && (! this.sePuedeUtilizar())) {
			this.estado = new CriaderoUtilizable(this.estado);
		}
		
	}

	public int radioDeMoho() {
		return (this.estado.radioMoho());
	}

	public int contarLarvas() {
		return (this.estado.contarLarvas());
	}

	public Zangano engendrarZangano() {
		return (this.estado.crearZangano());
	}

	public ArrayList<RequisitoDeConstruccion> requisitos() {
		return this.requisitos;
	}

	@Override
	public Moho moho() {
		return (this.estado.moho());
	}
	

}
