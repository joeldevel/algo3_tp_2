package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.FabricaDeEdificios;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;

class CasoDeUso14Test {

	/* -Un pilon no puede energizar un area ya cubierta por moho(Es decir, las construcciones 
	 * protoss no se pueden hacer sobre moho, por mas que esten dentro del alcance de un pilon)
	 * -El moho se puede expandir por un area no ocupada(es decir, que no tenga un edificio
	 * ya construido) aunque esta este energizada por un pilon*/

	Mapa mapa = new Mapa();
	JugadorZerg jugadorZerg = new JugadorZerg("Brian","Azul", new Recursos(10000,10000), mapa);
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Leo","Rojo", new Recursos(10000,10000), mapa);
	
	@Test
	void test01HayUnPilonCercaDelMohoPorLoQueNoSePuedeConstruirUnEdificioProtoss() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(7,0);
		Ubicacion ubicacion3 = new Ubicacion(5,0);
		Ubicacion ubicacion4 = new Ubicacion(4,0);
		Ubicacion ubicacion5 = new Ubicacion(4,1);
		Ubicacion ubicacion6 = new Ubicacion(6,0);
		
		FabricaDeEdificios.construir("Criadero", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Pilon", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		
		mapa.agregarVolcan(ubicacion4);
		mapa.agregarNodoMineral(ubicacion5);
		
		FabricaDeEdificios.construir("NexoMineral", ubicacion5, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Asimilador", ubicacion4, jugadorZerg, jugadorProtoss, mapa);
		FabricaDeEdificios.construir("Acceso", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorProtoss.verificarEdificio("NexoMineral"));
		assertFalse(jugadorProtoss.verificarEdificio("Asimilador"));
		assertFalse(jugadorProtoss.verificarEdificio("Acceso"));
		
		FabricaDeEdificios.construir("Acceso", ubicacion6, jugadorZerg, jugadorProtoss, mapa);
		
		assertTrue(jugadorProtoss.verificarEdificio("Acceso"));
		
		FabricaDeEdificios.construir("PuertoEstelar", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		assertFalse(jugadorProtoss.verificarEdificio("PuertoEstelar"));
	}
	
	@Test
	void test02HayEdificiosProtossEnUbicacionesYCuandoElMohoCreceNoAfectaLasUbicaciones() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(6,0);
		Ubicacion ubicacion3 = new Ubicacion(5,-1);
		Ubicacion ubicacion4 = new Ubicacion(5,1);
		Ubicacion ubicacion5 = new Ubicacion(5,-2);
		Ubicacion ubicacion6 = new Ubicacion(5,2);
		
		Moho moho = new Moho();
		
		ArrayList<Edificio> edificios = new ArrayList<Edificio>();
		edificios.add(new Pilon(ubicacion2,jugadorProtoss));
		edificios.add(new NexoMineral(new NodoMineral(ubicacion3),ubicacion3,jugadorProtoss));
		edificios.add(new Asimilador(new Volcan(ubicacion4),ubicacion4,jugadorProtoss));
		edificios.add(new Acceso(ubicacion5,jugadorProtoss));
		edificios.add(new PuertoEstelar(ubicacion6,jugadorProtoss));
		
		moho.agregarOrigen(ubicacion1, edificios);
		
		moho.avanzarTurno(2, edificios);
		
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion2));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion3));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion4));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion5));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion6));
	}
	
	@Test
	void test03SeDestruyenEdificiosProtossEnUbicacionesYCuandoElMohoCreceAfectaLasUbicaciones() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(6,0);
		Ubicacion ubicacion3 = new Ubicacion(5,-1);
		Ubicacion ubicacion4 = new Ubicacion(5,1);
		Ubicacion ubicacion5 = new Ubicacion(5,-2);
		Ubicacion ubicacion6 = new Ubicacion(5,2);
		
		Moho moho = new Moho();
		
		ArrayList<Edificio> edificios = new ArrayList<Edificio>();
		edificios.add(new Pilon(ubicacion2,jugadorProtoss));
		edificios.add(new NexoMineral(new NodoMineral(ubicacion3),ubicacion3,jugadorProtoss));
		edificios.add(new Asimilador(new Volcan(ubicacion4),ubicacion4,jugadorProtoss));
		edificios.add(new Acceso(ubicacion5,jugadorProtoss));
		edificios.add(new PuertoEstelar(ubicacion6,jugadorProtoss));
		
		moho.agregarOrigen(ubicacion1, edificios);
		
		moho.avanzarTurno(2, edificios);
		
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion2));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion3));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion4));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion5));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion6));
		
		edificios.clear();
		
		moho.avanzarTurno(edificios);
		
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion2));
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion3));
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion4));
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion5));
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion6));
	}
	
	@Test
	void test04HayEdificiosZergEnUbicacionesYCuandoElMohoCreceNoAfectaLasUbicaciones() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(6,0);
		Ubicacion ubicacion3 = new Ubicacion(5,-1);
		Ubicacion ubicacion4 = new Ubicacion(5,1);
		Ubicacion ubicacion5 = new Ubicacion(5,-2);
		Ubicacion ubicacion6 = new Ubicacion(5,2);
		
		Moho moho = new Moho();
		
		ArrayList<Edificio> edificios = new ArrayList<Edificio>();
		edificios.add(new Criadero(ubicacion2,jugadorZerg));
		edificios.add(new ReservaDeReproduccion(ubicacion3,jugadorZerg));
		edificios.add(new Extractor(new Volcan(ubicacion4),ubicacion4,jugadorZerg));
		edificios.add(new Guarida(ubicacion5,jugadorZerg));
		edificios.add(new Espiral(ubicacion6,jugadorZerg));
		
		moho.agregarOrigen(ubicacion1, edificios);
		
		moho.avanzarTurno(2, edificios);
		
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion2));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion3));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion4));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion5));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion6));
	}
	
	@Test
	void test05SeDestruyenEdificiosZergEnUbicacionesYCuandoElMohoCreceAfectaLasUbicaciones() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(6,0);
		Ubicacion ubicacion3 = new Ubicacion(5,-1);
		Ubicacion ubicacion4 = new Ubicacion(5,1);
		Ubicacion ubicacion5 = new Ubicacion(5,-2);
		Ubicacion ubicacion6 = new Ubicacion(5,2);
		
		Moho moho = new Moho();
		
		ArrayList<Edificio> edificios = new ArrayList<Edificio>();
		edificios.add(new Criadero(ubicacion2,jugadorZerg));
		edificios.add(new ReservaDeReproduccion(ubicacion3,jugadorZerg));
		edificios.add(new Extractor(new Volcan(ubicacion4),ubicacion4,jugadorZerg));
		edificios.add(new Guarida(ubicacion5,jugadorZerg));
		edificios.add(new Espiral(ubicacion6,jugadorZerg));
		
		moho.agregarOrigen(ubicacion1, edificios);
		
		moho.avanzarTurno(2, edificios);
		
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion2));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion3));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion4));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion5));
		assertFalse(moho.estaAfectadaLaUbicacion(ubicacion6));
		
		edificios.clear();
		
		moho.avanzarTurno(edificios);
		
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion2));
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion3));
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion4));
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion5));
		assertTrue(moho.estaAfectadaLaUbicacion(ubicacion6));
	}
	

}
