package edu.fiuba.algo3.modelo.Unidades;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

public class Dragon implements TipoDeUnidad,Atacante,Atacable {
	
	private Vida vida;
	private Escudo escudo;
	private Ubicacion ubicacion;
	private ArrayList<Ataque> ataques;
	
	public Dragon(Ubicacion unaUbicacion) {
		this.vida = new Vida(100);
		this.escudo = new Escudo(80);
		this.ubicacion = unaUbicacion;
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(20,new Superficie("Tierra"),4));
												 add(new Ataque(20,new Superficie("Aire"),4));}};
	}
	
	public Dragon() {
		this.vida = new Vida(100);
		this.escudo = new Escudo(80);
		this.ubicacion = new Ubicacion();
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(20,new Superficie("Tierra"),4));
		 										 add(new Ataque(20,new Superficie("Aire"),4));}};
	}

	@Override
	public void recibirAtaque(int unAtaque) {
		if(unAtaque > this.escudo.restante()) {
			int danioRestante = this.escudo.restante() - unAtaque;
			this.vida.recibirDanioPor(danioRestante);
		}
		this.escudo.recibirDanioPor(unAtaque);
		
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
	
	@Override
	public Ubicacion ubicacion() {
		return (this.ubicacion);
	}
	
	public int vidaRestante() {
		return (this.vida.restante());
	}
	
	public int escudoRestante() {
		return (this.escudo.restante());
	}


}
