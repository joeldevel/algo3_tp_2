package edu.fiuba.algo3.entrega_1;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Ubicacion;

class CasoDeUso06Test {
	
	/*Verificar el crecimiento del moho acorde a lo estipulado*/

	@Test
	void test01UnNuevoMohoEmpiezaSinUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		
		assertFalse(moho.tieneUbicacionesAfectadas());
	}
	
	@Test
	void test02SeAgregaUnNuevoOrigenAUnNuevoMohoDebeTenerUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		moho.agregarOrigen(new Ubicacion(0,0));
		
		assertTrue(moho.tieneUbicacionesAfectadas());
	}
	
	@Test
	void test03SeAgregaUnOrigenAUnNuevoNodoSeVerificanLasUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		moho.agregarOrigen(new Ubicacion(0,0));
		
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(-5,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(-4,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(-3,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(-2,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(-1,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(0,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(1,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(2,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(3,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(4,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(5,0)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(0,-5)));
		assertTrue(moho.estaAfectadaLaUbicacion(new Ubicacion(0,5)));
		
		assertEquals(moho.contarUbicacionesAfectadas(),81);
	}
	
	@Test
	void test04SeAgregaUnOrigenAUnNuevoMohoYLuegoDe2TurnosSeAgreganMasUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		moho.agregarOrigen(new Ubicacion(0,0));
		
		moho.avanzarTurno(2);
		
		assertEquals(moho.contarUbicacionesAfectadas(),113);
		
	}
	
	@Test
	void test05SeAgreganDosOrigenesAUnNuevoMohoYSeVerificanLasUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		moho.agregarOrigen(new Ubicacion(0,0));
		moho.agregarOrigen(new Ubicacion(0,20));
		
		assertEquals(moho.contarUbicacionesAfectadas(), 162);
	}
	
	@Test
	void test06SeAgreganDosOrigenesCercanosAUnNuevoMohoYSeVerificanLasUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		moho.agregarOrigen(new Ubicacion(0,0));
		moho.agregarOrigen(new Ubicacion(0,10));
		
		/* el (0,5) se comparte con los 2 origenes, por eso es 161 y no 162
		 * porque el (0,5) ya esta incluido cuando se agrega el origen (0,0)*/
		assertEquals(moho.contarUbicacionesAfectadas(),161);
	}
	
	@Test
	void test07SeAgreganOrigenesEnTurnosDiferentesYSeVerificaLaCantidadDeUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		moho.agregarOrigen(new Ubicacion(0,0));
		
		moho.avanzarTurno(2);
		
		moho.agregarOrigen(new Ubicacion(0,20));
		
		assertEquals(moho.contarUbicacionesAfectadas(),194);
	}
	
}
