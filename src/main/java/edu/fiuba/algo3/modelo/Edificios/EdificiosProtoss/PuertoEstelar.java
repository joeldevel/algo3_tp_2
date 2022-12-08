package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Recursos.Recursos;

public class PuertoEstelar extends EdificioProtoss {

    private final int POBLACION = 0;
	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 150;
	
	private ArrayList<Unidad> scouts;
	
    public PuertoEstelar(Ubicacion unaUbicacion, Jugador unJugador){
        super(new Tiempo(-10), new Vida(600), new Escudo(600), unaUbicacion, unJugador,"PuertoEstelar");
        
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
        this.scouts = new ArrayList<Unidad>();
    }

    @Override
    public int obtenerPoblacion() {
        return POBLACION;
    }
    
    @Override
    public void ejecutaOperable() {
    	if(this.estaEnergizado()) {
    		this.pasarScoutsProductivos();
    	}
    }
    
    public void transportarScout() {
    	if(! (this.estaEnergizado())) {
    		throw new EdificioNoEnergizadoError();
    	}
    	while(this.scouts.size() < 5) {
    		this.scouts.add(new Unidad(new Tiempo(-9), this.ubicacion, new Scout(this.ubicacion,this.jugador)));
    	}
        /* aca debe ir la verificacion de requisitos*/
    	//this.scouts.add(new Unidad(new Scout()));
    }
	
    private void pasarScoutsProductivos(){
		for(Unidad actual: this.scouts) {
			if(actual.tiempoRestante() == 0) {
				this.jugador.agregarUnidad(actual);
			}
		}
	}

    @Override
    public boolean compararSuperficie(String unTipoDeSuperficie) {
        return this.superficie.compararTipos(unTipoDeSuperficie);
    }

    @Override
    public void serRevelado() {
        // No hace nada.
    }
}
