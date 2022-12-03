package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* Verificar que cada edificio/construccion tarda lo que dice que tarda y que recién están operativos
 * cuando ya se terminaron de construir*/

class CasoDeUso02Test {

	JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(10000,10000));
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(10000,10000));

	/* Protoss */

	@Test
	void test01SeConstruyeUnAccesoYNoSeEncuentraOperativo(){
		// Arrange
		Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

		// Falta implementar la logica de Acceso.
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test02SeConstruyeUnAsimiladorEnUnVolcanYNoSeEncuentraOperativoYaQueAlAvanzarUnTurnoNoExtraeGas(){
		Volcan volcan = new Volcan();
		Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
		asimilador.avanzarTurno();

		// Act
		int resultado = jugadorProtoss.obtenerGas();

		// Assert
		assertEquals(10000, resultado);
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test03SeConstruyeUnNexoMineralEnUnNodoMineralYNoSeEncuentraOperativoYaQueAlAvanzarUnTurnoNoRecolectaMineral() {
		// Arrange
		NodoMineral nodoMineral = new NodoMineral();
		NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
		nexoMineral.avanzarTurno();

		// Act
		int resultado = jugadorProtoss.obtenerMineral();

		// Assert
		assertEquals(9950, resultado);
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test04SeConstruyeUnPilonYNoSeEncuentraOperativo(){
		// Arrange
		Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

		// Falta implementar la logica de Pilon.
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test05SeConstruyeUnPuertoEstelarYNoSeEncuentraOperativo(){
		// Arrange
		PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);

		// Falta implementar la logica de Puerto Estelar.
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	/* Zerg */

	@Test
	void test06SeConstruyeUnCriaderoYNoSeEncuentraOperativo(){
		// Arrange
		Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

		// Falta implementar la logica de Criadero.
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test07SeConstruyeUnExtractorEnUnVolcanYNoSeEncuentraOperativoYaQueAlAvanzarUnTurnoNoExtraeGas(){
		// Arrange
		Volcan volcan = new Volcan();
		Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
		extractor.avanzarTurno();

		// Act
		int resultado = jugadorZerg.obtenerGas();

		// Assert
		assertEquals(10000, resultado);
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test08SeConstruyeUnaGuaridaYNoSeEncuentraOperativa(){
		// Arrange
		Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

		// Falta la logica de Guarida.
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test09SeConstruyeUnaReservaDeProduccionYNoSeEncuentraOperativa(){
		// Arrange
		ReservaDeProduccion rdp = new ReservaDeProduccion(new Ubicacion(0,0), jugadorZerg);

		// Falta la logica de la Reserva de Produccion.
	}

	/* ------------------------------------------------------------------------------------------------------------ */

	@Test
	void test10SeConstruyeUnaEspiralYNoSeEncuentraOperativa(){
		// Arrange
		Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

		// Falta la logica de Espiral.
	}
}
