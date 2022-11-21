package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoParaVidaError;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoDeDanioError;
import edu.fiuba.algo3.modelo.Vida;

// Borre dos test referidos al parametro de regeneracion.

class VidaTest {

	@Test
	void test01UnaVidaRecibeDanioPorUnValorDeberiaReducirLaVida() {
		
		Vida vida = new Vida(100);
		
		vida.recibirDanioPor(10);
		
		assertEquals(vida.restante(),90);
	}
	
	@Test
	void test02UnaVidaRecibeDanioPorSuVidaMaximaSuVidaRestanteDeberiaSerCero() {
		
		Vida vida = new Vida(100);
		
		vida.recibirDanioPor(100);
		
		assertEquals(vida.restante(),0);
	}
	
	@Test
	void test03UnaVidaRecibeDanioPorEncimaDeSuVidaMaximaSuVidaRestanteDeberiaSerCero() {
		
		Vida vida = new Vida(100);
		
		vida.recibirDanioPor(200);
		
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
		
		vida.recibirDanioPor(50);
		vida.recuperarse();
		
		assertEquals(vida.restante(),55);
	}
	
	@Test
	void test07UnaVidaRecibeDanioPorSuVidaMaximaYSeRecuperaSuVidaRestanteDeberiaSerIgualASuRecuperacion() {
		
		Vida vida = new Vida(100);
		
		vida.recibirDanioPor(100);
		vida.recuperarse();
		
		assertEquals(vida.restante(),5);
	}
	
	@Test
	void test8UnaVidaRecibeDanioPorEncimaDeSuVidaMaximaYSeRecuperaSuVidaRestanteDeberiaSerIgualASuRecuperacion() {
		
		Vida vida = new Vida(100);
		
		vida.recibirDanioPor(1000);
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
		
		assertThrows(ValorInvalidoDeDanioError.class,()->{
			vida.recibirDanioPor(-100);
			});
	}
}
