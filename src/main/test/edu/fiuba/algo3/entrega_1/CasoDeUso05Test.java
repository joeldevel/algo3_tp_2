package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Fabrica;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;

class CasoDeUso05Test {

	/* Verificar que no se puedan construir edificios fuera del rango de un pilon o fuera del moho*/

	Mapa mapa = new Mapa();
	Recursos unosRecursos = new Recursos(10000,10000);
	Recursos otrosRecursos = new Recursos(10000,10000);
	JugadorZerg jugadorZerg = new JugadorZerg("Brian","Azul",unosRecursos, mapa);
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Cristian","Rojo",otrosRecursos, mapa);
	
	@Test
	void test01SiLaUbicacionNoEstaOcupadaDeberiaPoderConstruirUnCriadero() {
		Ubicacion ubicacion = new Ubicacion(0,0);
		
		Fabrica.construir("Criadero",ubicacion,jugadorZerg,jugadorProtoss,mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Criadero"));
		
	}
	
	@Test
	void test02SiNoHayUnCriaderoDesdeElCualCrezcaElMohoNoSePuedeConstruirUnEdificioZerg() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(2,0);
		Ubicacion ubicacion3 = new Ubicacion(0,2);
		Ubicacion ubicacion4 = new Ubicacion(-2,0);
		
		Fabrica.construir("Extractor", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("ReservaDeProduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Espiral", ubicacion4, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorZerg.verificarEdificio("Extractor"));
		assertFalse(jugadorZerg.verificarEdificio("ReservaDeProduccion"));
		assertFalse(jugadorZerg.verificarEdificio("Guarida"));
		assertFalse(jugadorZerg.verificarEdificio("Espiral"));
	}
	
	@Test
	void test03SiHayUnCriaderoDesdeElCualCreceElMohoPeroNoUnVolcanNoSePuedeConstruirUnExtractor() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(2,0);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Extractor", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Criadero"));
		assertFalse(jugadorZerg.verificarEdificio("Extractor"));
	}
	
	@Test
	void test04SiHayUnCriaderoDesdeElCualCreceElMohoYUnVolcanCercaSePuedeConstruirUnExtractor() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		
		mapa.agregarVolcan(ubicacion2);
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Extractor", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Extractor"));
	}
	
	@Test
	void test05SiHayUnCriaderoYUnVolcanFueraDeRangoDelMohoNoSePuedeConstruirUnExtractor() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(6,0);
		
		mapa.agregarVolcan(ubicacion2);
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Extractor", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorZerg.verificarEdificio("Extractor"));
	}
	
	@Test
	void test06SiHayCriaderoDesdeElCualCreceElMohoSePuedeConstruirUnaReservaDeProduccionDentroDelRangoDelMoho() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("ReservaDeReproduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("ReservaDeReproduccion"));
	}
	
	@Test
	void test07NoSePuedeConstruirUnaReservaDeProduccionFueraDelRangoDelMoho() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(6,0);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("ReservaDeProduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorZerg.verificarEdificio("ReservaDeProduccion"));
	}
	
	@Test
	void test08ConCriaderoYReservaDeProduccionSePuedeConstruirGuaridaDentroDelRangoDelMoho() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		Ubicacion ubicacion3 = new Ubicacion(4,0);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("ReservaDeReproduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Guarida"));
	}
	
	@Test
	void test09ConCriaderoYReservaDeProduccionNoSePuedeConstruirGuaridaFueraDelRangoDelMoho() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		Ubicacion ubicacion3 = new Ubicacion(6,0);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("ReservaDeProduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorZerg.verificarEdificio("Guarida"));
	}
	
	@Test
	void test10ConCriaderoYGuaridaSePuedeConstruirUnEspiralDentroDelRangoDelMoho() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		Ubicacion ubicacion3 = new Ubicacion(4,0);
		Ubicacion ubicacion4 = new Ubicacion(-4,0);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("ReservaDeReproduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Espiral", ubicacion4, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Espiral"));
	}
	
	@Test
	void test11ConCriaderoYGuaridaNoSePuedeConstruirUnEspiralFueraDelRangoDelMoho() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		Ubicacion ubicacion3 = new Ubicacion(4,0);
		Ubicacion ubicacion4 = new Ubicacion(6,0);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("ReservaDeProduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Espiral", ubicacion4, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorZerg.verificarEdificio("Espiral"));
	}
	
	@Test
	void test12SiLaUbicacionNoEstaOcupadaDeberiaPoderConstruirUnPilon() {
		Ubicacion ubicacion = new Ubicacion(0,0);
		
		Fabrica.construir("Pilon",ubicacion,jugadorZerg,jugadorProtoss,mapa);
		
		assertTrue(jugadorProtoss.verificarEdificio("Pilon"));
	}
	
	@Test
	void test13SiHayUnPilonYUnNodoMineralSePuedeConstruirUnNexoMineralDentroDelRangoDelPilon() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(2,0);
		
		mapa.agregarNodoMineral(ubicacion2);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("NexoMineral", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorProtoss.verificarEdificio("NexoMineral"));
	}
	
	@Test
	void test14SiHayUnPilonYUnNodoMineralNoSePuedeConstruirUnNexoMineralFueraDelRangoDelPilon() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(4,0);
		
		mapa.agregarNodoMineral(ubicacion2);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("NexoMineral", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorProtoss.verificarEdificio("NexoMineral"));
	}
	
	@Test
	void test15SiHayUnPilonYUnVolcanCercaSePuedeConstruirUnAsimiladorDentroDelRangoDelPilon() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(2,0);
		
		mapa.agregarVolcan(ubicacion2);
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Asimilador", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorProtoss.verificarEdificio("Asimilador"));
	}
	
	@Test
	void test16SiHayUnPilonYUnVolcanCercaNoSePuedeConstruirUnAsimiladorFueraDelRangoDelPilon() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(4,0);
		
		mapa.agregarVolcan(ubicacion2);
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Asimilador", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorProtoss.verificarEdificio("Asimilador"));
	}
	
	@Test
	void test17SiHayUnPilonSePuedeConstruirUnAccesoDentroDelRangoDelPilon() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(3,0);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Acceso", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorProtoss.verificarEdificio("Acceso"));
	}
	
	@Test
	void test18NoSePuedeConstruirUnAccesoFueraDelRangoDelPilon() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(4,0);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Acceso", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorProtoss.verificarEdificio("Acceso"));
	}
	
	@Test
	void test19SiHayUnPilonYUnAccesoSePuedeConstruirUnPuertoEstelarDentroDelRangoDelPilon() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(2,0);
		Ubicacion ubicacion3 = new Ubicacion(3,0);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Acceso", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("PuertoEstelar", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorProtoss.verificarEdificio("PuertoEstelar"));
	}
	
	@Test
	void test20SiHayUnPilonYUnAccesoNoSePuedeConstruirUnPuertoEstelarFueraDelRangoDelPilon() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(2,0);
		Ubicacion ubicacion3 = new Ubicacion(4,0);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Acceso", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("PuertoEstelar", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorProtoss.verificarEdificio("PuertoEstelar"));
	}

}
