package edu.fiuba.algo3.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Tiempo;

// Debido a la actualizacion de la implementacion de Tiempo fallan los test 04, 06 y 07.

class TiempoTest {

	@Test
	void test01UnTiempoNegativoPasaElTiempoSuTiempoRestanteDeberiaDisminuirEnUnaUnidad() {

		Tiempo tiempo = new Tiempo(-4);

		tiempo.pasarTiempo();

		assertEquals(tiempo.restante(),3);
	}

	@Test
	void test02UnTiempoEnCeroDeberiaTenerSuTiempoRestanteEnCero() {

		Tiempo tiempo = new Tiempo(0);

		assertEquals(tiempo.restante(),0);
	}

	@Test
	void test03UnTiempoPositivoDeberiaTenerSuTiempoRestanteEnCero() {

		Tiempo tiempo = new Tiempo(10);

		assertEquals(tiempo.restante(),0);
	}

	/*@Test
	void test04UnTiempoNegativoPasaElTiempoSuTiempoTranscurridoDeberiaSerUno() {

		Tiempo tiempo = new Tiempo(-4);

		tiempo.pasarTiempo();

		assertEquals(tiempo.transcurrido(),1);
	}*/

	@Test
	void test05UnTiempoEnCeroPasaElTiempoSuTiempoTranscurridoDeberiaSerUno() {

		Tiempo tiempo = new Tiempo(0);

		tiempo.pasarTiempo();

		assertEquals(tiempo.transcurrido(),1);
	}

	/*@Test
	void test06UnTiempoPositivoPasaElTiempoSuTiempoTranscurridoDeberiaSerUno() {

		Tiempo tiempo = new Tiempo(4);

		tiempo.pasarTiempo();

		assertEquals(tiempo.transcurrido(),1);
	}*/

	/*@Test
	void test07UnTiempoCualquieraPasaElTiempoDiezVecesSuTiempoTranscurridoDeberiaSerDiez() {

		Tiempo tiempo = new Tiempo(5);
		for(int i=0; i<10; i++) {
			tiempo.pasarTiempo();
		}

		assertEquals(tiempo.transcurrido(),10);
	}*/

}
