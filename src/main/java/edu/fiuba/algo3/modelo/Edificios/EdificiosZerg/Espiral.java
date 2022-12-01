package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Espiral extends EdificioZerg {

	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 100;
	
	private ArrayList<Unidad> larvas;
    private ArrayList<Unidad> mutaliscos;
	
	public Espiral(Ubicacion unaUbicacion, Jugador unJugador){
        super(new Tiempo(-10), new Vida(1300), unaUbicacion, unJugador);
        
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
        this.larvas = new ArrayList<Unidad>();
        this.mutaliscos = new ArrayList<Unidad>();
    }

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public void ejecutaOperable() {
		this.crearMutaliscos();
	}
	
	public void crearMutaliscos() {
		/* el ciclo deberia tener algo como && this.cumpleConLosRequisitos(unosRequisitos)*/
		while(this.contarLarvas() != 0) {
			Unidad actual = larvas.get(0);
			actual.setComportamientoEstado(new Mutalisco());
			mutaliscos.add(actual);
			larvas.remove(0);
		}
	}
	
	public int contarLarvas() {
		return (this.larvas.size());
	}
	
	public void recibirLarvas(ArrayList<Unidad> unasLarvas) {
		this.larvas.addAll(unasLarvas);
	}
	
	public ArrayList<Unidad> obtenerMutaliscos(){
		return (this.mutaliscos);
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}
}
