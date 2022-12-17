package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.util.*;

import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Larva;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.CONSTRUCCION_ZANGANO;

public class Criadero extends EdificioZerg {

	public static final int CONSTRUCCION_CRIADERO = -4;
	public static final int VIDA_CRIADERO = 500;

	private static final int POBLACION = 5;
	private static final int COSTO_MINERAL = 200;
	private static final int COSTO_GAS = 0;
	private static final int MAX_LARVAS = 3;
	
	private int maxLarvas;
	private ArrayList<Unidad> larvas;
		
	public Criadero(Ubicacion unaUbicacion, Jugador unJugador) {
		super(new Tiempo(CONSTRUCCION_CRIADERO), new Vida(VIDA_CRIADERO), unaUbicacion, unJugador,"Criadero");
		
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.maxLarvas = MAX_LARVAS;
		this.larvas = new ArrayList<Unidad>() {{ add(new Unidad(new Tiempo(0),unaUbicacion,new Larva()));
												 add(new Unidad(new Tiempo(0),unaUbicacion,new Larva()));
												 add(new Unidad(new Tiempo(0),unaUbicacion,new Larva()));}};
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

		if(this.tiempoRestante() == 0) {
			Unidad unaUnidad = this.larvas.get(0);
			unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_ZANGANO), new Zangano(this.jugador), this.ubicacion);
			this.larvas.remove(0);
			this.jugador.agregarUnidad(unaUnidad);			
		}
	}
	
	public void crearLarva() {
		if(this.contarLarvas()<this.maxLarvas) {
			this.larvas.add(new Unidad(new Tiempo(0),this.ubicacion(),new Larva()));
		}
	}

	@Override
	public ArrayList<Unidad> devolverLarvas(){
		ArrayList<Unidad> aDevolver = new ArrayList<>(this.larvas);
		this.larvas.clear();
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