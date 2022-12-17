package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CONSTRUCCION_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso31Test {

    Mapa mapa = new Mapa();
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000, 1000), mapa);
    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000, 1000), mapa);

    /* Protoss */

    @Test
    public void test01ConstruirTresPilonesAumentaElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange

        // Act
        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(0,0),jugadorProtoss));
        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(0,1),jugadorProtoss));
        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(0,2),jugadorProtoss));

        // Assert
        assertEquals(15, jugadorProtoss.calcularPoblacion());
    }

    @Test
    public void test02ConstruirTresPilonesYDestruirUnoDisminuyeElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange
        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(0,0),jugadorProtoss));
        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(0,1),jugadorProtoss));
        Pilon pilon = new Pilon(new Ubicacion(0,2),jugadorProtoss);

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
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        Pilon pilon = (Pilon) mapa.obtenerEdificioEn(new Ubicacion(0,0));

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 24; i++) {
            unidad.atacar(pilon);
        }

        // Act
        jugadorProtoss.construir("Zealot", new Ubicacion(1,1), jugadorZerg, mapa);

        // Assert
        assertEquals(0, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test04AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnDragon() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        Pilon pilon = (Pilon) mapa.obtenerEdificioEn(new Ubicacion(0,0));

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 24; i++) {
            unidad.atacar(pilon);
        }

        // Act
        jugadorProtoss.construir("Dragon", new Ubicacion(1,1), jugadorZerg, mapa);

        // Assert
        assertEquals(0, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test05AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnScout() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        Pilon pilon = (Pilon) mapa.obtenerEdificioEn(new Ubicacion(0,0));

        jugadorProtoss.construir("Acceso", new Ubicacion(1,0), jugadorZerg, mapa);
        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(1,1), jugadorZerg, mapa);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 24; i++) {
            unidad.atacar(pilon);
        }

        // Act
        jugadorProtoss.construir("Scout", new Ubicacion(1,1), jugadorZerg, mapa);

        // Assert
        assertEquals(0, jugadorProtoss.calcularSuministro());
    }

    /* Zerg */

    @Test
    public void test06ConstruirTresCriaderosAumentaElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange

        // Act
        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(0,0),jugadorZerg));
        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(0,1),jugadorZerg));
        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(0,2),jugadorZerg));

        // Assert
        assertEquals(15, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test07ConstruirTresCriaderosYDestruirUnoDisminuyeElNumeroDePoblacionDeLaFormaIndicada() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Criadero", new Ubicacion(1,1), jugadorProtoss, mapa);
        jugadorZerg.construir("Criadero", new Ubicacion(2,2), jugadorProtoss, mapa);

        Criadero criadero = (Criadero) mapa.obtenerEdificioEn(new Ubicacion(0,0));

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
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

        // Act
        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(0,0),jugadorZerg));
        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(0,1),jugadorZerg));
        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(0,2),jugadorZerg));
        jugadorZerg.construir("AmoSupremo", new Ubicacion(0,3), jugadorProtoss, mapa);
        jugadorZerg.construir("AmoSupremo", new Ubicacion(0,4), jugadorProtoss, mapa);
        jugadorZerg.construir("AmoSupremo", new Ubicacion(0,5), jugadorProtoss, mapa);

        // Assert
        assertEquals(30, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test09SeConstruyeUnCriaderoYUnZanganoYAlDestruirElCriaderoDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnSegundoZangano() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);
        Criadero criadero = (Criadero) mapa.obtenerEdificioEn(new Ubicacion(0,0));

        for(int i = 0; i < 5; i++) {
            jugadorZerg.avanzarTurno();
        }

        jugadorZerg.construir("Zangano", new Ubicacion(0, 0), jugadorProtoss, mapa);

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(1, 1), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        for(int i = 0; i < 25; i++) {
            dragon.atacar(criadero);
        }

        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Act
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test10SeConstruyeUnCriaderoYUnAmoSupremoYCincoZanganosYAlDestruirElAmoSupremoDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnSextoZangano() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("AmoSupremo", new Ubicacion(1,1), jugadorProtoss, mapa);
        Unidad amo = (Unidad) mapa.obtenerUnidadEnUbicacion(new Ubicacion(1,1));

        for(int i = 0; i < 5; i++) {
            jugadorZerg.avanzarTurno();
        }

        for(int i = 0; i < 5; i++) {
            jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);
            jugadorZerg.avanzarTurno();
        }

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(2, 2), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        for(int i = 0; i < 25; i++) {
            dragon.atacar(amo);
        }

        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Act
        assertEquals(5, jugadorZerg.calcularSuministro());
    }
}