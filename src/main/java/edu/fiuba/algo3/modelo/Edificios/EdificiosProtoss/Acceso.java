package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;


import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoError;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.SUMINISTRO_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.SUMINISTRO_ZEALOT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;

public class Acceso extends EdificioProtoss {

	public final int ALTO_RADIO = 21;
	public final int ANCHO_RADIO = 25;

	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 0;
	
	private ArrayList<Unidad> zealots;
	private ArrayList<Unidad> dragones;
	
    public Acceso(Ubicacion unaUbicacion, Jugador unJugador) {
		super(new Tiempo(-8), new Vida(500), new Escudo(500), unaUbicacion, unJugador,"Acceso");
		this.ubicacion.setPerimetro(ALTO_RADIO, ANCHO_RADIO);
		this.zealots = new ArrayList<Unidad>();
		this.dragones = new ArrayList<Unidad>();
		
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
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
			this.pasarDragonesProductivos();
			this.pasarZealotsProductivos();
		}*/
	}
	
	public Unidad transportarZealots() {
		if(! this.estaEnergizado()) {
			throw new EdificioNoEnergizadoError();
		}
		Unidad zealot = new Unidad(new Tiempo(-4), this.ubicacion, new Zealot(this.jugador));
		return zealot;
		/*while(this.zealots.size() < 5) {
			this.zealots.add(new Unidad(new Tiempo(-4), this.ubicacion, new Zealot(this.jugador)));
		}*/
	}
	
	public Unidad transportarDragones() {
		if(! this.estaEnergizado()) {
			throw new EdificioNoEnergizadoError();
		}
		Unidad dragon = new Unidad(new Tiempo(-6), this.ubicacion, new Dragon(this.jugador));
		return dragon;
		/*while(this.dragones.size() < 5) {
			this.dragones.add(new Unidad(new Tiempo(-6), this.ubicacion, new Dragon(this.jugador)));
		}*/
	}
	
	private void pasarZealotsProductivos(){
    	ArrayList<Unidad> borrar = new ArrayList<>();

		for(Unidad actual: this.zealots) {
			this.jugador.agregarUnidad(actual);
			borrar.add(actual);
		}

		this.zealots.removeAll(borrar);
	}
	
	private void pasarDragonesProductivos() {
		ArrayList<Unidad> borrar = new ArrayList<>();

		for(Unidad actual: this.dragones) {
			this.jugador.agregarUnidad(actual);
			borrar.add(actual);
		}

		this.zealots.removeAll(borrar);
	}
	
	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return this.superficie.compararTipos(otraSuperficie);
	}

	@Override
	public void serRevelado() {
		// No hace nada.
	}
}
