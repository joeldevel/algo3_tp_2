package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.FabricaDeEdificios;

public class EnConstruccion extends FabricaDeEdificios implements Edificio{

	@Override
	public Edificio construir() {
		return (new EnConstruccion());
	}

	@Override
	public boolean sePuedeUtilizar() {
		return false;
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
