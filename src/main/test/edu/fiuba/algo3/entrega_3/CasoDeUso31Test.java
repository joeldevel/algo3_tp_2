package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
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


    /*@Test
    public void test03AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnZealot() {
        // Arrange
        Pilon pilon = new Pilon(new Ubicacion(0,0),jugadorProtoss);
        jugadorProtoss.agregarEdificio(pilon);

        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        jugadorProtoss.crearZealot(acceso);

        //Guardian tipoGuardian = new Guardian(jugadorZerg);
        //Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        //unidad.avanzarTurno(4);

        //for(int i = 0; i < 24; i++) {
        //    unidad.atacar(pilon);
        //}

        jugadorProtoss.eliminarEdificio(pilon);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot(acceso));
    }

    @Test
    public void test04AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnDragon() {
        // Arrange
        Pilon pilon = new Pilon(new Ubicacion(0,0),jugadorProtoss);
        jugadorProtoss.agregarEdificio(pilon);

        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        jugadorProtoss.crearZealot(acceso);

        //Guardian tipoGuardian = new Guardian(jugadorZerg);
        //Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        //unidad.avanzarTurno(4);

        //for(int i = 0; i < 24; i++) {
        //    unidad.atacar(pilon);
        //}

        jugadorProtoss.eliminarEdificio(pilon);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon(acceso));
    }

    @Test
    public void test05AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnScout() {
        // Arrange
        Pilon pilon = new Pilon(new Ubicacion(0,0),jugadorProtoss);
        jugadorProtoss.agregarEdificio(pilon);

        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        jugadorProtoss.crearZealot(acceso);

        //Guardian tipoGuardian = new Guardian(jugadorZerg);
        //Unidad guardian = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        //guardian.avanzarTurno(4);

        //for(int i = 0; i < 24; i++) {
        //    guardian.atacar(pilon);
        //}

        jugadorProtoss.eliminarEdificio(pilon);
        PuertoEstelar puerto = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout(puerto));
    }*/

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
        Criadero primerCriadero = new Criadero(new Ubicacion(0,0),jugadorZerg);
        jugadorZerg.agregarEdificio(primerCriadero);
        Criadero segundoCriadero = new Criadero(new Ubicacion(0,0),jugadorZerg);
        jugadorZerg.agregarEdificio(segundoCriadero);
        Criadero tercerCriadero = new Criadero(new Ubicacion(0,0),jugadorZerg);
        jugadorZerg.agregarEdificio(tercerCriadero);

        //Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        //Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        //dragon.avanzarTurno(6);

        // Act
        //for(int i = 0; i < 25; i++) {
        //    dragon.atacar(criadero);
        //}

        jugadorZerg.eliminarEdificio(tercerCriadero);

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
        jugadorZerg.crearAmoSupremo(new Ubicacion(0,3));
        jugadorZerg.crearAmoSupremo(new Ubicacion(0,4));
        jugadorZerg.crearAmoSupremo(new Ubicacion(0,5));

        // Assert
        assertEquals(30, jugadorZerg.calcularPoblacion());
    }

    /*@Test
    public void test09SeConstruyeUnCriaderoYUnZanganoYAlDestruirElCriaderoDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnSegundoZangano() {
        // Arrange
        Criadero criadero = new Criadero(new Ubicacion(0,0),jugadorZerg);
        jugadorZerg.agregarEdificio(criadero);

        Criadero criaderoUnidad = new Criadero(new Ubicacion(0,0), jugadorZerg);
        jugadorZerg.crearZangano(criaderoUnidad);

        //Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        //Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        //dragon.avanzarTurno(6);

        //for(int i = 0; i < 25; i++) {
        //    dragon.atacar(criadero);
        //}

        jugadorZerg.eliminarEdificio(criadero);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano(criaderoUnidad));
    }

    @Test
    public void test10SeConstruyeUnAmoSupremoYUnZanganoYAlDestruirElAmoSupremoDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnSegundoZangano() {
        // Arrange
        Unidad amoSupremo = jugadorZerg.crearAmoSupremo(new Ubicacion(0,0));
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.crearZangano(criadero);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        for(int i = 0; i < 10; i++) {
            dragon.atacar(amoSupremo);
        }

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano(criadero));
    }*/
}