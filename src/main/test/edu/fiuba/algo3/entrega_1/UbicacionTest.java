package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.GasVespeno;
import edu.fiuba.algo3.modelo.Larva;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.SinGas;
import edu.fiuba.algo3.modelo.SinRequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Criadero.Criadero;
import edu.fiuba.algo3.modelo.Extractor.Extractor;
import edu.fiuba.algo3.modelo.ReservaDeProduccion.ReservaDeProduccion;

class UbicacionTest {
	
	
    @Test
    void test01EnUnaUbicacionSinMohoYSinGasSeDeberiaPoderConstruirUnCriadero() {

        Ubicacion ubicacion = new Ubicacion();
        Criadero criadero = new Criadero();
        
        ubicacion.agregarRequisito(new SinGas());

        assertTrue(ubicacion.sePuedeConstruir(criadero));

    }
    
    @Test
    void test02EnUnaUbicacionConMohoYConGasNoSeDeberiaPoderConstruirUnCriadero() {
    	
    	Ubicacion ubicacion = new Ubicacion();
    
    	Criadero criadero = new Criadero();
    	
    	ubicacion.agregarRequisito(new Moho());
    	ubicacion.agregarRequisito(new GasVespeno());
    	
    	assertFalse(ubicacion.sePuedeConstruir(criadero));
    }

    @Test
    void test03EnUnaUbicacionConMohoYSinGasSeDeberiaPoderConstruirUnCriadero() {

        Ubicacion ubicacion = new Ubicacion();
        Criadero criadero = new Criadero();
        
        ubicacion.agregarRequisito(new Moho());
        ubicacion.agregarRequisito(new SinGas());

        assertTrue(ubicacion.sePuedeConstruir(criadero));
    }

    @Test
    void test04EnUnaUbicacionSinMohoYConGasNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        Extractor extractor = new Extractor();
        
        ubicacion.agregarRequisito(new GasVespeno());

        assertFalse(ubicacion.sePuedeConstruir(extractor));
    }

    @Test
    void test05EnUnaUbicacionConMohoPeroSinGasNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        Extractor extractor = new Extractor();
        
        ubicacion.agregarRequisito(new Moho());
        ubicacion.agregarRequisito(new SinGas());

        assertFalse(ubicacion.sePuedeConstruir(extractor));
    }

    @Test
    void test06EnUnaUbicacionSinMohoPeroConGasNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        Extractor extractor = new Extractor();
        
        ubicacion.agregarRequisito(new GasVespeno());

        assertFalse(ubicacion.sePuedeConstruir(extractor));
    }

    @Test
    void test07EnUnaUbicacionConMohoYConGasSeDeberiaPoderConstruriUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        Extractor extractor = new Extractor();
        
        ubicacion.agregarRequisito(new Moho());
        ubicacion.agregarRequisito(new GasVespeno());

        assertTrue(ubicacion.sePuedeConstruir(extractor));
    }
    
    @Test
    void test08EnUnaUbicacionSinMohoYSinGasNoSeDeberiaPoderConstruirUnExtractor() {
    	
    	Ubicacion ubicacion = new Ubicacion();
    	Extractor extractor = new Extractor();
        
    	ubicacion.agregarRequisito(new SinGas());
    	
    	assertFalse(ubicacion.sePuedeConstruir(extractor));
    }

    /* en esta parte habria que probar mas edificios, como por ejemplo guarida
     * donde un requisito de construccion es una reserva de produccion, o un espiral
     * donde una requisito de construccion es una guarida
     * */

    @Test
    void test09UnaUbicacionNuevaComienzaSinEdificios() {

        Ubicacion ubicacion = new Ubicacion();

        assertFalse(ubicacion.tieneEdificio());
    }

    @Test
    void test10EnUnaUbicacionConCriaderoDestruidoSePuedenConstruir() {

        Ubicacion ubicacion = new Ubicacion();
        Criadero criadero = new Criadero();
        ReservaDeProduccion reserva = new ReservaDeProduccion();
        
        ubicacion.agregarRequisito(new SinGas());
        ubicacion.construir(criadero);
        ubicacion.destruirEdificio();

        assertTrue(ubicacion.sePuedeConstruir(reserva));
    }

    /* falta probar con otros edificios que se puede construir aun cuando criadero*/
}