package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.FabricaDeEdificios;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;

class CasoDeUso17Test {
	
	/*Verificar las "correlativas" de construccion */

	Recursos unosRecursos = new Recursos(10000,10000);
	Recursos otrosRecursos = new Recursos(10000,10000);
	JugadorZerg jugadorZerg = new JugadorZerg("Brian","Azul",unosRecursos);
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Cristian","Rojo",otrosRecursos);
	Mapa mapa = new Mapa();
	
	@Test
	void test01SiNoHayUnaReservaDeProduccionNoSePuedeConstruirUnaGuarida() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,0);
		
		FabricaDeEdificios.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Guarida", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorZerg.verificarEdificio("Guarida"));
	}
	
	@Test
	void test02SiHayUnaReservaDeProduccionSePuedeConstruirUnaGuarida() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,0);
		Ubicacion ubicacion3 = new Ubicacion(2,0);
		
		FabricaDeEdificios.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("ReservaDeReproduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Guarida"));
	}
	
	@Test
	void test03SiNoHayUnaGuaridaNoSePuedeConstruirUnEspiral() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,0);
		Ubicacion ubicacion3 = new Ubicacion(2,0);
		
		FabricaDeEdificios.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("ReservaDeProduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Espiral", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorZerg.verificarEdificio("Espiral"));
	}
	
	@Test
	void test04SiHayUnaGuaridaSePuedeConstruirUnEspiral() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,0);
		Ubicacion ubicacion3 = new Ubicacion(2,0);
		Ubicacion ubicacion4 = new Ubicacion(3,0);
		
		FabricaDeEdificios.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("ReservaDeReproduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Espiral", ubicacion4, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Espiral"));
	}
	
	@Test
	void test05SiNoHayAccesoNoSePuedeConstruirUnPuertoEstelar() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,0);
		
		FabricaDeEdificios.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("PuertoEstelar", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorProtoss.verificarEdificio("PuertoEstelar"));
	}
	
	@Test
	void test06SiHayAccesoSePuedeConstruirUnPuertoEstelar() {
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(1,0);
		Ubicacion ubicacion3 = new Ubicacion(2,0);
		
		FabricaDeEdificios.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Acceso", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("PuertoEstelar", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorProtoss.verificarEdificio("PuertoEstelar"));
	}

}
