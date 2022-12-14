package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;


import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoError;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.SUMINISTRO_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.SUMINISTRO_ZEALOT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;

public class Acceso extends EdificioProtoss {

	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 0;
	
	
    public Acceso(Ubicacion unaUbicacion, Jugador unJugador) {
		super(new Tiempo(-8), new Vida(500), new Escudo(500), unaUbicacion, unJugador,"Acceso");
		
		unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
	}

	@Override
	public ArrayList<Unidad> devolverLarvas() {
		return new ArrayList<Unidad>();
	}

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public void ejecutaOperable() {
		
	}
	
	public Unidad transportarZealots() {
		if(! this.estaEnergizado()) {
			throw new EdificioNoEnergizadoError();
		}
		if(this.tiempoRestante() != 0) {
			throw new EdificioNoOperativoException();
		}
		Unidad zealot = new Unidad(new Tiempo(-4), this.ubicacion, new Zealot(this.jugador));
		return zealot;
	}
	
	public Unidad transportarDragones() {
		if(! this.estaEnergizado()) {
			throw new EdificioNoEnergizadoError();
		}
		if(this.tiempoRestante() != 0) {
			throw new EdificioNoOperativoException();
		}
		Unidad dragon = new Unidad(new Tiempo(-6), this.ubicacion, new Dragon(this.jugador));
		return dragon;
	}
		
	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return this.superficie.compararTipos(otraSuperficie);
	}

	@Override
	public void serRevelado() {
		// No hace nada.
	}
}
