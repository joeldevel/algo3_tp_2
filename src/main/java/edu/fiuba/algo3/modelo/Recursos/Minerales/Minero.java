package edu.fiuba.algo3.modelo.Recursos.Minerales;

// Deben implementar esta interfaz NexoMineral y Zangano (ya que son los recolectores de ambas razas.)

import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;

public interface Minero {
	
    public int recolectarMineralDe(Mineral unNodoMineral);
    
    public int obtenerMineral();
    
    public boolean tieneMinero();
}