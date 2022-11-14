package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.FabricaDeEdificios;
import edu.fiuba.algo3.modelo.Vida;

public abstract class Construido extends FabricaDeEdificios implements Edificio{
	
	protected Vida vida;

	protected Construido(Vida unaVida) {
		this.vida = unaVida;
	}
	
	@Override
	public abstract Edificio construir();
	
	@Override
	public boolean sePuedeUtilizar() {
		return true;
	}
/*	
	
	
	
	@Override
    public void actualizar(Tiempo unTiempo) {
    	this.recuperarse();
    }
    
    @Override
    public abstract void recibirDanio(int unDanio);
    
    @Override
    public int vidaRestante() {
    	return (this.vida.restante());
    }
    
    @Override
    public abstract void recuperarse();
    
*/
}
