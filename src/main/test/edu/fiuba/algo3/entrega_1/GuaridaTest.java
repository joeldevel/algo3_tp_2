package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Guarida.Guarida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class GuaridaTest {
	
	Vida vida = new Vida(1250,10);
	Tiempo tiempo = new Tiempo(-12);
	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	ArrayList<CostoDeConstruccion> costos = new ArrayList<CostoDeConstruccion>();

    @Test
    void test01SeConstruyeUnaGuaridaYNoSeEncuentraOperativa(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            guarida.evolucionarLarva();
        });
    }

    @Test
    void test02SeConstruyeUnaGuaridaYRecibeDanioAunSinEstarOperativaYElResultadoEsElIndicado(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);
        guarida.recibirDanio(10);

        // Act
        int resultado = guarida.obtenerVida();

        // Assert
        assertEquals(resultado, 1240);
    }

    @Test
    void test03SeConstruyeUnaGuaridaYDespuesDeDoceTurnosSeEncuentraOperativa(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();

        // Act
        boolean resultado = guarida.evolucionarLarva();

        // Assert
        assertTrue(resultado);
    }

    @Test
    void test04SeConstruyeUnaGuaridaYDespuesDeDoceTurnosRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();

        guarida.recibirDanio(10);

        // Act
        int resultado = guarida.obtenerVida();

        // Assert
        assertEquals(resultado, 1240);
    }

    @Test
    void test05SeConstruyeUnaGuaridaYDespuesDeDoceTurnosRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.recibirDanio(10);

        // Act
        guarida.avanzarTurno();

        // Assert
        assertEquals(guarida.obtenerVida(), 1250);
    }


    @Test
    void test06SeConstruyeUnaGuaridaYRecibeDanio(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);
        guarida.recibirDanio(10);

        // Act
        int resultado = guarida.obtenerVida();

        // Assert
        assertEquals(resultado, 1240);
    }

    @Test
    void test07SeConstruyeUnaGuaridaQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Guarida guarida = new Guarida(vida, tiempo, requisitos, costos);
        guarida.recibirDanio(10);

        // Act
        guarida.avanzarTurno();

        // Assert
        assertEquals(guarida.obtenerVida(), 1250);
    }
}
