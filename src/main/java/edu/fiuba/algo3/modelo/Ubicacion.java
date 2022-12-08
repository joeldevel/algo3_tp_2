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
	
	public int obtenerX() {
		return (this.posX);
	}
	
	public int obtenerY() {
		return (this.posY);
	}
	
	public boolean esIgualA(Ubicacion otraUbicacion) {
		return((this.posX == otraUbicacion.posX) && (this.posY == otraUbicacion.posY));
	}
	
	public boolean xDentroDeRango(int inicio, int fin) {
		return ( (this.posX >= inicio) && (this.posX <= fin) );
	}
	
	public boolean yDentroDeRango(int inicio, int fin) {
		return ( (this.posY >= inicio) && (this.posY <= fin) );
	}

    
}