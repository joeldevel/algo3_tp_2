package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso30Test {

    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000));
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000));

    /* Protoss */

    @Test
    public void test01JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnZealot() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(i,0), jugadorProtoss));
        }

        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot(acceso);
        }

        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(1,1), jugadorProtoss));

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot(acceso));
    }

    @Test
    public void test02JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnDragon() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(i,0), jugadorProtoss));
        }

        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot(acceso);
        }

        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(1,1), jugadorProtoss));

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon(acceso));
    }

    @Test
    public void test03JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnScout() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(i,0), jugadorProtoss));
        }

        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot(acceso);
        }

        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(1,1), jugadorProtoss));
        PuertoEstelar puerto = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout(puerto));
    }

    /* Zerg */

    @Test
    public void test04JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnZangano() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(i,0),jugadorZerg));
        } 

        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano(criadero);
        }

        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(1,1),jugadorZerg));

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano(criadero));
    }

    @Test
    public void test05JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnZerling() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(i,0),jugadorZerg));
        }

        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano(criadero);
        }

        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(1,1),jugadorZerg));
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(new Ubicacion(0,0), jugadorZerg);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling(reserva));
    }

    @Test
    public void test06JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnHidralisco() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(i,0),jugadorZerg));
        }

        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano(criadero);
        }

        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(1,1),jugadorZerg));
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco(guarida));
    }

    @Test
    public void test07JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnMutalisco() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(i,0),jugadorZerg));
        }

        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano(criadero);
        }

        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(1,1),jugadorZerg));
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco(espiral));
    }
}