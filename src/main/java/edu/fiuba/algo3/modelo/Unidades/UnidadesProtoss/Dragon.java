package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

public class Dragon implements TipoDeUnidad, Atacante, Atacable {

	public static final int SUMINISTRO_DRAGON = 3;
	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 125;
	private final int COSTO_GAS = 50;
	public static final int CONSTRUCCION_DRAGON = -6;
	
	private Vida vida;
	private Escudo escudo;
	private Jugador jugador;
	private Unidad unidad;
	private Superficie superficie;
	private ArrayList<Ataque> ataques;
	
	public Dragon(Jugador unJugador) {
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

		this.vida = new Vida(100);
		this.escudo = new Escudo(80);
		this.jugador = unJugador;
		this.unidad = null;
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(20,new Superficie("Tierra"),4));
												 add(new Ataque(20,new Superficie("Aire"),4));}};
	}

	@Override
	public void conNodo(NodoMineral nodo) {
		// Dragon no entiende este mensaje.
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
		return SUMINISTRO_DRAGON;
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
	public void recuperarse() {
		this.escudo.recuperarse();
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
	public void serRevelado() {
		// No hace nada.
	}

	@Override
	public void contarBaja() {
		// No hace nada.
	}
}
