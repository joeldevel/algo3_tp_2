package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Fabrica;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;

class CasoDeUso13Test {
	
	/* Se Destruye un criadero e igual se puede seguir construyendo sobre el moho que dejo */

	Mapa mapa = new Mapa();
	JugadorZerg jugadorZerg = new JugadorZerg("Brian", "Azul", new Recursos(10000,10000), mapa);
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Alan","Rojo",new Recursos(10000,10000), mapa);

	@Test
	void test01SeDestruyeUnCriaderoYSePuedeConstruirUnExtractor() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(0,3);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		
		jugadorZerg.destruirEdificioEn(ubicacion1);
		mapa.destruirOrigenDeMoho(ubicacion1);
		mapa.agregarVolcan(ubicacion2);
		
		Fabrica.construir("Extractor", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Extractor"));
		
	}
	
	@Test
	void test02SeDestruyeUnCriaderoYSePuedeConstruirUnaReservaDeReproduccion() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(0,3);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		
		jugadorZerg.destruirEdificioEn(ubicacion1);
		mapa.destruirOrigenDeMoho(ubicacion1);
		
		Fabrica.construir("ReservaDeReproduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("ReservaDeReproduccion"));
	}
	
	@Test
	void test03SeDestruyeUnCriaderoYSePuedeConstruirUnaGuarida() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(0,3);
		Ubicacion ubicacion3 = new Ubicacion(0,5);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		
		jugadorZerg.destruirEdificioEn(ubicacion1);
		mapa.destruirOrigenDeMoho(ubicacion1);
		
		Fabrica.construir("ReservaDeReproduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Guarida"));
	}
	
	@Test
	void test04SeDestruyeUnCriaderoYSePuedeConstruirUnEspiral() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(0,3);
		Ubicacion ubicacion3 = new Ubicacion(0,5);
		Ubicacion ubicacion4 = new Ubicacion(3,0);
		
		Fabrica.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		
		jugadorZerg.destruirEdificioEn(ubicacion1);
		mapa.destruirOrigenDeMoho(ubicacion1);
		
		Fabrica.construir("ReservaDeReproduccion", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Guarida", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Espiral", ubicacion4, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorZerg.verificarEdificio("Espiral"));
	}
	
	

}
