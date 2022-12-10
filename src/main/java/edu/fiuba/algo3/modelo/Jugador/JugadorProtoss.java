package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.SinEdificioBuscadoError;
import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Excepciones.UbicacionSinEdificioException;
import edu.fiuba.algo3.modelo.FabricaDeEdificios;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.SUMINISTRO_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.SUMINISTRO_SCOUT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.SUMINISTRO_ZEALOT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorProtoss implements Jugador {

    private static final String RAZA = "Protoss";
    private static final int MAX_POBLACION = 200;
    private static final int CANT_MINERAL_INICIAL = 200;

    private String nombre;
    private String color;
    private Recursos recursos;
    private int suministro;

    private int cantidadDeZealots;
    private int cantidadDeDragones;
    private int cantidadDeScouts;

    private ArrayList<Edificio> edificios;
    private ArrayList<Unidad> unidades;

    public JugadorProtoss(String unNombre, String unColor) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.suministro = 0;

        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;

        this.edificios = new ArrayList<Edificio>();
        this.unidades = new ArrayList<Unidad>();
    }

    // Constructor utilizado unicamente para simplificar pruebas.
    public JugadorProtoss(String unNombre, String unColor, Recursos unosRecursos) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = unosRecursos;
        this.suministro = 0;

        this.cantidadDeZealots = 0;
        this.cantidadDeDragones = 0;
        this.cantidadDeScouts = 0;

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
        return (otraRaza.equals("Protoss"));
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
    
    public void construir(String edificio,Ubicacion unaUbicacion, Jugador jugador, Mapa mapa) {
    	FabricaDeEdificios.construir(edificio, unaUbicacion, jugador, this, mapa);
    }

    // Falta enviar el mensaje al edificio Acceso que permite instanciar Zealot.
    public void crearZealot(Ubicacion unaUbicacion, Mapa unMapa) {

        if (!this.haySuministroDisponible(SUMINISTRO_ZEALOT)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((unMapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (unMapa.verificarEdificioEnUbicacion("Acceso", unaUbicacion))) {
            Acceso acceso = (Acceso) unMapa.obtenerEdificioEnUbicacion("Acceso", unaUbicacion);
            acceso.transportarZealots();

            this.cantidadDeZealots++;
            this.incrementarSuministro(SUMINISTRO_ZEALOT);
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }

    // Falta enviar el mensaje al edificio Acceso que permite instanciar Dragon.
    public void crearDragon(Ubicacion unaUbicacion, Mapa unMapa) {
        if (!this.haySuministroDisponible(SUMINISTRO_DRAGON)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((unMapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (unMapa.verificarEdificioEnUbicacion("Acceso", unaUbicacion))) {
            Acceso acceso = (Acceso) unMapa.obtenerEdificioEnUbicacion("Acceso", unaUbicacion);
            acceso.transportarDragones();

            this.cantidadDeDragones++;
            this.incrementarSuministro(SUMINISTRO_DRAGON);
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }

    // Falta enviar el mensaje al edificio PuertoEstelar que permite instanciar Scout.
    public void crearScout(Ubicacion unaUbicacion, Mapa unMapa) {
        if (!this.haySuministroDisponible(SUMINISTRO_SCOUT)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((unMapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (unMapa.verificarEdificioEnUbicacion("PuertoEstelar", unaUbicacion))) {
            PuertoEstelar puerto = (PuertoEstelar) unMapa.obtenerEdificioEnUbicacion("PuertoEstelar", unaUbicacion);
            puerto.transportarScout();

            this.cantidadDeScouts++;
            this.incrementarSuministro(SUMINISTRO_SCOUT);
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }

    public int cantidadDeUnidades(UNIDADES_PROTOSS tipoUnidad) {
        if (tipoUnidad == UNIDADES_PROTOSS.ZEALOT) {
            return this.cantidadDeZealots;
        }
        if (tipoUnidad == UNIDADES_PROTOSS.DRAGON) {
            return this.cantidadDeDragones;
        }
        if (tipoUnidad == UNIDADES_PROTOSS.SCOUT) {
            return this.cantidadDeScouts;
        }
        return 0;
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

    @Override
    public ArrayList<Unidad> obtenerLarvas() {
        return new ArrayList<Unidad>();
    }

    // La poblacion debe ser siempre menor al valor maximo de poblacion.
    public int calcularSuministroo() {
        int cupo = 0;

        for (Unidad unidad : this.unidades) {
            cupo += unidad.obtenerSuministro();
        }

        return cupo;
    }

    // Este metodo sera reemplazado por el de arriba cuando se termine el codigo relacionado a la creacion de unidades.
    public int calcularSuministro() {
        return this.suministro;
    }

    // El cupo debe ser siempre menor al valor de poblacion.
    private void incrementarSuministro(int unIncremento) {
        if (this.suministro + unIncremento <= this.calcularPoblacion()) {
            this.suministro += unIncremento;
        }
    }

    private boolean haySuministroDisponible(int unSuministro) {
        return (this.suministro + unSuministro <= this.calcularPoblacion());
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
    }

    @Override
    public void eliminarUnidad(Unidad unaUnidad) {
        this.suministro -= unaUnidad.obtenerSuministro();
        this.unidades.remove(unaUnidad);
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

    public void agregarEdificio(Edificio unEdificio) {
		this.edificios.add(unEdificio);
	}
	
	public Recursos obtenerRecursos() {
		return (this.recursos);
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
	
	@Override
	public void agregarUnidad(Unidad unaUnidad) {
		this.unidades.add(unaUnidad);
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