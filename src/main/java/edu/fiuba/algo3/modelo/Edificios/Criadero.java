package edu.fiuba.algo3.modelo.Edificios;

import java.util.*;

import edu.fiuba.algo3.modelo.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Larva;
import edu.fiuba.algo3.modelo.Unidades.Zangano;

/* el criadero deberia implementar una interfaz evolucionador por ejemplo, que habilite a evolucionar las
 * larvas a otro tipo de unidad zerg. Sino una buna idea es usar el patron Factory Method */

public class Criadero extends EdificioZerg {

	private int maxLarvas;
	private ArrayList<Larva> larvas;
	private ArrayList<Zangano> zanganos;
		
	public Criadero() {	
		super(new Tiempo(-4),new Vida(500,10));
		this.maxLarvas = 3;
		this.larvas = new ArrayList<Larva>() {{ add(new Larva()); add(new Larva()); add(new Larva());}};
		this.zanganos = new ArrayList<Zangano>();
	}

	@Override
	public void ejecutaOperable() {
		this.crearLarva();
	}
	
	public int contarLarvas() {
		return (this.larvas.size());
	}

	public void crearZangano() {
		if(this.larvas.isEmpty()) {
			throw new CriaderoSinLarvasException();
		}
		Larva unaLarva = this.larvas.get(0);
		Zangano zangano = unaLarva.evolucionar();
		this.larvas.remove(0);
		zanganos.add(zangano);
	}
	
	public void crearLarva() {
		if(this.contarLarvas()<this.maxLarvas) {
			this.larvas.add(new Larva());
		}
	}


	
}
