package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Espiral.Espiral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

class EspiralTest {
	
	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	Tiempo tiempo = new Tiempo(-10);
	Vida vida = new Vida(1300,10);


    @Test
    void test01SeConstruyeUnaEspiralYRecibeDanio(){
        // Arrange
        Espiral espiral = new Espiral(tiempo, requisitos, vida, 150, 100);
        espiral.recibirDanio(10);

        // Act
        int resultado = espiral.obtenerVida();

        // Assert
        assertEquals(resultado, 1290);
    }

    @Test
    void test02SeConstruyeUnaEspiralQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Espiral espiral = new Espiral(tiempo, requisitos, vida, 150, 100);
        espiral.recibirDanio(10);

        // Act
        espiral.avanzarTurno();

        // Assert
        assertEquals(espiral.obtenerVida(), 1300);
    }
}
