package edu.fiuba.algo3.entrega_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.SinUnidadBuscadaException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

class CasoDeUso20Test {
	
	/* Verificar que solo las unidades voladoras puedan moverse por areas espaciales */

	Mapa mapa = new Mapa();
	JugadorZerg jugadorZerg = new JugadorZerg("Brian", "Azul", new Recursos(10000,10000), mapa);
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Alan", "Rojo", new Recursos(10000,10000),mapa);
	
	@Test
	void test01UnScoutSePuedeMoverPorAreasDeTierraYEspaciales() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		Ubicacion ubicacion2 = new Ubicacion(6,9);
		Ubicacion ubicacion3 = new Ubicacion(6,8);
		
		/* construyo los edificios necesarios para crear el Scout*/
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("PuertoEstelar", ubicacion3, jugadorZerg, mapa);
		
		Pilon pilon =(Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Acceso acceso = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		PuertoEstelar puerto = (PuertoEstelar)jugadorProtoss.obtenerEdificioEn(ubicacion3);
		
		/* dejo los edificios operativos */
		pilon.avanzarTurno(5);
		acceso.avanzarTurno(10);
		puerto.avanzarTurno(10);
		
		/* energizo los edificios para que no lance excepcion de edificio no energizado */
		pilon.energizarEdificios();
		
		jugadorProtoss.construir("Scout", ubicacion3, jugadorZerg, mapa);
		
		Unidad scout = jugadorProtoss.obtenerUnidadEn(ubicacion3);
		
		/* dejo al scout operativo*/
		scout.avanzarTurno(9);
		
		/* se mueve una vez, esta en la posicion 7,8 que es de tierra*/
		scout.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,8)));
		
		/* se mueve una segunda vez, esta en la posicion 8,8 que es de aire*/
		scout.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,8)));
	}
	
	@Test
	void test02ZealotYDragonNoSePuedenMoverEnAreasEspaciales() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		Ubicacion ubicacion2 = new Ubicacion(6,9);
		Ubicacion ubicacion3 = new Ubicacion(6,8);
		
		/* construyo los edificios necesarios para crear el Scout*/
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion3, jugadorZerg, mapa);
		
		Pilon pilon =(Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Acceso acceso1 = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		Acceso acceso2 = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion3);
		
		/* dejo los edificios operativos */
		pilon.avanzarTurno(5);
		acceso1.avanzarTurno(10);
		acceso2.avanzarTurno(10);
		
		/* energizo los edificios para que no lance excepcion de edificio no energizado */
		pilon.energizarEdificios();
		
		jugadorProtoss.construir("Zealot", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("Dragon", ubicacion3, jugadorZerg, mapa);
		
		Unidad zealot = jugadorProtoss.obtenerUnidadEn(ubicacion2);
		Unidad dragon = jugadorProtoss.obtenerUnidadEn(ubicacion3);
		
		/* dejo a las unidades operativas*/
		zealot.avanzarTurno(4);
		dragon.avanzarTurno(6);
		
		/* se mueven una vez, esta en la posicion 7,9 zealot, y 7,8 dragon, que es de tierra*/
		zealot.moverse(mapa);
		dragon.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,9)));
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,8)));
		
		/* se mueven una segunda vez, esta en la posicion 8,9 zealot, y 8,8 dragon, que es de aire*/
		zealot.moverse(mapa);
		dragon.moverse(mapa);
		assertThrows(SinUnidadBuscadaException.class, ()->{
			mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,9));
		});
		assertThrows(SinUnidadBuscadaException.class, ()->{
			mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,8));
		});
	}
	
	@Test
	void test03UnAmoSupremoSePuedeMoverPorAreasDeTierraYAreasEspaciales() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		
		/* el amo supremo se puede construir sin edificios */
		jugadorZerg.construir("AmoSupremo", ubicacion1, jugadorProtoss, mapa);
		
		Unidad amoSupremo = jugadorZerg.obtenerUnidadEn(ubicacion1);
		
		/* dejo al amo supremo operativo*/
		amoSupremo.avanzarTurno(5);
		
		/* se mueve una vez, esta en la posicion 7,7 que es de tierra*/
		amoSupremo.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,7)));
		
		/* se mueve una segunda vez, esta en la posicion 8,7, que es de aire */
		amoSupremo.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,7)));
	}
	
	@Test
	void test04MutaliscoSePuedenMoverPorAreasDeTierraYAreasEspaciales() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		Ubicacion ubicacion2 = new Ubicacion(6,9);
		Ubicacion ubicacion3 = new Ubicacion(6,8);
		Ubicacion ubicacion4 = new Ubicacion(6,6);
		
		/* creo los edificios que necesito para crear el mutalisco */
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		jugadorZerg.construir("Espiral", ubicacion4, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero) jugadorZerg.obtenerEdificioEn(ubicacion1);
		ReservaDeReproduccion reserva = (ReservaDeReproduccion)jugadorZerg.obtenerEdificioEn(ubicacion2);
		Guarida guarida = (Guarida)jugadorZerg.obtenerEdificioEn(ubicacion3);
		Espiral espiral = (Espiral)jugadorZerg.obtenerEdificioEn(ubicacion4);
		
		/* dejo los edificios operativos */
		criadero.avanzarTurno(4);
		reserva.avanzarTurno(12);
		guarida.avanzarTurno(12);
		espiral.avanzarTurno(10);
		
		jugadorZerg.construir("Mutalisco", ubicacion4, jugadorProtoss, mapa);
		
		Unidad mutalisco = jugadorZerg.obtenerUnidadEn(ubicacion4);
		
		/* dejo a las unidades operativas */
		mutalisco.avanzarTurno(7);
		
		/* se mueve una vez, esta en la posicion 7,6 que es de tierra*/
		mutalisco.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,6)));
		
		/* se mueve una segunda vez, esta en la posicion 8,6, que es de aire */
		mutalisco.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,6)));
				
	}
	
	@Test
	void test05GuardianSePuedeMoverPorAreasDeTierraYAreasEspaciales() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		Ubicacion ubicacion2 = new Ubicacion(6,9);
		Ubicacion ubicacion3 = new Ubicacion(6,8);
		Ubicacion ubicacion4 = new Ubicacion(6,6);
		
		/* creo los edificios que necesito para crear el mutalisco */
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		jugadorZerg.construir("Espiral", ubicacion4, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero) jugadorZerg.obtenerEdificioEn(ubicacion1);
		ReservaDeReproduccion reserva = (ReservaDeReproduccion)jugadorZerg.obtenerEdificioEn(ubicacion2);
		Guarida guarida = (Guarida)jugadorZerg.obtenerEdificioEn(ubicacion3);
		Espiral espiral = (Espiral)jugadorZerg.obtenerEdificioEn(ubicacion4);
		
		/* dejo los edificios operativos */
		criadero.avanzarTurno(4);
		reserva.avanzarTurno(12);
		guarida.avanzarTurno(12);
		espiral.avanzarTurno(10);
		
		jugadorZerg.construir("Mutalisco", ubicacion4, jugadorProtoss, mapa);
		
		Unidad guardian = jugadorZerg.obtenerUnidadEn(ubicacion4);
		
		/* dejo a las unidades operativas */
		guardian.avanzarTurno(7);
		guardian.evolucionarAGuardian();
		guardian.avanzarTurno(4);
		
		/* se mueve una vez, esta en la posicion 7,6 que es de tierra*/
		guardian.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,6)));
		
		/* se mueve una segunda vez, esta en la posicion 8,6, que es de aire */
		guardian.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,6)));
	}
	
	@Test
	void test06DevoradorSePuedeMoverPorAreasDeTierraYAreasEspaciales() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		Ubicacion ubicacion2 = new Ubicacion(6,9);
		Ubicacion ubicacion3 = new Ubicacion(6,8);
		Ubicacion ubicacion4 = new Ubicacion(6,6);
		
		/* creo los edificios que necesito para crear el mutalisco */
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		jugadorZerg.construir("Espiral", ubicacion4, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero) jugadorZerg.obtenerEdificioEn(ubicacion1);
		ReservaDeReproduccion reserva = (ReservaDeReproduccion)jugadorZerg.obtenerEdificioEn(ubicacion2);
		Guarida guarida = (Guarida)jugadorZerg.obtenerEdificioEn(ubicacion3);
		Espiral espiral = (Espiral)jugadorZerg.obtenerEdificioEn(ubicacion4);
		
		/* dejo los edificios operativos */
		criadero.avanzarTurno(4);
		reserva.avanzarTurno(12);
		guarida.avanzarTurno(12);
		espiral.avanzarTurno(10);
		
		jugadorZerg.construir("Mutalisco", ubicacion4, jugadorProtoss, mapa);
		
		Unidad devorador = jugadorZerg.obtenerUnidadEn(ubicacion4);
		
		/* dejo a las unidades operativas */
		devorador.avanzarTurno(7);
		devorador.evolucionarADevorador();
		devorador.avanzarTurno(4);
		
		/* se mueve una vez, esta en la posicion 7,6 que es de tierra*/
		devorador.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,6)));
		
		/* se mueve una segunda vez, esta en la posicion 8,6, que es de aire */
		devorador.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,6)));
	}
	
	@Test
	void test07HidraliscoSoloSePuedeMoverPorAreasDeTierra() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		Ubicacion ubicacion2 = new Ubicacion(6,9);
		Ubicacion ubicacion3 = new Ubicacion(6,8);
		
		/* creo los edificios que necesito para crear el hidralisco */
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero) jugadorZerg.obtenerEdificioEn(ubicacion1);
		ReservaDeReproduccion reserva = (ReservaDeReproduccion)jugadorZerg.obtenerEdificioEn(ubicacion2);
		Guarida guarida = (Guarida)jugadorZerg.obtenerEdificioEn(ubicacion3);
		
		/* dejo los edificios operativos */
		criadero.avanzarTurno(4);
		reserva.avanzarTurno(12);
		guarida.avanzarTurno(12);
		
		jugadorZerg.construir("Hidralisco", ubicacion3, jugadorProtoss, mapa);
		
		Unidad hidralisco = jugadorZerg.obtenerUnidadEn(ubicacion3);
		
		/* dejo a las unidades operativas */
		hidralisco.avanzarTurno(4);
		
		/* se mueve una vez, esta en la posicion 7,8 que es de tierra*/
		hidralisco.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,8)));
		
		/* se mueve una segunda vez, esta en la posicion 8,8, que es de aire */
		hidralisco.moverse(mapa);
		assertThrows(SinUnidadBuscadaException.class, ()->{
			mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,8));
		});
	}
	
	@Test
	void test08ZerlingSoloSePuedeMoverPorAreasDeTierra() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		Ubicacion ubicacion2 = new Ubicacion(6,9);
		
		/* creo los edificios que necesito para crear el zerling */
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero) jugadorZerg.obtenerEdificioEn(ubicacion1);
		ReservaDeReproduccion reserva = (ReservaDeReproduccion)jugadorZerg.obtenerEdificioEn(ubicacion2);
		
		/* dejo los edificios operativos */
		criadero.avanzarTurno(4);
		reserva.avanzarTurno(12);
		
		jugadorZerg.construir("Zerling", ubicacion2, jugadorProtoss, mapa);
		
		Unidad zerling = jugadorZerg.obtenerUnidadEn(ubicacion2);
		
		/* dejo a las unidades operativas */
		zerling.avanzarTurno(2);
		
		/* se mueve una vez, esta en la posicion 7,9 que es de tierra*/
		zerling.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,9)));
		
		/* se mueve una segunda vez, esta en la posicion 8,9, que es de aire */
		zerling.moverse(mapa);
		assertThrows(SinUnidadBuscadaException.class, ()->{
			mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,9));
		});
	}
	
	@Test
	void test09ZanganoSoloSePuedeMoverPorAreasDeTierra() {
		
		/* en el mapa las areas espaciales estan entre 8 y 20 en X, y entre 4 y 10 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(6,7);
		
		/* creo los edificios que necesito para crear el zangano */
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero) jugadorZerg.obtenerEdificioEn(ubicacion1);
		
		/* dejo el criadero operativo */
		criadero.avanzarTurno(4);
		
		jugadorZerg.construir("Zangano", ubicacion1, jugadorProtoss, mapa);
		
		Unidad zangano = jugadorZerg.obtenerUnidadEn(ubicacion1);
		
		/* dejo a las unidades operativas */
		zangano.avanzarTurno(1);
		
		/* se mueve una vez, esta en la posicion 7,7 que es de tierra*/
		zangano.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(7,7)));
		
		/* se mueve una segunda vez, esta en la posicion 8,7, que es de aire */
		zangano.moverse(mapa);
		assertThrows(SinUnidadBuscadaException.class, ()->{
			mapa.obtenerUnidadEnUbicacion(new Ubicacion(8,7));
		});
	}

}
