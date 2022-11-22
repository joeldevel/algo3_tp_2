package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Excepciones.EdificoInvalidoParaConstruirSobreVolcanException;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso3 {

    /*@Test
    void test01SeIntentaCrearUnEspiralSobreUnVolcanYLanzaUnaExcepcion(){
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 150);
        Espiral espiral = new Espiral(recursosJugador);

        // Act and Assert
        assertThrows(EdificoInvalidoParaConstruirSobreVolcanException.class,()->{
            volcan.construirRefineriaDeGas(espiral); No deja
        });
    } */
}
