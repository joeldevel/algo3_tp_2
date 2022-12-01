package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

public class Zerling implements TipoDeUnidad, Atacante, Atacable {

	public static final int SUMINISTRO_ZERLING = 1;
	private final int POBLACION = 0;

	private Vida vida;
	private Ubicacion ubicacion;
	private Superficie superficie;
	private ArrayList<Ataque> ataques;
	
	public Zerling(Ubicacion unaUbicacion) {
		this.vida = new Vida(35);
		this.ubicacion = unaUbicacion;
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(4,new Superficie("Tierra"),1));}};
	}
	
	public Zerling() {
		this.vida = new Vida(35);
		this.ubicacion = new Ubicacion();
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(4,new Superficie("Tierra"),1));}};
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
	public Superficie obtenerSuperficie() {
		return this.superficie;
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