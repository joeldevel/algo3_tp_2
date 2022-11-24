package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;

public class Unidad extends Raza{
	
	private TipoDeUnidad tipo;
    
	public Unidad(Tiempo unTiempo, Ubicacion unaUbicacion, TipoDeUnidad unTipo) {
		super(unTiempo,unaUbicacion);
		this.tipo = unTipo;
	}
	
	public void cambiarTipo(TipoDeUnidad unTipo) {
		this.tipo = unTipo;
	}
	

	@Override
	public void recibirAtaque(int unDanio) {
		this.tipo.recibirAtaque(unDanio);
	}

	@Override
	public Superficie obtenerSuperficie() {
		return (this.tipo.obtenerSuperficie());
	}

	@Override
	public void atacar(Atacable unAtacable) {
		this.tipo.atacar(unAtacable);
	}

	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return false;
	}

	@Override
	public void avanzarTurno() {
		this.tipo.recuperarse();
		
	}

	

}
