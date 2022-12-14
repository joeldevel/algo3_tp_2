package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Excepciones.SinEdificioBuscadoError;
import edu.fiuba.algo3.modelo.Fabrica;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorProtoss extends Jugador{

    private static final String RAZA = "Protoss";
    private static final int MAX_POBLACION = 200;
    private static final int CANT_MINERAL_INICIAL = 200;


    public JugadorProtoss(String unNombre, String unColor, Mapa unMapa) {
    	super(unNombre,unColor,unMapa);
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
    }

    // Constructor utilizado unicamente para simplificar pruebas.
    public JugadorProtoss(String unNombre, String unColor, Recursos unosRecursos, Mapa unMapa) {
    	super(unNombre,unColor,unosRecursos,unMapa);
    }

    @Override
    public String obtenerRaza() {
        return RAZA;
    }

    @Override
    public boolean compararRazas(String otraRaza) {
        return (otraRaza.equals("Protoss"));
    }
    
    public void construir(String entidad,Ubicacion unaUbicacion, Jugador jugadorZerg, Mapa mapa) {
    	Fabrica.construir(entidad, unaUbicacion, (JugadorZerg)jugadorZerg, this, mapa);
    }

    // La poblacion debe ser siempre menor al valor maximo de poblacion.
    @Override
    public int calcularPoblacion() {
        int poblacion = 0;

        for (Raza edificio : this.edificios) {
            poblacion += edificio.obtenerPoblacion();
        }

        for (Unidad unidad : this.unidades) {
            poblacion += unidad.obtenerPoblacion();
        }

        if (poblacion >= MAX_POBLACION) {
            return MAX_POBLACION;
        }

        return poblacion;
    }
	
	public Acceso obtenerAccesoEn(Ubicacion unaUbicacion) {
		Acceso acceso = null;
		for(Edificio actual:this.edificios) {
			if(actual.estaEn(unaUbicacion) && actual.esUn("Acceso")) {
				acceso = (Acceso)actual;
			}
		}
		if(acceso == null) {
			throw new SinEdificioBuscadoError();
		}
		return acceso;
	}
	
	public PuertoEstelar obtenerPuertoEstelarEn(Ubicacion unaUbicacion) {
		PuertoEstelar puertoEstelar = null;
		for(Edificio actual:this.edificios) {
			if(actual.estaEn(unaUbicacion) && actual.esUn("PuertoEstelar")) {
				puertoEstelar = (PuertoEstelar)actual;
			}
		}
		if(puertoEstelar == null) {
			throw new SinEdificioBuscadoError();
		}
		return puertoEstelar;
	}

}