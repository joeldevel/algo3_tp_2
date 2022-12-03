package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccesoTest {

    @Test
    void test02SeConstruyeUnAccesoYDespuesDeOchoTurnosSeEncuentraOperativo(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        // Falta implementar la logica de Acceso.
    }
}