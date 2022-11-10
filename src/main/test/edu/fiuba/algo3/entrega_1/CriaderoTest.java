package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Larva;
import edu.fiuba.algo3.modelo.Zangano;

class CriaderoTest {


	@Test
	void test01UnCriaderoNuevoNoDeberiaPoderSerUtilizado() {

		Criadero criadero = new Criadero();

		assertFalse(criadero.sePuedeUtilizar());
	}

	@Test
	void test02UnCriaderoNuevoDeberiaTenerUnTiempoDeEsperaDe4() {

		Criadero criadero = new Criadero();

		assertEquals(criadero.tiempoDeEspera(),4);
	}

	@Test
	void test03UnCriaderoNuevoAvanzaUnTurnoDeberiaSeguirSinPoderseUtilizar() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();

		assertFalse(criadero.sePuedeUtilizar());
	}

	@Test
	void test04UnCriaderoNuevoAvanzaUnTurnoDeberiaTenerUnTiempoDeEsperaDe3() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();

		assertEquals(criadero.tiempoDeEspera(),3);
	}

	@Test
	void test05UnCriaderoNuevoAvanzaCuatroTurnosSeDeberiaPoderUtilizar() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertTrue(criadero.sePuedeUtilizar());
	}

	@Test
	void test06UnCriaderoNuevoAvanzaCuatroTurnosSuTiempoDeEsperaDeberiaSerCero() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertEquals(criadero.tiempoDeEspera(),0);
	}

	@Test
	void test07UnCriaderoNuevoAvanzaCincoTurnosSuTiempoDeEsperaDeberiaSerCero() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertEquals(criadero.tiempoDeEspera(),0);
	}

	@Test
	void test08UnCriaderoNuevoTieneUnMohoDeRadio5() {

		Criadero criadero = new Criadero();

		assertEquals(criadero.radioDeMoho(),5);
	}

	@Test
	void test09UnCriaderoNuevoAvanzaUnTurnoSuRadioDeberiaSer5() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();

		assertEquals(criadero.radioDeMoho(),5);
	}

	@Test
	void test10UnCriaderoNuevoAvanzaDosTurnosSuRadioDeberiaSer6() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertEquals(criadero.radioDeMoho(),6);
	}

	@Test
	void test11UnCriaderoNuevoAvanzaTresTurnosSuRadioDeberiaSer6() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertEquals(criadero.radioDeMoho(),6);
	}

	@Test
	void test12UnCriaderoNuevoAvanzaDiezTurnoSuRadioDeberiaSer10() {

		Criadero criadero = new Criadero();

		for(int i=0; i<10; i++) {
			criadero.avanzarTurno();
		}

		assertEquals(criadero.radioDeMoho(),10);
	}

	/* habria que probar tambien que si un criadero no se puede utilizar, que cuando se quiere utilizar
	 * algun método que no me deje hacerlo. Podría probarse con una excepcion, pero la excepcion deberia
	 * manejar el error de manera adecuada, mostrando un mensaje por ejemplo, para que el programa no se
	 * interrumpa. En el juego si el jugador quiere realizar alguna accion con un edificio que todavia
	 * esta en construccion a pesar de no poder hacer nada con edificio, el jugador deberia poder seguir
	 * jugando*/


	@Test
	void test13UnNuevoCriaderoNuevoDeberiaEmpezarConTresLarvas(){

		/* quizas deba emplearse la clase Unidad y que dentro de ella se guarde la cantidad de larvas
		 * y un objeto de tipo Larva. En caso de que le pidan una larva desde afuera para crear un zangano
		 * la clase Unidad deberia crear con new una nueva larva o una copia y devolverla*/

		Criadero criadero = new Criadero();

		assertEquals(criadero.contarLarvas(),3);
	}

	@Test
	void test14UnCriaderoNuevoEngendraUnaZanganoDeberiaTenerDosLarvas() {

		Criadero criadero = new Criadero();

		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test15UnCriaderoConDosLarvasDeberiaTenerTresEnElSiguienteTurno() {

		Criadero criadero = new Criadero();
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),3);
	}

	@Test
	void test16UnCriaderoConsumeDosLarvasEnElProximoTurnoDebeTenerDos(){

		Criadero criadero = new Criadero();

		criadero.engendrarZangano();
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test17UnCriaderoConsumeTresLarvasEnElProximoTurnoDebeTenerUna(){

		Criadero criadero = new Criadero();

		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),1);
	}

	@Test
	void test18UnCriaderoQueConsumeUnaLarvaDeberiaTenerDosAntesDeAvanzarElTurno() {

		Criadero criadero = new Criadero();
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test19UnCriaderoConsumeDosLarvasDebeTenerUnaLarvaAntesDeAvanzarElTurno(){

		Criadero criadero = new Criadero();

		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),1);
	}

	@Test
	void test20UnCriaderoConsumeTresLarvasNoDeberiaTenerLarvasAntesDeAvanzarDeTurno(){

		Criadero criadero = new Criadero();

		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),0);
	}

	@Test
	void test21UnCriaderoSinLarvasQuiereConsumirUnaLarvaDeberiaLanzarUnaExcepcion(){

		Criadero criadero = new Criadero();

		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertThrows(CriaderoSinLarvasException.class,()->{
			criadero.engendrarZangano();
		});
	}

	@Test
	void test22UnCriaderoConTresLarvasAlPasarElTurnoDeberiaTenerTresLarvas() {

		Criadero criadero = new Criadero();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),3);
	}
}