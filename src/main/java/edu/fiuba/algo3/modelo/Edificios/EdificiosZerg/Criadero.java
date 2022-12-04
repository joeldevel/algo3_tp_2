package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.util.*;

import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Larva;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;

/* el criadero deberia implementar una interfaz evolucionador por ejemplo, que habilite a evolucionar las
 * larvas a otro tipo de unidad zerg. Sino una buna idea es usar el patron Factory Method */

public class Criadero extends EdificioZerg {

	private final int POBLACION = 5;
	private final int COSTO_MINERAL = 200;
	private final int COSTO_GAS = 0;
	
	private int maxLarvas;
	private ArrayList<Unidad> larvas;
	private ArrayList<Unidad> zanganos;
		
	public Criadero(Ubicacion unaUbicacion, Jugador unJugador) {
		super(new Tiempo(-4), new Vida(500), unaUbicacion, unJugador);
		
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.maxLarvas = 3;
		this.larvas = new ArrayList<Unidad>() {{ add(new Unidad(new Tiempo(0),unaUbicacion,new Larva()));
												 add(new Unidad(new Tiempo(0),unaUbicacion,new Larva()));
												 add(new Unidad(new Tiempo(0),unaUbicacion,new Larva()));}};
		this.zanganos = new ArrayList<Unidad>();
	}

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public void ejecutaOperable() {
		this.crearLarva();
	}
	
	public int contarLarvas() {
		return (this.larvas.size());
	}

	public void crearZangano() {
		if(this.larvas.isEmpty()) {
			throw new CriaderoSinLarvasException();
		}
		Unidad unaUnidad = this.larvas.get(0);
		unaUnidad.setComportamientoEstado(new Zangano(this.ubicacion, this.jugador));
		this.larvas.remove(0);
		zanganos.add(unaUnidad);
	}
	
	public void crearLarva() {
		if(this.contarLarvas()<this.maxLarvas) {
			this.larvas.add(new Unidad(new Tiempo(0),this.ubicacion(),new Larva()));
		}
	}
	
	public ArrayList<Unidad> obtenerLarvas(){
		ArrayList<Unidad> aDevolver = this.larvas;
		this.larvas.clear();
		return aDevolver;
	}
	
	public ArrayList<Unidad> obtenerZanganos(){
		ArrayList<Unidad> aDevolver = this.zanganos;
		this.zanganos.clear();
		return aDevolver;
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