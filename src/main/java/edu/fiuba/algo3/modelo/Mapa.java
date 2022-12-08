package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Areas.AreaEspacial;
import edu.fiuba.algo3.modelo.Areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.Areas.Base;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBasesException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;

import java.util.ArrayList;

public class Mapa {

    static final int cantidadDeJugadores = 2;

    private int cantidadDeBases;

    private Base baseJugadorUno, baseJugadorDos;

    private int baseJugadorUnoPosicionX, baseJugadorUnoPosicionY, baseJugadorDosPosicionX, baseJugadorDosPosicionY;
    
    private Moho moho;
    private ArrayList<Pilon> pilones;
    private ArrayList<Volcan> volcanes;
    private ArrayList<NodoMineral> nodosMinerales;

    private ArrayList<Base> bases;

    private ArrayList<AreaTerrestre> areasTerrestres;

    private ArrayList<AreaEspacial> areasEspaciales;

    public Mapa(int unaCantidadDeBases) {
        if (unaCantidadDeBases < cantidadDeJugadores) {
            throw new CantidadInsuficienteDeBasesException();
        }

        this.cantidadDeBases = unaCantidadDeBases;
        this.bases = new ArrayList<Base>();
        this.areasTerrestres = new ArrayList<AreaTerrestre>();
        this.areasEspaciales = new ArrayList<AreaEspacial>();
        
        this.moho = new Moho();
        this.pilones = new ArrayList<Pilon>();
        this.volcanes = new ArrayList<Volcan>();
        this.nodosMinerales = new ArrayList<NodoMineral>();

        this.baseJugadorUnoPosicionX = 0;
        this.baseJugadorUnoPosicionY = 0;
        this.baseJugadorDosPosicionX = unaCantidadDeBases - 1;
        this.baseJugadorDosPosicionY = unaCantidadDeBases - 1;

        this.crearAreas();
    }

    private void crearAreas() {
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
    }
    
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
	   this.moho.agregarOrigen(unaUbicacion);
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
}