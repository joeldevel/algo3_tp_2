package edu.fiuba.algo3.modelo;

public class Ubicacion {

    protected int posX;
    protected int posY;
    
    public Ubicacion() {
        this.posX = 0;
        this.posY = 0;
    }
    
    public Ubicacion(int x, int y) {
    	this.posX = x;
    	this.posY = y;
    }

	public int distanciaCon(Ubicacion otraUbicacion) {
		int distancia = 0;
		distancia = (int) Math.ceil(Math.sqrt(Math.pow((posX - otraUbicacion.posX),2) + Math.pow((posY - otraUbicacion.posY),2)));
		return distancia;
	}

    
}