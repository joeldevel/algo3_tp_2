package edu.fiuba.algo3.entidades;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorProtossTest {

    @Test
    public void test01JugadorProtossonstruyeUnAccesoYLuegoDeAvanzarOchoTurnosElAccesoEstaOperableYCreaUnZealot() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.construir("Zealot", new Ubicacion(1,1), jugadorZerg, mapa);  //crearZealot(new Ubicacion(1,1), mapa);
        jugadorProtoss.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(2, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test02JugadorProtossonstruyeUnAccesoYLuegoDeAvanzarOchoTurnosElAccesoEstaOperableYCreaUnDragon() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.construir("Dragon", new Ubicacion(1,1), jugadorZerg, mapa); //crearDragon(new Ubicacion(1,1), mapa);
        jugadorProtoss.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(3, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test03JugadorProtossonstruyeUnPuertoEstelarYLuegoDeAvanzarDiezTurnosElPuertoEstelarEstaOperableYCreaUnScout() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(2,2), jugadorZerg, mapa);

        for(int i = 0; i < 10; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Puerto Estelar este operable y transporte unidades
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.construir("Scout", new Ubicacion(2,2), jugadorZerg, mapa); //crearScout(new Ubicacion(2,2), mapa);
        jugadorProtoss.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(4, jugadorProtoss.calcularSuministro());
    }
    
    @Test
    void test04SeCreaUnaUnidadYAlMoverseDeberiaEstarALaDerecha() {
    	Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(1,1), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(3,3), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        Ubicacion ubicacion1 = new Ubicacion(3,3);
        Ubicacion ubicacion2 = new Ubicacion(4,3);
        
        jugadorProtoss.construir("Dragon", ubicacion1, jugadorZerg, mapa); //crearDragon(ubicacion1, mapa);
        
        for(int i = 0; i < 6; i++) {
        	jugadorProtoss.avanzarTurno();
        	mapa.avanzarTurno();        	
        }
        /* por default se mueve a la derecha*/
        jugadorProtoss.moverUnidadEn(ubicacion1);
        
        assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(ubicacion2));

    }
    
    @Test
    void test05SeCreaUnaUnidadYSeCambiarDeDireccionAlMoverseDeberiaEstarAbajo() {
    	Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(1,1), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(3,3), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        Ubicacion ubicacion1 = new Ubicacion(3,3);
        Ubicacion ubicacion2 = new Ubicacion(3,2);
        
        jugadorProtoss.construir("Dragon", ubicacion1, jugadorZerg, mapa); //crearDragon(ubicacion1, mapa);
        
        for(int i = 0; i < 6; i++) {
        	jugadorProtoss.avanzarTurno();
        	mapa.avanzarTurno();        	
        }
        
        /* se cambia de direccion una vez y se mueve hacia abajo*/
        jugadorProtoss.cambiarDireccionDeUnidadEn(ubicacion1);
        jugadorProtoss.moverUnidadEn(ubicacion1);
        
        assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(ubicacion2));

    }
    
    @Test
    void test06SeCreaUnaUnidadYSeCambiaDeDireccionDosVecesAlMoverseDeberiaEstarALaIzquierda() {
    	Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(1,1), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(3,3), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        Ubicacion ubicacion1 = new Ubicacion(3,3);
        Ubicacion ubicacion2 = new Ubicacion(2,3);
        
        jugadorProtoss.construir("Dragon", ubicacion1, jugadorZerg, mapa); //crearDragon(ubicacion1, mapa);
        
        for(int i = 0; i < 6; i++) {
        	jugadorProtoss.avanzarTurno();
        	mapa.avanzarTurno();        	
        }
        /* se cambia de direccion dos veces y se mueve a la izquierda */
        jugadorProtoss.cambiarDireccionDeUnidadEn(ubicacion1);
        jugadorProtoss.cambiarDireccionDeUnidadEn(ubicacion1);
        jugadorProtoss.moverUnidadEn(ubicacion1);
        
        assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(ubicacion2));

    }
    
    @Test
    void test07SeCreaUnaUnidadYSeCambiaDeDireccionTresVecesAlMoverseDeberiaEstarArriba() {
    	Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(1,1), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(3,3), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        Ubicacion ubicacion1 = new Ubicacion(3,3);
        Ubicacion ubicacion2 = new Ubicacion(3,4);
        
        jugadorProtoss.construir("Dragon", ubicacion1, jugadorZerg, mapa); //crearDragon(ubicacion1, mapa);
        
        for(int i = 0; i < 6; i++) {
        	jugadorProtoss.avanzarTurno();
        	mapa.avanzarTurno();        	
        }
        /* se cambia de direccion tres veces y se mueve hacia arriba */
        jugadorProtoss.cambiarDireccionDeUnidadEn(ubicacion1);
        jugadorProtoss.cambiarDireccionDeUnidadEn(ubicacion1);
        jugadorProtoss.cambiarDireccionDeUnidadEn(ubicacion1);
        
        jugadorProtoss.moverUnidadEn(ubicacion1);
        
        assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(ubicacion2));

    }
    
    
}
