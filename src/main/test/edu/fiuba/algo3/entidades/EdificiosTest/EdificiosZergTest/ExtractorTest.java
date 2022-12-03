package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtractorTest {

    @Test
    void test08SeConstruyeUnExtractorYRecibeDanio(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.recibirAtaque(10);

        // Act
        int resultado = extractor.obtenerVida();

        // Assert
        assertEquals(resultado, 740);
    }

    @Test
    void test09SeConstruyeUnExtractorQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.recibirAtaque(10);

        // Act
        extractor.avanzarTurno(1);

        // Assert
        assertEquals(extractor.obtenerVida(), 750);
    }
}