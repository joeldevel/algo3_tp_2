package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CONSTRUCCION_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.CONSTRUCCION_ZERLING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso31Test {

    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000, 1000));
    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000, 1000));

    /* Protoss */

    @Test
    public void test01ConstruirTresPilonesAumentaElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange
        Recursos recursos = new Recursos(0, 600);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        // Act
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));
        jugadorProtoss.crearPilon(new Ubicacion(0,2));

        // Assert
        assertEquals(15, jugadorProtoss.calcularPoblacion());
    }

    @Test
    public void test02ConstruirTresPilonesYDestruirUnoDisminuyeElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange
        Recursos recursos = new Recursos(0, 600);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));
        Pilon pilon = jugadorProtoss.crearPilon(new Ubicacion(0,2));

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        for(int i = 0; i < 24; i++) {
            unidad.atacar(pilon);
        }

        // Assert
        assertEquals(10, jugadorProtoss.calcularPoblacion());
    }


    @Test
    public void test03AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnZealot() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearZealot();

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 24; i++) {
            unidad.atacar(pilon);
        }

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot());
    }

    @Test
    public void test04AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnDragon() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearZealot();

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 24; i++) {
            unidad.atacar(pilon);
        }

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon());
    }

    @Test
    public void test05AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnScout() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearZealot();

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        guardian.avanzarTurno(4);

        for(int i = 0; i < 24; i++) {
            guardian.atacar(pilon);
        }

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout());
    }

    /* Zerg */

    @Test
    public void test06ConstruirTresCriaderosAumentaElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange
        Recursos recursos = new Recursos(0, 600);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        // Act
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(0,1));
        jugadorZerg.crearCriadero(new Ubicacion(0,2));

        // Assert
        assertEquals(15, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test07ConstruirTresCriaderosYDestruirUnoDisminuyeElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange
        Recursos recursos = new Recursos(0, 600);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(0,1));
        Criadero criadero = jugadorZerg.crearCriadero(new Ubicacion(0,2));

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        for(int i = 0; i < 25; i++) {
            dragon.atacar(criadero);
        }

        // Assert
        assertEquals(10, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test08ConstruirTresCriaderosYTresAmosSupremosAumentaElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange
        Recursos recursos = new Recursos(0, 750);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        // Act
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(0,1));
        jugadorZerg.crearCriadero(new Ubicacion(0,2));
        jugadorZerg.crearAmoSupremo(new Ubicacion(0,3));
        jugadorZerg.crearAmoSupremo(new Ubicacion(0,4));
        jugadorZerg.crearAmoSupremo(new Ubicacion(0,5));

        // Assert
        assertEquals(30, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test09SeConstruyeUnCriaderoYUnZanganoYAlDestruirElCriaderoDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnSegundoZangano() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearZangano();

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        for(int i = 0; i < 25; i++) {
            dragon.atacar(criadero);
        }

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }

    @Test
    public void test10SeConstruyeUnAmoSupremoYUnZanganoYAlDestruirElAmoSupremoDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnSegundoZangano() {
        // Arrange
        Recursos recursos = new Recursos(0, 50);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Unidad amoSupremo = jugadorZerg.crearAmoSupremo(new Ubicacion(0,0));
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.crearZangano();

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        for(int i = 0; i < 10; i++) {
            dragon.atacar(amoSupremo);
        }

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }
}