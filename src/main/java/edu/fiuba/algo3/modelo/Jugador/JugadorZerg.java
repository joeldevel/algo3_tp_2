package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.UbicacionSinEdificioException;
import edu.fiuba.algo3.modelo.Fabrica;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import java.util.ArrayList;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorZerg extends Jugador {

    private static final String RAZA = "Zerg";

    public JugadorZerg(String unNombre, String unColor, Mapa unMapa) {
    	super(unNombre, unColor, unMapa);
    }

    // Constructor utilizado unicamente para pruebas debido a los recursos.
    public JugadorZerg(String unNombre, String unColor, Recursos unosRecursos, Mapa unMapa) {
    	super(unNombre,unColor,unosRecursos,unMapa);
    }

    @Override
    public String obtenerRaza() {
        return RAZA;
    }

    @Override
    public boolean compararRazas(String otraRaza) {
        return (otraRaza.equals(RAZA));
    }

    public void construir(String entidad,Ubicacion unaUbicacion,Jugador jugadorProtoss,Mapa mapa) {
    	Fabrica.construir(entidad, unaUbicacion, this, (JugadorProtoss)jugadorProtoss, mapa);
    }

    public ArrayList<Unidad> obtenerLarvas() {
        // Devolvemos las larvas del primer criadero que encontremos
        for(Edificio edificio: this.edificios) {
            if(edificio.esUn("Criadero")) {
            	Criadero criadero = (Criadero)edificio;
            	if(criadero.contarLarvas() != 0) {
            		return criadero.devolverLarvas();            		
            	}
            }
        }

        return new ArrayList<Unidad>();
    }

    public void evolucionarMutaliscoAGuardian(Ubicacion unaUbicacion) {

        if((this.mapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (this.mapa.verificarUnidadEnUbicacion(unaUbicacion))) {
            Unidad mutalisco = this.mapa.obtenerUnidadEnUbicacion(unaUbicacion);
            mutalisco.evolucionarAGuardian();
        }
    }

    public void evolucionarMutaliscoADevorador(Ubicacion unaUbicacion) {

        if((this.mapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (this.mapa.verificarUnidadEnUbicacion(unaUbicacion))) {
            Unidad mutalisco = this.mapa.obtenerUnidadEnUbicacion(unaUbicacion);
            mutalisco.evolucionarADevorador();
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }
}