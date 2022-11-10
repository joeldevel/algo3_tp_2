package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoDeEdificio;
import edu.fiuba.algo3.modelo.Larva;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.SinGas;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Zangano;

class CriaderoTest {

	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	ArrayList<Larva> larvas = new ArrayList<Larva>();
	EstadoDeEdificio estado = new EnConstruccion();
	Tiempo tiempo = new Tiempo(-4);
	Moho moho = new Moho(5,new Tiempo(0));
	Vida vida = new Vida(500,10);

	@Test
	void test01UnCriaderoNuevoNoDeberiaPoderSerUtilizado() {
		
		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);

		assertFalse(criadero.sePuedeUtilizar());
	}

	@Test
	void test02UnCriaderoNuevoDeberiaTenerUnTiempoDeEsperaDe4() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		assertEquals(criadero.tiempoDeEspera(),4);
	}

	@Test
	void test03UnCriaderoNuevoAvanzaUnTurnoDeberiaSeguirSinPoderseUtilizar() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();

		assertFalse(criadero.sePuedeUtilizar());
	}

	@Test
	void test04UnCriaderoNuevoAvanzaUnTurnoDeberiaTenerUnTiempoDeEsperaDe3() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();

		assertEquals(criadero.tiempoDeEspera(),3);
	}

	@Test
	void test05UnCriaderoNuevoAvanzaCuatroTurnosSeDeberiaPoderUtilizar() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertTrue(criadero.sePuedeUtilizar());
	}

	@Test
	void test06UnCriaderoNuevoAvanzaCuatroTurnosSuTiempoDeEsperaDeberiaSerCero() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertEquals(criadero.tiempoDeEspera(),0);
	}

	@Test
	void test07UnCriaderoNuevoAvanzaCincoTurnosSuTiempoDeEsperaDeberiaSerCero() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertEquals(criadero.tiempoDeEspera(),0);
	}

	@Test
	void test08UnCriaderoNuevoTieneUnMohoDeRadio5() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		assertEquals(criadero.radioDeMoho(),5);
	}

	@Test
	void test09UnCriaderoNuevoAvanzaUnTurnoSuRadioDeberiaSer5() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();

		assertEquals(criadero.radioDeMoho(),5);
	}

	@Test
	void test10UnCriaderoNuevoAvanzaDosTurnosSuRadioDeberiaSer6() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertEquals(criadero.radioDeMoho(),6);
	}

	@Test
	void test11UnCriaderoNuevoAvanzaTresTurnosSuRadioDeberiaSer6() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();
		criadero.avanzarTurno();
		criadero.avanzarTurno();

		assertEquals(criadero.radioDeMoho(),6);
	}

	@Test
	void test12UnCriaderoNuevoAvanzaDiezTurnoSuRadioDeberiaSer10() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
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

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		assertEquals(criadero.contarLarvas(),3);
	}

	@Test
	void test14UnCriaderoNuevoEngendraUnaZanganoDeberiaTenerDosLarvas() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test15UnCriaderoConDosLarvasDeberiaTenerTresEnElSiguienteTurno() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),3);
	}

	@Test
	void test16UnCriaderoConsumeDosLarvasEnElProximoTurnoDebeTenerDos(){

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test17UnCriaderoConsumeTresLarvasEnElProximoTurnoDebeTenerUna(){

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),1);
	}

	@Test
	void test18UnCriaderoQueConsumeUnaLarvaDeberiaTenerDosAntesDeAvanzarElTurno() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),2);
	}

	@Test
	void test19UnCriaderoConsumeDosLarvasDebeTenerUnaLarvaAntesDeAvanzarElTurno(){

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),1);
	}

	@Test
	void test20UnCriaderoConsumeTresLarvasNoDeberiaTenerLarvasAntesDeAvanzarDeTurno(){

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertEquals(criadero.contarLarvas(),0);
	}

	@Test
	void test21UnCriaderoSinLarvasQuiereConsumirUnaLarvaDeberiaLanzarUnaExcepcion(){

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.engendrarZangano();
		criadero.engendrarZangano();
		criadero.engendrarZangano();

		assertThrows(CriaderoSinLarvasException.class,()->{
			criadero.engendrarZangano();
		});
	}

	@Test
	void test22UnCriaderoConTresLarvasAlPasarElTurnoDeberiaTenerTresLarvas() {

		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.avanzarTurno();

		assertEquals(criadero.contarLarvas(),3);
	}

	@Test
	void test23SeConstruyeUnCriaderoYRecibeDanio() {
		// Arrange
		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.recibirDanio(10);

		// Act
		int resultado = criadero.obtenerVida();

		// Assert
		assertEquals(resultado, 490);
	}

	@Test
	void test24SeConstruyeUnCriaderoQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente() {
		// Arrange
		requisitos.add(new SinGas());
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());			
		}
		
		Criadero criadero = new Criadero(estado,tiempo,moho,requisitos,larvas,vida);
		
		criadero.recibirDanio(10);
		criadero.avanzarTurno();

		// Act
		int resultado = criadero.obtenerVida();

		// Assert
		assertEquals(resultado, 500);
	}
}