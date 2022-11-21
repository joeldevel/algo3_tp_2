package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

public class Zealot implements TipoDeUnidad,Atacante,Atacable {
	
	private Vida vida;
	private Escudo escudo;
	private Ubicacion ubicacion;
	private ArrayList<Ataque> ataques;
	
	public Zealot(Ubicacion unaUbicacion) {
		this.vida = new Vida(100);
		this.escudo = new Escudo(60);
		this.ubicacion = unaUbicacion;
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(8,new Superficie("Tierra"),1));}};
	}
	
	public Zealot() {
		this.vida = new Vida(100);
		this.escudo = new Escudo(60);
		this.ubicacion = new Ubicacion();
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(8,new Superficie("Tierra"),1));}};
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
