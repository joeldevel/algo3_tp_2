package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Asimilador;
import edu.fiuba.algo3.modelo.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Extractor;
import edu.fiuba.algo3.modelo.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AsimiladorTest {

    @Test
    void test01SeConstruyeUnAsimiladorEnUnVolcanYNoSeEncuentraOperativo(){
        Asimilador asimilador = new Asimilador();
        Volcan volcan = new Volcan();
        volcan.construirRefineriaDeGas(asimilador);

        assertThrows(EdificioNoOperativoException.class,()->{
            volcan.extraerGasUsandoRefineria();
        });
    }

    @Test
    void test02SeConstruyeUnAsimiladorEnUnVolcanYLuegoDeSeisTurnosSeExtraeGasYDevuelveElResultadoIndicado(){
        // Arrange
        Asimilador asimilador = new Asimilador();
        Volcan volcan = new Volcan();
        volcan.construirRefineriaDeGas(asimilador);
        asimilador.avanzarTurno();
        asimilador.avanzarTurno();
        asimilador.avanzarTurno();
        asimilador.avanzarTurno();
        asimilador.avanzarTurno();
        asimilador.avanzarTurno();

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(20, resultado);
    }
}
