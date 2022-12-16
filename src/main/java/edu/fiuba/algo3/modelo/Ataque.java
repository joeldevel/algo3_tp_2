package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Ataque {
	
	private int danio;
	private Superficie superficie;
	private int rango;
	
	public Ataque(int unDanio, Superficie unaSuperficie, int unRango) {
		this.danio = unDanio;
		this.superficie = unaSuperficie;
		this.rango = unRango;
	}
	
	public int rango() {
		return (this.rango);
	}
	
	public void atacarA(Atacable unAtacable, Unidad unidadAtacante) {

		if(this.superficie.atacableTieneLaMismaSuperficie(unAtacable)) {
            unAtacable.recibirAtaque(this.danio, unidadAtacante);
        }
    }
}