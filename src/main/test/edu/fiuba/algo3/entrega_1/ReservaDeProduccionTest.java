package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.ReservaDeProduccion.ReservaDeProduccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

class ReservaDeProduccionTest {
	
	Vida vida = new Vida(1000,10);
	Tiempo tiempo = new Tiempo(-12);
	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	ArrayList<CostoDeConstruccion> costos = new ArrayList<CostoDeConstruccion>();
	
    @Test
    void test01SeConstruyeUnaReservaDeProduccionYRecibeDanio(){
        // Arrange
        ReservaDeProduccion rdp = new ReservaDeProduccion(vida, tiempo, requisitos, costos);
        rdp.recibirDanio(10);

        // Act
        int resultado = rdp.obtenerVida();

        // Assert
        assertEquals(resultado, 990);
    }

    @Test
    void test02SeConstruyeUnaReservaDeProduccionQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        ReservaDeProduccion rdp = new ReservaDeProduccion(vida, tiempo, requisitos, costos);
        rdp.recibirDanio(10);

        // Act
        rdp.avanzarTurno();

        // Assert
        assertEquals(rdp.obtenerVida(), 1000);
    }
}
