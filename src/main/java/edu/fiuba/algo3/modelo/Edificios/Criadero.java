package edu.fiuba.algo3.modelo.Edificios;

import java.util.*;

import edu.fiuba.algo3.modelo.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Unidades.Larva;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.Zangano;

/* el criadero deberia implementar una interfaz evolucionador por ejemplo, que habilite a evolucionar las
 * larvas a otro tipo de unidad zerg. Sino una buna idea es usar el patron Factory Method */

public class Criadero extends EdificioZerg {
	
	private final int COSTO_MINERAL = 50;
	private final int COSTO_GAS = 0;
	
	private int maxLarvas;
	private ArrayList<Unidad> larvas;
	private ArrayList<Unidad> zanganos;
		
	public Criadero(Recursos recursosJugador) {	
		super(new Tiempo(-4),new Vida(500));
		
		recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
		
		this.maxLarvas = 3;
		this.larvas = new ArrayList<Unidad>() {{ add(new Unidad(new Larva())); add(new Unidad(new Larva())); 
												 add(new Unidad(new Larva()));}};
		this.zanganos = new ArrayList<Unidad>();
	}

	@Override
	public void ejecutaOperable() {
		this.crearLarva();
	}
	
	public int contarLarvas() {
		return (this.larvas.size());
	}

	public void crearZangano() {
		if(this.larvas.isEmpty()) {
			throw new CriaderoSinLarvasException();
		}
		Unidad unaUnidad = this.larvas.get(0);
		unaUnidad.cambiarTipo(new Zangano());
		this.larvas.remove(0);
		zanganos.add(unaUnidad);
	}
	
	public void crearLarva() {
		if(this.contarLarvas()<this.maxLarvas) {
			this.larvas.add(new Unidad(new Larva()));
		}
	}
	
	public ArrayList<Unidad> obtenerLarvas(){
		ArrayList<Unidad> aDevolver = this.larvas;
		this.larvas.clear();
		return aDevolver;
	}
	
	public ArrayList<Unidad> obtenerZanganos(){
		ArrayList<Unidad> aDevolver = this.zanganos;
		this.zanganos.clear();
		return aDevolver;
	}
	
}
