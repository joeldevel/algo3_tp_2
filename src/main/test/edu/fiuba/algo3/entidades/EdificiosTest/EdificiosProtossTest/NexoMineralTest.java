package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NexoMineralTest {

    @Test
    void test05SeConstruyeUnNexoMineralQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.recibirAtaque(400); // Le sacamos todo el escudo con 250 de daño y luego 150 de vida.

        // Act
        nexoMineral.avanzarTurno(25); // Recupera (250 x 0.05) = 12 de escudo por turno.

        // Assert
        assertEquals(250, nexoMineral.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnNexoMineralQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.recibirAtaque(400); // Le sacamos todo el escudo con 250 de daño y luego 150 de vida.

        // Act
        nexoMineral.avanzarTurno(25);

        // Assert
        assertEquals(100, nexoMineral.obtenerVida());
    }
}