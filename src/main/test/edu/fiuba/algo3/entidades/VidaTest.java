package edu.fiuba.algo3.entidades;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoParaVidaError;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoDeDanioError;
import edu.fiuba.algo3.modelo.Vida;

// Borre dos test referidos al parametro de regeneracion.

class VidaTest {

	/*@Test
	void test01UnaVidaRecibeDanioPorUnValorDeberiaReducirLaVida() {
		
		Vida vida = new Vida(100);

		Recursos recursos = new Recursos(0,100);

		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
		
		vida.recibirDanioPor(10, pilon, jugadorProtoss);
		
		assertEquals(vida.restante(),90);
	}
	
	@Test
	void test02UnaVidaRecibeDanioPorSuVidaMaximaSuVidaRestanteDeberiaSerCero() {
		
		Vida vida = new Vida(100);

		Recursos recursos = new Recursos(0,100);

		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

		vida.recibirDanioPor(100, pilon, jugadorProtoss);
		
		assertEquals(vida.restante(),0);
	}
	
	@Test
	void test03UnaVidaRecibeDanioPorEncimaDeSuVidaMaximaSuVidaRestanteDeberiaSerCero() {
		
		Vida vida = new Vida(100);

		Recursos recursos = new Recursos(0,100);

		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

		vida.recibirDanioPor(200, pilon, jugadorProtoss);
		
		assertEquals(vida.restante(),0);
	}
	
	@Test
	void test04SeIntentaInstanciarUnaVidaConSuVidaMaximaNegativaDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaVidaError.class,()->{
		new Vida(-1);
		});
	}
	
	@Test
	void test05SeIntentaInstanciarUnaVidaConSuVidaMaximaEnCeroDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaVidaError.class,()->{
		new Vida(0);
		});
	}
	
	@Test
	void test06UnaVidaRecibeDanioYSeRecuperaDeberiaTenerSuVidaRestanteAumentada() {
		
		Vida vida = new Vida(100);

		Recursos recursos = new Recursos(0,100);

		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

		vida.recibirDanioPor(50, pilon, jugadorProtoss);
		vida.recuperarse();
		
		assertEquals(vida.restante(),55);
	}
	
	@Test
	void test07UnaVidaRecibeDanioPorSuVidaMaximaYSeRecuperaSuVidaRestanteDeberiaSerIgualASuRecuperacion() {
		
		Vida vida = new Vida(100);

		Recursos recursos = new Recursos(0,100);

		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

		vida.recibirDanioPor(100, pilon, jugadorProtoss);
		vida.recuperarse();
		
		assertEquals(vida.restante(),5);
	}
	
	@Test
	void test8UnaVidaRecibeDanioPorEncimaDeSuVidaMaximaYSeRecuperaSuVidaRestanteDeberiaSerIgualASuRecuperacion() {
		
		Vida vida = new Vida(100);

		Recursos recursos = new Recursos(0,100);

		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

		vida.recibirDanioPor(1000, pilon, jugadorProtoss);
		vida.recuperarse();
		
		assertEquals(vida.restante(),5);
	}
	
	@Test
	void test9UnaVidaNoRecibeDanioYSeRecuperaSuVidaRestanteDeberiaSerIgualASuVidaMaxima() {
		
		Vida vida = new Vida(100);
		
		vida.recuperarse();
		
		assertEquals(vida.restante(),100);
	}
	
	@Test
	void test10UnaVidaRecibeDanioNegativoDeberiaLanzarUnaExcepcion() {
		
		Vida vida = new Vida(100);

		Recursos recursos = new Recursos(0,100);

		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
		
		assertThrows(ValorInvalidoDeDanioError.class,()->{
			vida.recibirDanioPor(-100, pilon, jugadorProtoss);
			});
	}*/
}
