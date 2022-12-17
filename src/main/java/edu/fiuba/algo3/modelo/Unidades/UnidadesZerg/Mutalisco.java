package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Devorador.CONSTRUCCION_DEVORADOR;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;

public class Mutalisco implements TipoDeUnidad, Atacante, Atacable {

	public static final int CONSTRUCCION_MUTALISCO = -7;
	private static final int VIDA_MUTALISCO = 120;

	private static final int ATAQUE_DANIO = 9;
	private static final int ATAQUE_RADIO = 3;

	public static final int SUMINISTRO_MUTALISCO = 4;
	private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 100;
	private static final int COSTO_GAS = 100;
	
	private Vida vida;
	private Jugador jugador;
	private Unidad unidad;
	private Superficie superficie;
	private ArrayList<Ataque> ataques;
	
	public Mutalisco(Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(VIDA_MUTALISCO);
		this.jugador = unJugador;
		this.unidad = null;
		this.superficie = new Superficie("Aire");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(ATAQUE_DANIO ,new Superficie("Tierra"), ATAQUE_RADIO));
		 										 add(new Ataque(ATAQUE_DANIO ,new Superficie("Aire"), ATAQUE_RADIO));}};
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
		return SUMINISTRO_MUTALISCO;
	}

	@Override
	public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
		this.vida.recibirDanioPor(unDanio, unidadAtacante, this.unidad, this.jugador);
	}

	@Override
	public void atacar(Atacable unAtacable, Unidad unidadAtacante) {

		for (Ataque ataque : ataques) {
			if(this.estaEnRangoDeAtaque(unAtacable, ataque)) {
				ataque.atacarA(unAtacable, unidadAtacante);
			}
		}
	}

	@Override
	public void recuperarse() {
		this.vida.recuperarse();
	}

	public boolean estaEnRangoDeAtaque(Atacable unAtacable, Ataque unAtaque) {
		return (this.unidad.ubicacion().distanciaCon(unAtacable.ubicacion()) <= unAtaque.rango());
	}
	
	public Ubicacion ubicacion() {
		return (this.unidad.ubicacion());
	}
	
	public int vidaRestante() {
		return (this.vida.restante());
	}

	public int escudoRestante() {
		return 0;
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

	public void evolucionarAGuardian(Unidad unaUnidad) {
		unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_GUARDIAN), new Guardian(this.jugador), this.unidad.ubicacion());
	}

	public void evolucionarADevorador(Unidad unaUnidad) {
		unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_DEVORADOR), new Devorador(this.jugador), this.unidad.ubicacion());
	}

	@Override
	public void revelar(Atacable unRevelable) {
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