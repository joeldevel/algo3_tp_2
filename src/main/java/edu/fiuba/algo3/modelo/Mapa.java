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

	private static int TAMANIO = 100;

    private Moho moho;
    private ArrayList<Pilon> pilones;
    private ArrayList<Volcan> volcanes;
    private ArrayList<NodoMineral> nodosMinerales;
    private ArrayList<Edificio> edificios;

    private ArrayList<AreaTerrestre> areasTerrestres;

    private ArrayList<AreaEspacial> areasEspaciales;

    public Mapa() {
        this.moho = new Moho();
        this.pilones = new ArrayList<Pilon>();
        this.volcanes = new ArrayList<Volcan>();
        this.nodosMinerales = new ArrayList<NodoMineral>();
        this.edificios = new ArrayList<Edificio>();

        this.areasTerrestres = new ArrayList<AreaTerrestre>();
        this.areasEspaciales = new ArrayList<AreaEspacial>();
        
        this.crearBases();
        
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
    
    public boolean ubicacionEstaDentroDeMapa(Ubicacion unaUbicacion) {
    	return( (unaUbicacion.xDentroDeRango(0,this.TAMANIO)) && (unaUbicacion.yDentroDeRango(0,this.TAMANIO)) );
    }
    
    /*private void crearAreas() {
        int i;

        for (i = 0; i < this.cantidadDeBases; ++i) {
            this.bases.add(new Base(i, i));

            if (i < (this.cantidadDeBases - 1)) {
                this.areasTerrestres.add(new AreaTerrestre(i, i + 1));
                this.areasEspaciales.add(new AreaEspacial(i + 1, i));
            }
        }

        this.baseJugadorUno = this.bases.get(0);
        this.baseJugadorDos = this.bases.get(i - 1);
    }

    public boolean basesEstanEnExtremosOpuestos() {
        if ((this.baseJugadorUno.obtenerX() == baseJugadorUnoPosicionX) && (this.baseJugadorUno.obtenerY() == baseJugadorUnoPosicionY) && (this.baseJugadorDos.obtenerX() == baseJugadorDosPosicionX) && (this.baseJugadorDos.obtenerY() == baseJugadorDosPosicionY)) {
            return true;
        }

        return false;
    }

    public boolean existeUbicacionEn(int x, int y) {
        boolean existencia = false;

        for (Base base : bases) {
            if (base.obtenerX() == x && base.obtenerY() == y) {
                existencia = true;
            }
        }

        for (AreaEspacial areaEspacial : areasEspaciales) {
            if (areaEspacial.obtenerX() == x && areaEspacial.obtenerY() == y) {
                existencia = true;
            }
        }

        for (AreaTerrestre areaTerrestre : areasTerrestres) {
            if (areaTerrestre.obtenerX() == x && areaTerrestre.obtenerY() == y) {
                existencia = true;
            }
        }

        return existencia;
    }

    public void ocuparUbicacion(Ubicacion unaUbicacion) {
        for (Base base : bases) {
            if (base.obtenerX() == unaUbicacion.obtenerX() && base.obtenerY() == unaUbicacion.obtenerX()) {
                base.ocupar();
            }
        }

        for (AreaEspacial areaEspacial : areasEspaciales) {
            if (areaEspacial.obtenerX() == unaUbicacion.obtenerX() && areaEspacial.obtenerY() == unaUbicacion.obtenerX()) {
                areaEspacial.ocupar();
            }
        }

        for (AreaTerrestre areaTerrestre : areasTerrestres) {
            if (areaTerrestre.obtenerX() == unaUbicacion.obtenerX() && areaTerrestre.obtenerY() == unaUbicacion.obtenerX()) {
                areaTerrestre.ocupar();
            }
        }
    }

    // Refactorizar el código repetido.
    public void desocuparUbicacion(Ubicacion unaUbicacion) {
        for (Base base : bases) {
            if (base.obtenerX() == unaUbicacion.obtenerX() && base.obtenerY() == unaUbicacion.obtenerX()) {
                base.desocupar();
            }
        }

        for (AreaEspacial areaEspacial : areasEspaciales) {
            if (areaEspacial.obtenerX() == unaUbicacion.obtenerX() && areaEspacial.obtenerY() == unaUbicacion.obtenerX()) {
                areaEspacial.desocupar();
            }
        }

        for (AreaTerrestre areaTerrestre : areasTerrestres) {
            if (areaTerrestre.obtenerX() == unaUbicacion.obtenerX() && areaTerrestre.obtenerY() == unaUbicacion.obtenerX()) {
                areaTerrestre.desocupar();
            }
        }
    }

    public boolean ubicacionOcupadaEn(int x, int y) {
        if (!existeUbicacionEn(x, y)) {
            return false;
        }

        boolean ocupada = false;

        for (Base base : bases) {
            if (base.obtenerX() == x && base.obtenerY() == y) {
                ocupada = base.estaOcupada();
            }
        }

        for (AreaEspacial areaEspacial : areasEspaciales) {
            if (areaEspacial.obtenerX() == x && areaEspacial.obtenerY() == y) {
                ocupada = areaEspacial.estaOcupada();
            }
        }

        for (AreaTerrestre areaTerrestre : areasTerrestres) {
            if (areaTerrestre.obtenerX() == x && areaTerrestre.obtenerY() == y) {
                ocupada = areaTerrestre.estaOcupada();
            }
        }

        return ocupada;
    }*/
    
    public boolean verificarUbicacionLibre(Ubicacion unaUbicacion, Jugador unJugador, Jugador otroJugador) {
    	return (!unJugador.tieneEdificioEnUbicacion(unaUbicacion) && 
    			!otroJugador.tieneEdificioEnUbicacion(unaUbicacion));
    }
    
   public boolean verificarConstruccionZerg(Ubicacion unaUbicacion, JugadorZerg jugadorZerg, JugadorProtoss jugadorProtoss) {
	   return ( (!(this.estaAfectadaPorPilonLaUbicacion(unaUbicacion))) && 
				(moho.estaAfectadaLaUbicacion(unaUbicacion)) );
   }
   
   public boolean verificarConstruccionProtoss(Ubicacion unaUbicacion,JugadorZerg jugadorZerg,JugadorProtoss jugadorProtoss) {
	   return ( (this.estaAfectadaPorPilonLaUbicacion(unaUbicacion)) && 
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
}
