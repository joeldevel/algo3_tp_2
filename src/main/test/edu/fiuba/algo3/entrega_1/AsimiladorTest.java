package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Volcan;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AsimiladorTest {

    @Test
    void test01SeConstruyeUnAsimiladorEnUnVolcanYNoSeEncuentraOperativo(){
        Asimilador asimilador = new Asimilador();
        Volcan volcan = new Volcan(5000);
        volcan.construirRefineriaDeGas(asimilador);

        assertThrows(EdificioNoOperativoException.class,()->{
            volcan.extraerGasUsandoRefineria();
        });
    }

    @Test
    void test02SeConstruyeUnAsimiladorEnUnVolcanYLuegoDeSeisTurnosSeExtraeGasYDevuelveElResultadoIndicado(){
        // Arrange
        Asimilador asimilador = new Asimilador();
        Volcan volcan = new Volcan(5000);
        volcan.construirRefineriaDeGas(asimilador);
        
        asimilador.avanzarTurno(6);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(resultado, 20);
    }
}
