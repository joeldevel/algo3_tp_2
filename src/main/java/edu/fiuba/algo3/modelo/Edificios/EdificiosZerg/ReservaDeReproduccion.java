package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.CONSTRUCCION_ZANGANO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.CONSTRUCCION_ZERLING;

public class ReservaDeReproduccion extends EdificioZerg {

	private final int POBLACION = 0;
    private final int COSTO_MINERAL = 150;
    private final int COSTO_GAS = 0;
    
    private ArrayList<Unidad> larvas;
    private ArrayList<Unidad> zerlings;
    	
    public ReservaDeReproduccion(Ubicacion unaUbicacion, Jugador unJugador) {
    	super(new Tiempo(-12), new Vida(1000), unaUbicacion, unJugador,"ReservaDeReproduccion");
    	
    	unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.larvas = new ArrayList<Unidad>();
    	this.zerlings = new ArrayList<Unidad>();
    }

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}
    
	@Override
	public void ejecutaOperable() {
		this.crearZerlings();
	}

	@Override
	public ArrayList<Unidad> devolverLarvas() {
		return new ArrayList<Unidad>();
	}

	public void crearZerlings() {
		/* el ciclo deberia tener algo como && this.cumpleConLosRequisitos(unosRequisitos)*/
		/*while(this.contarLarvas() != 0) {
			Unidad actual = larvas.get(0);
			actual.setComportamientoEstado(new Zerling(this.ubicacion, this.jugador));
			zerlings.add(actual);
			larvas.remove(0);
		}*/

		if(!this.larvas.isEmpty()) {
			Unidad unaUnidad = this.larvas.get(0);
			unaUnidad.setComportamientoTipo(new Tiempo(CONSTRUCCION_ZERLING), new Zerling(this.ubicacion, this.jugador));
			this.larvas.remove(0);
			zerlings.add(unaUnidad);
		}
	}
	
	public int contarLarvas() {
		return (this.larvas.size());
	}
	
	public void recibirLarvas(ArrayList<Unidad> unasLarvas) {
		this.larvas.addAll(unasLarvas);
	}
	
	public ArrayList<Unidad> obtenerZerlings(){
		ArrayList<Unidad> aDevolver = new ArrayList<>(this.zerlings);
		this.zerlings.clear();
		return aDevolver;
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