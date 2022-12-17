package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot.EstadoDeZealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot.ZealotInvisible;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot.ZealotNoInvisible;

public class Zealot implements TipoDeUnidad, Atacante, Atacable {

	public static final int CONSTRUCCION_ZEALOT = -4;
	private static final int VIDA_ZEALOT = 100;
	private static final int ESCUDO_ZEALOT = 60;

	private static final int ATAQUE_TIERRA_DANIO = 8;
	private static final int ATAQUE_TIERRA_RADIO = 1;

	public static final int SUMINISTRO_ZEALOT = 2;
	private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 150;
	private static final int COSTO_GAS = 0;

	private Vida vida;
	private Escudo escudo;
	private Jugador jugador;
	private Unidad unidad;
	private Superficie superficie;
	private ArrayList<Ataque> ataques;
	private EstadoDeZealot estado;
	private int cantidadDeBajas;

	public Zealot(Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(VIDA_ZEALOT);
		this.escudo = new Escudo(ESCUDO_ZEALOT);
		this.jugador = unJugador;
		this.unidad = null;
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{
			add(new Ataque(ATAQUE_TIERRA_DANIO, new Superficie("Tierra"), ATAQUE_TIERRA_RADIO));
		}};
		this.estado = new ZealotNoInvisible();
		this.cantidadDeBajas = 0;
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
		return SUMINISTRO_ZEALOT;
	}

	@Override
	public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
		this.estado.recibirAtaque(unDanio, this.vida, this.escudo, unidadAtacante, this.unidad, this.jugador);
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
		this.escudo.recuperarse();
	}

	public boolean estaEnRangoDeAtaque(Atacable unAtacable, Ataque unAtaque) {
		return (this.unidad.ubicacion().distanciaCon(unAtacable.ubicacion()) <= unAtaque.rango());
	}

	public void hacerseInvisible() {
		if (cantidadDeBajas >= 3) {
			estado = new ZealotInvisible();
		}
	}

	@Override
	public void serRevelado() {
		estado = new ZealotNoInvisible();
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

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}

	@Override
	public void avanzarTurno() {
		this.hacerseInvisible();
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
	public void revelar(Atacable unRevelable) {
		// No entiende este mensaje.
	}

	@Override
	public void contarBaja() {
		cantidadDeBajas += 1;
	}
}
