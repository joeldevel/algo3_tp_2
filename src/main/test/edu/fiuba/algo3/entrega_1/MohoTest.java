package edu.fiuba.algo3.entrega_1;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Recursos.Recursos;

class MohoTest {
	
	Recursos recursos = new Recursos(10000,10000);

	@Test
	void test01UnNuevoMohoEmpiezaSinUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		
		assertFalse(moho.tieneUbicacionesAfectadas());
	}
	
	@Test
	void test02SeAgregaUnNuevoCriaderoAUnNuevoMohoDebeTenerUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		Criadero criadero = new Criadero(recursos,new Ubicacion(0,0));
		moho.agregarCriadero(criadero);
		
		assertTrue(moho.tieneUbicacionesAfectadas());
	}
	
	@Test
	void test03SeAgregaUnCriaderoAUnNuevoNodoSeVerificanLasUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		Criadero criadero = new Criadero(recursos,new Ubicacion(0,0));
		moho.agregarCriadero(criadero);
		
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
	void test04SeAgregaUnCriaderoAUnNuevoMohoYLuegoDe2TurnosSeAgreganMasUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		Criadero criadero = new Criadero(recursos,new Ubicacion(0,0));
		moho.agregarCriadero(criadero);
		moho.avanzarTurno(2);
		
		assertEquals(moho.contarUbicacionesAfectadas(),113);
		
	}
	
	@Test
	void test05SeAgreganDosCriaderosAUnNuevoMohoYSeVerificanLasUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		Criadero criadero = new Criadero(recursos,new Ubicacion(0,0));
		moho.agregarCriadero(criadero);
		Criadero otroCriadero = new Criadero(recursos, new Ubicacion(0,20));
		moho.agregarCriadero(otroCriadero);
		
		assertEquals(moho.contarUbicacionesAfectadas(), 162);
	}
	
	@Test
	void test06SeAgreganDosCriaderosCercanosAUnNuevoMohoYSeVerificanLasUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		Criadero criadero = new Criadero(recursos,new Ubicacion(0,0));
		moho.agregarCriadero(criadero);
		Criadero otroCriadero = new Criadero(recursos, new Ubicacion(0,10));
		moho.agregarCriadero(otroCriadero);
		
		/* el (0,5) se comparte con los 2 origenes, por eso es 161 y no 162
		 * porque el (0,5) ya esta incluido cuando se agrega el origen (0,0)*/
		assertEquals(moho.contarUbicacionesAfectadas(),161);
	}
	
	@Test
	void test07SeAgreganOrigenesEnTurnosDiferentesYSeVerificaLaCantidadDeUbicacionesAfectadas() {
		
		Moho moho = new Moho();
		Criadero criadero = new Criadero(recursos,new Ubicacion(0,0));
		moho.agregarCriadero(criadero);
		moho.avanzarTurno(2);
		Criadero otroCriadero = new Criadero(recursos, new Ubicacion(0,20));
		moho.agregarCriadero(otroCriadero);
		
		assertEquals(moho.contarUbicacionesAfectadas(),194);
	}
	
	@Test
	void test08SiSeDestruyeUnCriaderoSeVerificaQueLasUbicacionesAfectadasNoDesaparecen() {
		
		Moho moho = new Moho();
		Criadero criadero = new Criadero(recursos,new Ubicacion(0,0));
		moho.agregarCriadero(criadero);
		moho.eliminarCriaderoEnUbicacion(new Ubicacion(0,0));
		
		assertEquals(moho.contarCriaderos(),0);
		assertEquals(moho.contarUbicacionesAfectadas(),81);
	}
	
}
