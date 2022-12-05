package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout.CONSTRUCCION_SCOUT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.CONSTRUCCION_ZEALOT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.CONSTRUCCION_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.CONSTRUCCION_ZERLING;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso19Test {

    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000, 1000));
    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000, 1000));

    /* Protoss */

    @Test
    void test01UnZealotAtacaAUnMutaliscoYLaVidaDelMutaliscoNoDisminuyeYaQueNoSonCompatibles() {
        // Arrange
        Zealot tipoZealot = new Zealot(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0, 0), tipoZealot);
        zealot.avanzarTurno(4);

        Mutalisco tipoMutalisco = new Mutalisco(new Ubicacion(0, 0), jugadorZerg); // Unidad de aire
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0, 0), tipoMutalisco);
        mutalisco.avanzarTurno(7);

        // Act
        zealot.atacar(mutalisco);

        // Assert
        assertEquals(120, mutalisco.vidaRestante()); // No son compatibles
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    /* Zerg */

    @Test
    void test02UnZerlingAtacaAUnScoutYElEscudoDelScoutNoDisminuyeYaQueNoSonCompatibles() {
        // Arrange
        Zerling tipoZerling = new Zerling(new Ubicacion(0, 0), jugadorZerg); // Ataque de tierra
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0, 0), tipoZerling);
        zerling.avanzarTurno(2);

        Scout tipoScout = new Scout(new Ubicacion(0, 0), jugadorProtoss); // Unidad de Aire
        Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), new Ubicacion(0, 0), tipoScout);
        scout.avanzarTurno(9);

        // Act
        zerling.atacar(scout);

        // Assert
        assertEquals(100, tipoScout.escudoRestante()); // No son compatibles
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test03UnGuardianAtacaAUnScoutYElEscudoDelScoutNoDisminuyeYaQueNoSonCompatibles(){
        // Arrange
        Guardian tipoGuardian = new Guardian(new Ubicacion(0, 0), jugadorZerg); // Ataque de tierra
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0, 0), tipoGuardian);
        guardian.avanzarTurno(4);

        Scout tipoScout = new Scout(new Ubicacion(0, 0), jugadorProtoss); // Unidad de Aire
        Unidad scout = new Unidad(new Tiempo(CONSTRUCCION_SCOUT), new Ubicacion(0, 0), tipoScout);
        scout.avanzarTurno(9);

        // Act
        guardian.atacar(scout);

        // Assert
        assertEquals(100, tipoScout.escudoRestante());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test04UnaUnidadAtacaAAmoSupremoYSuVidaNoDisminuyeLoIndicadoYaQueNoSonCompatibles(){
        // Arrange
        Zealot tipoZealot = new Zealot(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0, 0), tipoZealot);
        zealot.avanzarTurno(4);

        AmoSupremo tipoAmoSupremo = new AmoSupremo(new Ubicacion(0,0), jugadorZerg); // Unidad de aire
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0, 0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);

        // Act
        zealot.atacar(amoSupremo);

        // Assert
        assertEquals(200, amoSupremo.vidaRestante()); // No son compatibles
    }
}
