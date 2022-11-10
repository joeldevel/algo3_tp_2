package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.ValorInvalidoParaEscudoError;
import edu.fiuba.algo3.modelo.ValorInvalidoParaVidaError;
import edu.fiuba.algo3.modelo.Vida;

class EscudoTest {

	@Test
	void test01UnEscudoRecibeDanioDeberiaReducirLaProteccion() {
		
		Escudo escudo = new Escudo(100,10);
		
		escudo.recibirDanioPor(50);
		
		assertEquals(escudo.proteccion(),50);
	}
	
	@Test
	void test02UnEscudoRecibeDanioPorElValorDeSuProteccionMaximaSuProteccionRestanteDeberiaSerCero() {
		
		Escudo escudo = new Escudo(100,20);
		
		escudo.recibirDanioPor(100);
		
		assertEquals(escudo.proteccion(),0);
	}
	
	@Test
	void test03UnEscudoRecibeDanioPorEncimaDeSuProteccionMaximaSuProteccionRestanteDeberiaSerCero() {
		
		Escudo escudo = new Escudo(100,20);
		
		escudo.recibirDanioPor(1000);
		
		assertEquals(escudo.proteccion(),0);
	}
	
	@Test
	void test04SeIntentaInstanciarUnEscudoConSuProteccionMaximaNegativaSeDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaEscudoError.class,()->{
			new Escudo(-100,30);
			});
	}
	
	@Test
	void test05SeIntentaInstanciarUnEscudoConSuValorDeRecuperacionNegativoSeDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaEscudoError.class,()->{
			new Escudo(100,-30);
			});
	}
	
	@Test
	void test06SeIntentaInstanciarUnEscudoConElValorDeSuProteccionEnCeroSeDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaEscudoError.class,()->{
			new Escudo(0,30);
			});
	}
	
	@Test
	void test07SeIntentaInstanciarUnEscdoConElValorDeSuRecuperacionEnCeroSeDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaEscudoError.class,()->{
			new Escudo(100,0);
			});
	}
	
	@Test
	void test08UnEscudoRecibeDanioYSeRecuperaDeberiaAumentarSuProteccion() {
		
		Escudo escudo = new Escudo(100,35);
		
		escudo.recibirDanioPor(50);
		escudo.recuperarse();
		
		assertEquals(escudo.proteccion(),85);
	}
	
	@Test 
	void test09UnEscudoRecibeDanioPorElValorDeSuProteccionMaximaYSeRecuperaSuProteccionDeberiaSerSuRecuperacion() {
		
		Escudo escudo = new Escudo(100,50);
		
		escudo.recibirDanioPor(100);
		escudo.recuperarse();
		
		assertEquals(escudo.proteccion(),50);
	}
	
	
	
	

}
