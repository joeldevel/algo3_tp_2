package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBajasException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Revelable;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot.EstadoDeZealot;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot.ZealotInvisible;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot.ZealotNoInvisible;

public class Zealot implements TipoDeUnidad, Atacante, Atacable, Revelable {

	public static final int SUMINISTRO_ZEALOT = 2;
	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 0;
	public static final int CONSTRUCCION_ZEALOT = -4;

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

		this.vida = new Vida(100);
		this.escudo = new Escudo(60);
		this.jugador = unJugador;
		this.unidad = null;
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{
			add(new Ataque(8, new Superficie("Tierra"), 1));
		}};
		this.estado = new ZealotNoInvisible();
		this.cantidadDeBajas = 0;
	}

	@Override
	public void conNodo(NodoMineral nodo) {
		// Zealot no entiende este mensaje.
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

	public void hacerseInvisible() {
		if (cantidadDeBajas >= 3) {
			estado = new ZealotInvisible();
		} else {
			throw new CantidadInsuficienteDeBajasException();
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
		// No hace nada.
	}

	@Override
	public void evolucionarAGuardian(Unidad unaUnidad) {
		// No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
	}

	@Override
	public void evolucionarADevorador(Unidad unaUnidad) {
		// No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
	}

	@Override
	public void revelar(Revelable unRevelable) {
		// No hace nada.
	}

	@Override
	public void contarBaja() {
		cantidadDeBajas += 1;
	}
}
