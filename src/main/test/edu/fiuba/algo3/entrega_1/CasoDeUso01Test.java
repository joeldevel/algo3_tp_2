package edu.fiuba.algo3.entrega_1;


import static org.junit.jupiter.api.Assertions.*;

/* Criadero se inicia con 3 larvas, se consume una para engendrar un zangano le quedan 2 y después de
 * un turno vuelve a tener 3 larvas. Lo mismo al consumir 2 y las 3 larvas, verificar que se regeneren 
 * acorde a los tiempos estipulados*/

import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Recursos.Recursos;

/* Criadero se inicia con 3 larvas, se consume una para engendrar un zángano, le quedan 2 
 * y después de un turno vuelve a tener 3 larvas. Lo mismo al consumir 2 y las 3 larvas, verificar 
 * que se regeneren acorde a los tiempos estipulados.*/

class CasoDeUso01Test {

	Mapa mapa = new Mapa();
	Recursos recursos = new Recursos(10000,10000);
	
	@Test
	void test01UnNuevoCriaderoComienzaCon3Larvas() {
		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		
		assertEquals(criadero.contarLarvas(),3);
	}
	
	@Test
	void test02UnCriaderoOperativoCreaUnZanganoDeberiaTener2Larvas() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		
		assertEquals(criadero.contarLarvas(),2);
	}
	
	@Test
	void test03UnCriaderoOperativoCreaUnZanganoYLuegoDeUnTurnoDeberiaTener3Larvas() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		criadero.avanzarTurno();
		
		assertEquals(criadero.contarLarvas(),3);
	}
	
	@Test
	void test04UnCriaderoOperativoCrea2ZanganosDeberiaTenerUnaLarva() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		criadero.crearZangano();
		
		assertEquals(criadero.contarLarvas(),1);
	}
	
	@Test
	void test05UnCriaderoOperativoCrea2ZanganosYLuegoDeUnTurnoDeberiaTener2Larvas() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		criadero.crearZangano();
		criadero.avanzarTurno();
		
		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test06UnCriaderoOperativoCrea3ZanganosNoDeberiaTenerLarvas() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		criadero.crearZangano();
		criadero.crearZangano();
		
		assertEquals(criadero.contarLarvas(),0);
	}
	
	@Test
	void test07UnCriaderoOperativoCrea3ZanganosYLuegoDeUnTurnoDeberiaTenerUnaLarva() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		criadero.crearZangano();
		criadero.crearZangano();
		criadero.avanzarTurno();
		
		assertEquals(criadero.contarLarvas(),1);
	}
	
	@Test
	void test08UnCriaderoOperativoCrea2ZanganosYLuegoDe2TurnosVuelveATener3larvas() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		criadero.crearZangano();
		
		criadero.avanzarTurno(2);
		
		assertEquals(criadero.contarLarvas(),3);
	}
	
	@Test
	void test09UnCriaderoOperativoCrea3ZanganosYLuegoDe3TurnosVuelveATener3Larvas() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		criadero.crearZangano();
		criadero.crearZangano();
		criadero.avanzarTurno(3);
		
		assertEquals(criadero.contarLarvas(),3);
	}
	
	@Test
	void test10UnCriaderoOperativoNuncaRegeneraMasDe3Larvas() {

		JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
		criadero.avanzarTurno(4);
		
		criadero.crearZangano();
		criadero.crearZangano();
		criadero.crearZangano();
		criadero.avanzarTurno(10);
		
		assertEquals(criadero.contarLarvas(),3);
	}
	
		
}
