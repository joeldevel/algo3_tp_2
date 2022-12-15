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
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.CONSTRUCCION_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.SUMINISTRO_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.SUMINISTRO_HIDRALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.SUMINISTRO_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.SUMINISTRO_ZANGANO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.SUMINISTRO_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.SUMINISTRO_SCOUT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.SUMINISTRO_ZEALOT;

public class Fabrica {
	
	public static void construir(String entidad, Ubicacion unaUbicacion, JugadorZerg jugadorZerg, 
								 JugadorProtoss jugadorProtoss, Mapa unMapa) {
		
		/* EDIFICIOS */
		
		if(unMapa.verificarUbicacionLibre(unaUbicacion)) {

			/* EDIFICIOS ZERG */
			
			if((entidad == "Criadero") && (!(unMapa.estaAfectadaPorPilonLaUbicacion(unaUbicacion)) && (!(unMapa.verificarAreaEspacial(unaUbicacion))))) {
				
				Criadero criadero = new Criadero(unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(criadero);
				unMapa.agregarEdificio(criadero);
				unMapa.agregarOrigenAMoho(unaUbicacion);
			}
			if((entidad == "Extractor") && (unMapa.verificarConstruccionZerg(unaUbicacion)) && 
			   (unMapa.verificarVolcanEnUbicacion(unaUbicacion))){
				
				Extractor extractor = new Extractor(unMapa.volcanEnUbicacion(unaUbicacion), unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(extractor);
				unMapa.agregarEdificio(extractor);
			}
			if((entidad == "ReservaDeReproduccion") && (unMapa.verificarConstruccionZerg(unaUbicacion))) {
				
				ReservaDeReproduccion reserva = new ReservaDeReproduccion(unaUbicacion,jugadorZerg); 
				jugadorZerg.agregarEdificio(reserva);
				unMapa.agregarEdificio(reserva);
			}
			if((entidad == "Guarida") && (unMapa.verificarConstruccionZerg(unaUbicacion)) && 
			   (jugadorZerg.verificarEdificio("ReservaDeReproduccion"))) {
				
				Guarida guarida = new Guarida(unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(guarida);
				unMapa.agregarEdificio(guarida);
			}
			if((entidad == "Espiral") && (unMapa.verificarConstruccionZerg(unaUbicacion)) && 
			   (jugadorZerg.verificarEdificio("Guarida"))) {
				
				Espiral espiral = new Espiral(unaUbicacion,jugadorZerg);
				jugadorZerg.agregarEdificio(espiral);
				unMapa.agregarEdificio(espiral);
			}
			
			/* EDIFICIOS PROTOSS */
			
			if((entidad == "NexoMineral") && (unMapa.verificarConstruccionProtoss(unaUbicacion)) && 
			   (unMapa.verificarNodoMineralEnUbicacion(unaUbicacion))){
				
				NexoMineral nexo = new NexoMineral(unMapa.nodoEnUbicacion(unaUbicacion),unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(nexo);
				unMapa.agregarEdificio(nexo);
			}
			if((entidad == "Pilon") && (!(unMapa.verificarUbicacionAfectadaPorMoho(unaUbicacion))) && (!(unMapa.verificarAreaEspacial(unaUbicacion)))) {
				
				Pilon pilon = new Pilon(unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(pilon);
				unMapa.agregarEdificio(pilon);
				unMapa.agregarPilon(pilon);
			}
			if((entidad == "Asimilador") && (unMapa.verificarVolcanEnUbicacion(unaUbicacion) && (unMapa.verificarConstruccionProtoss(unaUbicacion)))) {
				
				Asimilador asimilador = new Asimilador(unMapa.volcanEnUbicacion(unaUbicacion),unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(asimilador);
				unMapa.agregarEdificio(asimilador);
			}
			if((entidad == "Acceso") && (unMapa.verificarConstruccionProtoss(unaUbicacion))) {
				
				Acceso acceso = new Acceso(unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(acceso);
				unMapa.agregarEdificio(acceso);
				unMapa.agregarAPilones(unaUbicacion,acceso);
			}
			if((entidad == "PuertoEstelar") && (unMapa.verificarConstruccionProtoss(unaUbicacion)) && 
			   (jugadorProtoss.verificarEdificio("Acceso"))) {
				
				PuertoEstelar puertoEstelar = new PuertoEstelar(unaUbicacion,jugadorProtoss);
				jugadorProtoss.agregarEdificio(puertoEstelar);
				unMapa.agregarEdificio(puertoEstelar);
				unMapa.agregarAPilones(unaUbicacion,puertoEstelar);
			}
			
		}
		
		/* UNIDADES */
		
		if(unMapa.ubicacionEstaDentroDeMapa(unaUbicacion)) {
			
			/* UNIDADES ZERG */
			
			if((entidad == "AmoSupremo") && (jugadorZerg.haySuministroDisponible(SUMINISTRO_AMO))) {

				AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
				Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), unaUbicacion, tipoAmoSupremo);
				jugadorZerg.agregarUnidad(amoSupremo);
				unMapa.agregarUnidad(amoSupremo);
				unMapa.agregarAmoSupremo(amoSupremo);
			}
			
			if((entidad == "Zangano") && (jugadorZerg.haySuministroDisponible(SUMINISTRO_ZANGANO)) && 
			   (unMapa.verificarEdificioEnUbicacion("Criadero", unaUbicacion))) {

				Criadero criadero = (Criadero) unMapa.obtenerEdificioEnUbicacion("Criadero", unaUbicacion);
				criadero.crearZangano();
				Unidad zangano = jugadorZerg.obtenerUnidadEn(unaUbicacion);
				unMapa.agregarUnidad(zangano);
			}
			
			if((entidad == "Zerling") && (jugadorZerg.haySuministroDisponible(SUMINISTRO_ZERLING)) && 
			   (unMapa.verificarEdificioEnUbicacion("ReservaDeReproduccion", unaUbicacion))) {
				
				ReservaDeReproduccion reserva = (ReservaDeReproduccion) unMapa.obtenerEdificioEnUbicacion("ReservaDeReproduccion", unaUbicacion);
				reserva.recibirLarvas(jugadorZerg.obtenerLarvas());
				reserva.crearZerling();
				Unidad zerling = jugadorZerg.obtenerUnidadEn(unaUbicacion);
				unMapa.agregarUnidad(zerling);
			}
			
			if((entidad == "Hidralisco") && (jugadorZerg.haySuministroDisponible(SUMINISTRO_HIDRALISCO)) && 
			   (unMapa.verificarEdificioEnUbicacion("Guarida", unaUbicacion))) {
				
				Guarida guarida = (Guarida) unMapa.obtenerEdificioEnUbicacion("Guarida", unaUbicacion);
				guarida.recibirLarvas(jugadorZerg.obtenerLarvas());
				guarida.crearHidralisco();
				Unidad hidralisco = jugadorZerg.obtenerUnidadEn(unaUbicacion);
				unMapa.agregarUnidad(hidralisco);
			}
			
			if((entidad == "Mutalisco") && (jugadorZerg.haySuministroDisponible(SUMINISTRO_MUTALISCO)) && 
			   (unMapa.verificarEdificioEnUbicacion("Espiral", unaUbicacion))) {
				
				Espiral espiral = (Espiral) unMapa.obtenerEdificioEnUbicacion("Espiral", unaUbicacion);
				espiral.recibirLarvas(jugadorZerg.obtenerLarvas());
				espiral.crearMutalisco();
				Unidad mutalisco = jugadorZerg.obtenerUnidadEn(unaUbicacion);
				unMapa.agregarUnidad(mutalisco);
			}
			
			/* UNIDADES PROTOSS */
			
			if((entidad == "Zealot") && (jugadorProtoss.haySuministroDisponible(SUMINISTRO_ZEALOT)) && 
			   (unMapa.verificarEdificioEnUbicacion("Acceso", unaUbicacion))) {
				
				Acceso acceso = (Acceso) unMapa.obtenerEdificioEnUbicacion("Acceso", unaUbicacion);
				Unidad zealot = acceso.transportarZealots();
				jugadorProtoss.agregarUnidad(zealot);
				unMapa.agregarUnidad(zealot);
			}
			
			if((entidad == "Dragon") && (jugadorProtoss.haySuministroDisponible(SUMINISTRO_DRAGON)) && 
			   (unMapa.verificarEdificioEnUbicacion("Acceso", unaUbicacion))) {
				
				Acceso acceso = (Acceso) unMapa.obtenerEdificioEnUbicacion("Acceso", unaUbicacion);
				Unidad dragon = acceso.transportarDragones();
				jugadorProtoss.agregarUnidad(dragon);
				unMapa.agregarUnidad(dragon);
			}
			
			if((entidad == "Scout") && (jugadorProtoss.haySuministroDisponible(SUMINISTRO_SCOUT)) && 
			   (unMapa.verificarEdificioEnUbicacion("PuertoEstelar", unaUbicacion))) {
				
				PuertoEstelar puerto = (PuertoEstelar) unMapa.obtenerEdificioEnUbicacion("PuertoEstelar", unaUbicacion);
				Unidad scout = puerto.transportarScout();
				jugadorProtoss.agregarUnidad(scout);
				unMapa.agregarUnidad(scout);
			}
		}
		
		
	}
	
		
	
}
