package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Areas.AreaEspacial;
import edu.fiuba.algo3.modelo.Areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.Areas.Base;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBasesException;
import edu.fiuba.algo3.modelo.Excepciones.SinEdificioBuscadoError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;

import java.util.ArrayList;

public class Mapa {

	private static int TAMANIO_HORIZONTAL = 100;
	private static int TAMANIO_VERTICAL = 100;

    private Moho moho;
    private ArrayList<Pilon> pilones;
    private ArrayList<Volcan> volcanes;
    private ArrayList<NodoMineral> nodosMinerales;
    private ArrayList<Edificio> edificios;

    //private ArrayList<AreaTerrestre> areasTerrestres;

    private ArrayList<Ubicacion> areasEspaciales;

    public Mapa() {
        this.moho = new Moho();
        this.pilones = new ArrayList<Pilon>();
        this.volcanes = new ArrayList<Volcan>();
        this.nodosMinerales = new ArrayList<NodoMineral>();
        this.edificios = new ArrayList<Edificio>();
        this.areasEspaciales = new ArrayList<Ubicacion>();
        
        this.crearBases();
        this.crearAreas();
    }

	public ArrayList<Ubicacion> ubicacionesConMoho() {
		return this.moho.ubicacionesConMoho();
	}

    public ArrayList<Volcan> volcanes() {
    	return this.volcanes;
	}

	public ArrayList<NodoMineral> nodosMinerales() {
		return this.nodosMinerales;
	}

	public ArrayList<Edificio> edificios() {
		return this.edificios;
	}

    public void crearBases() {
    	/* se crean bases manualmente */
    	this.agregarVolcan(new Ubicacion(10,10));
    	this.agregarVolcan(new Ubicacion(90,90));
    	this.agregarNodoMineral(new Ubicacion(10,20));
    	this.agregarNodoMineral(new Ubicacion(20,10));
    	this.agregarNodoMineral(new Ubicacion(20,20));
    	this.agregarNodoMineral(new Ubicacion(90,80));
    	this.agregarNodoMineral(new Ubicacion(80,80));
    	this.agregarNodoMineral(new Ubicacion(80,90));
    }
    
    public void crearAreas() {
    	/* se crean las areas manualmente*/
    	for(int i= 40; i<60; i++) {
    		for(int j= 40; j<60; j++) {
    			this.areasEspaciales.add(new Ubicacion(i,j));
    		}
    	}
    }
    
    public boolean ubicacionEstaDentroDeMapa(Ubicacion unaUbicacion) {
    	return( (unaUbicacion.xDentroDeRango(0,this.TAMANIO_HORIZONTAL)) && 
    			(unaUbicacion.yDentroDeRango(0,this.TAMANIO_VERTICAL)) );
    }
    
    public boolean verificarAreaEspacial(Ubicacion ubicacion) {
    	boolean verificado = false;
    	for(Ubicacion actual: this.areasEspaciales) {
    		if(actual.esIgualA(ubicacion)) {
    			verificado = true;
    		}
    	}

    	return verificado;
    }
    
    public boolean verificarUbicacionLibre(Ubicacion unaUbicacion) {
    	boolean verificado = true;
    	for(Edificio actual: this.edificios) {
    		if(actual.estaEn(unaUbicacion)) {
    			verificado = false;
    		}
    	}
    	return verificado;
    }
    
   public boolean verificarConstruccionZerg(Ubicacion unaUbicacion) {
	   return ( (!(this.verificarAreaEspacial(unaUbicacion))) && (!(this.estaAfectadaPorPilonLaUbicacion(unaUbicacion))) &&
				(moho.estaAfectadaLaUbicacion(unaUbicacion)) );
   }
   
   public boolean verificarConstruccionProtoss(Ubicacion unaUbicacion) {
	   return ( (!(this.verificarAreaEspacial(unaUbicacion))) && (this.estaAfectadaPorPilonLaUbicacion(unaUbicacion)) &&
				(!(moho.estaAfectadaLaUbicacion(unaUbicacion))) );
   }
   
