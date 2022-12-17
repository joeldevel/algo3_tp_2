package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

public abstract class Edificio extends Raza implements Recuperable{
	
	protected Vida vida;
	protected Jugador jugador;
	protected Superficie superficie;
	protected EstadoOperativo estado;
	protected String identificador;
	
	public Edificio(Tiempo unTiempo, Vida unaVida, Ubicacion unaUbicacion, Jugador unJugador,String unIdentificador) {
		super(unTiempo, unaUbicacion);
		this.jugador = unJugador;
		this.vida = unaVida;
		this.superficie = new Superficie("Tierra");
		this.estado = new EnConstruccion(this);
		this.identificador = unIdentificador;
	}
	
	public void ejecutaEnConstruccion() {
		if(this.tiempo.restante() == 0) {
			this.estado = new Operable(this);
		};
	}
	
	public abstract void ejecutaOperable();
	
	public abstract void avanzarTurno();

	public abstract int obtenerEscudo();
    
    @Override
    public abstract void recuperarse();
    
    @Override
    public abstract void recibirAtaque(int unAtaque, Unidad unidadAtacante);
    
    @Override
    public boolean compararSuperficie(String unTipoDeSuperficie) {
        return this.superficie.compararTipos(unTipoDeSuperficie);
    }
    
    public int obtenerVida() {
    	return (this.vida.restante());
    }
    
    public int distanciaCon(Edificio otroEdificio) {
    	return (this.ubicacion.distanciaCon(otroEdificio.ubicacion()));
    }
	
    public boolean esUn(String unEdificio) {
    	return (this.identificador == unEdificio);
    }

    public abstract ArrayList<Unidad> devolverLarvas();
    
    @Override
    public void serRevelado() {
    	//No entiende este mensaje
    }
    
}
