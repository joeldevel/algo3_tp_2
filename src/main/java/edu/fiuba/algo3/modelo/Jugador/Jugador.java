package edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.SinEdificioBuscadoException;
import edu.fiuba.algo3.modelo.Excepciones.SinUnidadBuscadaException;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public abstract class Jugador {

	private static final int MAX_POBLACION = 200;
	private static final int CANT_MINERAL_INICIAL = 200;
	
	protected String nombre;
	protected String color;
	protected Recursos recursos;
	protected Mapa mapa;
	protected ArrayList<Edificio> edificios;
	protected ArrayList<Unidad> unidades;

    public Jugador(String unNombre, String unColor, Mapa unMapa) {
    	this.nombre = unNombre;
    	this.color = unColor;
    	this.recursos = new Recursos();
		this.recursos.guardar(0, CANT_MINERAL_INICIAL);
    	this.mapa = unMapa;
    	this.edificios = new ArrayList<Edificio>();
    	this.unidades = new ArrayList<Unidad>();
    }
    
    public Jugador(String unNombre, String unColor, Recursos unosRecursos, Mapa unMapa) {
    	this.nombre = unNombre;
    	this.color = unColor;
    	this.recursos = unosRecursos;
    	this.mapa = unMapa;
    	this.edificios = new ArrayList<Edificio>();
    	this.unidades = new ArrayList<Unidad>();
    }
    
    public String getNombre() {
        return (this.nombre);
    }

    public String getColor() {
        return (this.color);
    }

	public abstract String getRaza();

	public int getGas() {
		return this.recursos.obtenerGas();
	}

	public int getMineral() {
		return this.recursos.obtenerMineral();
	}

	public Recursos getRecursos() {
		return (this.recursos);
	}

	public boolean tieneEdificios() {
		return (this.edificios.size() > 0);
	}

    public boolean compararNombres(String otroNombre) {
        return (this.nombre.equals(otroNombre));
    }

    public boolean compararColores(String otroColor) {
        return (this.color.equals(otroColor));
    }

    public abstract boolean compararRazas(String otraRaza);

    public void guardar(int costoGas, int costoMineral) {
        this.recursos.guardar(costoGas, costoMineral);
    }

    public void utilizar(int costoGas, int costoMineral) {
        this.recursos.utilizar(costoGas, costoMineral);
    }
    
    public abstract void construir(String entidad,Ubicacion unaUbicacion, Jugador jugador, Mapa mapa);

    // La poblacion debe ser siempre menor al valor maximo de poblacion.
    public int calcularPoblacion() {
		int poblacion = 0;

		for (Edificio edificio : this.edificios) {
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

	public boolean tieneEdificioEnUbicacion(Ubicacion unaUbicacion) {
		boolean verificado = false;
		for(Edificio actual: this.edificios) {
			if(actual.estaEn(unaUbicacion)) {
				verificado = true;
			}
		}
		return verificado;
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

	public Edificio obtenerEdificioEn(Ubicacion unaUbicacion) {
		Edificio edificio = null;
		for(Edificio actual: this.edificios) {
			if(actual.estaEn(unaUbicacion)) {
				edificio = actual;
			}
		}
		if(edificio == null) {
			throw new SinEdificioBuscadoException();
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
			throw new SinUnidadBuscadaException();
		}
		return unidad;
	}

	public void agregarEdificio(Edificio unEdificio) {
		this.edificios.add(unEdificio);
	}

	public void agregarUnidad(Unidad unaUnidad) {
		this.unidades.add(unaUnidad);
	}
    
    public void destruirEdificio(Edificio unEdificio) {
        this.edificios.remove(unEdificio);
        this.mapa.destruirEdificio(unEdificio);
    }

    public void destruirUnidad(Unidad unaUnidad) {
        this.unidades.remove(unaUnidad);
        this.mapa.destruirUnidad(unaUnidad);
    }
	
	public void destruirEdificioEn(Ubicacion unaUbicacion) {
		Edificio edificio = this.obtenerEdificioEn(unaUbicacion);
		this.edificios.remove(edificio);
	}

	public int contarUnidades() {
		return (this.unidades.size());
	}
    
    public void moverUnidadEn(Ubicacion unaUbicacion) {
		Unidad unidad = this.obtenerUnidadEn(unaUbicacion);
		unidad.moverse(this.mapa);
	}
	
	public void cambiarDireccionDeUnidadEn(Ubicacion unaUbicacion) {
		Unidad unidad = this.obtenerUnidadEn(unaUbicacion);
		unidad.cambiarDireccion();
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
}