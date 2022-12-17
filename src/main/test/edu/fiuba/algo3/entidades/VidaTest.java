package edu.fiuba.algo3.entidades;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.CONSTRUCCION_ZERLING;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoParaVidaException;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoDeDanioException;
import edu.fiuba.algo3.modelo.Vida;

// Borre dos test referidos al parametro de regeneracion.

class VidaTest {

	Mapa mapa = new Mapa();
    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000), mapa);
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(1000,1000), mapa);

	@Test
	void test01UnaVidaRecibeDanioPorUnValorDeberiaReducirLaVida() {
	    // Arrange
		Vida vida = new Vida(100);

		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

		// Act
		vida.recibirDanioPor(10, zerling, pilon, jugadorProtoss);

		// Assert
		assertEquals(vida.restante(),90);
	}
	
	@Test
	void test02UnaVidaRecibeDanioPorSuVidaMaximaSuVidaRestanteDeberiaSerCero() {
        // Arrange
        Vida vida = new Vida(100);

        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        // Act
        vida.recibirDanioPor(100, zerling, pilon, jugadorProtoss);

        // Assert
		assertEquals(vida.restante(),0);
	}
	
	@Test
	void test03UnaVidaRecibeDanioPorEncimaDeSuVidaMaximaSuVidaRestanteDeberiaSerCero() {
        // Arrange
        Vida vida = new Vida(100);

        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        // Act
        vida.recibirDanioPor(200, zerling, pilon, jugadorProtoss);

        // Assert
		assertEquals(vida.restante(),0);
	}
	
	@Test
	void test04SeIntentaInstanciarUnaVidaConSuVidaMaximaNegativaDeberiaLanzarUnaExcepcion() {
		
		assertThrows(ValorInvalidoParaVidaException.class,()->{
		new Vida(-1);
		});
	}
	
	@Test
	void test05SeIntentaInstanciarUnaVidaConSuVidaMaximaEnCeroDeberiaLanzarUnaExcepcion() {

		assertThrows(ValorInvalidoParaVidaException.class,()->{
		new Vida(0);
		});
	}
	
	@Test
	void test06UnaVidaRecibeDanioYSeRecuperaDeberiaTenerSuVidaRestanteAumentada() {
        // Arrange
        Vida vida = new Vida(100);

        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        vida.recibirDanioPor(50, zerling, pilon, jugadorProtoss);

        // Act
		vida.recuperarse();

		// Assert
		assertEquals(vida.restante(),55);
	}
	
	@Test
	void test07UnaVidaRecibeDanioPorSuVidaMaximaYSeRecuperaSuVidaRestanteDeberiaSerIgualASuRecuperacion() {
        // Arrange
        Vida vida = new Vida(100);

        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        vida.recibirDanioPor(100, zerling, pilon, jugadorProtoss);

        // Act
        vida.recuperarse();

        // Assert
		assertEquals(vida.restante(),5);
	}
	
	@Test
	void test8UnaVidaRecibeDanioPorEncimaDeSuVidaMaximaYSeRecuperaSuVidaRestanteDeberiaSerIgualASuRecuperacion() {
        // Arrange
        Vida vida = new Vida(100);

        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        vida.recibirDanioPor(1000, zerling, pilon, jugadorProtoss);

        // Act
        vida.recuperarse();

        // Assert
		assertEquals(vida.restante(),5);
	}
	
	@Test
	void test9UnaVidaNoRecibeDanioYSeRecuperaSuVidaRestanteDeberiaSerIgualASuVidaMaxima() {
		// Arrange
		Vida vida = new Vida(100);

		// Act
		vida.recuperarse();

		// Assert
		assertEquals(vida.restante(),100);
	}
	
	@Test
	void test10UnaVidaRecibeDanioNegativoDeberiaLanzarUnaExcepcion() {
        // Arrange
        Vida vida = new Vida(100);

        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        // Act & Assert
		assertThrows(ValorInvalidoDeDanioException.class,()->{
            vida.recibirDanioPor(-10, zerling, pilon, jugadorProtoss);
			});
	}
}
