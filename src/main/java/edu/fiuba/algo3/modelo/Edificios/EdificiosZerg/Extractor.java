package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Gas.RefineriaDeGas;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import java.util.ArrayList;

public class Extractor extends EdificioZerg implements RefineriaDeGas {

	public static final int CONSTRUCCION_EXTRACTOR = -6;
	public static final int VIDA_EXTRACTOR = 750;

	private static final int POBLACION = 0;
	private static final int COSTO_MINERAL = 100;
	private static final int COSTO_GAS = 0;
	private static final int RECOLECTABLE = 10;
	private static final int MAX_ZANGANOS = 3;
	
	private int cantidadExtraible;
    private int cantidadMaximaDeZanganos;
    private Volcan volcan;
    private ArrayList<Unidad> zanganos;
    
    public Extractor(Volcan unVolcan, Ubicacion unaUbicacion, Jugador unJugador){
    	super(new Tiempo(CONSTRUCCION_EXTRACTOR), new Vida(VIDA_EXTRACTOR), unaUbicacion, unJugador,"Extractor");
    	
    	unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.cantidadExtraible = RECOLECTABLE;
    	this.cantidadMaximaDeZanganos = MAX_ZANGANOS;
    	this.volcan = unVolcan;
        this.zanganos = new ArrayList<Unidad>();

		unVolcan.construirRefineriaDeGas(this);
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
    	this.jugador.guardar(this.extraerGasDe(this.volcan), 0);
    }
    
    public int contarZanganos() {
    	return (this.zanganos.size());
    }

    public void guardarZangano(Unidad unZangano) {
    	
    	if(this.contarZanganos() == this.cantidadMaximaDeZanganos) {
    		throw new CantidadMaximaDeZanganosEnExtractorException();
    	}

    	if(unZangano.ubicacion().esIgualA(this.ubicacion())) {
			this.zanganos.add(unZangano);
		}
    }

    @Override
	public int extraerGasDe(Volcan unVolcan) {
		return (unVolcan.extraerGas(this.cantidadExtraible * this.contarZanganos()));
	}
	
	@Override
    public int obtenerGas() {
		return this.jugador.getGas();
    }

	@Override
	public boolean tieneRefineria() {
		return true;
	}

}