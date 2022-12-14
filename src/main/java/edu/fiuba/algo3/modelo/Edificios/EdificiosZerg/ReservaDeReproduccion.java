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

	private final int POBLACION = 0;
    private final int COSTO_MINERAL = 150;
    private final int COSTO_GAS = 0;
    
    private ArrayList<Unidad> larvas;
    	
    public ReservaDeReproduccion(Ubicacion unaUbicacion, Jugador unJugador) {
    	super(new Tiempo(-12), new Vida(1000), unaUbicacion, unJugador,"ReservaDeReproduccion");
    	
    	unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.larvas = new ArrayList<Unidad>();
    }

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}
    
	@Override
	public void ejecutaOperable() {
		this.crearZerling();
	}

	@Override
	public ArrayList<Unidad> devolverLarvas() {
		return new ArrayList<Unidad>();
	}

public void crearZerling() {
	
		if(!this.larvas.isEmpty() && this.jugador.haySuministroDisponible(SUMINISTRO_ZERLING)) {
			Unidad unaUnidad = this.larvas.get(0);
			unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_ZERLING), new Zerling(this.jugador), this.ubicacion);
			this.larvas.remove(0);
			this.jugador.agregarUnidad(unaUnidad);
		}
		 
	}
	
	public int contarLarvas() {
		return (this.larvas.size());
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