package edu.fiuba.algo3.modelo.Recursos.Minerales;

public interface Minero {
	
    public int recolectarMineralDe(Mineral unNodoMineral);
    
    public int obtenerMineral();
    
    public boolean tieneMinero();
}