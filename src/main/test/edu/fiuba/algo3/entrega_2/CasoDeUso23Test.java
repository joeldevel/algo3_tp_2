package edu.fiuba.algo3.entrega_2;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;

/* Verificar que una unidad no pueda dañar a la otra o a un edificio si no esta en el rango de ataque de la misma*/

/*Supuesto: una unidad Zerg solo puede daniar a una unidad o un edificio Protoss*/

class CasoDeUso23Test {

	/* Unidades Zerg */

	@Test
	void test01UnaUnidadZerlingEn00NoPuedeDaniarAUnaUnidadZealotEn02() {

		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,2);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			zerling.atacar(zealot);			
		});
	}
	
	@Test
	void test02UnaUnidadZerlingEn00PuedeAtacarAUnaUnidadZealotEn01() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,1);
		Zealot zealot = new Zealot(ubicacion2);
		
		zerling.atacar(zealot);
		
		assertEquals(zealot.escudoRestante(),56);
	}
	
	@Test
	void test03UnaUnidadZerlingEn00NoPuedeAtacarAUnaUnidadZealotEn11() {
		
		/* el rango de ataque es 1 y la distancia 1.41, no lo puede atacar*/
	
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(1,1);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			zerling.atacar(zealot);			
		});
	}
	
	@Test
	void test04UnaUnidadZerlingEn00PuedeAtacarAUnaUnidadZealotEn00() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion2);
		
		zerling.atacar(zealot);
		
		assertEquals(zealot.escudoRestante(),56);
	}
	
	@Test
	void test05UnaUnidadHidraliscoEn00NoPuedeAtacarAUnaUnidadZealotEn05() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Hidralisco hidralisco = new Hidralisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,5);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			hidralisco.atacar(zealot);
		});
	}
	
	@Test
	void test06UnaUnidadHidraliscoEn00NoPuedeAtacarAUnaUnidadZealotEn44() {
		
		/* el rango es 4 y la distancia 5.6, no puede atacarlo*/
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Hidralisco hidralisco = new Hidralisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(4,4);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			hidralisco.atacar(zealot);
		});
	}
	
	@Test
	void test07UnaUnidadHidraliscoEn00NoPuedeAtaacarAUnaUnidadZealotEn4Menos3(){
		
		/* el rango es 4 y la distancia 5, no puede atacarlo*/
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Hidralisco hidralisco = new Hidralisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(4,-3);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			hidralisco.atacar(zealot);
		});
	}
	
	@Test
	void test08UnaUnidadHidraliscoEn00NoPuedeAtacarAUnaUnidadZealotEn33() {
		
		/* el rango es 4 y la distancia 4.2, no puede atacarlo*/
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Hidralisco hidralisco = new Hidralisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(3,3);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			hidralisco.atacar(zealot);
		});
	}
	
	@Test
	void test09UnaUnidadHidraliscoEn00PuedeAtacarAUnaUnidadZealotEnMeno3Menos2() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Hidralisco hidralisco = new Hidralisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(-3,-2);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertDoesNotThrow(() -> hidralisco.atacar(zealot));
	}
	
	@Test
	void test10UnaUnidadHidralisconEn00PuedeAtacarAUnaUnidadZealotEn00() {
	
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Hidralisco hidralisco = new Hidralisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertDoesNotThrow(() -> hidralisco.atacar(zealot));
	}
	
	@Test
	void test11UnaUnidadMutaliscoEn00NoPuedeAtacarAUnaUnidadZealotEn04() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Mutalisco mutalisco = new Mutalisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,4);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			mutalisco.atacar(zealot);
		});		
	}
	
	@Test
	void test12UnaUnidadMutaliscoEn00NoPuedeAtacarAUnaUnidadZealotEn33() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Mutalisco mutalisco = new Mutalisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(3,3);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			mutalisco.atacar(zealot);
		});		
	}
	
	@Test
	void test13UnaUnidadMutaliscoEn00NoPuedeAtacarAUnaUnidadZealotEn32() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Mutalisco mutalisco = new Mutalisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(3,2);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			mutalisco.atacar(zealot);
		});		
	}
	
	@Test
	void test14UnaUnidadMutaliscoEn00PuedeAtacarAUnaUnidadZealotEn22() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Mutalisco mutalisco = new Mutalisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(2,2);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertDoesNotThrow( ()->{
			mutalisco.atacar(zealot);
		});		
	}
	
	@Test
	void test15UnaUnidadMutaliscoEn00PuedeAtacarAUnaUnidadZealotEn30() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Mutalisco mutalisco = new Mutalisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(3,0);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertDoesNotThrow(()->{
			mutalisco.atacar(zealot);
		});		
	}
	
	@Test
	void test16UnaUnidadMutaliscoEn00PuedeAtacarAUnaUnidadZealotEn00() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Mutalisco mutalisco = new Mutalisco(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertDoesNotThrow(()->{
			mutalisco.atacar(zealot);
		});		
	}
	
	@Test
	void test17UnaUnidadGuardianEn00NoPuedeAtacarAUnaUnidadZealotEn011() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Guardian guardian = new Guardian(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,11);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			guardian.atacar(zealot);
		});		
	}
	
	@Test
	void test18UnaUnidadGuardianEn00NoPuedeAtacarAUnaUnidadZealotEn88() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Guardian guardian = new Guardian(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(8,8);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			guardian.atacar(zealot);
		});		
	}
	
	@Test
	void test19UnaUnidadGuardianEn00PuedeAtacarAUnaUnidadZealotEnMenos7Menos7() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Guardian guardian = new Guardian(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(-7,-7);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertDoesNotThrow(()->{
			guardian.atacar(zealot);
		});		
	}
	
	@Test
	void test20UnaUnidadGuardianEn00PuedeAtacarAUnaUnidadZealotEn100() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Guardian guardian = new Guardian(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(10,0);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertDoesNotThrow(()->{
			guardian.atacar(zealot);
		});		
	}
	
	@Test
	void test21UnaUnidadGuardianEn00PuedeAtacarAUnaUnidadZealotEn00() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Guardian guardian = new Guardian(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion2);
		
		assertDoesNotThrow(()->{
			guardian.atacar(zealot);
		});		
	}

	/* Unidades Protoss */
	
	@Test
	void test22UnaUnidadZealotEn00NoPuedeAtacarAUnaUnidadZerlingEn02() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,2);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			zealot.atacar(zerling);
		});		
	}
	
	@Test
	void test23UnaUnidadZealotEn00NoPuedeAtacarAUnaUnidadZerlingEn11() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(1,1);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			zealot.atacar(zerling);
		});		
	}
	
	@Test
	void test24UnaUnidadZealotEn00PuedeAtacarAUnaUnidadZerlingEn01() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,1);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertDoesNotThrow(()->{
			zealot.atacar(zerling);
		});		
	}
	
	@Test
	void test25UnaUnidadZealotEn00PuedeAtacarAUnaUnidadZerlingEn00() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertDoesNotThrow(()->{
			zealot.atacar(zerling);
		});		
	}
	
	@Test
	void test26UnaUnidadDragonEn00NoPuedeAtacarAUnaUnidadZerlingEn05() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Dragon dragon = new Dragon(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,5);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			dragon.atacar(zerling);
		});		
	}
	
	@Test
	void test27UnaUnidadDragonEn00NoPuedeAtacarAUnaUnidadZerlingEn44() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Dragon dragon = new Dragon(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(4,4);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			dragon.atacar(zerling);
		});		
	}
	
	@Test
	void test28UnaUnidadDragonEn00NoPuedeAtacarAUnaUnidadZerlingEn33() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Dragon dragon = new Dragon(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(3,3);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			dragon.atacar(zerling);
		});		
	}
	
	@Test
	void test29UnaUnidadDragonEn00PuedeAtacarAUnaUnidadZerlingEn22() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Dragon dragon = new Dragon(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(2,2);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertDoesNotThrow(()->{
			dragon.atacar(zerling);
		});		
	}
	
	@Test
	void test30UnaUnidadDragonEn00NoPuedeAtacarAUnaUnidadZerlingEn00() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Dragon dragon = new Dragon(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertDoesNotThrow(()->{
			dragon.atacar(zerling);
		});		
	}
	
	@Test
	void test31UnaUnidadScoutEn00NoPuedeAtacarAUnaUnidadZerlingEn05() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Scout scout = new Scout(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,5);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			scout.atacar(zerling);
		});		
	}
	
	@Test
	void test32UnaUnidadScoutEn00NoPuedeAtacarAUnaUnidadZerlingEn33() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Scout scout = new Scout(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(3,3);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertThrows(AtacableFueraDeRangoError.class, ()->{
			scout.atacar(zerling);
		});		
	}
	
	@Test
	void test33UnaUnidadScoutEn00PuedeAtacarAUnaUnidadZerlingEn23() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Scout scout = new Scout(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(2,3);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertDoesNotThrow(()->{
			scout.atacar(zerling);
		});		
	}

	@Test
	void test34UnaUnidadScoutEn00PuedeAtacarAUnaUnidadZerlingEn00() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Scout scout = new Scout(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion2);
		
		assertDoesNotThrow(()->{
			scout.atacar(zerling);
		});		
	}

	/* Unidades Zerg y edificios Protoss */

	@Test
	void test35UnaUnidadZerlingEn00NoPuedeDaniarAUnAccesoEn02() {

		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(0,2);
		Recursos recursos = new Recursos(0, 150);
		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
		Acceso acceso = new Acceso(recursos, ubicacion2, jugadorProtoss);

		assertThrows(AtacableFueraDeRangoError.class, ()->{
			zerling.atacar(acceso);
		});
	}

	@Test
	void test36UnaUnidadZerlingEn00PuedeAtacarAUnAccesoEn01() {

		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zerling zerling = new Zerling(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(0,1);
		Recursos recursos = new Recursos(0, 150);
		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
		Acceso acceso = new Acceso(recursos, ubicacion2, jugadorProtoss);

		zerling.atacar(acceso);

		assertEquals(496, acceso.obtenerEscudo());
	}

	/* Unidades Protoss y edificios Zerg */

	@Test
	void test37UnaUnidadZealotEn00NoPuedeAtacarAUnCriaderoEn02() {

		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(0,2);
		Recursos recursos = new Recursos(0, 200);
		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
		Criadero criadero = new Criadero(recursos, ubicacion2, jugadorProtoss);

		assertThrows(AtacableFueraDeRangoError.class, ()->{
			zealot.atacar(criadero);
		});
	}

	@Test
	void test38UnaUnidadZealotEn00PuedeAtacarAUnCriaderoEn01() {

		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Zealot zealot = new Zealot(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(0,1);
		Recursos recursos = new Recursos(0, 200);
		JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
		Criadero criadero = new Criadero(recursos, ubicacion2, jugadorProtoss);

		zealot.atacar(criadero);

		assertEquals(492, criadero.obtenerVida());
	}
}