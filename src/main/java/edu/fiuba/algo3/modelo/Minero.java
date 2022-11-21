package edu.fiuba.algo3.modelo;

// Deben implementar esta interfaz NexoMineral y Zangano (ya que son los recolectores de ambas razas.)

public interface Minero {
	
    public int recolectarMineralDe(Mineral unNodoMineral);
    
    public int obtenerMineral();
    
    public boolean tieneMinero();
}