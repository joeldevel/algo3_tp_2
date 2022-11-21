package edu.fiuba.algo3.modelo.Unidades;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;

public class Unidad extends Raza{
	
	private TipoDeUnidad tipo;
	private Superficie superficie;
    
	
	public Unidad(Tiempo unTiempo, Ubicacion unaUbicacion, TipoDeUnidad unTipo, Superficie unaSuperficie) {
		super(unTiempo,unaUbicacion);
		this.tipo = unTipo;
		this.superficie = unaSuperficie;
	}
	
	public void cambiarTipo(TipoDeUnidad unTipo) {
		this.tipo = unTipo;
	}
	

	@Override
	public void recibirAtaque(int unAtaque) {
		this.tipo.recibirAtaque(unAtaque);
	}

	@Override
	public Superficie obtenerSuperficie() {
		return (this.superficie);
	}

	@Override
	public void atacar(Atacable unAtacable) {
		this.tipo.atacar(unAtacable);
	}

	@Override
	public void avanzarTurno() {
		this.tipo.recuperarse();
		
	}

	

}
