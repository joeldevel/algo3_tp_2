package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Fabrica;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;

public class JugadorProtoss extends Jugador{

    private static final String RAZA = "Protoss";

    public JugadorProtoss(String unNombre, String unColor, Mapa unMapa) {
    	super(unNombre,unColor,unMapa);
    }

    // Constructor utilizado unicamente para simplificar pruebas.
    public JugadorProtoss(String unNombre, String unColor, Recursos unosRecursos, Mapa unMapa) {
    	super(unNombre,unColor,unosRecursos,unMapa);
    }

    @Override
    public String getRaza() {
        return RAZA;
    }

    @Override
    public boolean compararRazas(String otraRaza) {
        return (otraRaza.equals(RAZA));
    }
    
    public void construir(String entidad,Ubicacion unaUbicacion, Jugador jugadorZerg, Mapa mapa) {
    	Fabrica.construir(entidad, unaUbicacion, (JugadorZerg)jugadorZerg, this, mapa);
    }
	
}