package edu.fiuba.algo3.entrega_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.SinUnidadBuscadaError;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;

class CasoDeUso20Test {
	
	/* Verificar que solo las unidades voladoras puedan moverse por areas espaciales */

	Mapa mapa = new Mapa();
	JugadorZerg jugadorZerg = new JugadorZerg("Brian", "Azul", new Recursos(10000,10000), mapa);
	JugadorProtoss jugadorProtoss = new JugadorProtoss("Alan", "Rojo", new Recursos(10000,10000),mapa);
	
	@Test
	void test01UnScoutSePuedeMoverPorAreasDeTierraYEspaciales() {
		
		/* en el mapa las areas espaciales estan entre 250 y 750 en X, y entre 125 y 375 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(246,250);
		Ubicacion ubicacion2 = new Ubicacion(248,251);
		Ubicacion ubicacion3 = new Ubicacion(248,249);
		
		/* construyo los edificios necesarios para crear el Scout*/
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("PuertoEstelar", ubicacion3, jugadorZerg, mapa);
		
		Pilon pilon =(Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Acceso acceso = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		PuertoEstelar puerto = (PuertoEstelar)jugadorProtoss.obtenerEdificioEn(ubicacion3);
		
		/* dejo los edificios operativos */
		pilon.avanzarTurno(5);
		acceso.avanzarTurno(10);
		puerto.avanzarTurno(10);
		
		/* energizo los edificios para que no lance excepcion de edificio no energizado */
		pilon.energizarEdificios();
		
		jugadorProtoss.construir("Scout", ubicacion3, jugadorZerg, mapa);
		
		Unidad scout = jugadorProtoss.obtenerUnidadEn(ubicacion3);
		
		/* dejo al scout operativo*/
		scout.avanzarTurno(9);
		
		/* se mueve una vez, esta en la posicion 249,249 que es de tierra*/
		scout.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(249,249)));
		
		/* se mueve una segunda vez, esta en la posicion 250,249 que es de aire*/
		scout.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(250,249)));
	}
	
	@Test
	void test02ZealotYDragonNoSePuedenEspaciales() {
		
		/* en el mapa las areas espaciales estan entre 250 y 750 en X, y entre 125 y 375 en Y*/
		Ubicacion ubicacion1 = new Ubicacion(246,250);
		Ubicacion ubicacion2 = new Ubicacion(248,251);
		Ubicacion ubicacion3 = new Ubicacion(248,249);
		
		/* construyo los edificios necesarios para crear el Scout*/
		jugadorProtoss.construir("Pilon", ubicacion1, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("Acceso", ubicacion3, jugadorZerg, mapa);
		
		Pilon pilon =(Pilon)jugadorProtoss.obtenerEdificioEn(ubicacion1);
		Acceso acceso1 = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion2);
		Acceso acceso2 = (Acceso)jugadorProtoss.obtenerEdificioEn(ubicacion3);
		
		/* dejo los edificios operativos */
		pilon.avanzarTurno(5);
		acceso1.avanzarTurno(10);
		acceso2.avanzarTurno(10);
		
		/* energizo los edificios para que no lance excepcion de edificio no energizado */
		pilon.energizarEdificios();
		
		jugadorProtoss.construir("Zealot", ubicacion2, jugadorZerg, mapa);
		jugadorProtoss.construir("Dragon", ubicacion3, jugadorZerg, mapa);
		
		Unidad zealot = jugadorProtoss.obtenerUnidadEn(ubicacion2);
		Unidad dragon = jugadorProtoss.obtenerUnidadEn(ubicacion3);
		
		/* dejo a las unidades operativas*/
		zealot.avanzarTurno(4);
		dragon.avanzarTurno(6);
		
		/* se mueven una vez, esta en la posicion 249,251 zealot, y 249,249 dragon, que es de tierra*/
		zealot.moverse(mapa);
		dragon.moverse(mapa);
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(249,251)));
		assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(new Ubicacion(249,249)));
		
		/* se mueven una segunda vez, esta en la posicion 250,251 zealot, y 250,249 dragon, que es de aire*/
		zealot.moverse(mapa);
		dragon.moverse(mapa);
		assertThrows(SinUnidadBuscadaError.class, ()->{
			mapa.obtenerUnidadEnUbicacion(new Ubicacion(250,251));
		});
		assertThrows(SinUnidadBuscadaError.class, ()->{
			mapa.obtenerUnidadEnUbicacion(new Ubicacion(250,249));
		});
	}

}
