package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recuperable;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;

public abstract class Edificio extends Raza implements Recuperable{
	
	protected Vida vida;
	protected Superficie superficie;
	protected EstadoOperativo estado;
	
	public Edificio(Tiempo unTiempo, Vida unaVida, Ubicacion unaUbicacion, Jugador unJugador) {
		super(unTiempo, unaUbicacion, unJugador);
		this.vida = unaVida;
		this.superficie = new Superficie("Tierra");
		this.estado = new EnConstruccion(this);
	}

	public abstract int obtenerPoblacion();
	
	public void ejecutaEnConstruccion() {
		if(this.tiempo.restante() == 0) {
			this.estado = new Operable(this);
		};
	}
	
	public abstract void ejecutaOperable();
	
	public void avanzarTurno() {
		this.tiempo.pasarTiempo();
		this.estado.ejecutar();
		this.recuperarse();
	}
    
    @Override
    public abstract void recuperarse();
    
    @Override
    public abstract void recibirAtaque(int unAtaque);
    
    public int obtenerVida() {
    	return (this.vida.restante());
    }
    
    public Superficie obtenerSuperficie(){
   		return (this.superficie);
   	}
	

}
