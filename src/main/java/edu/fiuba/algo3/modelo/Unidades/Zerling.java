package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

public class Zerling implements Atacante,Atacable{

	private Vida vida;
	private Ubicacion ubicacion;
	private Ataque ataque;
	
	public Zerling(Ubicacion unaUbicacion) {
		this.vida = new Vida(35);
		this.ubicacion = unaUbicacion;
		this.ataque = new Ataque(4,1);
	}

	@Override
	public void recibirAtaque(int unAtaque) {
		this.vida.recibirDanioPor(unAtaque);
	}

	@Override
	public void atacar(Atacable unAtacable) {
		if(! (this.estaEnRangoDeAtaque(unAtacable))) {
			throw new AtacableFueraDeRangoError();
		}
		unAtacable.recibirAtaque(this.ataque.danio());
	}
	
	public boolean estaEnRangoDeAtaque(Atacable unAtacable) {
		return (this.ubicacion.distanciaCon(unAtacable.ubicacion()) <= this.ataque.rango());
	}
	
	public Ubicacion ubicacion() {
		return (this.ubicacion);
	}
	
	public int vidaRestante() {
		return (this.vida.restante());
	}
}
