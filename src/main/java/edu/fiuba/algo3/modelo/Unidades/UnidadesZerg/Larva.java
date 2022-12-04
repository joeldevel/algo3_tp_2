package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Larva implements TipoDeUnidad {
	
	public Larva() {
		
	}

	@Override
	public void conNodo(NodoMineral nodo) {
		// Larva no entiende este mensaje.
	}

	public void setComportamientoUnidad(Unidad unaUnidad) {
	}

	@Override
	public int obtenerPoblacion() {
		return 0;
	}

	@Override
	public int obtenerSuministro() {
		return 0;
	}

	@Override
	public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
	}

	@Override
	public Superficie obtenerSuperficie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atacar(Atacable unAtacable, Unidad unidadAtacante) {
		// TODO Auto-generated method stub
	}

	@Override
	public void recuperarse() {
		// TODO Auto-generated method stub
		
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
	public int vidaRestante() {
		return 0;
	}

	public int escudoRestante() {
		return 0;
	}

	public void hacerseInvisible() {
		// No entiende este mensaje.
	}

	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return false;
	}

	@Override
	public void avanzarTurno() {
		// No hace nada.
	}


}
