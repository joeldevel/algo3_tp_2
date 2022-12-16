package edu.fiuba.algo3.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoDeDanioException;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoParaEscudoException;

// Borre dos test referidos al parametro de regeneracion.

class EscudoTest {

	@Test
	void test01UnEscudoRecibeDanioDeberiaReducirLaProteccion() {

		Escudo escudo = new Escudo(100);
		
		escudo.recibirDanioPor(50);
		
		assertEquals(escudo.restante(),50);
	}
	
	@Test
	void test02UnEscudoRecibeDanioPorElValorDeSuProteccionMaximaSuProteccionRestanteDeberiaSerCero() {
		
		Escudo escudo = new Escudo(100);

		escudo.recibirDanioPor(100);
		
		assertEquals(escudo.restante(),0);
	}
	
	@Test
	void test03UnEscudoRecibeDanioPorEncimaDeSuProteccionMaximaSuProteccionRestanteDeberiaSerCero() {
		
		Escudo escudo = new Escudo(100);

		escudo.recibirDanioPor(1000);
		
		assertEquals(escudo.restante(),0);
	}
	
	@Test
	void test04SeIntentaInstanciarUnEscudoConSuProteccionMaximaNegativaSeDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaEscudoException.class,()->{
			new Escudo(-100);
			});
	}

	@Test
	void test05UnEscudoRecibeDanioYSeRecuperaDeberiaAumentarSuProteccion() {
		
		Escudo escudo = new Escudo(100);

		escudo.recibirDanioPor(50);
		escudo.recuperarse();
		
		assertEquals(escudo.restante(),55);
	}
	
	@Test 
	void test06UnEscudoRecibeDanioPorElValorDeSuProteccionMaximaYSeRecuperaSuProteccionDeberiaSerSuRecuperacion() {
		
		Escudo escudo = new Escudo(100);

		escudo.recibirDanioPor(100);
		escudo.recuperarse();
		
		assertEquals(escudo.restante(),5);
	}
	
	@Test
	void test7UnEscudoRecibeDanioPorEncimaDeSuProteccionMaximaYSeRecuperaSuProteccionDeberiaSerSuRecuperacion() {
		
		Escudo escudo = new Escudo(100);

		escudo.recibirDanioPor(100);
		escudo.recuperarse();
		
		assertEquals(escudo.restante(),5);
	}
	
	@Test
	void test8UnEscudoNoRecibeDanioYSeRecuperaSuProteccionDeberiaSerMaxima() {
		
		Escudo escudo = new Escudo(100);
		
		escudo.recuperarse();
		
		assertEquals(escudo.restante(),100);
	}
	
	@Test
	void test9UnEscudoRecibeDanioNegativoDeberiaLanzarUnaExcepcion() {
		
		Escudo escudo = new Escudo(500);
		
		assertThrows(ValorInvalidoDeDanioException.class,()->{
			escudo.recibirDanioPor(-100);
			});
	}
	
	
	
	
	
	

}
