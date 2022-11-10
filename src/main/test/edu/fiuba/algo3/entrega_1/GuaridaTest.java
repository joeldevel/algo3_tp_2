package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Guarida.Guarida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

class GuaridaTest {
	
	Vida vida = new Vida(1250,10);
	Tiempo tiempo = new Tiempo(-12);
	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	ArrayList<CostoDeConstruccion> costos = new ArrayList<CostoDeConstruccion>();
	
    @Test
    void test01SeConstruyeUnaGuaridaYRecibeDanio(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);
        guarida.recibirDanio(10);

        // Act
        int resultado = guarida.obtenerVida();

        // Assert
        assertEquals(resultado, 1240);
    }

    @Test
    void test02SeConstruyeUnaGuaridaQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);
        guarida.recibirDanio(10);

        // Act
        guarida.avanzarTurno();

        // Assert
        assertEquals(guarida.obtenerVida(), 1250);
    }
}
