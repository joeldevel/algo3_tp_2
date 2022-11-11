package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.PuertoEstelar.PuertoEstelar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PuertoEstelarTest {

    Vida vida = new Vida(600,0);

    Escudo escudo = new Escudo(600,10);

    Tiempo tiempo = new Tiempo(-10);
    ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
    ArrayList<CostoDeConstruccion> costos = new ArrayList<CostoDeConstruccion>();

    @Test
    void test01SeConstruyeUnPuertoEstelarYNoSeEncuentraOperativo(){
        // Arrange
        PuertoEstelar puertoEstelar = new PuertoEstelar(vida, tiempo, requisitos, costos, escudo);

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            puertoEstelar.transportarUnidades();
        });
    }

    @Test
    void test02SeConstruyeUnPuertoEstelarYDespuesDeDiezTurnosSeEncuentraOperativo(){
        // Arrange
        PuertoEstelar puertoEstelar = new PuertoEstelar(vida, tiempo, requisitos, costos, escudo);
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();
        puertoEstelar.avanzarTurno();

        // Act
        boolean resultado = puertoEstelar.transportarUnidades();

        // Assert
        assertTrue(resultado);
    }
}
