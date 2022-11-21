package edu.fiuba.algo3.entrega_1;

class UbicacionTest {
	
	
    /*@Test
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
     *

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
    }/*

    /* falta probar con otros edificios que se puede construir aun cuando criadero*/
}