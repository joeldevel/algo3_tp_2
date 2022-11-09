package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;

import java.util.*;


public class Criadero {
	
	private int maxLarvas;
	private ArrayList<Larva> larvas;
	
	public Criadero() {
		this.maxLarvas = 3;
	}
	
	public Criadero(ArrayList<Larva>unasLarvas) {
		this.maxLarvas = 3;
		this.larvas = unasLarvas;
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
	
	public void avanzarTurno() {
		/* En esta parte debe ir una clase tiempo o un metodo actualizar que llame a los demas metodos
		 * incluyendo al metodo que genera la larva*/
		if(this.contarLarvas() != 3) {
			Larva nuevaLarva = this.generarLarva();
			this.larvas.add(nuevaLarva);
		}
	}
	
	public Larva generarLarva() {
		/* aca hay que usar la inyeccion de dependencias y que el metodo reciva una larva o bien que este metodo
		 * este en una interfaz, por ejemplo creador, y que este cree la larva*/
		Larva larva = new Larva();
		return larva;
	}
}
