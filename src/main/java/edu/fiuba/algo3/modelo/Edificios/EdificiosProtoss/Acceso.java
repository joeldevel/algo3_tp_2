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
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CONSTRUCCION_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.CONSTRUCCION_ZEALOT;

public class Acceso extends EdificioProtoss {

	public static final int CONSTRUCCION_ACCESO = -8;
	public static final int VIDA_ACCESO = 500;
	public static final int ESCUDO_ACCESO = 500;

	private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 150;
	private static final int COSTO_GAS = 0;
	
    public Acceso(Ubicacion unaUbicacion, Jugador unJugador) {
		super(new Tiempo(CONSTRUCCION_ACCESO), new Vida(VIDA_ACCESO), new Escudo(ESCUDO_ACCESO), unaUbicacion, unJugador,"Acceso");
		
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
		// ...
	}
	
	public Unidad transportarZealots() {
		if(! this.estaEnergizado()) {
			throw new EdificioNoEnergizadoError();
		}
		if(this.tiempoRestante() != 0) {
			throw new EdificioNoOperativoException();
		}
		Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), this.ubicacion, new Zealot(this.jugador));
		return zealot;
	}
	
	public Unidad transportarDragones() {
		if(! this.estaEnergizado()) {
			throw new EdificioNoEnergizadoError();
		}
		if(this.tiempoRestante() != 0) {
			throw new EdificioNoOperativoException();
		}
		Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), this.ubicacion, new Dragon(this.jugador));
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
