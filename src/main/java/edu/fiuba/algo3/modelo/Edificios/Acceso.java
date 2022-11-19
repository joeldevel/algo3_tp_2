package edu.fiuba.algo3.modelo.Edificios;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Dragon;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.Zealot;

public class Acceso extends EdificioProtoss{

	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 0;
	
	private ArrayList<Unidad> zealots;
	private ArrayList<Unidad> dragones;
	
    protected Acceso() {
		super(new Tiempo(-8),new Vida(500), new Escudo(500));
		this.zealots = new ArrayList<Unidad>();
		this.dragones = new ArrayList<Unidad>();
	}

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}
	
	public void transportarZealot() {
		/* aca tiene que ir la verificacion de requisitos*/
		this.zealots.add(new Unidad(new Zealot()));
	}
	
	public void transportarDragon() {
		/* aca tiene que ir la verificacion de requisitos*/
		this.dragones.add(new Unidad(new Dragon()));
	}
	
	public ArrayList<Unidad> obtenerZealots(){
		return (this.zealots);
	}
	
	public ArrayList<Unidad> obtenerDragones(){
		return (this.dragones);
	}
		
}
