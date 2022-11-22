package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Minero;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.SinNodoMineral;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Vida;

public class Zangano implements TipoDeUnidad, Minero, Atacable {

	private Vida vida;
	private Ubicacion ubicacion;
	private Superficie superficie;

	private int cantidadRecolectableDeMineral;
    private int cantidadRecolectada;
    private Mineral nodo;

	public Zangano(Ubicacion unaUbicacion) {
		this.vida = new Vida(25);
		this.ubicacion = unaUbicacion;
		this.superficie = new Superficie("Tierra");

		this.cantidadRecolectableDeMineral = 10;
		this.cantidadRecolectada = 0;
		this.nodo = new SinNodoMineral();
	}

    public Zangano() {
		this.vida = new Vida(25);
		this.ubicacion = new Ubicacion();
		this.superficie = new Superficie("Tierra");

        this.cantidadRecolectableDeMineral = 10;
        this.cantidadRecolectada = 0;
        this.nodo = new SinNodoMineral();
    }
    
    public void conNodo(NodoMineral unNodo) {
    	this.nodo = unNodo;
    	unNodo.construirRecolectorDeMineral(this);
    }

	public void avanzarTurno() {
		if(nodo.tieneMineral()) {
			this.cantidadRecolectada += this.recolectarMineralDe(this.nodo);
		}
	}

	@Override
	public int recolectarMineralDe(Mineral unNodoMineral) {
		return (unNodoMineral.recolectarMineral(cantidadRecolectableDeMineral));
	}

	@Override
	public int obtenerMineral() {
		int recolectado = this.cantidadRecolectada;
		this.cantidadRecolectada = 0;
		return recolectado;
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
}