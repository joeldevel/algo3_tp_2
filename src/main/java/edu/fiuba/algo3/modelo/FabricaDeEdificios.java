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
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeProduccion;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;

public class FabricaDeEdificios {
	
	public static void construir(String unEdificio, Ubicacion unaUbicacion, JugadorZerg jugadorZerg, 
								 JugadorProtoss jugadorProtoss, Mapa unMapa) {
		
		if(unMapa.verificarUbicacionLibre(unaUbicacion, jugadorZerg, jugadorProtoss)) {

			if((unEdificio == "Criadero") && !(unMapa.estaAfectadaPorPilonLaUbicacion(unaUbicacion))) {
				
				Criadero criadero = new Criadero(unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(criadero);
				unMapa.agregarOrigenAMoho(unaUbicacion);
			}
			if((unEdificio == "Extractor") && (unMapa.verificarConstruccionZerg(unaUbicacion, jugadorZerg, jugadorProtoss)) && 
			   (unMapa.verificarVolcanEnUbicacion(unaUbicacion))){
				
				jugadorZerg.agregarEdificio(new Extractor(unMapa.volcanEnUbicacion(unaUbicacion), unaUbicacion,jugadorZerg));
			}
			if((unEdificio == "ReservaDeProduccion") && (unMapa.verificarConstruccionZerg(unaUbicacion, jugadorZerg, jugadorProtoss))) {
				
				jugadorZerg.agregarEdificio(new ReservaDeProduccion(unaUbicacion,jugadorZerg));
			}
			if((unEdificio == "Guarida") && (unMapa.verificarConstruccionZerg(unaUbicacion,jugadorZerg,jugadorProtoss)) && 
			   (jugadorZerg.verificarEdificio("ReservaDeProduccion"))) {
				
				jugadorZerg.agregarEdificio(new Guarida(unaUbicacion,jugadorZerg));
			}
			if((unEdificio == "Espiral") && (unMapa.verificarConstruccionZerg(unaUbicacion, jugadorZerg, jugadorProtoss)) && 
			   (jugadorZerg.verificarEdificio("Guarida"))) {
				
				jugadorZerg.agregarEdificio(new Espiral(unaUbicacion,jugadorZerg));
			}
			if((unEdificio == "NexoMineral") && (unMapa.verificarConstruccionProtoss(unaUbicacion,jugadorZerg,jugadorProtoss)) && 
			   (unMapa.verificarNodoMineralEnUbicacion(unaUbicacion))){
				
				jugadorProtoss.agregarEdificio(new NexoMineral(unMapa.nodoEnUbicacion(unaUbicacion),unaUbicacion,jugadorProtoss));
			}
			if((unEdificio == "Pilon") && (!(unMapa.verificarUbicacionAfectadaPorMoho(unaUbicacion)))) {
				
				Pilon pilon = new Pilon(unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(pilon);
				unMapa.agregarPilon(pilon);
			}
			if((unEdificio == "Asimilador") && (unMapa.verificarConstruccionProtoss(unaUbicacion,jugadorZerg,jugadorProtoss)) && 
			   (unMapa.verificarVolcanEnUbicacion(unaUbicacion))) {
				
				jugadorProtoss.agregarEdificio(new Asimilador(unMapa.volcanEnUbicacion(unaUbicacion),unaUbicacion,jugadorProtoss));
			}
			if((unEdificio == "Acceso") && (unMapa.verificarConstruccionProtoss(unaUbicacion,jugadorZerg,jugadorProtoss))) {
				
				jugadorProtoss.agregarEdificio(new Acceso(unaUbicacion,jugadorProtoss));
			}
			if((unEdificio == "PuertoEstelar") && (unMapa.verificarConstruccionProtoss(unaUbicacion,jugadorZerg,jugadorProtoss)) && 
			   (jugadorProtoss.verificarEdificio("Acceso"))) {
				
				jugadorProtoss.agregarEdificio(new PuertoEstelar(unaUbicacion,jugadorProtoss));
			}
			
		}
		
	}
	
		
	
}
