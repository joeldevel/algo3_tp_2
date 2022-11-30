package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso31Test {

    /* Protoss */

    @Test
    public void test01AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnZealot() {
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearZealot();
        pilon.recibirAtaque(600);
        jugadorProtoss.avanzarTurno();
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot());
    }

    @Test
    public void test02AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnDragon() {
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearZealot();
        pilon.recibirAtaque(600);
        jugadorProtoss.avanzarTurno();
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon());
    }

    @Test
    public void test03AlDestruirUnPilonDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnScout() {
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearZealot();
        pilon.recibirAtaque(600);
        jugadorProtoss.avanzarTurno();
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout());
    }

    /* Zerg */

    @Test
    public void test04AlDestruirUnCriaderoDisminuyeElNumeroDePoblacionYNoEsPosibleCrearUnZangano() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearZangano();
        criadero.recibirAtaque(500);
        jugadorZerg.avanzarTurno();
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }
}

