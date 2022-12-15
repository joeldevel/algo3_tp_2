package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoError;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Excepciones.SinUnidadBuscadaError;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/* Verificar que cada edificio/construccion tarda lo que dice que tarda y que recién están operativos
 * cuando ya se terminaron de construir*/

class CasoDeUso02Test {

	Mapa mapa = new Mapa();
	JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(10000,10000), mapa);
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(10000,10000), mapa);

	/* Protoss */

	@Test
	void test01SeConstruyeUnAccesoYNoSeEncuentraOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,1);
		
		/* Siempre se necesita un pilon para construir un edificio protoss */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		Acceso acceso = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		/* energizo el edificio para que no tire la excepcion correspondiente a la energia*/
		acceso.energizar();
		
		assertThrows(EdificioNoOperativoException.class, ()->{
			acceso.transportarZealots();
		});
		
		assertThrows(EdificioNoOperativoException.class, ()->{
			acceso.transportarDragones();
		});

	}

	@Test
	void test02SeConstruyeUnAccesoYDespuesDeOchoTurnosSeEncuentraOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,1);
		
		/* Siempre se necesita un pilon para construir un edificio protoss */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		Acceso acceso = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		acceso.avanzarTurno(8);
		acceso.energizar();
		
		assertDoesNotThrow(()-> acceso.transportarZealots());
		assertDoesNotThrow(()-> acceso.transportarDragones());
		
	}
	
	@Test
	void test03SeConstruyeUnAccesoYSeAvanzanSieteTurnosNoDeberiaEstarOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,1);
		
		/* Siempre se necesita un pilon para construir un edificio protoss */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		Acceso acceso = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		acceso.avanzarTurno(7);
		acceso.energizar();
		
		assertThrows(EdificioNoOperativoException.class, ()->{
			acceso.transportarZealots();
		});
		
		assertThrows(EdificioNoOperativoException.class, ()->{
			acceso.transportarDragones();
		});
		
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test04SeConstruyeUnAsimiladorEnUnVolcanYNoSeEncuentraOperativoYaQueAlAvanzarUnTurnoNoExtraeGas(){
		Volcan volcan = new Volcan(new Ubicacion(0,0));
		Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
		asimilador.avanzarTurno();

		// Act
		int resultado = jugadorProtoss.obtenerGas();

		// Assert
		assertEquals(10000, resultado);
	}
	
	@Test
	void test05SeConstruyeUnAsimiladorEnUnVolcanYLuegoDeSeisTurnosDebeEstarOperativo(){
		Volcan volcan = new Volcan(new Ubicacion(0,0));
		Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
		asimilador.avanzarTurno(6);

		/* avanzo un turno mas para que extraiga el gas automaticamente */
		asimilador.avanzarTurno();
		int resultado = jugadorProtoss.obtenerGas();

		// Assert
		assertEquals(10020, resultado);
	}
	
	@Test
	void test06SeConstruyeUnAsimiladorEnUnVolcanYSeAvanzaCincoTurnosNoDeberiaEstarOperativo(){
		Volcan volcan = new Volcan(new Ubicacion(0,0));
		Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
		asimilador.avanzarTurno(5);

		/* avanzo un turno mas para que intente extraer gas automaticamente*/
		int resultado = jugadorProtoss.obtenerGas();

		// Assert
		assertEquals(10000, resultado);
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test07SeConstruyeUnNexoMineralEnUnNodoMineralYNoSeEncuentraOperativoYaQueAlAvanzarUnTurnoNoRecolectaMineral() {
		// Arrange
		NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
		NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
		nexoMineral.avanzarTurno();

		// Act
		int resultado = jugadorProtoss.obtenerMineral();

		// Assert
		assertEquals(9950, resultado);
	}
	
	@Test
	void test08SeConstruyeUnNexoMineralEnUnNodoMineralYLuegoDeCuatroTurnosDeberiaEstarOperativo() {
		// Arrange
		NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
		NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
		nexoMineral.avanzarTurno(4);

		/* se avanza un turno para que extraiga mineral automaticamente*/
		nexoMineral.avanzarTurno();
		int resultado = jugadorProtoss.obtenerMineral();

		// Assert
		assertEquals(9960, resultado);
	}
	
	@Test
	void test09SeConstruyeUnNexoMineralEnUnNodoMineralYSeAvanzaTresTurnosNoDeberiaEstarOperativo() {
		// Arrange
		NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
		NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
		nexoMineral.avanzarTurno(3);

		/* se avanza un turno para que intente extraer mineral automaticamente */
		nexoMineral.avanzarTurno();
		int resultado = jugadorProtoss.obtenerMineral();

		// Assert
		assertEquals(9950, resultado);
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test10SeConstruyeUnPilonYNoSeEncuentraOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		Ubicacion ubicacion2 = new Ubicacion(21,21);
		
		/* se construye un pilon y un acceso cerca para que sea energizado por el pilon */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);

		/* se le dice al pilon que energice a los edificios cercanos pero como no esta operativo no funciona */
		Pilon pilon = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Acceso acceso = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		pilon.energizarEdificios();
		
		assertThrows(EdificioNoEnergizadoError.class,()->{
			acceso.transportarZealots();
		});
		
		assertThrows(EdificioNoEnergizadoError.class,()->{
			acceso.transportarDragones();
		});
	}

	@Test
	void test11SeConstruyeUnPilonYDespuesDeCincoTurnosSeEncuentraOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		Ubicacion ubicacion2 = new Ubicacion(21,21);
		
		/* se construye un pilon y un acceso cerca para que sea energizado por el pilon */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);

		/* luego de cinco turnos se le dice a pilon que energice los edificios cercanos */
		Pilon pilon = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Acceso acceso = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		/* se avanzan 8 turnos para el acceso para que no lance error de no estar operativo*/
		acceso.avanzarTurno(8);
		pilon.avanzarTurno(5);
		pilon.energizarEdificios();
		
		assertDoesNotThrow(()-> acceso.transportarZealots());
		assertDoesNotThrow(()-> acceso.transportarDragones());
	}
	
	@Test
	void test12SeConstruyeUnPilonYSeAvanzaCuatroTurnosNoDeberiaEstarOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		Ubicacion ubicacion2 = new Ubicacion(21,21);
		
		/* se construye un pilon y un acceso cerca para que sea energizado por el pilon */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);

		/* luego de cuatro turnos se le dice a pilon que energice los edificios cercanos y no funciona */
		Pilon pilon = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Acceso acceso = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		/* se avanzan 8 turnos para el acceso para que no lance error de no estar operativo*/
		acceso.avanzarTurno(8);
		pilon.avanzarTurno(4);
		pilon.energizarEdificios();
		
		assertThrows(EdificioNoEnergizadoError.class,()->{
			acceso.transportarZealots();
		});
		
		assertThrows(EdificioNoEnergizadoError.class,()->{
			acceso.transportarDragones();
		});
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test13SeConstruyeUnPuertoEstelarYNoSeEncuentraOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		Ubicacion ubicacion2 = new Ubicacion(21,21);
		Ubicacion ubicacion3 = new Ubicacion(19,19);
		
		/* se necesita pilon y acceso para construir un puerto estelar */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("PuertoEstelar", ubicacion3, jugadorZerg, mapa);

		PuertoEstelar puertoEstelar = (PuertoEstelar)jugadorProtoss.obtenerEdificioEn(ubicacion3);

		/*energizo el puerto estelar para que no lance excepcion de si esta energizado */
		puertoEstelar.energizar();
		
		assertThrows(EdificioNoOperativoException.class,()->{
			puertoEstelar.transportarScout();
		});
	}

	@Test
	void test14SeConstruyeUnPuertoEstelarYDespuesDeDiezTurnosSeEncuentraOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		Ubicacion ubicacion2 = new Ubicacion(21,21);
		Ubicacion ubicacion3 = new Ubicacion(19,19);
		
		/* se necesita pilon y acceso para construir un puerto estelar */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("PuertoEstelar", ubicacion3, jugadorZerg, mapa);

		PuertoEstelar puertoEstelar = (PuertoEstelar)jugadorProtoss.obtenerEdificioEn(ubicacion3);
		puertoEstelar.avanzarTurno(10);

		/*energizo el puerto estelar para que no lance excepcion de si esta energizado */
		puertoEstelar.energizar();
		
		assertDoesNotThrow(()-> puertoEstelar.transportarScout());
	}
	
	@Test
	void test15SeConstruyeUnPuertoEstelarYSeAvanzaNueveTurnosNoDeberiaEstarOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		Ubicacion ubicacion2 = new Ubicacion(21,21);
		Ubicacion ubicacion3 = new Ubicacion(19,19);
		
		/* se necesita pilon y acceso para construir un puerto estelar */
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("PuertoEstelar", ubicacion3, jugadorZerg, mapa);

		PuertoEstelar puertoEstelar = (PuertoEstelar)jugadorProtoss.obtenerEdificioEn(ubicacion3);
		puertoEstelar.avanzarTurno(9);

		/*energizo el puerto estelar para que no lance excepcion de si esta energizado */
		puertoEstelar.energizar();
		
		assertThrows(EdificioNoOperativoException.class,()->{
			puertoEstelar.transportarScout();
		});
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	/* Zerg */

	@Test
	void test16SeConstruyeUnCriaderoYNoSeEncuentraOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);

		assertEquals(jugadorZerg.contarUnidades(),0);
		
		criadero.crearZangano();
		
		assertEquals(jugadorZerg.contarUnidades(),0);
	}

	@Test
	void test17SeConstruyeUnCriaderoYDespuesDeCuatroTurnosSeEncuentraOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		criadero.crearZangano();
		
		assertEquals(jugadorZerg.contarUnidades(),1);
	}
	
	@Test
	void test18SeConstruyeUnCriaderoYSeAvanzaTresTurnosNoDeberiaEstarOperativo(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(20,20);
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(3);
		criadero.crearZangano();
		
		assertEquals(jugadorZerg.contarUnidades(),0);
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test19SeConstruyeUnExtractorEnUnVolcanYNoSeEncuentraOperativoYaQueAlAvanzarUnTurnoNoExtraeGas(){
		// Arrange
		Volcan volcan = new Volcan(new Ubicacion(0,0));
		Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
		extractor.avanzarTurno();

		// Act
		int resultado = jugadorZerg.obtenerGas();

		// Assert
		assertEquals(10000, resultado);
	}
	
	@Test
	void test20SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnoSeEncuentraOperativo(){
		// Arrange
		Volcan volcan = new Volcan(new Ubicacion(0,0));
		Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
		extractor.avanzarTurno(6);
		
		/* se agregan zanganos para que extraigan gas */
		extractor.guardarZangano(new Unidad(new Tiempo(0), new Ubicacion(0,0), new Zangano(jugadorZerg)));
		extractor.guardarZangano(new Unidad(new Tiempo(0), new Ubicacion(0,0), new Zangano(jugadorZerg)));
		extractor.guardarZangano(new Unidad(new Tiempo(0), new Ubicacion(0,0), new Zangano(jugadorZerg)));

		/* se avanza un turno para que extraiga el gas automaticamente*/
		extractor.avanzarTurno();
		int resultado = jugadorZerg.obtenerGas();

		// Assert
		assertEquals(10030, resultado);
	}
	
	@Test
	void test21SeConstruyeUnExtractorEnUnVolcanYSeAvanzaCincoTurnosNoDeberiaEstarOperativo(){
		// Arrange
		Volcan volcan = new Volcan(new Ubicacion(0,0));
		Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
		extractor.avanzarTurno(5);
		
		/* se agregan zanganos para que extraigan gas */
		extractor.guardarZangano(new Unidad(new Tiempo(0), new Ubicacion(0,0), new Zangano(jugadorZerg)));
		extractor.guardarZangano(new Unidad(new Tiempo(0), new Ubicacion(0,0), new Zangano(jugadorZerg)));
		extractor.guardarZangano(new Unidad(new Tiempo(0), new Ubicacion(0,0), new Zangano(jugadorZerg)));

		/* se avanza un turno para que intente extraer gas automaticamente*/
		extractor.avanzarTurno();
		int resultado = jugadorZerg.obtenerGas();

		// Assert
		assertEquals(10000, resultado);
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test22SeConstruyeUnaGuaridaYNoSeEncuentraOperativa(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(2,2);
		Ubicacion ubicacion2 = new Ubicacion(3,3);
		Ubicacion ubicacion3 = new Ubicacion(1,1);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		Guarida guarida = (Guarida)jugadorZerg.obtenerEdificioEn(ubicacion3);
		
		/* se quiere buscar la unidad en jugador para agregarla al mapa y tira error */
		assertThrows(SinUnidadBuscadaError.class,()-> {
			jugadorZerg.construir("Hidralisco", ubicacion3, jugadorProtoss, mapa);
			
		});

	}

	@Test
    void test23SeConstruyeUnaGuaridaYDespuesDeDoceTurnosSeEncuentraOperativa(){
		Ubicacion ubicacion1 = new Ubicacion(2,2);
		Ubicacion ubicacion2 = new Ubicacion(3,3);
		Ubicacion ubicacion3 = new Ubicacion(1,1);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		Guarida guarida = (Guarida)jugadorZerg.obtenerEdificioEn(ubicacion3);
		guarida.avanzarTurno(12);
		
		jugadorZerg.construir("Hidralisco", ubicacion3, jugadorProtoss, mapa);
        // Assert
        assertEquals(jugadorZerg.contarUnidades(),1);
    }
	
	@Test
	void test24SeConstruyeUnaGuaridaYSeAvanzaOnceTurnosNoDeberiaEstarOperativa(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(2,2);
		Ubicacion ubicacion2 = new Ubicacion(3,3);
		Ubicacion ubicacion3 = new Ubicacion(1,1);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		Guarida guarida = (Guarida)jugadorZerg.obtenerEdificioEn(ubicacion3);
		guarida.avanzarTurno(11);
		
		/* se quiere buscar la unidad en jugador para agregarla al mapa y tira error */
		assertThrows(SinUnidadBuscadaError.class,()-> {
			jugadorZerg.construir("Hidralisco", ubicacion3, jugadorProtoss, mapa);
			
		});

	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test25SeConstruyeUnaReservaDeReproduccionYNoSeEncuentraOperativa(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(1,1);
		Ubicacion ubicacion2 = new Ubicacion(2,2);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		/* se quiere buscar la unidad en jugador para agregarla al mapa y tira error */
		assertThrows(SinUnidadBuscadaError.class,()-> {
			jugadorZerg.construir("Zerling", ubicacion2, jugadorProtoss, mapa);
			
		});
	}
	
	@Test
	void test26SeConstruyeUnaReservaDeReproduccionYDespuesDeDoceTurnosSeEncuentraOperativa(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(1,1);
		Ubicacion ubicacion2 = new Ubicacion(2,2);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		ReservaDeReproduccion reserva = (ReservaDeReproduccion)jugadorZerg.obtenerEdificioEn(ubicacion2);
		reserva.avanzarTurno(12);
		
		jugadorZerg.construir("Zerling", ubicacion2, jugadorProtoss, mapa);
		
		assertEquals(jugadorZerg.contarUnidades(),1);
	}
	
	@Test
	void test27SeConstruyeUnaReservaDeReproduccionYSeAvanzaOnceTurnosNoDeberiaEstarOperativa(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(1,1);
		Ubicacion ubicacion2 = new Ubicacion(2,2);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		ReservaDeReproduccion reserva = (ReservaDeReproduccion)jugadorZerg.obtenerEdificioEn(ubicacion2);
		reserva.avanzarTurno(11);
		
		/* se quiere buscar la unidad en jugador para agregarla al mapa y tira error */
		assertThrows(SinUnidadBuscadaError.class,()-> {
			jugadorZerg.construir("Zerling", ubicacion2, jugadorProtoss, mapa);
			
		});
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test28SeConstruyeUnaEspiralYNoSeEncuentraOperativa(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(3,3);
		Ubicacion ubicacion2 = new Ubicacion(4,4);
		Ubicacion ubicacion3 = new Ubicacion(2,2);
		Ubicacion ubicacion4 = new Ubicacion(1,1);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		jugadorZerg.construir("Espiral", ubicacion4, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		/* se quiere buscar la unidad en jugador para agregarla al mapa y tira error */
		assertThrows(SinUnidadBuscadaError.class,()-> {
			jugadorZerg.construir("Mutalisco", ubicacion4, jugadorProtoss, mapa);
		});
	}

	@Test
	void test29SeConstruyeUnaEspiralYDespuesDeDiezTurnosSeEncuentraOperativa(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(3,3);
		Ubicacion ubicacion2 = new Ubicacion(4,4);
		Ubicacion ubicacion3 = new Ubicacion(2,2);
		Ubicacion ubicacion4 = new Ubicacion(1,1);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		jugadorZerg.construir("Espiral", ubicacion4, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		Espiral espiral = (Espiral)jugadorZerg.obtenerEdificioEn(ubicacion4);
		espiral.avanzarTurno(10);
		
		jugadorZerg.construir("Mutalisco", ubicacion4, jugadorProtoss, mapa);

		assertEquals(jugadorZerg.contarUnidades(),1);
	}
	
	@Test
	void test30SeConstruyeUnaEspiralYSeAvanzaNueveTurnosNoDeberiaEstarOperativa(){
		// Arrange
		Ubicacion ubicacion1 = new Ubicacion(3,3);
		Ubicacion ubicacion2 = new Ubicacion(4,4);
		Ubicacion ubicacion3 = new Ubicacion(2,2);
		Ubicacion ubicacion4 = new Ubicacion(1,1);
		
		jugadorZerg.construir("Criadero", ubicacion1, jugadorProtoss, mapa);
		jugadorZerg.construir("ReservaDeReproduccion", ubicacion2, jugadorProtoss, mapa);
		jugadorZerg.construir("Guarida", ubicacion3, jugadorProtoss, mapa);
		jugadorZerg.construir("Espiral", ubicacion4, jugadorProtoss, mapa);
		
		/* necesito criadero operativo para pasarle las larvas a guarida*/
		Criadero criadero = (Criadero)jugadorZerg.obtenerEdificioEn(ubicacion1);
		criadero.avanzarTurno(4);
		
		Espiral espiral = (Espiral)jugadorZerg.obtenerEdificioEn(ubicacion4);
		espiral.avanzarTurno(9);
		
		/* se quiere buscar la unidad en jugador para agregarla al mapa y tira error */
		assertThrows(SinUnidadBuscadaError.class,()-> {
			jugadorZerg.construir("Mutalisco", ubicacion4, jugadorProtoss, mapa);
		});
	}
}
