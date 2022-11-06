package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Creador {
	
	
	public ArrayList<Larva> crearLarvas(){
		
		ArrayList<Larva>larvas = new ArrayList<Larva>();
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());
		}
		
		return larvas;
	}

}
