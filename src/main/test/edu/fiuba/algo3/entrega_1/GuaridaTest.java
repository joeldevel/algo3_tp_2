package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Guarida.Guarida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

class GuaridaTest {
	
	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	Tiempo tiempo = new Tiempo(-12);
	Vida vida = new Vida(1250,10);

    @Test
    void test01SeConstruyeUnaGuaridaYRecibeDanio(){
        // Arrange
        Guarida guarida = new Guarida(tiempo,requisitos,vida, 200, 100);
        guarida.recibirDanio(10);

        // Act
        int resultado = guarida.obtenerVida();

        // Assert
        assertEquals(resultado, 1240);
    }

    @Test
    void test02SeConstruyeUnaGuaridaQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Guarida guarida = new Guarida(tiempo,requisitos,vida, 200, 100);
        guarida.recibirDanio(10);

        // Act
        guarida.avanzarTurno();

        // Assert
        assertEquals(guarida.obtenerVida(), 1250);
    }
}
