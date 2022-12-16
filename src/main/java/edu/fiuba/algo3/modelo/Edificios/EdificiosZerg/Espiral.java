package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.SUMINISTRO_MUTALISCO;

public class Espiral extends EdificioZerg {

	public static final int CONSTRUCCION_ESPIRAL = -10;
	public static final int VIDA_ESPIRAL = 1300;

	private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 150;
	private static final int COSTO_GAS = 100;
	
	private ArrayList<Unidad> larvas;
	
	public Espiral(Ubicacion unaUbicacion, Jugador unJugador){
        super(new Tiempo(CONSTRUCCION_ESPIRAL), new Vida(VIDA_ESPIRAL), unaUbicacion, unJugador,"Espiral");
        
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
        this.larvas = new ArrayList<Unidad>();
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
	
	public void crearMutalisco() {

		if(!this.larvas.isEmpty() && this.jugador.haySuministroDisponible(SUMINISTRO_MUTALISCO) && 
			this.tiempoRestante() == 0) {

			Unidad unaUnidad = larvas.get(0);
			unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_MUTALISCO), new Mutalisco(this.jugador), this.ubicacion);
			larvas.remove(0);
			this.jugador.agregarUnidad(unaUnidad);
		}
	}
	
	public void recibirLarvas(ArrayList<Unidad> unasLarvas) {
		this.larvas.addAll(unasLarvas);
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}

	@Override
	public void serRevelado() {
		// No hace nada.
	}
}
