package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Tiempo;

class MohoTest {

	@Test
	void test01UnNuevoMohoEmpiezaConRadioCinco() {
		
		Tiempo tiempo = new Tiempo(0);
		Moho moho = new Moho(5,tiempo);
		
		assertEquals(moho.radio(),5);
	}
	
	@Test
	void test02UnNuevoMohoAvanzaUnTurnoSuRadioDeberiaSerCinco() {
		
		Tiempo tiempo = new Tiempo(0);
		Moho moho = new Moho(5,tiempo);
		moho.avanzarTurno();
		
		assertEquals(moho.radio(),5);
	}
	
	@Test
	void test03UnNuevoMohoAvanzaDosTurnosSuRadioDeberiaSerSeis() {
		
		Tiempo tiempo = new Tiempo(0);
		Moho moho = new Moho(5,tiempo);
		moho.avanzarTurno();
		moho.avanzarTurno();
		
		assertEquals(moho.radio(),6);
	}
	
	@Test
	void test04UnNuevoMohoAvanzaDiezTurnosSuRadioDeberiaSerDiez() {
		
		Tiempo tiempo = new Tiempo(0);
		Moho moho = new Moho(5,tiempo);
		for(int i=0; i<10; i++) {
			moho.avanzarTurno();			
		}
		
		assertEquals(moho.radio(),10);
	}

}
