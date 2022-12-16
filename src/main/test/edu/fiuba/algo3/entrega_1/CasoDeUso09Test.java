package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoEnergizadoException;
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
		
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Pilon", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion3, jugadorZerg, mapa);
		
		/* los pilones tienen que estar operativos para poder energizar edificios*/
		Pilon pilon1 = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Pilon pilon2 = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		pilon1.avanzarTurno(5);
		pilon2.avanzarTurno(5);
		
		/* avanzo un turno el mapa para que se energicen los edificios protoss */
		mapa.avanzarTurno();
		
		jugadorProtoss.destruirEdificioEn(ubicacion1);
		mapa.destruirPilonEn(ubicacion1);
		
		jugadorProtoss.avanzarTurno();
		mapa.avanzarTurno();
		
		/* dejo el acceso operativo para que no lance error de edificio no operativo */
		Acceso acceso =(Acceso) jugadorProtoss.obtenerEdificioEn(ubicacion3);
		acceso.avanzarTurno(8);
		
		/* hago que mapa energice los edificios*/
		mapa.avanzarTurno();
		
		assertDoesNotThrow(()-> acceso.transportarZealots());
	}
	
	@Test
	void test02SeDestruyeUnPilonDe2QueEnergizanUnPuertoEstelarDebeEstarOperativo() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(0,2);
		Ubicacion ubicacion3 = new Ubicacion(1,0);
		Ubicacion ubicacion4 = new Ubicacion(1,2);
		
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Pilon", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion3, jugadorZerg, mapa);
		jugadorProtoss.construir("PuertoEstelar", ubicacion4, jugadorZerg, mapa);
		
		/* los pilones tienen que estar operativos para poder energizar edificios*/
		Pilon pilon1 = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Pilon pilon2 = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		pilon1.avanzarTurno(5);
		pilon2.avanzarTurno(5);
		
		/* avanzo un turno el mapa para que se energicen los edificios protoss */
		mapa.avanzarTurno();
		
		jugadorProtoss.destruirEdificioEn(ubicacion1);
		mapa.destruirPilonEn(ubicacion1);
		
		jugadorProtoss.avanzarTurno();
		mapa.avanzarTurno();
		
		/* dejo el puerto estelar operativo para que no tire error de edifio no operativo*/
		PuertoEstelar puertoEstelar = (PuertoEstelar)jugadorProtoss.obtenerEdificioEn(ubicacion4);
		puertoEstelar.avanzarTurno(10);
		
		/* hago que mapa energice los edificios*/
		mapa.avanzarTurno();
		
		assertDoesNotThrow(()-> puertoEstelar.transportarScout());
	}
	
	@Test
	void test03SeDestruyenTodosLosPilonesQueEnergizanUnAccesoNoDebeEstarOperativo() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(5,0);
		Ubicacion ubicacion3 = new Ubicacion(3,0);
		
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Pilon", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion3, jugadorZerg, mapa);
		
		/* los pilones tienen que estar operativos para poder energizar edificios*/
		Pilon pilon1 = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Pilon pilon2 = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		pilon1.avanzarTurno(5);
		pilon2.avanzarTurno(5);
		
		jugadorProtoss.destruirEdificioEn(ubicacion1);
		jugadorProtoss.destruirEdificioEn(ubicacion2);
		mapa.destruirPilonEn(ubicacion1);
		mapa.destruirPilonEn(ubicacion2);
		
		jugadorProtoss.avanzarTurno();
		mapa.energizarEdificios();
		
		/* dejo el acceso operativo para que no lance error de edificio no operativo */
		Acceso acceso =(Acceso) jugadorProtoss.obtenerEdificioEn(ubicacion3);
		acceso.avanzarTurno(8);
		
		/* hago que mapa energice los edificios*/
		mapa.avanzarTurno();
		
		assertThrows(EdificioNoEnergizadoException.class,()-> {
			acceso.transportarZealots();
		});	
	}
	
	@Test
	void test04SeDestruyenTodosLosPilonesQueEnergizanUnPuertoEstelarNoDebeEstarOperativo() {
		
		Ubicacion ubicacion1 = new Ubicacion(0,0);
		Ubicacion ubicacion2 = new Ubicacion(0,2);
		Ubicacion ubicacion3 = new Ubicacion(1,0);
		Ubicacion ubicacion4 = new Ubicacion(1,2);
		
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Pilon", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion3, jugadorZerg, mapa);
		jugadorProtoss.construir("PuertoEstelar", ubicacion4, jugadorZerg, mapa);
		
		/* los pilones tienen que estar operativos para poder energizar edificios*/
		Pilon pilon1 = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Pilon pilon2 = (Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		
		pilon1.avanzarTurno(5);
		pilon2.avanzarTurno(5);
		
		/* avanzo un turno el mapa para que se energicen los edificios protoss */
		mapa.avanzarTurno();
		
		jugadorProtoss.destruirEdificioEn(ubicacion1);
		jugadorProtoss.destruirEdificioEn(ubicacion2);
		mapa.destruirPilonEn(ubicacion1);
		mapa.destruirPilonEn(ubicacion2);
		
		jugadorProtoss.avanzarTurno();
		mapa.avanzarTurno();
		
		/* dejo el puerto estelar operativo para que no tire error de edifio no operativo*/
		PuertoEstelar puertoEstelar = (PuertoEstelar)jugadorProtoss.obtenerEdificioEn(ubicacion4);
		puertoEstelar.avanzarTurno(10);
		
		/* hago que mapa energice los edificios*/
		mapa.avanzarTurno();
		
		assertThrows(EdificioNoEnergizadoException.class,()-> {
			puertoEstelar.transportarScout();
		});
	}

}
