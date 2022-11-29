package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;


import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;

public class Acceso extends EdificioProtoss {

	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 0;
	
	private ArrayList<Unidad> zealotsPedido;
	private ArrayList<Unidad> dragonesPedido;
	private ArrayList<Unidad> zealotsProductivo;
	private ArrayList<Unidad> dragonesProductivo;
	
    public Acceso(Recursos recursosJugador, Ubicacion unaUbicacion) {
		super(new Tiempo(-8),new Vida(500),new Escudo(500),unaUbicacion);
		this.zealotsPedido = new ArrayList<Unidad>();
		this.dragonesPedido = new ArrayList<Unidad>();
		this.zealotsProductivo = new ArrayList<Unidad>();
		this.dragonesProductivo = new ArrayList<Unidad>();
		
		recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
	}

	@Override
	public void ejecutaOperable() {
		this.crearZealot();
		this.crearDragon();
	}
	
	private void crearZealot() {
		/* solo crea los zealots que se almacenan en pedido */
		while(this.zealotsPedido.size() < 5) {
			this.zealotsPedido.add(new Unidad(new Tiempo(-4), this.ubicacion, new Zealot(this.ubicacion)));
		}
	}
	
	private void crearDragon() {
		/* solo crea los zealots que se almacenan en pedido */
		while(this.dragonesPedido.size() < 5) {
			this.dragonesPedido.add(new Unidad(new Tiempo(-6), this.ubicacion, new Dragon(this.ubicacion)));			
		}
	}
	
	public void transportarZealots(Recursos recursosDelJugador) {
		/* hay que verificar que el jugador tenga los recursos, una vez verificado se pasa
		 * de pedido a produccion, y cuando pase el tiempo de creacion el jugador puede
		 * puede obtener la unidad*/
	}
	
	public void transportarDragones(Recursos recursosDelJugador) {
		/* hay que verificar que el jugador tenga los recursos, una vez verificado se pasa
		 * de pedido a produccion, y cuando pase el tiempo de creacion el jugador puede
		 * puede obtener la unidad*/
	}
	
	public ArrayList<Unidad> obtenerZealots(){
		return (this.zealotsProductivo);
	}
	
	public ArrayList<Unidad> obtenerDragones(){
		return (this.dragonesProductivo);
	}

	@Override
	public void atacar(Atacable unAtacable) {
		// No hace nada
	}

	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return this.superficie.compararTipos(otraSuperficie);
	}
		
}
