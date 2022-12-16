package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

public class Scout implements TipoDeUnidad, Atacante, Atacable {

	public static final int CONSTRUCCION_SCOUT = -9;
	private static final int VIDA_SCOUT = 150;
	private static final int ESCUDO_SCOUT = 100;

	private static final int ATAQUE_TIERRA_DANIO = 8;
	private static final int ATAQUE_AIRE_DANIO = 14;
	private static final int ATAQUE_RADIO = 4;

	public static final int SUMINISTRO_SCOUT = 4;
	private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 300;
	private static final int COSTO_GAS = 150;

	private Vida vida;
	private Escudo escudo;
	private Jugador jugador;
	private Unidad unidad;
	private Superficie superficie;
	private ArrayList<Ataque> ataques;
	
	public Scout(Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(VIDA_SCOUT);
		this.escudo = new Escudo(ESCUDO_SCOUT);
		this.jugador = unJugador;
		this.unidad = null;
		this.superficie = new Superficie("Aire");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(ATAQUE_TIERRA_DANIO,new Superficie("Tierra"),ATAQUE_RADIO));
		 										 add(new Ataque(ATAQUE_AIRE_DANIO,new Superficie("Aire"),ATAQUE_RADIO));}};
	}

	@Override
	public void trabajarEn(NodoMineral nodo) {
		// No entiende este mensaje.
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
		return SUMINISTRO_SCOUT;
	}

	@Override
	public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
		if(unDanio > this.escudo.restante()) {
			int danioRestante = this.escudo.restante() - unDanio;
			this.vida.recibirDanioPor(danioRestante, unidadAtacante, this.unidad, this.jugador);
		}
		this.escudo.recibirDanioPor(unDanio);
	}

	@Override
	public void atacar(Atacable unAtacable, Unidad unidadAtacante) {

		for (Ataque ataque : ataques) {
			if(! (this.estaEnRangoDeAtaque(unAtacable, ataque))) {
				throw new AtacableFueraDeRangoError();
			}

			ataque.atacarA(unAtacable, unidadAtacante);
		}
	}

	@Override
	public void recuperarse() {
		this.escudo.recuperarse();
	}

	public boolean estaEnRangoDeAtaque(Atacable unAtacable, Ataque unAtaque) {
		return (this.unidad.ubicacion().distanciaCon(unAtacable.ubicacion()) <= unAtaque.rango());
	}
	
	@Override
	public Ubicacion ubicacion() {
		return (this.unidad.ubicacion());
	}
	
	public int vidaRestante() {
		return (this.vida.restante());
	}

	public int escudoRestante() {
		return (this.escudo.restante());
	}

	public void hacerseInvisible() {
		// No entiende este mensaje.
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}

	@Override
	public void avanzarTurno() {
		// ...
	}

	@Override
	public void evolucionarAGuardian(Unidad unaUnidad) {
		// No entiende este mensaje.
	}

	@Override
	public void evolucionarADevorador(Unidad unaUnidad) {
		// No entiende este mensaje.
	}

	@Override
	public void revelar(Revelable unRevelable) {
		// No entiende este mensaje.
	}

	@Override
	public void serRevelado() {
		// No entiende este mensaje.
	}

	@Override
	public void contarBaja() {
		// ...
	}
}