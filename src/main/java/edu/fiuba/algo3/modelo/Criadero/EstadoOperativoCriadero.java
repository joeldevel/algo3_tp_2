package edu.fiuba.algo3.modelo.Criadero;

import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Zangano;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Larva;

public interface EstadoOperativoCriadero {
	
	public int maximoDeLarvas();
	
	public Moho moho();
	
	public ArrayList<Larva> larvas();
	
	public boolean estaOperativo();
	
	public void actualizar();
	
	public int contarLarvas();
	
	public int radioMoho();
	
	public Zangano crearZangano();
	
}
