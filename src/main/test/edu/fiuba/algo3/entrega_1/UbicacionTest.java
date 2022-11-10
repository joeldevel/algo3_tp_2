package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.GasVespeno;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.SinRequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Extractor.Extractor;

class UbicacionTest {

    @Test
    void test01EnUnaUbicacionSinMohoSeDeberiaPoderConstruirUnCriadero() {

        Ubicacion ubicacion = new Ubicacion();

        assertTrue(ubicacion.sePuedeConstruir(new Criadero()));

    }

    @Test
    void test02EnUnaUbicacionConMohoSeDeberiaPoderConstruirUnCriadero() {

        Ubicacion ubicacion = new Ubicacion();

        ubicacion.agregarRequisito(new Moho());

        assertTrue(ubicacion.sePuedeConstruir(new Criadero()));
    }

    @Test
    void test03EnUnaUbicacionSinMohoNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();

        assertFalse(ubicacion.sePuedeConstruir(new Extractor(750, -6, 100, 0, 10)));
    }

    @Test
    void test04EnUnaUbicacionConMohoPeroSinGasNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();

        ubicacion.agregarRequisito(new Moho());

        assertFalse(ubicacion.sePuedeConstruir(new Extractor(750, -6, 100, 0, 10)));
    }

    @Test
    void test05EnUnaUbicacionSinMohoPeroConGasNoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();

        ubicacion.agregarRequisito(new GasVespeno());

        assertFalse(ubicacion.sePuedeConstruir(new Extractor(750, -6, 100, 0, 10)));
    }

    @Test
    void test06EnUnaUbicacionConMohoYGasSeDeberiaPoderConstruriUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();

        ubicacion.agregarRequisito(new Moho());
        ubicacion.agregarRequisito(new GasVespeno());

        assertTrue(ubicacion.sePuedeConstruir(new Extractor(750, -6, 100, 0, 10)));
    }

    /* en esta parte habria que probar mas edificios, como por ejemplo guarida
     * donde un requisito de construccion es una reserva de produccion, o un espiral
     * donde una requisito de construccion es una guarida
     * */

    @Test
    void test07UnaUbicacionNuevaComienzaSinEdificios() {

        Ubicacion ubicacion = new Ubicacion();

        assertFalse(ubicacion.tieneEdificio());
    }

    @Test
    void test08EnUnaUbicacionConCriaderoYGasSiSeDestruyeElCriaderoSeDeberiaPoderConstruirUnExtractor() {

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.agregarRequisito(new GasVespeno());
        ubicacion.construir(new Criadero());
        ubicacion.destruirEdificio();

        assertTrue(ubicacion.sePuedeConstruir(new Extractor(750, -6, 100, 0, 10)));
    }

    /* falta probar con otros edificios que se puede construir aun cuando criadero*/
}