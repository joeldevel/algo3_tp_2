package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.SinEdificioBuscadoError;
import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Excepciones.UbicacionSinEdificioException;
import edu.fiuba.algo3.modelo.FabricaDeEdificios;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.SUMINISTRO_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Devorador.SUMINISTRO_DEVORADOR;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.SUMINISTRO_GUARDIAN;
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
    private int suministro;

    private int cantidadDeAmos;
    private int cantidadDeZanganos;
    private int cantidadDeZerlings;
    private int cantidadDeHidraliscos;
    private int cantidadDeMutaliscos;
    private int cantidadDeGuardianes;
    private int cantidadDeDevoradores;

    private ArrayList<Edificio> edificios;
    private ArrayList<Unidad> unidades;

    public JugadorZerg(String unNombre, String unColor) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = new Recursos();
        this.recursos.guardar(0, CANT_MINERAL_INICIAL);
        this.suministro = 0;

        this.cantidadDeAmos = 0;
        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
        this.cantidadDeGuardianes = 0;
        this.cantidadDeDevoradores = 0;

        this.edificios = new ArrayList<Edificio>();
        this.unidades = new ArrayList<Unidad>();
    }

    // Constructor utilizado unicamente para pruebas debido a los recursos.
    public JugadorZerg(String unNombre, String unColor, Recursos unosRecursos) {
        this.nombre = unNombre;
        this.color = unColor;
        this.recursos = unosRecursos;
        this.suministro = 0;

        this.cantidadDeAmos = 0;
        this.cantidadDeZanganos = 0;
        this.cantidadDeZerlings = 0;
        this.cantidadDeHidraliscos = 0;
        this.cantidadDeMutaliscos = 0;
        this.cantidadDeGuardianes = 0;
        this.cantidadDeDevoradores = 0;

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
    
    public void construir(String edificio,Ubicacion unaUbicacion,Jugador jugadorProtoss,Mapa mapa) {
    	FabricaDeEdificios.construir(edificio, unaUbicacion, this, jugadorProtoss, mapa);
    }

    public Unidad crearAmoSupremo(Ubicacion unaUbicacion) {

        if (!this.haySuministroDisponible(SUMINISTRO_AMO)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        AmoSupremo tipoAmoSupremo = new AmoSupremo(unaUbicacion, this);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), unaUbicacion, tipoAmoSupremo);
        this.unidades.add(amoSupremo);

        this.cantidadDeAmos++;
        this.incrementarSuministro(SUMINISTRO_AMO);

        return amoSupremo;
    }

    public void crearZangano(Ubicacion unaUbicacion, Mapa unMapa) {

        if (!this.haySuministroDisponible(SUMINISTRO_ZANGANO)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((unMapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (unMapa.verificarEdificioEnUbicacion("Criadero", unaUbicacion))) {
            Criadero criadero = (Criadero) unMapa.obtenerEdificioEnUbicacion("Criadero", unaUbicacion);
            criadero.crearZangano();
            this.unidades.addAll(criadero.obtenerZanganos());

            this.cantidadDeZanganos++;
            this.incrementarSuministro(SUMINISTRO_ZANGANO);
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }

    public void crearZerling(Ubicacion unaUbicacion, Mapa unMapa) {

        if (!this.haySuministroDisponible(SUMINISTRO_ZERLING)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((unMapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (unMapa.verificarEdificioEnUbicacion("ReservaDeReproduccion", unaUbicacion))) {
            ReservaDeReproduccion reserva = (ReservaDeReproduccion) unMapa.obtenerEdificioEnUbicacion("ReservaDeReproduccion", unaUbicacion);
            this.unidades.addAll(reserva.obtenerZerlings());

            this.cantidadDeZerlings++;
            this.incrementarSuministro(SUMINISTRO_ZERLING);
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }

    public ArrayList<Unidad> obtenerLarvas() {
        // Devolvemos las larvas del primer criadero que encontremos
        for(Edificio edificio: this.edificios) {
            if(edificio.esUn("Criadero")) {
                return edificio.devolverLarvas();
            }
        }

        return new ArrayList<Unidad>();
    }

    public void crearHidralisco(Ubicacion unaUbicacion, Mapa unMapa) {

        if (!this.haySuministroDisponible(SUMINISTRO_HIDRALISCO)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        if((unMapa.ubicacionEstaDentroDeMapa(unaUbicacion)) && (unMapa.verificarEdificioEnUbicacion("Guarida", unaUbicacion))) {
            Guarida guarida = (Guarida) unMapa.obtenerEdificioEnUbicacion("Guarida", unaUbicacion);
            this.unidades.addAll(guarida.obtenerHidraliscos());

            this.cantidadDeHidraliscos++;
            this.incrementarSuministro(SUMINISTRO_HIDRALISCO);
        }

        else {
            throw new UbicacionSinEdificioException();
        }
    }

    // Falta enviar el mensaje al edificio Espiral que permite instanciar Mutalisco.
    public void crearMutalisco(Edificio unaEspiral) {

        if (!this.haySuministroDisponible(SUMINISTRO_MUTALISCO)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeMutaliscos++;
        this.incrementarSuministro(SUMINISTRO_MUTALISCO);
    }

    // Falta enviar el mensaje que permite instanciar Guardian (evolucion de Mutalisco).
    public void evolucionarMutaliscoAGuardian(Unidad unMutalisco) {

        if (!this.haySuministroDisponible(SUMINISTRO_GUARDIAN)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeGuardianes++;
        this.incrementarSuministro(SUMINISTRO_GUARDIAN);
    }

    // Falta enviar el mensaje que permite instanciar Devorador (evolucion de Mutalisco).
    public void evolucionarMutaliscoADevorador(Unidad unMutalisco) {

        if (!this.haySuministroDisponible(SUMINISTRO_DEVORADOR)) {
            throw new SuministroSuperaElNumeroDePoblacionException();
        }

        this.cantidadDeDevoradores++;
        this.incrementarSuministro(SUMINISTRO_DEVORADOR);
    }

    public int cantidadDeUnidades(UNIDADES_ZERG tipoUnidad) {
        if (tipoUnidad == UNIDADES_ZERG.ZANGANO) {
            return this.cantidadDeZanganos;
        }
        if (tipoUnidad == UNIDADES_ZERG.ZERLING) {
            return this.cantidadDeZerlings;
        }
        if (tipoUnidad == UNIDADES_ZERG.HIDRALISCO) {
            return this.cantidadDeHidraliscos;
        }
        if (tipoUnidad == UNIDADES_ZERG.MUTALISCO) {
            return this.cantidadDeMutaliscos;
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
}