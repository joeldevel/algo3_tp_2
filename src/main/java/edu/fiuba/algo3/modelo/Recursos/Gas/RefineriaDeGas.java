package edu.fiuba.algo3.modelo.Recursos.Gas;

import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;

public interface RefineriaDeGas {
    
	public int extraerGasDe(Volcan unVolcan);
    
    public int obtenerGas();
    
    public boolean tieneRefineria();
}
