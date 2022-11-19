package edu.fiuba.algo3.modelo.Unidades;

public class Unidad {
	
	protected TipoDeUnidad tipo;
	
	public Unidad(TipoDeUnidad unTipo) {
		this.tipo = unTipo;
	}
	
	public void cambiarTipo(TipoDeUnidad unTipo) {
		this.tipo = unTipo;
	}
	

}
