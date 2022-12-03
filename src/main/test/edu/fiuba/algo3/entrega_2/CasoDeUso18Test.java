package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.*;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CONSTRUCCION_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.CONSTRUCCION_SCOUT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.CONSTRUCCION_ZEALOT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.CONSTRUCCION_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.CONSTRUCCION_HIDRALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.CONSTRUCCION_ZANGANO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.CONSTRUCCION_ZERLING;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso18Test {

    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000, 1000));
    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000, 1000));

    /* Protoss */

    @Test
    void test01UnDragonAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado() {
        // Arrange
        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        Zerling tipoZerling = new Zerling(new Ubicacion(0, 0), jugadorZerg); // Unidad de tierra
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0, 0), tipoZerling);
        zerling.avanzarTurno(2);

        // Act
        dragon.atacar(zerling);

        // Assert
        assertEquals(15, zerling.vidaRestante()); // Solo se considera el ataque de tierra del Dragon
    }

    @Test
    void test02UnDragonAtacaAUnMutaliscoYLaVidaDelMutaliscoDisminuyeLoIndicado() {
        // Arrange
        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        Mutalisco tipoMutalisco = new Mutalisco(new Ubicacion(0, 0), jugadorZerg); // Unidad de aire
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0, 0), tipoMutalisco);
        mutalisco.avanzarTurno(7);

        // Act
        dragon.atacar(mutalisco);

        // Assert
        assertEquals(100, mutalisco.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test03UnScoutAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado() {
        // Arrange
        Scout tipoScout = new Scout(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), new Ubicacion(0, 0), tipoScout);
        scout.avanzarTurno(9);

        Zerling tipoZerling = new Zerling(new Ubicacion(0, 0), jugadorZerg); // Unidad de tierra
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0, 0), tipoZerling);
        zerling.avanzarTurno(2);

        // Act
        scout.atacar(zerling);

        // Assert
        assertEquals(27, zerling.vidaRestante()); // Solo se considera el ataque de tierra del Scout
    }

    @Test
    void test04UnScoutAtacaAUnGuardianYLaVidaDelGuardianDisminuyeLoIndicado() {
        // Arrange
        Scout tipoScout = new Scout(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), new Ubicacion(0, 0), tipoScout);
        scout.avanzarTurno(9);

        Guardian tipoGuardian = new Guardian(new Ubicacion(0, 0), jugadorZerg); // Unidad de aire
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0, 0), tipoGuardian);
        guardian.avanzarTurno(4);

        // Act
        scout.atacar(guardian);

        // Assert
        assertEquals(86, guardian.vidaRestante()); // Solo se considera el ataque de aire del Scout
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test05UnZealotAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado() {
        // Arrange
        Zealot tipoZealot = new Zealot(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0, 0), tipoZealot);
        zealot.avanzarTurno(4);

        Zerling tipoZerling = new Zerling(new Ubicacion(0, 0), jugadorZerg); // Unidad de tierra
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0, 0), tipoZerling);
        zerling.avanzarTurno(2);

        // Act
        zealot.atacar(zerling);

        // Assert
        assertEquals(27, zerling.vidaRestante());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    /* Zerg */

    @Test
    void test06UnZanganoEsAtacadoPorUnZealotYLaVidaDelZanganotDisminuyeLoIndicado() {
        // Arrange
        Zealot tipoZealot = new Zealot(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0, 0), tipoZealot);
        zealot.avanzarTurno(4);

        Zangano tipoZangano = new Zangano(new Ubicacion(0, 0), jugadorZerg); // Unidad de tierra
        Unidad zangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0, 0), tipoZangano);
        zangano.avanzarTurno(1);

        // Act
        zealot.atacar(zangano);

        // Assert
        assertEquals(17, zangano.vidaRestante());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test07UnZerlingAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado() {
        // Arrange
        Zerling tipoZerling = new Zerling(new Ubicacion(0, 0), jugadorZerg); // Ataque de tierra
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0, 0), tipoZerling);
        zerling.avanzarTurno(2);

        Zealot tipoZealot = new Zealot(new Ubicacion(0, 0), jugadorProtoss); // Unidad de tierra
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0, 0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        zerling.atacar(zealot);

        // Assert
        assertEquals(56, tipoZealot.escudoRestante());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test08UnHidraliscoAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado() {
        // Arrange
        Hidralisco tipoHidralisco = new Hidralisco(new Ubicacion(0, 0), jugadorZerg); // Ataque de tierra y aire
        Unidad hidralisco = new Unidad(new Tiempo(CONSTRUCCION_HIDRALISCO), new Ubicacion(0, 0), tipoHidralisco);
        hidralisco.avanzarTurno(4);

        Zealot tipoZealot = new Zealot(new Ubicacion(0, 0), jugadorProtoss); // Unidad de tierra
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0, 0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        hidralisco.atacar(zealot);

        // Assert
        assertEquals(50, tipoZealot.escudoRestante()); // Solo se considera el ataque de tierra del Hidralisco
    }

    @Test
    void test09UnHidraliscoAtacaAUnScoutYElEscudoDelScoutDisminuyeLoIndicado() {
        // Arrange
        Hidralisco tipoHidralisco = new Hidralisco(new Ubicacion(0, 0), jugadorZerg); // Ataque de tierra y aire
        Unidad hidralisco = new Unidad(new Tiempo(CONSTRUCCION_HIDRALISCO), new Ubicacion(0, 0), tipoHidralisco);
        hidralisco.avanzarTurno(4);

        Scout tipoScout = new Scout(new Ubicacion(0, 0), jugadorProtoss); // Unidad de Aire
        Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), new Ubicacion(0, 0), tipoScout);
        scout.avanzarTurno(9);

        // Act
        hidralisco.atacar(scout);

        // Assert
        assertEquals(90, tipoScout.escudoRestante()); // Solo se considera el ataque de aire del Hidralisco
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test10UnMutaliscoAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado() {
        // Arrange
        Mutalisco tipoMutalisco = new Mutalisco(new Ubicacion(0, 0), jugadorZerg); // Ataque de tierra y aire
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0, 0), tipoMutalisco);
        mutalisco.avanzarTurno(7);

        Zealot tipoZealot = new Zealot(new Ubicacion(0, 0), jugadorProtoss); // Unidad de tierra
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0, 0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        mutalisco.atacar(zealot);

        // Assert
        assertEquals(51, tipoZealot.escudoRestante()); // Solo se considera el ataque de tierra del Mutalisco
    }

    @Test
    void test11UnMutaliscoAtacaAUnScoutYElEscudoDelScoutDisminuyeLoIndicado() {
        // Arrange
        Mutalisco tipoMutalisco = new Mutalisco(new Ubicacion(0, 0), jugadorZerg); // Ataque de tierra y aire
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0, 0), tipoMutalisco);
        mutalisco.avanzarTurno(7);

        Scout tipoScout = new Scout(new Ubicacion(0, 0), jugadorProtoss); // Unidad de Aire
        Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), new Ubicacion(0, 0), tipoScout);
        scout.avanzarTurno(9);

        // Act
        mutalisco.atacar(scout);

        // Assert
        assertEquals(91, tipoScout.escudoRestante()); // Solo se considera el ataque de aire del Mutalisco
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test11UnGuardianAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        Guardian tipoGuardian = new Guardian(new Ubicacion(0, 0), jugadorZerg); // Ataque de tierra
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0, 0), tipoGuardian);
        guardian.avanzarTurno(4);

        Zealot tipoZealot = new Zealot(new Ubicacion(0, 0), jugadorProtoss); // Unidad de tierra
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0, 0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        guardian.atacar(zealot);

        // Assert
        assertEquals(35, tipoZealot.escudoRestante());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test12UnaUnidadAtacaAAmoSupremoYSuVidaDisminuyeLoIndicado(){
        // Arrange
        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        AmoSupremo tipoAmoSupremo = new AmoSupremo(new Ubicacion(0,0), jugadorZerg); // Unidad de aire
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0, 0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);

        // Act
        dragon.atacar(amoSupremo);

        // Assert
        assertEquals(180, amoSupremo.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }
}