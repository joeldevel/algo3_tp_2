package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;

public class FabricaDeEdificios {
	
	public static void construir(String unEdificio, Ubicacion unaUbicacion, Jugador jugadorZerg, 
								 Jugador jugadorProtoss, Mapa unMapa) {
		
		if(unMapa.verificarUbicacionLibre(unaUbicacion)) {

			if((unEdificio == "Criadero") && !(unMapa.estaAfectadaPorPilonLaUbicacion(unaUbicacion))) {
				
				Criadero criadero = new Criadero(unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(criadero);
				unMapa.agregarEdificio(criadero);
				unMapa.agregarOrigenAMoho(unaUbicacion);
			}
			if((unEdificio == "Extractor") && (unMapa.verificarConstruccionZerg(unaUbicacion)) && 
			   (unMapa.verificarVolcanEnUbicacion(unaUbicacion))){
				
				Extractor extractor = new Extractor(unMapa.volcanEnUbicacion(unaUbicacion), unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(extractor);
				unMapa.agregarEdificio(extractor);
			}
			if((unEdificio == "ReservaDeReproduccion") && (unMapa.verificarConstruccionZerg(unaUbicacion))) {
				
				ReservaDeReproduccion reserva = new ReservaDeReproduccion(unaUbicacion,jugadorZerg); 
				jugadorZerg.agregarEdificio(reserva);
				unMapa.agregarEdificio(reserva);
			}
			if((unEdificio == "Guarida") && (unMapa.verificarConstruccionZerg(unaUbicacion)) && 
			   (jugadorZerg.verificarEdificio("ReservaDeReproduccion"))) {
				
				Guarida guarida = new Guarida(unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(guarida);
				unMapa.agregarEdificio(guarida);
			}
			if((unEdificio == "Espiral") && (unMapa.verificarConstruccionZerg(unaUbicacion)) && 
			   (jugadorZerg.verificarEdificio("Guarida"))) {
				
				Espiral espiral = new Espiral(unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(espiral);
				unMapa.agregarEdificio(espiral);
			}
			if((unEdificio == "NexoMineral") && (unMapa.verificarConstruccionProtoss(unaUbicacion)) && 
			   (unMapa.verificarNodoMineralEnUbicacion(unaUbicacion))){
				
				NexoMineral nexo = new NexoMineral(unMapa.nodoEnUbicacion(unaUbicacion),unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(nexo);
				unMapa.agregarEdificio(nexo);
			}
			if((unEdificio == "Pilon") && (!(unMapa.verificarUbicacionAfectadaPorMoho(unaUbicacion)))) {
				
				Pilon pilon = new Pilon(unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(pilon);
				unMapa.agregarEdificio(pilon);
				unMapa.agregarPilon(pilon);
			}
			if((unEdificio == "Asimilador") && (unMapa.verificarVolcanEnUbicacion(unaUbicacion) && (unMapa.verificarConstruccionProtoss(unaUbicacion)))) {
				
				Asimilador asimilador = new Asimilador(unMapa.volcanEnUbicacion(unaUbicacion),unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(asimilador);
				unMapa.agregarEdificio(asimilador);
			}
			if((unEdificio == "Acceso") && (unMapa.verificarConstruccionProtoss(unaUbicacion))) {
				
				Acceso acceso = new Acceso(unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(acceso);
				unMapa.agregarEdificio(acceso);
				unMapa.agregarAPilones(unaUbicacion,acceso);
			}
			if((unEdificio == "PuertoEstelar") && (unMapa.verificarConstruccionProtoss(unaUbicacion)) && 
			   (jugadorProtoss.verificarEdificio("Acceso"))) {
				
				PuertoEstelar puertoEstelar = new PuertoEstelar(unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(puertoEstelar);
				unMapa.agregarEdificio(puertoEstelar);
				unMapa.agregarAPilones(unaUbicacion,puertoEstelar);
			}
			
		}
		
	}
	
		
	
}
