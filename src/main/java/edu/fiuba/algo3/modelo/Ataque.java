package edu.fiuba.algo3.modelo;

public class Ataque {
	
	private int danio;
	private int rango;
	
	public Ataque(int unDanio, int unRango) {
		this.danio = unDanio;
		this.rango = unRango;
	}
	
	public int rango() {
		return (this.rango);
	}
	
	public int danio() {
		return (this.danio);
	}

}
