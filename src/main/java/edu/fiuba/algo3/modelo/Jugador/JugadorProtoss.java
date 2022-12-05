package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
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

// La poblacion aumenta a medida que se crean los edificios correspondientes.
// El cupo aumenta a metida que se crean unidades.
// Siempre debe cumplirse que cupo <= poblacion <= MAX_POBLACION.

public class JugadorProtoss implements Jugador {

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

    public void crearNexoMineral(Ubicacion unaUbicacion, NodoMineral unNodo) {
        this.edificios.add(new NexoMineral(unNodo, unaUbicacion, this));
    }

    public Pilon crearPilon(Ubicacion unaUbicacion) {
        Pilon pilon = new Pilon(unaUbicacion, this);
        this.edificios.add(pilon);
        return pilon;
    }

    public void crearAsimilador(Ubicacion unaUbicacion, Volcan unVolcan) {
        this.edificios.add(new Asimilador(unVolcan, unaUbicacion, this));
    }

    public void crearAcceso(Ubicacion unaUbicacion) {
        this.edificios.add(new Acceso(unaUbicacion, this));
    }

    public void crearPuertoEstelar(Ubicacion unaUbicacion) {
        this.edificios.add(new PuertoEstelar(unaUbicacion, this));
    }

    // Falta enviar el mensaje al edificio Acceso que permite instanciar Zealot.
    public void crearZealot(Edificio unAcceso) {

        if (!this.haySuministroDisponible(SUMINISTRO_ZEALOT)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeZealots++;
        this.incrementarSuministro(SUMINISTRO_ZEALOT);
    }

    // Falta enviar el mensaje al edificio Acceso que permite instanciar Dragon.
    public void crearDragon(Edificio unAcceso) {
        if (!this.haySuministroDisponible(SUMINISTRO_DRAGON)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeDragones++;
        this.incrementarSuministro(SUMINISTRO_DRAGON);
    }

    // Falta enviar el mensaje al edificio PuertoEstelar que permite instanciar Scout.
    public void crearScout(Edificio unPuertoEstelar) {
        if (!this.haySuministroDisponible(SUMINISTRO_SCOUT)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeScouts++;
        this.incrementarSuministro(SUMINISTRO_SCOUT);
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
    /*public int calcularSuministro() {
        int cupo = 0;

        for (Unidad unidad : this.unidades) {
            cupo += unidad.obtenerSuministro();
        }

        return cupo;
    }*/

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
}