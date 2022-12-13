package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Fabrica;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoError;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;

class CasoDeUso09Test {

	/* Verificar que un edificio protoss sigue operativo si le destruyen un pilon que lo energiza
	 * pero aun esta dentro del rango de otro que tambien lo energiza*/
	
	/* Los unicos edificios que necesitan energia son el acceso y el puerto estelar*/

	Mapa mapa = new Mapa();
	JugadorZerg jugadorZerg = new JugadorZerg("Brian", "Azul", new Recursos(10000,10000), mapa);
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Alan","Rojo",new Recursos(10000,10000), mapa);
	
	@Test
	void test01SeDestruyeUnPilonDe2QueEnergizanUnAccesoDebeEstarOperativo() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		Ubicacion ubicacion3 = new Ubicacion(3,0);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Pilon", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Acceso", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		jugadorProtoss.destruirEdificioEn(ubicacion1);
		mapa.destruirPilonEn(ubicacion1);
		
		jugadorProtoss.avanzarTurno();
		mapa.energizarEdificios();
		
		Acceso acceso = jugadorProtoss.obtenerAccesoEn(ubicacion3);
		
		assertDoesNotThrow(()-> acceso.transportarZealots());
	}
	
	@Test
	void test02SeDestruyeUnPilonDe2QueEnergizanUnPuertoEstelarDebeEstarOperativo() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(0,2);
		Ubicacion ubicacion3 = new Ubicacion(1,0);
		Ubicacion ubicacion4 = new Ubicacion(1,2);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Pilon", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Acceso", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("PuertoEstelar", ubicacion4, jugadorZerg, jugadorProtoss, mapa);
		
		jugadorProtoss.destruirEdificioEn(ubicacion1);
		mapa.destruirPilonEn(ubicacion1);
		
		jugadorProtoss.avanzarTurno();
		mapa.energizarEdificios();
		
		PuertoEstelar puertoEstelar = jugadorProtoss.obtenerPuertoEstelarEn(ubicacion4);
		
		assertDoesNotThrow(()-> puertoEstelar.transportarScout());
	}
	
	@Test
	void test03SeDestruyenTodosLosPilonesQueEnergizanUnAccesoNoDebeEstarOperativo() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		Ubicacion ubicacion3 = new Ubicacion(3,0);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Pilon", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Acceso", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		
		jugadorProtoss.destruirEdificioEn(ubicacion1);
		jugadorProtoss.destruirEdificioEn(ubicacion2);
		mapa.destruirPilonEn(ubicacion1);
		mapa.destruirPilonEn(ubicacion2);
		
		jugadorProtoss.avanzarTurno();
		mapa.energizarEdificios();
		
		Acceso acceso = jugadorProtoss.obtenerAccesoEn(ubicacion3);
		
		assertThrows(EdificioNoEnergizadoError.class,()-> {
			acceso.transportarZealots();
		});	
	}
	
	@Test
	void test04SeDestruyenTodosLosPilonesQueEnergizanUnPuertoEstelarNoDebeEstarOperativo() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(0,2);
		Ubicacion ubicacion3 = new Ubicacion(1,0);
		Ubicacion ubicacion4 = new Ubicacion(1,2);
		
		Fabrica.construir("Pilon", ubicacion1, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Pilon", ubicacion2, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("Acceso", ubicacion3, jugadorZerg, jugadorProtoss, mapa);
		Fabrica.construir("PuertoEstelar", ubicacion4, jugadorZerg, jugadorProtoss, mapa);
		
		jugadorProtoss.destruirEdificioEn(ubicacion1);
		jugadorProtoss.destruirEdificioEn(ubicacion2);
		mapa.destruirPilonEn(ubicacion1);
		mapa.destruirPilonEn(ubicacion2);
		
		jugadorProtoss.avanzarTurno();
		mapa.energizarEdificios();
		
		PuertoEstelar puertoEstelar = jugadorProtoss.obtenerPuertoEstelarEn(ubicacion4);
		
		assertThrows(EdificioNoEnergizadoError.class,()-> {
			puertoEstelar.transportarScout();
		});
	}

}
