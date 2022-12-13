package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.SinEdificioBuscadoError;
import edu.fiuba.algo3.modelo.Excepciones.SinUnidadBuscadaError;
import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Excepciones.UbicacionSinEdificioException;
import edu.fiuba.algo3.modelo.Fabrica;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.SUMINISTRO_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.SUMINISTRO_HIDRALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.SUMINISTRO_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.SUMINISTRO_ZANGANO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.CONSTRUCCION_AMO;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorZerg implements Jugador {

    private static final String RAZA = "Zerg";
    private static final int MAX_POBLACION = 200;
    private static final int CANT_MINERAL_INICIAL = 200;

    private String nombre;
    private String color;
    private Recursos recursos;
    private Mapa mapa;
    private ArrayList<Edificio> edificios;
    private ArrayList<Unidad> unidades;

    public JugadorZerg(String unNombre, String unColor, Mapa unMapa) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.mapa = unMapa;
        this.edificios = new ArrayList<Edificio>();
        this.unidades = new ArrayList<Unidad>();
    }

    // Constructor utilizado unicamente para pruebas debido a los recursos.
    public JugadorZerg(String unNombre, String unColor, Recursos unosRecursos, Mapa unMapa) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = unosRecursos;
        this.mapa = unMapa;
        this.edificios = new ArrayList<Edificio>();
        this.unidades = new ArrayList<Unidad>();
    }

    @Override
    public String obtenerNombre() {
        return (this.nombre);
    }

    @Override
    public String obtenerColor() {
        return (this.color);
    }

    @Override
    public String obtenerRaza() {
        return RAZA;
    }

    @Override
    public boolean compararNombres(String otroNombre) {
        return (this.nombre.equals(otroNombre));
    }

    @Override
    public boolean compararColores(String otroColor) {
        return (this.color.equals(otroColor));
    }

    @Override
    public boolean compararRazas(String otraRaza) {
        return (otraRaza.equals("Zerg"));
    }

    @Override
    public void guardar(int costoGas, int costoMineral) {
        this.recursos.guardar(costoGas, costoMineral);
    }

    @Override
    public void utilizar(int costoGas, int costoMineral) {
        this.recursos.utilizar(costoGas, costoMineral);
    }

    @Override
    public int obtenerGas() {
        return this.recursos.obtenerGas();
    }

    @Override
    public int obtenerMineral() {
        return this.recursos.obtenerMineral();
    }
    
    public void construir(String entidad,Ubicacion unaUbicacion,Jugador jugadorProtoss,Mapa mapa) {
        Fabrica.construir(entidad, unaUbicacion, this, jugadorProtoss, mapa);
    }

    /*
    public void crearAmoSupremo(Ubicacion unaUbicacion) {

        if (!this.haySuministroDisponible(SUMINISTRO_AMO)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        AmoSupremo tipoAmoSupremo = new AmoSupremo(this);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), unaUbicacion, tipoAmoSupremo);
        this.agregarUnidad(amoSupremo);
    }

    public void crearZangano(Ubicacion unaUbicacion) {

        if (!this.haySuministroDisponible(SUMINISTRO_ZANGANO)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((this.mapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (this.mapa.verificarEdificioEnUbicacion("Criadero", unaUbicacion))) {
            Criadero criadero = (Criadero) this.mapa.obtenerEdificioEnUbicacion("Criadero", unaUbicacion);
            criadero.crearZangano();
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }

    public void crearZerling(Ubicacion unaUbicacion) {

        if (!this.haySuministroDisponible(SUMINISTRO_ZERLING)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((this.mapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (this.mapa.verificarEdificioEnUbicacion("ReservaDeReproduccion", unaUbicacion))) {
            ReservaDeReproduccion reserva = (ReservaDeReproduccion) this.mapa.obtenerEdificioEnUbicacion("ReservaDeReproduccion", unaUbicacion);
            reserva.recibirLarvas(obtenerLarvas());
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }*/

    public ArrayList<Unidad> obtenerLarvas() {
        // Devolvemos las larvas del primer criadero que encontremos
        for(Edificio edificio: this.edificios) {
            if(edificio.esUn("Criadero")) {
                return edificio.devolverLarvas();
            }
        }

        return new ArrayList<Unidad>();
    }

    /*
    public void crearHidralisco(Ubicacion unaUbicacion) {

        if (!this.haySuministroDisponible(SUMINISTRO_HIDRALISCO)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((this.mapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (this.mapa.verificarEdificioEnUbicacion("Guarida", unaUbicacion))) {
            Guarida guarida = (Guarida) this.mapa.obtenerEdificioEnUbicacion("Guarida", unaUbicacion);
            guarida.recibirLarvas(obtenerLarvas());
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }

    public void crearMutalisco(Ubicacion unaUbicacion) {

        if (!this.haySuministroDisponible(SUMINISTRO_MUTALISCO)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((this.mapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (this.mapa.verificarEdificioEnUbicacion("Espiral", unaUbicacion))) {
            Espiral espiral = (Espiral) this.mapa.obtenerEdificioEnUbicacion("Espiral", unaUbicacion);
            espiral.recibirLarvas(obtenerLarvas());
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }*/

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

    // La poblacion debe ser siempre menor al valor maximo de poblacion.
    public int calcularSuministro() {
        int cupo = 0;

        for (Unidad unidad : this.unidades) {
            cupo += unidad.obtenerSuministro();
        }

        return cupo;
    }

    public boolean haySuministroDisponible(int unSuministro) {
        return (this.calcularSuministro() + unSuministro <= this.calcularPoblacion());
    }

    public void avanzarTurno() {

        for (Edificio edificio : this.edificios) {
            edificio.avanzarTurno(); // Edificios: Criadero expande el moho, Extractor recolecta gas, Zangano recolecta mineral, se recuperan, pasa el tiempo de construccion.
        }

        for (Unidad unidad : this.unidades) {
            unidad.avanzarTurno(); // Unidades: Se recuperan, pasa el tiempo de construccion.
        }

        this.recursos.guardar(5, 5);
    }

    @Override
    public void eliminarEdificio(Edificio unEdificio) {
        this.edificios.remove(unEdificio);
        this.mapa.destruirEdificio(unEdificio);
    }

    @Override
    public void eliminarUnidad(Unidad unaUnidad) {
        this.unidades.remove(unaUnidad);
        this.mapa.destruirUnidad(unaUnidad);
    }
    
    @Override
	public boolean tieneEdificioEnUbicacion(Ubicacion unaUbicacion) {
		boolean verificado = false;
		for(Edificio actual: this.edificios) {
			if(actual.estaEn(unaUbicacion)) {
				verificado = true;
			}
		}
		return verificado;
	}

    public Recursos obtenerRecursos() {
		return (this.recursos);
	}
	
	public void agregarEdificio(Edificio unEdificio) {
		this.edificios.add(unEdificio);
	}
	
	public boolean verificarEdificio(String unEdificio) {
		boolean verificado = false;
		for(Edificio actual: this.edificios) {
			if(actual.esUn(unEdificio)) {
				verificado = true;
			}
		}
		return verificado;
	}
	
	@Override
	public void agregarUnidad(Unidad unaUnidad) {
		this.unidades.add(unaUnidad);
		//this.mapa.agregarUnidad(unaUnidad);
	}
	
	public void destruirEdificioEn(Ubicacion unaUbicacion) {
		Edificio edificio = this.obtenerEdificioEn(unaUbicacion);
		this.edificios.remove(edificio);
	}
	
	public Edificio obtenerEdificioEn(Ubicacion unaUbicacion) {
		Edificio edificio = null;
		for(Edificio actual: this.edificios) {
			if(actual.estaEn(unaUbicacion)) {
				edificio = actual;
			}
		}
		if(edificio == null) {
			throw new SinEdificioBuscadoError();
		}
		return edificio;
	}
	
	public Unidad obtenerUnidadEn(Ubicacion unaUbicacion) {
		Unidad unidad = null;
		for(Unidad actual: this.unidades) {
			if(actual.estaEn(unaUbicacion)) {
				unidad = actual;
			}
		}
		if(unidad == null) {
			throw new SinUnidadBuscadaError();
		}
		return unidad;
	}
	
	public void moverUnidadEn(Ubicacion unaUbicacion) {
		Unidad unidad = this.obtenerUnidadEn(unaUbicacion);
		unidad.moverse(this.mapa);
	}
	
	public void cambiarDireccionDeUnidadEn(Ubicacion unaUbicacion) {
		Unidad unidad = this.obtenerUnidadEn(unaUbicacion);
		unidad.cambiarDireccion();
	}
}