package edu.fiuba.algo3.modelo.Edificios;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.Zerling;

public class ReservaDeProduccion extends EdificioZerg {

    private final int COSTO_MINERAL = 150;
    private final int COSTO_GAS = 0;
    
    private ArrayList<Unidad> larvas;
    private ArrayList<Unidad> zerlings;
    	
    public ReservaDeProduccion() {
    	super(new Tiempo(-12),new Vida(1000));   
    	this.larvas = new ArrayList<Unidad>();
    	this.zerlings = new ArrayList<Unidad>();
    }
    
	@Override
	public void ejecutaOperable() {
		this.crearZerlings();
	}
	
	public void crearZerlings() {
		/* el ciclo deberia tener algo como && this.cumpleConLosRequisitos(unosRequisitos)*/
		while(this.contarLarvas() != 0) {
			Unidad actual = larvas.get(0);
			actual.cambiarTipo(new Zerling());
			zerlings.add(actual);
			larvas.remove(0);
		}
	}
	
	public int contarLarvas() {
		return (this.larvas.size());
	}
	
	public void recibirLarvas(ArrayList<Unidad> unasLarvas) {
		this.larvas.addAll(unasLarvas);
	}
	
	public ArrayList<Unidad> obtenerZerlings(){
		return (this.zerlings);
	}
		
}