package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Minero;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.SinNodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;

public class Zangano implements TipoDeUnidad, Minero, Atacable {

	public static final int SUMINISTRO_ZANGANO = 1;

	private Vida vida;
	private Ubicacion ubicacion;
	private Superficie superficie;

	private int cantidadRecolectableDeMineral;
    private Recursos recursosJugador;
    private Mineral nodo;

	public Zangano(Ubicacion unaUbicacion, Recursos recursosJugador) {
		this.vida = new Vida(25);
		this.ubicacion = unaUbicacion;
		this.superficie = new Superficie("Tierra");

		this.cantidadRecolectableDeMineral = 10;
		this.recursosJugador = recursosJugador;
		this.nodo = new SinNodoMineral();
	}

    public Zangano(Recursos recursosJugador) {
		this.vida = new Vida(25);
		this.ubicacion = new Ubicacion();
		this.superficie = new Superficie("Tierra");

        this.cantidadRecolectableDeMineral = 10;
		this.recursosJugador = recursosJugador;
        this.nodo = new SinNodoMineral();
    }
    
    public void conNodo(NodoMineral unNodo) {
    	this.nodo = unNodo;
    	unNodo.construirRecolectorDeMineral(this);
    }

	public void avanzarTurno() {
		if(nodo.tieneMineral()) {
			this.recursosJugador.guardar(0, this.recolectarMineralDe(this.nodo));
		}
	}

	@Override
	public int recolectarMineralDe(Mineral unNodoMineral) {
		return (unNodoMineral.recolectarMineral(cantidadRecolectableDeMineral));
	}

	@Override
	public int obtenerMineral() {
		return this.recursosJugador.obtenerMineral();
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