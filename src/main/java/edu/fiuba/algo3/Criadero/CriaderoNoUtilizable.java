package edu.fiuba.algo3.Criadero;

import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Zangano;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Larva;

public class CriaderoNoUtilizable implements EstadoOperativoCriadero {
	
	protected int maxLarvas;
	private Moho moho;
	private ArrayList<Larva> larvas;
	
	public CriaderoNoUtilizable(int unMaximoLarvas, Moho unMoho, ArrayList<Larva> unasLarvas){
			this.maxLarvas = unMaximoLarvas;
			this.moho = unMoho;
			this.larvas = unasLarvas;
	}
	
	public CriaderoNoUtilizable(EstadoOperativoCriadero otroEstado) {
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
		return false;
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int contarLarvas() {
		return 0;
	}
	@Override
	public int radioMoho() {
		return this.moho.radio();
	}

	@Override
	public Zangano crearZangano() {
		// TODO Auto-generated method stub
		return null;
	}
}
