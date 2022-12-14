package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.CONSTRUCCION_ZERLING;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;

public class ReservaDeReproduccion extends EdificioZerg {

	public static final int CONSTRUCCION_RESERVA = -12;
	public static final int VIDA_RESERVA = 1000;

	private static final int POBLACION = 0;
    private static final int COSTO_MINERAL = 150;
    private static final int COSTO_GAS = 0;
    
    private ArrayList<Unidad> larvas;
    	
    public ReservaDeReproduccion(Ubicacion unaUbicacion, Jugador unJugador) {
    	super(new Tiempo(CONSTRUCCION_RESERVA), new Vida(VIDA_RESERVA), unaUbicacion, unJugador,"ReservaDeReproduccion");
    	
    	unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.larvas = new ArrayList<Unidad>();
    }

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}
    
	@Override
	public void ejecutaOperable() {
		// ...
	}

	@Override
	public ArrayList<Unidad> devolverLarvas() {
		return new ArrayList<Unidad>();
	}

public void crearZerling() {
	
		if(!this.larvas.isEmpty() && this.jugador.haySuministroDisponible(SUMINISTRO_ZERLING) && 
			this.tiempoRestante() == 0) {
			Unidad unaUnidad = this.larvas.get(0);
			unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_ZERLING), new Zerling(this.jugador), this.ubicacion);
			this.larvas.remove(0);
			this.jugador.agregarUnidad(unaUnidad);
		}
	}
	
	public void recibirLarvas(ArrayList<Unidad> unasLarvas) {
		this.larvas.addAll(unasLarvas);
	}

}