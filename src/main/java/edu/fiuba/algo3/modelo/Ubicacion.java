package edu.fiuba.algo3.modelo;


public class Ubicacion {

    protected int posX;
    protected int posY;

    protected int alto;
    protected int ancho;
    
    public Ubicacion() {
        this.posX = 0;
        this.posY = 0;

        this.alto = 0;
        this.ancho = 0;
    }
    
    public Ubicacion(int x, int y) {
    	this.posX = x;
    	this.posY = y;

    	this.alto = 0;
    	this.ancho = 0;
    }

	public void setPerimetro(int unAlto, int unAncho) {
    	this.alto = unAlto;
    	this.ancho = unAncho;
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
		//return (((this.posX - this.ancho) <= otraUbicacion.posX && otraUbicacion.posX <= (this.posX + this.ancho)) && ((this.posY - alto) <= otraUbicacion.posY && otraUbicacion.posY <= (this.posY + alto)));
	}
	
	public boolean xDentroDeRango(int inicio, int fin) {
		return ( (this.posX >= inicio) && (this.posX <= fin) );
	}
	
	public boolean yDentroDeRango(int inicio, int fin) {
		return ( (this.posY >= inicio) && (this.posY <= fin) );
	}
	
	public Ubicacion derecha() {
		return(new Ubicacion(this.posX+1,this.posY));
	}
	
	public Ubicacion abajo() {
		return (new Ubicacion(this.posX,this.posY-1));
	}
	
	public Ubicacion izquierda() {
		return (new Ubicacion(this.posX-1,this.posY));
	}
	
	public Ubicacion arriba() {
		return (new Ubicacion(this.posX,this.posY+1));
	}


    
}