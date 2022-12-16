package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Minero;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.SinNodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Zangano implements TipoDeUnidad, Minero, Atacable {

	public static final int CONSTRUCCION_ZANGANO = -1;
	private static final int VIDA_ZANGANO = 25;

	public static final int SUMINISTRO_ZANGANO = 1;
	private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 25;
	private static final int COSTO_GAS = 0;
	private static final int RECOLECTABLE = 10;

	private Vida vida;
	private Jugador jugador;
	private Unidad unidad;
	private Superficie superficie;

	private int cantidadRecolectableDeMineral;
    private Mineral nodo;

	public Zangano(Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(VIDA_ZANGANO);
		this.superficie = new Superficie("Tierra");

		this.cantidadRecolectableDeMineral = RECOLECTABLE;
		this.jugador = unJugador;
		this.unidad = null;
		this.nodo = new SinNodoMineral();
	}

	public void setComportamientoUnidad(Unidad unaUnidad) {
		this.unidad = unaUnidad;
	}
    
    public void trabajarEn(NodoMineral unNodo) {
		this.nodo = unNodo;
		unNodo.construirRecolectorDeMineral(this);
    }

	public void avanzarTurno() {
		if(nodo.tieneMineral()) {
			this.jugador.guardar(0, this.recolectarMineralDe(this.nodo));
		}
	}

	@Override
	public int recolectarMineralDe(Mineral unNodoMineral) {
		return (unNodoMineral.recolectarMineral(cantidadRecolectableDeMineral));
	}

	@Override
	public int obtenerMineral() {
		return this.jugador.obtenerMineral();
	}

	@Override
	public boolean tieneMinero() {
		return true;
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
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public int obtenerSuministro() {
		return SUMINISTRO_ZANGANO;
	}

	@Override
	public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
		this.vida.recibirDanioPor(unDanio, unidadAtacante, this.unidad, this.jugador);
	}


	@Override
	public Ubicacion ubicacion() {
		return (this.unidad.ubicacion());
	}

	@Override
	public void atacar(Atacable unAtacable, Unidad unidadAtacante) {
		// No entiende este mensaje.
	}

	@Override
	public void recuperarse() {
		this.vida.recuperarse();
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
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