package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Criadero;

class PruebasCriadero {

	@Test
	void test01UnNuevoCriaderoNuevoDeberiaEmpezarConTresLarvas(){
		
		Criadero criadero = new Criadero();
		
		assertEquals(criadero.contarLarvas(),3);
		
	}

}
