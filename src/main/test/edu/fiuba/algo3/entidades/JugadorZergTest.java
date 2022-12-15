package edu.fiuba.algo3.entidades;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorZergTest {

    @Test
    public void test01JugadorZergCreaUnAmoSupremo() {
        // Arrange
        Mapa mapa = new Mapa();
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);
        
        // Act
        jugadorZerg.construir("AmoSupremo", new Ubicacion(0,0), jugadorProtoss, mapa); //crearAmoSupremo(new Ubicacion(0,0));

        // Assert
        assertEquals(0, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test02JugadorZergConstruyeUnCriaderoYLuegoDeAvanzarCuatroTurnosElCriaderoEstaOperableYCreaUnZangano() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for(int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa); //crearZangano(new Ubicacion(0,0));

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test03JugadorZergConstruyeUnaReservaDeReproduccionYLuegoDeAvanzarDoceTurnosLaReservaDeReproduccionEstaOperableYCreaUnZerling() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho

        for(int i = 0; i < 5; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,0), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Zerling", new Ubicacion(1,0), jugadorProtoss, mapa);
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(2, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test04JugadorZergConstruyeUnaGuaridaYLuegoDeAvanzarDoceTurnosLaGuaridaEstaOperableYCreaUnHidralisco() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Hidralisco", new Ubicacion(1,2), jugadorProtoss, mapa); //crearHidralisco(new Ubicacion(1,2));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test05JugadorZergConstruyeUnaEspiralYLuegoDeAvanzarDiezTurnosLaEspiralEstaOperableYCreaUnMutalisco() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa); // Debemos construir una Guarida debido a que es condicion para una Espiral
        jugadorZerg.construir("Espiral", new Ubicacion(2,1), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Mutalisco", new Ubicacion(2,1), jugadorProtoss, mapa); //crearMutalisco(new Ubicacion(2,1));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test06JugadorZergCreaUnMutaliscoYLoEvolucionaAGuardian() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa); // Debemos construir una Guarida debido a que es condicion para una Espiral
        jugadorZerg.construir("Espiral", new Ubicacion(2,1), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Mutalisco", new Ubicacion(2,1), jugadorProtoss, mapa); //crearMutalisco(new Ubicacion(2,1));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        for(int i = 0; i < 7; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.evolucionarMutaliscoAGuardian(new Ubicacion(2,1));

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test07JugadorZergCreaUnMutaliscoYLoEvolucionaADevorador() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa); // Debemos construir una Guarida debido a que es condicion para una Espiral
        jugadorZerg.construir("Espiral", new Ubicacion(2,1), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Mutalisco", new Ubicacion(2,1), jugadorProtoss, mapa); //crearMutalisco(new Ubicacion(2,1));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        for(int i = 0; i < 7; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.evolucionarMutaliscoADevorador(new Ubicacion(2,1));

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }
    
    @Test
    void test08UnaUnidadSeMueveDeberiaEstarEstarALaDerecha() {
    	
    	Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for(int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }
        
    	Ubicacion ubicacion1 = new Ubicacion(0,0);
    	Ubicacion ubicacion2 = new Ubicacion(1,0);
    	
    	/* por default la direccion inicial a la que se mueve es hacia la derecha */
    	jugadorZerg.construir("Zangano", ubicacion1, jugadorProtoss, mapa); //crearZangano(ubicacion1);
    	
    	jugadorZerg.avanzarTurno();
    	mapa.avanzarTurno();
    	
    	jugadorZerg.moverUnidadEn(ubicacion1);
    	
    	assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(ubicacion2));
    }
    
    @Test
    void test09UnaUnidadCambiaLaDireccionUnaVezAntesDeMoverseDeberiaEstarAbajo() {
    	
    	Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(15,15), jugadorProtoss, mapa);

        for(int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }
        
        /* usos las ubicaciones 15,15 porque el mapa no tiene ubicaciones negativas*/
    	Ubicacion ubicacion1 = new Ubicacion(15,15);
    	Ubicacion ubicacion2 = new Ubicacion(15,14);
    	
    	/* por default la direccion inicial a la que se mueve es hacia la derecha */
    	jugadorZerg.construir("Zangano", ubicacion1, jugadorProtoss, mapa); //crearZangano(ubicacion1);
    	
    	jugadorZerg.avanzarTurno();
    	mapa.avanzarTurno();
    	
    	/* al cambiar la direccion se va a mover hacia abajo */
    	jugadorZerg.cambiarDireccionDeUnidadEn(ubicacion1);
    	
    	jugadorZerg.moverUnidadEn(ubicacion1);
    	
    	assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(ubicacion2));
    }
    
    @Test
    void test10UnaUnidadCambiaLaDireccionDosVecesAntesDeMoverseDeberiaEstarALaIzquierda() {
    	
    	Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(15,15), jugadorProtoss, mapa);

        for(int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }
        
        /* usos las ubicaciones 15,15 porque el mapa no tiene ubicaciones negativas*/
    	Ubicacion ubicacion1 = new Ubicacion(15,15);
    	Ubicacion ubicacion2 = new Ubicacion(14,15);
    	
    	/* por default la direccion inicial a la que se mueve es hacia la derecha */
    	jugadorZerg.construir("Zangano", ubicacion1, jugadorProtoss, mapa); //crearZangano(ubicacion1);
    	
    	jugadorZerg.avanzarTurno();
    	mapa.avanzarTurno();
    	
    	/* al cambiar la direccion se va a mover hacia abajo */
    	jugadorZerg.cambiarDireccionDeUnidadEn(ubicacion1);
    	jugadorZerg.cambiarDireccionDeUnidadEn(ubicacion1);
    	
    	jugadorZerg.moverUnidadEn(ubicacion1);
    	
    	assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(ubicacion2));
    }
    
    @Test
    void test11UnaUnidadCambiaLaDireccionTresVecesAntesDeMoverseDeberiaEstarArriba() {
    	
    	Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(15,15), jugadorProtoss, mapa);

        for(int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }
        
        /* usos las ubicaciones 15,15 porque el mapa no tiene ubicaciones negativas*/
    	Ubicacion ubicacion1 = new Ubicacion(15,15);
    	Ubicacion ubicacion2 = new Ubicacion(15,16);
    	
    	/* por default la direccion inicial a la que se mueve es hacia la derecha */
    	jugadorZerg.construir("Zangano", ubicacion1, jugadorProtoss, mapa); //crearZangano(ubicacion1);
    	
    	jugadorZerg.avanzarTurno();
    	mapa.avanzarTurno();
    	
    	/* al cambiar la direccion se va a mover hacia abajo */
    	jugadorZerg.cambiarDireccionDeUnidadEn(ubicacion1);
    	jugadorZerg.cambiarDireccionDeUnidadEn(ubicacion1);
    	jugadorZerg.cambiarDireccionDeUnidadEn(ubicacion1);
    	
    	jugadorZerg.moverUnidadEn(ubicacion1);
    	
    	assertDoesNotThrow(()-> mapa.obtenerUnidadEnUbicacion(ubicacion2));
    }
}