package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Creador;
import edu.fiuba.algo3.modelo.Criadero;
import edu.fiuba.algo3.modelo.Excepciones.CriaderoSinLarvasException;
import edu.fiuba.algo3.modelo.Larva;
import edu.fiuba.algo3.modelo.Zangano;

class PruebasCriadero {

	@Test
	void test01UnNuevoCriaderoNuevoDeberiaEmpezarConTresLarvas(){
		
		/* quizas deba emplearse la clase Unidad y que dendtro de ella se guarde la cantidad de larvas
		 * y un objeto de tipo Larva. En caso de que le pidan una larva desde afuera para crear un zangano
		 * la clase Unidad deberia crear con new una nueva larva o una copia y devolverla*/
		
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		
		assertEquals(criadero.contarLarvas(),3);
		
	}
	
	@Test
	void test02UnCriaderoNuevoEngendraUnaZanganoDeberiaTenerDosLarvas() {
		
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		
		Zangano nuevoZangano = criadero.engendrarZangano();
		
		assertEquals(criadero.contarLarvas(),2);
		
	}
	
	@Test
	void test03UnCriaderoConDosLarvasDeberiaTenerTresEnElSiguienteTurno() {
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		Zangano nuevoZangano = criadero.engendrarZangano();
		
		criadero.avanzarTurno();
		
		assertEquals(criadero.contarLarvas(),3);
	}
	
	@Test 
	void test04UnCriaderoConsumeDosLarvasEnElProximoTurnoDebeTenerDos(){
		
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		
		Zangano nuevoZangano = criadero.engendrarZangano();
		Zangano otroZangano = criadero.engendrarZangano();
		
		criadero.avanzarTurno();
		
		assertEquals(criadero.contarLarvas(),2);

	}
	
	@Test 
	void test05UnCriaderoConsumeTresLarvasEnElProximoTurnoDebeTenerUna(){
		
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		
		Zangano nuevoZangano = criadero.engendrarZangano();
		Zangano otroZangano = criadero.engendrarZangano();
		Zangano ultimoZangano = criadero.engendrarZangano();
		
		criadero.avanzarTurno();
		
		assertEquals(criadero.contarLarvas(),1);

	}
	
	@Test
	void test06UnCriaderoQueConsumeUnaLarvaDeberiaTenerDosAntesDeAvanzarElTurno() {
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		Zangano nuevoZangano = criadero.engendrarZangano();
		
		
		assertEquals(criadero.contarLarvas(),2);
	}
	
	@Test 
	void test07UnCriaderoConsumeDosLarvasDebeTenerUnaLarvaAntesDeAvanzarElTurno(){
		
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		
		Zangano nuevoZangano = criadero.engendrarZangano();
		Zangano otroZangano = criadero.engendrarZangano();
		
		
		assertEquals(criadero.contarLarvas(),1);

	}
	
	@Test 
	void test08UnCriaderoConsumeTresLarvasNoDeberiaTenerLarvasAntesDeAvanzarDeTurno(){
		
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		
		Zangano nuevoZangano = criadero.engendrarZangano();
		Zangano otroZangano = criadero.engendrarZangano();
		Zangano ultimoZangano = criadero.engendrarZangano();
		

		
		assertEquals(criadero.contarLarvas(),0);

	}
	
	@Test
	void test09UnCriaderoSinLarvasQuiereConsumirUnaLarvaDeberiaLanzarUnaExcepcion(){
	
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		
		Zangano nuevoZangano = criadero.engendrarZangano();
		Zangano otroZangano = criadero.engendrarZangano();
		Zangano ultimoZangano = criadero.engendrarZangano();


		assertThrows(CriaderoSinLarvasException.class,()->{
			Zangano zangano = criadero.engendrarZangano();
		});
		
	}
	
	@Test
	void test10UnCriaderoConTresLarvasAlPasarElTurnoDeberiaTenerTresLarvas() {
		Creador creador = new Creador();
		ArrayList<Larva>larvas = new ArrayList<>();
		
		larvas = creador.crearLarvas();
		
		Criadero criadero = new Criadero(larvas);
		criadero.avanzarTurno();
		
		assertEquals(criadero.contarLarvas(),3);
	}
	

}
