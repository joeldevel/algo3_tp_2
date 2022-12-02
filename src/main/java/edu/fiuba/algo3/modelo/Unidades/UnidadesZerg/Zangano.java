package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Minero;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.SinNodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Zangano implements TipoDeUnidad, Minero, Atacable {

	public static final int SUMINISTRO_ZANGANO = 1;
	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 25;
	private final int COSTO_GAS = 0;

	private Vida vida;
	private Jugador jugador;
	private Ubicacion ubicacion;
	private Superficie superficie;

	private int cantidadRecolectableDeMineral;
    private Mineral nodo;

	public Zangano(Ubicacion unaUbicacion, Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(25);
		this.ubicacion = unaUbicacion;
		this.superficie = new Superficie("Tierra");

		this.cantidadRecolectableDeMineral = 10;
		this.jugador = unJugador;
		this.nodo = new SinNodoMineral();
	}

    public Zangano(Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(25);
		this.ubicacion = new Ubicacion();
		this.superficie = new Superficie("Tierra");

        this.cantidadRecolectableDeMineral = 10;
		this.jugador = unJugador;
        this.nodo = new SinNodoMineral();
    }
    
    public void conNodo(NodoMineral unNodo) {
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
		// TODO Auto-generated method stub
		return true;
	}

	public int vidaRestante() {
		return (this.vida.restante());
	}

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public void recibirAtaque(int unDanio) {
		this.vida.recibirDanioPor(unDanio);
	}

	@Override
	public Ubicacion ubicacion() {
		return (this.ubicacion);
	}

	@Override
	public Superficie obtenerSuperficie() {
		return this.superficie;
	}

	@Override
	public void atacar(Atacable unAtacable) {
		// Zangano no entiende este mensaje.
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
		// No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
	}

	@Override
	public void evolucionarADevorador(Unidad unaUnidad) {
		// No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
	}
}