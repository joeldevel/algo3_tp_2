package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.SinEdificioBuscadoException;
import edu.fiuba.algo3.modelo.Excepciones.SinUnidadBuscadaException;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import java.util.ArrayList;

public class Mapa {

	private static int ANCHO = 28;
	private static int ALTURA = 14;

    private Moho moho;
    private ArrayList<Pilon> pilones;
    private ArrayList<Volcan> volcanes;
    private ArrayList<NodoMineral> nodosMinerales;
	private ArrayList<Edificio> edificios;
	private ArrayList<Unidad> unidades;
	private ArrayList<Unidad> amosSupremos;
    private ArrayList<Ubicacion> areasEspaciales;

    public Mapa() {
        this.moho = new Moho();
        this.pilones = new ArrayList<Pilon>();
        this.volcanes = new ArrayList<Volcan>();
        this.nodosMinerales = new ArrayList<NodoMineral>();
        this.edificios = new ArrayList<Edificio>();
		this.unidades = new ArrayList<Unidad>();
		this.amosSupremos = new ArrayList<Unidad>();
        this.areasEspaciales = new ArrayList<Ubicacion>();
        
        this.crearBases();
        this.crearAreas();
        this.moho.agregarUbicacionesInafectables(this.areasEspaciales);
    }

	public ArrayList<Ubicacion> getUbicacionesConMoho() {
		return this.moho.ubicacionesConMoho();
	}

    public ArrayList<Volcan> getVolcanes() {
    	return this.volcanes;
	}

	public ArrayList<NodoMineral> getNodosMinerales() {
		return this.nodosMinerales;
	}

	public ArrayList<Edificio> getEdificios() {
		return this.edificios;
	}

	public ArrayList<Unidad> getUnidades() {
		return this.unidades;
	}

	public ArrayList<Ubicacion> getAreasEspaciales() {
		return this.areasEspaciales;
	}

    public void crearBases() {
    	// Primer base creada manualmente
		this.agregarVolcan(new Ubicacion(0,0));
		this.agregarNodoMineral(new Ubicacion(1,1));
		this.agregarNodoMineral(new Ubicacion(0,1));
		this.agregarNodoMineral(new Ubicacion(1,0));

		// Segunda base creada manualmente
		this.agregarVolcan(new Ubicacion(27,13));
		this.agregarNodoMineral(new Ubicacion(26,12));
		this.agregarNodoMineral(new Ubicacion(27,12));
		this.agregarNodoMineral(new Ubicacion(26,13));
    }
    
    public void crearAreas() {
    	// Areas espaciales creadas manualmente
    	for(int i = 8; i < 20; i++) {
    		for(int j = 4; j < 10; j++) {
    			this.areasEspaciales.add(new Ubicacion(i,j));
    		}
    	}
    }
    
    public boolean ubicacionEstaDentroDeMapa(Ubicacion unaUbicacion) {
    	return( (unaUbicacion.xDentroDeRango(0, ANCHO-1)) &&
    			(unaUbicacion.yDentroDeRango(0, ALTURA-1)) );
    }

	public boolean verificarUbicacionAfectadaPorMoho(Ubicacion unaUbicacion) {
		return (this.moho.estaAfectadaLaUbicacion(unaUbicacion));
	}

	public boolean verificarQueUnidadPuedeMoverseAUbicacion(Unidad unaUnidad,Ubicacion unaUbicacion) {
		return (this.ubicacionEstaDentroDeMapa(unaUbicacion) &&
				this.verificarUbicacionLibreDeUnidad(unaUbicacion) &&
				this.verificarSuperficieParaUnidadEnUbicacion(unaUnidad,unaUbicacion));
	}

	public boolean verificarUbicacionLibreDeUnidad(Ubicacion unaUbicacion) {
		boolean verificado = true;
		for(Unidad actual: this.unidades) {
			if(actual.estaEn(unaUbicacion)) {
				verificado = false;
			}
		}
		return verificado;
	}

