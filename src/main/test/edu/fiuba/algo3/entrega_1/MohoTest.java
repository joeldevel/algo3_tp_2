package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Moho;

class MohoTest {

	@Test
	void test01UnMohoSeCreaConUnRadioDe5Unidades() {
		
		Moho moho = new Moho();
		
		assertEquals(moho.radio(),5);
		
	}
	
	@Test
	void test02UnNuevoMohoSeExpandeUnaVezSuRadioDeberiaSer6() {
		
		Moho moho = new Moho();
		
		moho.expandir();
		
		assertEquals(moho.radio(),6);
		
	}

}
