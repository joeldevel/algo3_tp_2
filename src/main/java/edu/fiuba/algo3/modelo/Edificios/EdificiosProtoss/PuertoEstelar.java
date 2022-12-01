package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
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
	
    public PuertoEstelar(Recursos recursosJugador, Ubicacion unaUbicacion, Jugador unJugador){
        super(new Tiempo(-10), new Vida(600), new Escudo(600), unaUbicacion, unJugador);
        
        recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
        this.scouts = new ArrayList<Unidad>();
    }

    @Override
    public int obtenerPoblacion() {
        return POBLACION;
    }
    
    @Override
    public void ejecutaOperable() {
    	// TODO Auto-generated method stub
    	
    }
   
    public void transportarScout() {
        /* aca debe ir la verificacion de requisitos*/
    	//this.scouts.add(new Unidad(new Scout()));
    }
	
	public ArrayList<Unidad> obtenerScouts(){
		return (this.scouts);
	}

    @Override
    public boolean compararSuperficie(String unTipoDeSuperficie) {
        return this.superficie.compararTipos(unTipoDeSuperficie);
    }
}
