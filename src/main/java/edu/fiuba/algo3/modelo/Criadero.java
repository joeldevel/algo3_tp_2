package edu.fiuba.algo3.modelo;

import java.util.*;

public class Criadero extends EdificioZerg implements Edificio{

	private int maxLarvas;
	private EstadoDeEdificio estado;
	private Tiempo tiempo;
	private Moho moho;
	private ArrayList<RequisitoDeConstruccion> requisitos;
	private ArrayList<Larva> larvas;

	/*este constructor hay que cambiarlo porque es muy malo tener una dependencia tan fuerte con otras clases
	 * el constructor deberia recibir las dependecias por parametro y asi no depender de ellas y no instanciarlas
	 * esto haria el codigo mas flexible, pues el criadero pordria admitir cachorros en vez de larvas y deberia
	 * funcionar igual*/

	public Criadero() {
		this.maxLarvas = 3;
		this.estado = new EnConstruccion();
		this.tiempo = new Tiempo(-4);
		this.moho = new Moho();
		this.requisitos = new ArrayList<RequisitoDeConstruccion>();
		this.requisitos.add(new SinRequisitoDeConstruccion());
		this.larvas = new ArrayList<Larva>();
		for(int i=0; i<this.maxLarvas; i++) {
			larvas.add(new Larva());
		}

	}

	public boolean sePuedeUtilizar() {
		return (! this.estado.estaEnConstruccion());
	}

	public int tiempoDeEspera() {
		return (this.tiempo.restante());
	}

	public void avanzarTurno() {
		/* En esta parte debe ir una clase tiempo o un metodo actualizar que llame a los demas metodos
		 * incluyendo al metodo que genera la larva
		 * hay que sacar los if y encapsular el comportamiento de esos if en un metodo o en un objeto
		 * aparte*/

		this.tiempo.pasarTiempo();
		this.moho.expandirRadio(this.tiempo);
		if(this.tiempoDeEspera() == 0) {
			this.estado = new Construido();
		}
		if(this.contarLarvas() < this.maxLarvas) {
			this.larvas.add(new Larva());
		}
	}

	public int radioDeMoho() {
		return (this.moho.radio());
	}

	public int contarLarvas() {
		return this.larvas.size();
	}

	public Zangano engendrarZangano() {
		if(this.larvas.isEmpty()) {
			throw new CriaderoSinLarvasException();
		}
		Larva unaLarva = this.larvas.get(0);
		Zangano zangano = unaLarva.evolucionar();
		this.larvas.remove(0);
		return zangano;
	}

	public ArrayList<RequisitoDeConstruccion> requisitos() {
		return this.requisitos;
	}

	@Override
	public void actualizarRequisitosDeLaUbicacion(ArrayList<RequisitoDeConstruccion> requisitos) {
		requisitos.add(this.moho());
	}

	public Moho moho() {
		return this.moho;
	}

}
