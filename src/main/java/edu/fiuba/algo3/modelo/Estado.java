package edu.fiuba.algo3.modelo;

public interface Estado {
	
	public boolean sePuedeUtilizar();
	
	public void actualizar(Tiempo unTiempo);
	
	public void recibirDanio(int unDanio);
	
	public int vidaRestante();
	
	public void recuperarse();

}
