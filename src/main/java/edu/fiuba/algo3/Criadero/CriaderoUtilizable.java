package edu.fiuba.algo3.Criadero;

import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Zangano;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Larva;

public class CriaderoUtilizable implements EstadoOperativoCriadero{
	
	protected int maxLarvas;
	private Moho moho;
	private ArrayList<Larva> larvas;
	
	
	public CriaderoUtilizable(int unMaximoLarvas,Moho unMoho, ArrayList<Larva> unasLarvas){
		this.maxLarvas = unMaximoLarvas;
		this.moho = unMoho;
		this.larvas = unasLarvas;
}
	
	public CriaderoUtilizable(EstadoOperativoCriadero otroEstado) {
		this.maxLarvas = otroEstado.maximoDeLarvas();
		this.moho = otroEstado.moho();
		this.larvas = otroEstado.larvas();
	}
	
	public int maximoDeLarvas() {
		return this.maxLarvas;
	}
	
	public Moho moho() {
		return this.moho;
	}
	
	public ArrayList<Larva> larvas(){
		return this.larvas;
	}

	@Override
	public boolean estaOperativo() {
		return true;
	}

	@Override
	public void actualizar() {
		this.moho.avanzarTurno();
		if(this.contarLarvas() < this.maxLarvas) {
			this.larvas.add(new Larva());
		}
	}

	@Override
	public int contarLarvas() {
		return (this.larvas.size());
	}

	@Override
	public int radioMoho() {
		return (this.moho.radio());
	}
	
	public Zangano crearZangano() {
		if(this.larvas.isEmpty()) {
			throw new CriaderoSinLarvasException();
		}
		Larva unaLarva = this.larvas.get(0);
		Zangano zangano = unaLarva.evolucionar();
		this.larvas.remove(0);
		return zangano;
	}

}
