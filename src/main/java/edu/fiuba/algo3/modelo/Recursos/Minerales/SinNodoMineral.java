package edu.fiuba.algo3.modelo.Recursos.Minerales;

public class SinNodoMineral implements Mineral {

	@Override
	public int mineralRestante() {
		return 0;
	}

	@Override
	public int recolectarMineral(int unaCantidad) {
		return 0;
	}
	
	@Override
    public boolean tieneMineral() {
        return false;
    }

}
