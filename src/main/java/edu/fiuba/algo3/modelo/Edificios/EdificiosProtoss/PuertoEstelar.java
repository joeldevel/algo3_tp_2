package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Recursos.Recursos;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.SUMINISTRO_SCOUT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;

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
    public ArrayList<Unidad> devolverLarvas() {
        return new ArrayList<Unidad>();
    }

    @Override
    public int obtenerPoblacion() {
        return POBLACION;
    }
    
    @Override
    public void ejecutaOperable() {
    	/*if(this.estaEnergizado()) {
    		this.pasarScoutsProductivos();
    	}*/
    }
    
    public Unidad transportarScout() {
    	if(! this.estaEnergizado()) {
    		throw new EdificioNoEnergizadoError();
    	}
    	Unidad scout = new Unidad(new Tiempo(-9), this.ubicacion, new Scout(this.jugador));
    	return scout;
    	/*while(this.scouts.size() < 5) {
    		this.scouts.add(new Unidad(new Tiempo(-9), this.ubicacion, new Scout(this.jugador)));
    	}*/
    }
	
    private void pasarScoutsProductivos(){
        ArrayList<Unidad> borrar = new ArrayList<>();

		for(Unidad actual: this.scouts) {
		    this.jugador.agregarUnidad(actual);
		    borrar.add(actual);
		}

        this.scouts.removeAll(borrar);
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
