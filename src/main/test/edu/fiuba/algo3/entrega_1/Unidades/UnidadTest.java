package edu.fiuba.algo3.entrega_1.Unidades;

import edu.fiuba.algo3.modelo.Excepciones.UnidadEnConstruccionException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnidadTest {

    @Test
    void test01SeCreaUnaUnidadConTipoZerlingYSeEncuentraEnConstruccion(){
        // Arrange
        Zerling tipoZerling = new Zerling();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad zerling = new Unidad(new Tiempo(-2), new Ubicacion(0,0), tipoZerling, jugadorZerg);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            zerling.recibirAtaque(10);
        });
    }

    @Test
    void test02SeCreaUnaUnidadConTipoZerlingYLuegoDeDosTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Zerling tipoZerling = new Zerling();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad zerling = new Unidad(new Tiempo(-2), new Ubicacion(0,0), tipoZerling, jugadorZerg);
        zerling.avanzarTurno(2);

        // Act
        zerling.recibirAtaque(10);

        // Assert
        assertEquals(25, tipoZerling.vidaRestante());
    }

    @Test
    void test03SeCreaUnaUnidadConTipoHidraliscoYSeEncuentraEnConstruccion(){
        // Arrange
        Hidralisco tipoHidralisco = new Hidralisco();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad hidralisco = new Unidad(new Tiempo(-4), new Ubicacion(0,0), tipoHidralisco, jugadorZerg);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            hidralisco.recibirAtaque(10);
        });
    }

    @Test
    void test04SeCreaUnaUnidadConTipoHidraliscoYLuegoDeCuatroTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Hidralisco tipoHidralisco = new Hidralisco();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad hidralisco = new Unidad(new Tiempo(-4), new Ubicacion(0,0), tipoHidralisco, jugadorZerg);
        hidralisco.avanzarTurno(4);

        // Act
        hidralisco.recibirAtaque(10);

        // Assert
        assertEquals(70, tipoHidralisco.vidaRestante());
    }

    @Test
    void test05SeCreaUnaUnidadConTipoMutaliscoYSeEncuentraEnConstruccion(){
        // Arrange
        Mutalisco tipoMutalisco = new Mutalisco();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad mutalisco = new Unidad(new Tiempo(-7), new Ubicacion(0,0), tipoMutalisco, jugadorZerg);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            mutalisco.recibirAtaque(10);
        });
    }

    @Test
    void test06SeCreaUnaUnidadConTipoMutaliscoYLuegoDeSieteTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Mutalisco tipoMutalisco = new Mutalisco();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad mutalisco = new Unidad(new Tiempo(-7), new Ubicacion(0,0), tipoMutalisco, jugadorZerg);
        mutalisco.avanzarTurno(7);

        // Act
        mutalisco.recibirAtaque(10);

        // Assert
        assertEquals(110, tipoMutalisco.vidaRestante());
    }

    @Test
    void test07SeCreaUnaUnidadConTipoGuardianYSeEncuentraEnConstruccion(){
        // Arrange
        Guardian tipoGuardian = new Guardian();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad guardian = new Unidad(new Tiempo(-4), new Ubicacion(0,0), tipoGuardian, jugadorZerg);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            guardian.recibirAtaque(10);
        });
    }

    @Test
    void test08SeCreaUnaUnidadConTipoGuardianYLuegoDeCuatroTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Guardian tipoGuardian = new Guardian();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad guardian = new Unidad(new Tiempo(-4), new Ubicacion(0,0), tipoGuardian, jugadorZerg);
        guardian.avanzarTurno(4);

        // Act
        guardian.recibirAtaque(10);

        // Assert
        assertEquals(90, tipoGuardian.vidaRestante());
    }

    @Test
    void test09SeCreaUnaUnidadConTipoZealotYSeEncuentraEnConstruccion(){
        // Arrange
        Zealot tipoZealot = new Zealot();
        Recursos recursos = new Recursos(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Unidad zealot = new Unidad(new Tiempo(-4), new Ubicacion(0,0), tipoZealot, jugadorProtoss);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            zealot.recibirAtaque(10);
        });
    }

    @Test
    void test10SeCreaUnaUnidadConTipoZealotYLuegoDeCuatroTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Zealot tipoZealot = new Zealot();
        Recursos recursos = new Recursos(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Unidad zealot = new Unidad(new Tiempo(-4), new Ubicacion(0,0), tipoZealot, jugadorProtoss);
        zealot.avanzarTurno(4);

        // Act
        zealot.recibirAtaque(10);

        // Assert
        assertEquals(50, tipoZealot.escudoRestante());
    }

    @Test
    void test11SeCreaUnaUnidadConTipoDragonYSeEncuentraEnConstruccion(){
        // Arrange
        Dragon tipoDragon = new Dragon();
        Recursos recursos = new Recursos(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Unidad dragon = new Unidad(new Tiempo(-6), new Ubicacion(0,0), tipoDragon, jugadorProtoss);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            dragon.recibirAtaque(10);
        });
    }

    @Test
    void test12SeCreaUnaUnidadConTipoDragonYLuegoDeSeisTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Dragon tipoDragon = new Dragon();
        Recursos recursos = new Recursos(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Unidad dragon = new Unidad(new Tiempo(-6), new Ubicacion(0,0), tipoDragon, jugadorProtoss);
        dragon.avanzarTurno(6);

        // Act
        dragon.recibirAtaque(10);

        // Assert
        assertEquals(70, tipoDragon.escudoRestante());
    }

    @Test
    void test13SeCreaUnaUnidadConTipoScoutYSeEncuentraEnConstruccion(){
        // Arrange
        Scout tipoScout = new Scout();
        Recursos recursos = new Recursos(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Unidad scout = new Unidad(new Tiempo(-9), new Ubicacion(0,0), tipoScout, jugadorProtoss);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            scout.recibirAtaque(10);
        });
    }

    @Test
    void test14SeCreaUnaUnidadConTipoScoutYLuegoDeNueveTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Scout tipoScout = new Scout();
        Recursos recursos = new Recursos(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Unidad scout = new Unidad(new Tiempo(-9), new Ubicacion(0,0), tipoScout, jugadorProtoss);
        scout.avanzarTurno(9);

        // Act
        scout.recibirAtaque(10);

        // Assert
        assertEquals(90, tipoScout.escudoRestante());
    }
}