package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Devorador.CONSTRUCCION_DEVORADOR;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;

public class Mutalisco implements TipoDeUnidad, Atacante, Atacable {

	public static final int SUMINISTRO_MUTALISCO = 4;
	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 100;
	public static final int CONSTRUCCION_MUTALISCO = -7;
	
	private Vida vida;
	private Jugador jugador;
	private Unidad unidad;
	private Ubicacion ubicacion;
	private Superficie superficie;
	private ArrayList<Ataque> ataques;
	
	public Mutalisco(Ubicacion unaUbicacion, Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(120);
		this.jugador = unJugador;
		this.unidad = null;
		this.ubicacion = unaUbicacion;
		this.superficie = new Superficie("Aire");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(9,new Superficie("Tierra"),3));
		 										 add(new Ataque(9,new Superficie("Aire"),3));}};
	}
	
	public Mutalisco(Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(120);
		this.jugador = unJugador;
		this.unidad = null;
		this.ubicacion = new Ubicacion();
		this.superficie = new Superficie("Aire");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(9,new Superficie("Tierra"),3));
		 										 add(new Ataque(9,new Superficie("Aire"),3));}};
	}

	public void setComportamientoUnidad(Unidad unaUnidad) {
		this.unidad = unaUnidad;
	}

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public int obtenerSuministro() {
		return SUMINISTRO_MUTALISCO;
	}

	@Override
	public void recibirAtaque(int unDanio) {
		this.vida.recibirDanioPor(unDanio, this.unidad, this.jugador);
	}


	@Override
	public Superficie obtenerSuperficie() {
		return this.superficie;
	}

	@Override
	public void atacar(Atacable unAtacable) {

		for (Ataque ataque : ataques) {
			if(! (this.estaEnRangoDeAtaque(unAtacable, ataque))) {
				throw new AtacableFueraDeRangoError();
			}

			ataque.atacarA(unAtacable);
		}
	}

	@Override
	public void recuperarse() {
		this.vida.recuperarse();
	}

	public boolean estaEnRangoDeAtaque(Atacable unAtacable, Ataque unAtaque) {
		return (this.ubicacion.distanciaCon(unAtacable.ubicacion()) <= unAtaque.rango());
	}
	
	public Ubicacion ubicacion() {
		return (this.ubicacion);
	}
	
	public int vidaRestante() {
		return (this.vida.restante());
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}

	public void evolucionarAGuardian(Unidad unaUnidad) {
		unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_GUARDIAN), new Guardian(this.ubicacion, this.jugador));
	}

	public void evolucionarADevorador(Unidad unaUnidad) {
		unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_DEVORADOR), new Devorador(this.ubicacion, this.jugador));
	}
}