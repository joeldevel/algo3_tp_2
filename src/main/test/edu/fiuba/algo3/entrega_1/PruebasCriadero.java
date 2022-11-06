package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.Larva;

class PruebasCriadero {

	@Test
	void test01UnNuevoCriaderoNuevoDeberiaEmpezarConTresLarvas(){
		
		/* la parte del ciclo debería estar en otra parte
		 * puesto que al crear el criadero ya deberia contener las 3 larvas.
		 * Quizá es una interfaz que implementa Criadero*/
		
		ArrayList<Larva>larvas = new ArrayList<Larva>();
		for(int i=0; i<3; i++) {
			larvas.add(new Larva());
		}
		
		Criadero criadero = new Criadero(larvas);
		
		assertEquals(criadero.contarLarvas(),3);
		
	}

}
