package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.SUMINISTRO_HIDRALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.SUMINISTRO_MUTALISCO;

public class Espiral extends EdificioZerg {

	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 100;
	
	private ArrayList<Unidad> larvas;
	
	public Espiral(Ubicacion unaUbicacion, Jugador unJugador){
        super(new Tiempo(-10), new Vida(1300), unaUbicacion, unJugador,"Espiral");
        
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
		this.crearMutalisco();
	}
	
	public void crearMutalisco() {

		if(!this.larvas.isEmpty() && this.jugador.haySuministroDisponible(SUMINISTRO_MUTALISCO)) {

			Unidad unaUnidad = larvas.get(0);
			unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_MUTALISCO), new Mutalisco(this.jugador), this.ubicacion);
			larvas.remove(0);
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
