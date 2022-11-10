package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoDeEdificio;
import edu.fiuba.algo3.modelo.GasVespeno;
import edu.fiuba.algo3.modelo.Larva;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.SinGas;
import edu.fiuba.algo3.modelo.SinRequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Extractor.Extractor;
import edu.fiuba.algo3.modelo.ReservaDeProduccion.ReservaDeProduccion;

class UbicacionTest {
	
	Vida vida = new Vida(500,10);
	Tiempo tiempo = new Tiempo(-4);
	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	ArrayList<CostoDeConstruccion> costos = new ArrayList<CostoDeConstruccion>();
	EstadoDeEdificio estado = new EnConstruccion();
	Moho moho = new Moho(5,new Tiempo(0));
	ArrayList<Larva> larvas = new ArrayList<Larva>();

    @Test
    void test01EnUnaUbicacionSinMohoYSinGasSeDeberiaPoderConstruirUnCriadero() {

        Ubicacion ubicacion = new Ubicacion();
        Criadero criadero = new Criadero(vida, tiempo, requisitos, costos,estado,moho,larvas);
        
        ubicacion.agregarRequisito(new SinGas());

        assertTrue(ubicacion.sePuedeConstruir(criadero));

    }
    
    @Test
    void test02EnUnaUbicacionConMohoYConGasNoSeDeberiaPoderConstruirUnCriadero() {
    	
    	Ubicacion ubicacion = new Ubicacion();
    	requisitos.add(new SinGas());
    	Criadero criadero = new Criadero(vida, tiempo, requisitos, costos,estado,moho,larvas);
    	
    	ubicacion.agregarRequisito(new Moho(5,new Tiempo(0)));
    	ubicacion.agregarRequisito(new GasVespeno());
    	
    	assertFalse(ubicacion.sePuedeConstruir(criadero));
    }

    @Test
    void test03EnUnaUbicacionConMohoYSinGasSeDeberiaPoderConstruirUnCriadero() {

        Ubicacion ubicacion = new Ubicacion();
        Criadero criadero = new Criadero(vida, tiempo, requisitos, costos,estado,moho,larvas);
        
        ubicacion.agregarRequisito(new Moho(5,new Tiempo(0)));
        ubicacion.agregarRequisito(new SinGas());

        assertTrue(ubicacion.sePuedeConstruir(criadero));
    }

    @Test
    void test04EnUnaUbicacionSinMohoYConGasNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        requisitos.add(moho);
        requisitos.add(new GasVespeno());
        Extractor extractor = new Extractor(new Vida(750,10),new Tiempo(-6),requisitos,costos,10);
        
        ubicacion.agregarRequisito(new GasVespeno());

        assertFalse(ubicacion.sePuedeConstruir(extractor));
    }

    @Test
    void test05EnUnaUbicacionConMohoPeroSinGasNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        requisitos.add(moho);
        requisitos.add(new GasVespeno());
        Extractor extractor = new Extractor(new Vida(750,10),new Tiempo(-6),requisitos,costos,10);
        
        ubicacion.agregarRequisito(new Moho(5,new Tiempo(0)));
        ubicacion.agregarRequisito(new SinGas());

        assertFalse(ubicacion.sePuedeConstruir(extractor));
    }

    @Test
    void test06EnUnaUbicacionSinMohoPeroConGasNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        requisitos.add(moho);
        requisitos.add(new GasVespeno());
        Extractor extractor = new Extractor(new Vida(750,10),new Tiempo(-6),requisitos,costos,10);
        
        ubicacion.agregarRequisito(new GasVespeno());

        assertFalse(ubicacion.sePuedeConstruir(extractor));
    }

    @Test
    void test07EnUnaUbicacionConMohoYConGasSeDeberiaPoderConstruriUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        requisitos.add(moho);
        requisitos.add(new GasVespeno());
        Extractor extractor = new Extractor(new Vida(750,10),new Tiempo(-6),requisitos,costos,10);
        
        ubicacion.agregarRequisito(new Moho(5,new Tiempo(0)));
        ubicacion.agregarRequisito(new GasVespeno());

        assertTrue(ubicacion.sePuedeConstruir(extractor));
    }
    
    @Test
    void test08EnUnaUbicacionSinMohoYSinGasNoSeDeberiaPoderConstruirUnExtractor() {
    	
    	Ubicacion ubicacion = new Ubicacion();
    	requisitos.add(moho);
        requisitos.add(new GasVespeno());
        Extractor extractor = new Extractor(new Vida(750,10),new Tiempo(-6),requisitos,costos,10);
        
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
        requisitos.add(new SinGas());
        ArrayList<RequisitoDeConstruccion> otrosRequisitos = new ArrayList<RequisitoDeConstruccion>();
        otrosRequisitos.add(moho);
        otrosRequisitos.add(new SinGas());
        Criadero criadero = new Criadero(vida, tiempo, requisitos, costos,estado,moho,larvas);
        ReservaDeProduccion reserva = new ReservaDeProduccion(new Vida(1000,10),new Tiempo(-12),otrosRequisitos,costos);
        
        ubicacion.agregarRequisito(new SinGas());
        ubicacion.construir(criadero);
        ubicacion.destruirEdificio();

        assertTrue(ubicacion.sePuedeConstruir(reserva));
    }

    /* falta probar con otros edificios que se puede construir aun cuando criadero*/
}