   public boolean estaAfectadaPorPilonLaUbicacion(Ubicacion unaUbicacion) {
		boolean verificado = false;
		for(Pilon actual: pilones) {
			if(actual.laUbicacionEstaEnElRangoDeConstruccion(unaUbicacion)) {
				verificado = true;
			}
		}
		return verificado;
	}
   
   public boolean verificarVolcanEnUbicacion(Ubicacion unaUbicacion) {
	   boolean verificado = false;
	   for(Volcan actual: this.volcanes) {
		   if(actual.estaEn(unaUbicacion)) {
			   verificado = true;
		   }
	   }
	   return verificado;
   }
   
   public Volcan volcanEnUbicacion(Ubicacion unaUbicacion) {
	   Volcan buscado = null;
	   for(Volcan actual: this.volcanes) {
		   if(actual.estaEn(unaUbicacion)) {
			   buscado = actual;
		   }
	   }
	   return buscado;
   }
   
   public boolean verificarNodoMineralEnUbicacion(Ubicacion unaUbicacion) {
	   boolean verificado = false;
	   for(NodoMineral actual: this.nodosMinerales) {
		   if(actual.estaEn(unaUbicacion)) {
			   verificado = true;
		   }
	   }
	   return verificado;
   }
   
   public NodoMineral nodoEnUbicacion(Ubicacion unaUbicacion) {
	   NodoMineral buscado = null;
	   for(NodoMineral actual: this.nodosMinerales) {
		   if(actual.estaEn(unaUbicacion)) {
			   buscado = actual;
		   }
	   }
	   return buscado;
   }
   
   public boolean verificarUbicacionAfectadaPorMoho(Ubicacion unaUbicacion) {
	   return (this.moho.estaAfectadaLaUbicacion(unaUbicacion));
   }
   
   public void agregarOrigenAMoho(Ubicacion unaUbicacion) {
	   this.moho.agregarOrigen(unaUbicacion,this.edificios);
   }
   
   public void agregarPilon(Pilon unPilon) {
	   this.pilones.add(unPilon);
   }
   
   public void agregarVolcan(Ubicacion unaUbicacion) {
	   if(!(this.verificarVolcanEnUbicacion(unaUbicacion))) {
		   this.volcanes.add(new Volcan(unaUbicacion));
	   }
   }
   
   public void agregarNodoMineral(Ubicacion unaUbicacion) {
	   if(!(this.verificarNodoMineralEnUbicacion(unaUbicacion))) {
		   this.nodosMinerales.add(new NodoMineral(unaUbicacion));
	   }
   }
   
   public void agregarAPilones(Ubicacion unaUbicacion, EdificioProtoss edificio) {
	   for(Pilon actual: this.pilones) {
		   if(actual.laUbicacionEstaEnElRangoDeConstruccion(unaUbicacion)) {
			   actual.agregarEdificio(edificio);
		   }
	   }
   }
   
   public void destruirPilonEn(Ubicacion unaUbicacion) {
	   Pilon pilon = this.obtenerPilonEn(unaUbicacion);
	   this.pilones.remove(pilon);
   }
   
   public Pilon obtenerPilonEn(Ubicacion unaUbicacion) {
	   Pilon pilon = null;
	   for(Pilon actual: this.pilones) {
		   if(actual.estaEn(unaUbicacion)) {
			   pilon = actual;
		   }
	   }
	   if(pilon == null) {
		   throw new SinEdificioBuscadoError();
	   }
	   return pilon;
   }
   
   public void energizarEdificios() {
	   for(Pilon actual: this.pilones) {
		   actual.energizarEdificios();
	   }
   }
   
   public void destruirOrigenDeMoho(Ubicacion unaUbicacion) {
	   this.moho.destruirOrigenEn(unaUbicacion);
   }
   
   public void agregarEdificio(Edificio unEdificio) {
	   this.edificios.add(unEdificio);
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
   
   public void avanzarTurno() {
	   	this.energizarEdificios();
	   	this.moho.avanzarTurno(this.edificios);
   }
}