	public boolean verificarSuperficieParaUnidadEnUbicacion(Unidad unaUnidad, Ubicacion unaUbicacion) {
		String superficie = this.obtenerSuperficieDeLaUbicacion(unaUbicacion);
		if(unaUnidad.compararSuperficie("Aire")) {
			return true;
		}
		return (unaUnidad.compararSuperficie(superficie));
	}

    public boolean verificarEdificioEnUbicacion(String unEdificio, Ubicacion unaUbicacion) {

    	for(Edificio edificio: this.edificios) {
    		if(edificio.esUn(unEdificio) && edificio.estaEn(unaUbicacion)) {
    			return true;
			}
		}

    	return false;
	}

	public boolean verificarEdificioEn(Ubicacion unaUbicacion) {

		for(Edificio edificio: this.edificios) {
			if(edificio.estaEn(unaUbicacion)) {
				return true;
			}
		}

		return false;
	}

	public boolean verificarUnidadEnUbicacion(Ubicacion unaUbicacion) {

		for(Unidad unidad: this.unidades) {
			if(unidad.estaEn(unaUbicacion)) {
				return true;
			}
		}

		return false;
	}

	public boolean verificarAreaEspacial(Ubicacion unaUbicacion) {
		boolean verificado = false;
		for(Ubicacion actual: this.areasEspaciales) {
			if(actual.esIgualA(unaUbicacion)) {
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

	public boolean verificarNodoMineralEnUbicacion(Ubicacion unaUbicacion) {
		boolean verificado = false;
		for(NodoMineral actual: this.nodosMinerales) {
			if(actual.estaEn(unaUbicacion)) {
				verificado = true;
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

	public Unidad obtenerUnidadEnUbicacion(Ubicacion unaUbicacion) {
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
   
   public Volcan obtenerVolcanEnUbicacion(Ubicacion unaUbicacion) {
	   Volcan buscado = null;
	   for(Volcan actual: this.volcanes) {
		   if(actual.estaEn(unaUbicacion)) {
			   buscado = actual;
		   }
	   }
	   return buscado;
   }
   
   public NodoMineral obtenerNodoEnUbicacion(Ubicacion unaUbicacion) {
	   NodoMineral buscado = null;
	   for(NodoMineral actual: this.nodosMinerales) {
		   if(actual.estaEn(unaUbicacion)) {
			   buscado = actual;
		   }
	   }
	   return buscado;
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

	public Pilon obtenerPilonEn(Ubicacion unaUbicacion) {
		Pilon pilon = null;
		for(Pilon actual: this.pilones) {
			if(actual.estaEn(unaUbicacion)) {
				pilon = actual;
			}
		}
		if(pilon == null) {
			throw new SinEdificioBuscadoException();
		}
		return pilon;
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

   	public void agregarEdificio(Edificio unEdificio) {
		this.edificios.add(unEdificio);
	}

	public void agregarUnidad(Unidad unaUnidad) {
		this.unidades.add(unaUnidad);
	}

	public void agregarAmoSupremo(Unidad unAmoSupremo) {
		this.amosSupremos.add(unAmoSupremo);
	}
   
   public void destruirPilonEn(Ubicacion unaUbicacion) {
	   Pilon pilon = this.obtenerPilonEn(unaUbicacion);
	   this.pilones.remove(pilon);
   }
   
   public void destruirOrigenDeMoho(Ubicacion unaUbicacion) {
	   this.moho.destruirOrigenEn(unaUbicacion);
   }
   
   public void destruirEdificio(Edificio unEdificio) {
	   this.edificios.remove(unEdificio);
   }

	public void destruirUnidad(Unidad unaUnidad) {
		this.amosSupremos.remove(unaUnidad);
		this.unidades.remove(unaUnidad);
	}

   public void avanzarTurno() {
	   	this.energizarEdificios();
	   	this.revelarUnidades();
	   	this.moho.avanzarTurno(this.edificios);
   }

	public void energizarEdificios() {
		for(Pilon actual: this.pilones) {
			actual.energizarEdificios();
		}
	}

   public void revelarUnidades() {

    	for(Unidad amo: this.amosSupremos) {
    		for(Unidad unidad: this.unidades) {
    			amo.revelar(unidad);
			}
		}
   }
}