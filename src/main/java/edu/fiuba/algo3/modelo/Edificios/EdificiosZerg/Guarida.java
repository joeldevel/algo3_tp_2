package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.CONSTRUCCION_HIDRALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.SUMINISTRO_HIDRALISCO;

public class Guarida extends EdificioZerg {

	public static final int CONSTRUCCION_GUARIDA = -12;
	public static final int VIDA_GUARIDA = 1250;

	private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 200;
	private static final int COSTO_GAS = 100;
	
	private ArrayList<Unidad> larvas;
	
    public Guarida(Ubicacion unaUbicacion, Jugador unJugador){
        super(new Tiempo(CONSTRUCCION_GUARIDA), new Vida(VIDA_GUARIDA), unaUbicacion, unJugador,"Guarida");
        
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
	
	public void crearHidralisco() {
		
		if(!this.larvas.isEmpty() && this.jugador.haySuministroDisponible(SUMINISTRO_HIDRALISCO) && 
			this.tiempoRestante() == 0) {
			Unidad unaUnidad = this.larvas.get(0);
			unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_HIDRALISCO), new Hidralisco(this.jugador), this.ubicacion);
			this.larvas.remove(0);
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