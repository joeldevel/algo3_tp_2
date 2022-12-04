package edu.fiuba.algo3.entrega_2;

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

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CONSTRUCCION_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.CONSTRUCCION_SCOUT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.CONSTRUCCION_ZEALOT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.CONSTRUCCION_HIDRALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.CONSTRUCCION_ZERLING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso22Test {

    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));

    @Test
    void test01SeCreaUnaUnidadConTipoZerlingYSeEncuentraEnConstruccion(){
        // Arrange
        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            dragon.atacar(zerling);
        });
    }

    @Test
    void test02SeCreaUnaUnidadConTipoZerlingYLuegoDeDosTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(zerling);

        // Assert
        assertEquals(15, tipoZerling.vidaRestante());
    }

    @Test
    void test03SeCreaUnaUnidadConTipoHidraliscoYSeEncuentraEnConstruccion(){
        // Arrange
        Hidralisco tipoHidralisco = new Hidralisco(jugadorZerg);
        Unidad hidralisco = new Unidad(new Tiempo(CONSTRUCCION_HIDRALISCO), new Ubicacion(0,0), tipoHidralisco);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            dragon.atacar(hidralisco);
        });
    }

    @Test
    void test04SeCreaUnaUnidadConTipoHidraliscoYLuegoDeCuatroTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Hidralisco tipoHidralisco = new Hidralisco(jugadorZerg);
        Unidad hidralisco = new Unidad(new Tiempo(CONSTRUCCION_HIDRALISCO), new Ubicacion(0,0), tipoHidralisco);
        hidralisco.avanzarTurno(4);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(hidralisco);

        // Assert
        assertEquals(60, tipoHidralisco.vidaRestante());
    }

    @Test
    void test05SeCreaUnaUnidadConTipoMutaliscoYSeEncuentraEnConstruccion(){
        // Arrange
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            dragon.atacar(mutalisco);
        });
    }

    @Test
    void test06SeCreaUnaUnidadConTipoMutaliscoYLuegoDeSieteTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        mutalisco.avanzarTurno(7);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(mutalisco);

        // Assert
        assertEquals(100, tipoMutalisco.vidaRestante());
    }

    @Test
    void test07SeCreaUnaUnidadConTipoGuardianYSeEncuentraEnConstruccion(){
        // Arrange
        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            dragon.atacar(guardian);
        });
    }

    @Test
    void test08SeCreaUnaUnidadConTipoGuardianYLuegoDeCuatroTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        guardian.avanzarTurno(4);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(guardian);

        // Assert
        assertEquals(80, tipoGuardian.vidaRestante());
    }

    @Test
    void test09SeCreaUnaUnidadConTipoZealotYSeEncuentraEnConstruccion(){
        // Arrange
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        guardian.avanzarTurno(4);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            guardian.atacar(zealot);
        });
    }

    @Test
    void test10SeCreaUnaUnidadConTipoZealotYLuegoDeCuatroTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        guardian.avanzarTurno(4);

        // Act
        guardian.atacar(zealot);

        // Assert
        assertEquals(35, tipoZealot.escudoRestante());
    }

    @Test
    void test11SeCreaUnaUnidadConTipoDragonYSeEncuentraEnConstruccion(){
        // Arrange
        Dragon tipoDragon = new Dragon(jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0,0), tipoDragon);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        guardian.avanzarTurno(4);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            guardian.atacar(dragon);
        });
    }

    @Test
    void test12SeCreaUnaUnidadConTipoDragonYLuegoDeSeisTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Dragon tipoDragon = new Dragon(jugadorProtoss);
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0,0), tipoDragon);
        dragon.avanzarTurno(6);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        guardian.avanzarTurno(4);

        // Act
        guardian.atacar(dragon);

        // Assert
        assertEquals(55, tipoDragon.escudoRestante());
    }

    @Test
    void test13SeCreaUnaUnidadConTipoScoutYSeEncuentraEnConstruccion(){
        // Arrange
        Scout tipoScout = new Scout(jugadorProtoss);
        Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), new Ubicacion(0,0), tipoScout);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        guardian.avanzarTurno(4);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            guardian.atacar(scout);
        });
    }

    @Test
    void test14SeCreaUnaUnidadConTipoScoutYLuegoDeNueveTurnosRecibeUnAtaqueYSeEncuentraOperativo(){
        // Arrange
        Scout tipoScout = new Scout(jugadorProtoss);
        Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), new Ubicacion(0,0), tipoScout);
        scout.avanzarTurno(9);

        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        mutalisco.avanzarTurno(7);

        // Act
        mutalisco.atacar(scout);

        // Assert
        assertEquals(91, tipoScout.escudoRestante());
    }
}