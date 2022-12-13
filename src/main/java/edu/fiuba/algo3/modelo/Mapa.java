package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.SinEdificioBuscadoError;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

public class Mapa {

	private static int ANCHO = 1000;
	private static int ALTURA = 500;

    private Moho moho;
    private ArrayList<Pilon> pilones;
    private ArrayList<Volcan> volcanes;
    private ArrayList<NodoMineral> nodosMinerales;
	private ArrayList<Edificio> edificios;
	private ArrayList<Unidad> unidades;

    //private ArrayList<AreaTerrestre> areasTerrestres;

    private ArrayList<Ubicacion> areasEspaciales;

    public Mapa() {
        this.moho = new Moho();
        this.pilones = new ArrayList<Pilon>();
        this.volcanes = new ArrayList<Volcan>();
        this.nodosMinerales = new ArrayList<NodoMineral>();
        this.edificios = new ArrayList<Edificio>();
		this.unidades = new ArrayList<Unidad>();
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

	public ArrayList<Unidad> unidades() {
		return this.unidades;
	}

	public ArrayList<Ubicacion> areasEspaciales() {
		return this.areasEspaciales;
	}

    public void crearBases() {
    	// Primer base creada manualmente
    	this.agregarVolcan(new Ubicacion(35,23)); // radio de 25 en x / radio de 13 en y
    	this.agregarNodoMineral(new Ubicacion(80,23));
    	this.agregarNodoMineral(new Ubicacion(35,57));
    	this.agregarNodoMineral(new Ubicacion(80,57));

		// Segunda base creada manualmente
		this.agregarVolcan(new Ubicacion(965,477)); // radio de 25 en x / radio de 13 en y
		this.agregarNodoMineral(new Ubicacion(965,444));
		this.agregarNodoMineral(new Ubicacion(920,477));
		this.agregarNodoMineral(new Ubicacion(920,444));
    }
    
    public void crearAreas() {
    	// Areas espaciales creadas manualmente
    	for(int i = 250; i < 750; i++) {
    		for(int j = 125; j < 375; j++) {
    			this.areasEspaciales.add(new Ubicacion(i,j));
    		}
    	}
    }
    
    public boolean ubicacionEstaDentroDeMapa(Ubicacion unaUbicacion) {
    	return( (unaUbicacion.xDentroDeRango(0, ANCHO)) &&
    			(unaUbicacion.yDentroDeRango(0, ALTURA)) );
    }

    public boolean verificarEdificioEnUbicacion(String unEdificio, Ubicacion unaUbicacion) {
    	boolean verificado = false;

    	for(Edificio edificio: this.edificios) {
    		if(edificio.esUn(unEdificio)) {
    			verificado = edificio.estaEn(unaUbicacion);
			}
		}

    	return verificado;
	}

	public Edificio obtenerEdificioEnUbicacion(String unEdificio, Ubicacion unaUbicacion) {

		for(Edificio edificio: this.edificios) {
			if((edificio.esUn(unEdificio)) && (edificio.estaEn(unaUbicacion))) {
				return edificio;
			}
		}

		return null;
	}

	public boolean verificarUnidadEnUbicacion(Ubicacion unaUbicacion) {
		boolean verificado = false;

		for(Unidad unidad: this.unidades) {
			verificado = unidad.estaEn(unaUbicacion);
		}

		return verificado;
	}

	public Unidad obtenerUnidadEnUbicacion(Ubicacion unaUbicacion) {

		for(Unidad unidad: this.unidades) {
			if(unidad.estaEn(unaUbicacion)) {
				return unidad;
			}
		}

		return null;
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
   
   public void destruirEdificio(Edificio unEdificio) {
	   this.edificios.remove(unEdificio);
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

	public void agregarUnidad(Unidad unaUnidad) {
		this.unidades.add(unaUnidad);
	}

	public void destruirUnidad(Unidad unaUnidad) {
		this.edificios.remove(unaUnidad);
	}
   
   public void avanzarTurno() {
	   	this.energizarEdificios();
	   	this.moho.avanzarTurno(this.edificios);
   }
   
   public boolean verificarQueUnidadPuedeMoverseAUbicacion(Unidad unaUnidad,Ubicacion unaUbicacion) {
	   return (this.ubicacionEstaDentroDeMapa(unaUbicacion) && 
			   this.verificarSuperficieParaUnidadEnUbicacion(unaUnidad,unaUbicacion));
   }
   
   public boolean verificarSuperficieParaUnidadEnUbicacion(Unidad unaUnidad, Ubicacion unaUbicacion) {
	   String superficie = this.obtenerSuperficieDeLaUbicacion(unaUbicacion);
	   return (unaUnidad.compararSuperficie(superficie));
   }
   
   public String obtenerSuperficieDeLaUbicacion(Ubicacion unaUbicacion) {
	   String superficie = "Tierra";
	   for(Ubicacion actual: this.areasEspaciales) {
		   if(actual.esIgualA(unaUbicacion)) {
			   superficie = "Aire";
		   }
	   }
	   return superficie;
   }
}
