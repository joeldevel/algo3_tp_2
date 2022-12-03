package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspiralTest {

    @Test
    void test04SeConstruyeUnaEspiralYDespuesDeDiezTurnosSeEncuentraOperativa(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        
       // Falta la logica de Espiral.
    }
}
