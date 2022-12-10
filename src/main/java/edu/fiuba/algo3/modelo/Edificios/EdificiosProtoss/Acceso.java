package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;


import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoError;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;

public class Acceso extends EdificioProtoss {

	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 0;
	
	private ArrayList<Unidad> zealots;
	private ArrayList<Unidad> dragones;
	
    public Acceso(Ubicacion unaUbicacion, Jugador unJugador) {
		super(new Tiempo(-8), new Vida(500), new Escudo(500), unaUbicacion, unJugador,"Acceso");
		this.zealots = new ArrayList<Unidad>();
		this.dragones = new ArrayList<Unidad>();
		
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
	}

	@Override
	public ArrayList<Unidad> devolverLarvas() {
		return new ArrayList<Unidad>();
	}

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public void ejecutaOperable() {
		if(this.estaEnergizado()) {
			this.pasarDragonesProductivos();
			this.pasarZealotsProductivos();
		}
	}
	
	public void transportarZealots() {
		if(! this.estaEnergizado()) {
			throw new EdificioNoEnergizadoError();
		}
		while(this.zealots.size() < 5) {
			this.zealots.add(new Unidad(new Tiempo(-4), this.ubicacion, new Zealot(this.ubicacion, this.jugador)));
		}
	}
	
	public void transportarDragones() {
		if(! this.estaEnergizado()) {
			throw new EdificioNoEnergizadoError();
		}
		while(this.dragones.size() < 5) {
			this.dragones.add(new Unidad(new Tiempo(-6), this.ubicacion, new Dragon(this.ubicacion, this.jugador)));
		}
	}
	
	private void pasarZealotsProductivos(){
    	ArrayList<Unidad> borrar = new ArrayList<>();

		for(Unidad actual: this.zealots) {
			this.jugador.agregarUnidad(actual);
			borrar.add(actual);
		}

		this.zealots.removeAll(borrar);
	}
	
	private void pasarDragonesProductivos() {
		ArrayList<Unidad> borrar = new ArrayList<>();

		for(Unidad actual: this.dragones) {
			this.jugador.agregarUnidad(actual);
			borrar.add(actual);
		}

		this.zealots.removeAll(borrar);
	}
	
	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return this.superficie.compararTipos(otraSuperficie);
	}

	@Override
	public void serRevelado() {
		// No hace nada.
	}
}
