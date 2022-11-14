package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.FabricaDeEdificios;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.SinGas;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Unidades.Larva;
import edu.fiuba.algo3.modelo.Unidades.Zangano;


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
		
		criadero.avanzarTurno(4);

		assertTrue(criadero.sePuedeUtilizar());
	}

	@Test
	void test06UnCriaderoNuevoAvanzaCuatroTurnosSuTiempoDeEsperaDeberiaSerCero() {

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);

		assertEquals(criadero.tiempoDeEspera(),0);
	}

	@Test
	void test07UnCriaderoNuevoAvanzaCincoTurnosSuTiempoDeEsperaDeberiaSerCero() {
		
		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
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
	void test10UnCriaderoNuevoAvanzaDosTurnosSuRadioDeberiaSer5() {

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(2);

		assertEquals(criadero.radioDeMoho(),5);
	}

	@Test
	void test11UnCriaderoNuevoAvanzaTresTurnosSuRadioDeberiaSer5() {
		
		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(3);
		
		assertEquals(criadero.radioDeMoho(),5);
	}

	@Test
	void test12UnCriaderoNuevoAvanzaDiezTurnoSuRadioDeberiaSer8() {

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(10);

		assertEquals(criadero.radioDeMoho(),8);
	}

	/* habria que probar tambien que si un criadero no se puede utilizar, que cuando se quiere utilizar
	 * algun método que no me deje hacerlo. Podría probarse con una excepcion, pero la excepcion deberia
	 * manejar el error de manera adecuada, mostrando un mensaje por ejemplo, para que el programa no se
	 * interrumpa. En el juego si el jugador quiere realizar alguna accion con un edificio que todavia
	 * esta en construccion a pesar de no poder hacer nada con edificio, el jugador deberia poder seguir
	 * jugando*/

	@Test
	void test13UnNuevoCriaderoNoTieneLarvas() {
		
		Criadero criadero = new Criadero();
		
		assertEquals(criadero.contarLarvas(),0);
	}
	
	@Test
	void test14UnNuevoCriaderoQueAvanzaCuatroTurnoDeberiaTenerTresLarvas(){

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
		assertEquals(criadero.contarLarvas(),3);
	}

	@Test
	void test15UnCriaderoOperativoEngendraUnaZanganoDeberiaTenerDosLarvas() {
		
		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test16UnCriaderoOperativoConDosLarvasDeberiaTenerTresEnElSiguienteTurno() {

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),3);
	}

	@Test
	void test17UnCriaderoOperativoConsumeDosLarvasEnElProximoTurnoDebeTenerDos(){

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test18UnCriaderoOperativoConsumeTresLarvasEnElProximoTurnoDebeTenerUna(){

		Criadero criadero = new Criadero();
	
		criadero.avanzarTurno(4);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),1);
	}

	@Test
	void test19UnCriaderoOperativoQueConsumeUnaLarvaDeberiaTenerDosAntesDeAvanzarElTurno() {

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test20UnCriaderoOperativoConsumeDosLarvasDebeTenerUnaLarvaAntesDeAvanzarElTurno(){

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),1);
	}

	@Test
	void test21UnCriaderoOperativoConsumeTresLarvasNoDeberiaTenerLarvasAntesDeAvanzarDeTurno(){

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),0);
	}

	@Test
	void test22UnCriaderoOperativoSinLarvasQuiereConsumirUnaLarvaDeberiaLanzarUnaExcepcion(){
		
		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(4);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertThrows(CriaderoSinLarvasException.class,()->{
			criadero.engendrarZangano();
		});
	}

	@Test
	void test23UnCriaderoOperativoConTresLarvasAlPasarElTurnoDeberiaTenerTresLarvas() {

		Criadero criadero = new Criadero();
		
		criadero.avanzarTurno(5);

		assertEquals(criadero.contarLarvas(),3);
	}

	@Test
	void test23SeConstruyeUnCriaderoYRecibeDanio() {
		// Arrange
		Criadero criadero = new Criadero();
		
		criadero.recibirDanio(10);

		// Act
		int resultado = criadero.obtenerVida();

		// Assert
		assertEquals(resultado, 490);
	}

	@Test
	void test24SeConstruyeUnCriaderoQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente() {
		// Arrange
		Criadero criadero = new Criadero();
		
		criadero.recibirDanio(10);
		criadero.avanzarTurno();

		// Act
		int resultado = criadero.obtenerVida();

		// Assert
		assertEquals(resultado, 500);
	}
}