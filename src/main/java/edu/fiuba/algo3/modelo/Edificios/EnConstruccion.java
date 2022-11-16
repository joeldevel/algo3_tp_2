package edu.fiuba.algo3.modelo.Edificios;

public class EnConstruccion extends EstadoOperativo{
	
	
	public EnConstruccion(Edificio unEdificio) {
		super(unEdificio);
	}
	
	@Override
	public void ejecutar() {
		this.edificio.ejecutaEnConstruccion();
	}
	

	/*
	@Override
	public void actualizar(Tiempo unTiempo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sePuedeUtilizar() {
		return false;
	}

	@Override
	public void recibirDanio(int unDanio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int vidaRestante() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recuperarse() {
		// TODO Auto-generated method stub
		
	}

*/

}
