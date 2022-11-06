package edu.fiuba.algo3.modelo;
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

}
