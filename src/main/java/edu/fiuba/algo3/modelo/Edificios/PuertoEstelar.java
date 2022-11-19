package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Scout;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Tiempo;

public class PuertoEstelar extends EdificioProtoss {

	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 150;
	
	private ArrayList<Unidad> scouts;
	
    public PuertoEstelar(){
        super(new Tiempo(-10),new Vida(600),new Escudo(600));
        this.scouts = new ArrayList<Unidad>();
    }
   
    public void transportarScout() {
        /* aca debe ir la verificacion de requisitos*/
    	this.scouts.add(new Unidad(new Scout()));
    }

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Unidad> obtenerScouts(){
		return (this.scouts);
	}

	
}
