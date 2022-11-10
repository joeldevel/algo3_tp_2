package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.ValorInvalidoParaVidaError;
import edu.fiuba.algo3.modelo.ValorInvalidoDeDanioError;
import edu.fiuba.algo3.modelo.Vida;

class VidaTest {

	@Test
	void test01UnaVidaRecibeDanioPorUnValorDeberiaReducirLaVida() {
		
		Vida vida = new Vida(100,10);
		
		vida.recibirDanioPor(10);
		
		assertEquals(vida.restante(),90);
	}
	
	@Test
	void test02UnaVidaRecibeDanioPorSuVidaMaximaSuVidaRestanteDeberiaSerCero() {
		
		Vida vida = new Vida(100,10);
		
		vida.recibirDanioPor(100);
		
		assertEquals(vida.restante(),0);
	}
	
	@Test
	void test03UnaVidaRecibeDanioPorEncimaDeSuVidaMaximaSuVidaRestanteDeberiaSerCero() {
		
		Vida vida = new Vida(100,10);
		
		vida.recibirDanioPor(200);
		
		assertEquals(vida.restante(),0);
	}
	
	@Test
	void test04SeIntentaInstanciarUnaVidaConSuVidaMaximaNegativaDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaVidaError.class,()->{
		new Vida(-1,5);
		});
	}
	
	@Test
	void test05SeIntentaInstanciarUnaVidaConRecuperacionNegativaDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaVidaError.class,()->{
		new Vida(100,-1);
		});
	}
	
	@Test
	void test06SeIntentaInstanciarUnaVidaConSuVidaMaximaEnCeroDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaVidaError.class,()->{
		new Vida(0,5);
		});
	}
	
	@Test
	void test07SeIntentaInstanciarUnaVidaConSuRecuperacionEnCeroDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaVidaError.class,()->{
		new Vida(100,0);
		});
	}
	
	@Test
	void test08UnaVidaRecibeDanioYSeRecuperaDeberiaTenerSuVidaRestanteAumentada() {
		
		Vida vida = new Vida(100,10);
		
		vida.recibirDanioPor(50);
		vida.recuperarse();
		
		assertEquals(vida.restante(),60);
	}
	
	@Test
	void test09UnaVidaRecibeDanioPorSuVidaMaximaYSeRecuperaSuVidaRestanteDeberiaSerIgualASuRecuperacion() {
		
		Vida vida = new Vida(100,10);
		
		vida.recibirDanioPor(100);
		vida.recuperarse();
		
		assertEquals(vida.restante(),10);
	}
	
	@Test
	void test10UnaVidaRecibeDanioPorEncimaDeSuVidaMaximaYSeRecuperaSuVidaRestanteDeberiaSerIgualASuRecuperacion() {
		
		Vida vida = new Vida(100,10);
		
		vida.recibirDanioPor(1000);
		vida.recuperarse();
		
		assertEquals(vida.restante(),10);
	}
	
	@Test
	void test11UnaVidaNoRecibeDanioYSeRecuperaSuVidaRestanteDeberiaSerIgualASuVidaMaxima() {
		
		Vida vida = new Vida(100,10);
		
		vida.recuperarse();
		
		assertEquals(vida.restante(),100);
	}
	
	@Test
	void test12UnaVidaRecibeDanioNegativoDeberiaLanzarUnaExcepcion() {
		
		Vida vida = new Vida(100,10);
		
		assertThrows(ValorInvalidoDeDanioError.class,()->{
			vida.recibirDanioPor(-100);
			});
	}

}
