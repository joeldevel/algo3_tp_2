package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBajasException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.*;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.CONSTRUCCION_ZERLING;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot.CONSTRUCCION_ZEALOT;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.CONSTRUCCION_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.CONSTRUCCION_HIDRALISCO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso28Test {

    Mapa mapa = new Mapa();

    @Test
    void test06UnZealotIntentaHacerseInvisibleSinTenerTresBajasYSaleUnError() {
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos, mapa);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(1,0), tipoZealot);
        zealot.avanzarTurno(4);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Zerling tipoZerling1 = new Zerling(jugadorZerg);
        Unidad zerling1 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling1);
        zerling1.avanzarTurno(2);
        Zerling tipoZerling2 = new Zerling(jugadorZerg);
        Unidad zerling2 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling2);
        zerling2.avanzarTurno(2);

        // Act and Assert
        for(int i = 0; i < 5; i++) {
            zealot.atacar(zerling1);
            zealot.atacar(zerling2);
        }

        assertThrows(CantidadInsuficienteDeBajasException.class,()->{
            zealot.hacerseInvisible();
        });
    }

    /*@Test
    void test05UnAmoSupremoIntentaRevelarAUnZealotPeroEstaFueraDeRangoYTiraUnError(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(10,10), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);

        Zerling tipoZerling1 = new Zerling(jugadorZerg);
        Unidad zerling1 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling1);
        zerling1.avanzarTurno(2);
        Zerling tipoZerling2 = new Zerling(jugadorZerg);
        Unidad zerling2 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling2);
        zerling2.avanzarTurno(2);
        Zerling tipoZerling3 = new Zerling(jugadorZerg);
        Unidad zerling3 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling3);
        zerling3.avanzarTurno(2);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos, mapa);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(1,0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act and Assert
        for(int i = 0; i < 5; i++) {
            zealot.atacar(zerling1);
            zealot.atacar(zerling2);
            zealot.atacar(zerling3);
        }

        zealot.hacerseInvisible();

        assertThrows(RevelableFueraDeRangoError.class,()->{
            amoSupremo.revelar(zealot);
        });
    }*/

    @Test
    void test01UnZerlingAtacaAUnZealotYElEscudoDelZealotNoDisminuyePorqueEstaInvisible(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        Zerling tipoZerling1 = new Zerling(jugadorZerg);
        Unidad zerling1 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling1);
        zerling1.avanzarTurno(2);
        Zerling tipoZerling2 = new Zerling(jugadorZerg);
        Unidad zerling2 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling2);
        zerling2.avanzarTurno(2);
        Zerling tipoZerling3 = new Zerling(jugadorZerg);
        Unidad zerling3 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling3);
        zerling3.avanzarTurno(2);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos, mapa);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        for(int i = 0; i < 5; i++) {
            zealot.atacar(zerling1);
            zealot.atacar(zerling2);
            zealot.atacar(zerling3);
        }
        zealot.hacerseInvisible();
        zerling.atacar(zealot);

        // Assert
        assertEquals(60, zealot.escudoRestante());
    }

    @Test
    void test02UnAmoSupremoRevelaAUnZealotYAlAtacarloUnZerlingElEscudoDelZealotDisminuye(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0,0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);
        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        Zerling tipoZerling1 = new Zerling(jugadorZerg);
        Unidad zerling1 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling1);
        zerling1.avanzarTurno(2);
        Zerling tipoZerling2 = new Zerling(jugadorZerg);
        Unidad zerling2 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling2);
        zerling2.avanzarTurno(2);
        Zerling tipoZerling3 = new Zerling(jugadorZerg);
        Unidad zerling3 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling3);
        zerling3.avanzarTurno(2);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos, mapa);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        for(int i = 0; i < 5; i++) {
            zealot.atacar(zerling1);
            zealot.atacar(zerling2);
            zealot.atacar(zerling3);
        }
        zealot.hacerseInvisible();
        amoSupremo.revelar(zealot);
        zerling.atacar(zealot);

        // Assert
        assertEquals(56, zealot.escudoRestante());
    }

    @Test
    void test03UnAmoSupremoRevelaAUnZealotYAlAtacarloUnMutaliscoElEscudoDelZealotDisminuye(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0,0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        mutalisco.avanzarTurno(7);

        Zerling tipoZerling1 = new Zerling(jugadorZerg);
        Unidad zerling1 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling1);
        zerling1.avanzarTurno(2);
        Zerling tipoZerling2 = new Zerling(jugadorZerg);
        Unidad zerling2 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling2);
        zerling2.avanzarTurno(2);
        Zerling tipoZerling3 = new Zerling(jugadorZerg);
        Unidad zerling3 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling3);
        zerling3.avanzarTurno(2);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos, mapa);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        for(int i = 0; i < 5; i++) {
            zealot.atacar(zerling1);
            zealot.atacar(zerling2);
            zealot.atacar(zerling3);
        }
        zealot.hacerseInvisible();
        amoSupremo.revelar(zealot);
        mutalisco.atacar(zealot);

        // Assert
        assertEquals(51, zealot.escudoRestante());
    }

    @Test
    void test04UnAmoSupremoRevelaAUnZealotYAlAtacarloUnHidraliscoElEscudoDelZealotDisminuye(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos, mapa);

        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0,0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);

        Zerling tipoZerling1 = new Zerling(jugadorZerg);
        Unidad zerling1 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling1);
        zerling1.avanzarTurno(2);

        Zerling tipoZerling2 = new Zerling(jugadorZerg);
        Unidad zerling2 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling2);
        zerling2.avanzarTurno(2);

        Zerling tipoZerling3 = new Zerling(jugadorZerg);
        Unidad zerling3 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling3);
        zerling3.avanzarTurno(2);

        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        Hidralisco tipoHidralisco = new Hidralisco(jugadorZerg);
        Unidad hidralisco = new Unidad(new Tiempo(CONSTRUCCION_HIDRALISCO), new Ubicacion(0,0), tipoHidralisco);
        hidralisco.avanzarTurno(4);

        for(int i = 0; i < 5; i++) {
            zealot.atacar(zerling1);
            zealot.atacar(zerling2);
            zealot.atacar(zerling3);
        }

        zealot.hacerseInvisible();

        // Act
        amoSupremo.revelar(zealot);
        hidralisco.atacar(zealot);

        // Assert
        assertEquals(50, zealot.escudoRestante());
    }

    @Test
    void test07UnZealotReveladoPorUnAmoSupremoVuelveASerInvisibleCuandoEsteUltimoEsDestruidoYAlAtacarloUnHidraliscoElEscudoDelZealotNoDisminuye() {
        // Arrange
        Recursos recursos = new Recursos(1000,1000);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos, mapa);

        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0,0), tipoAmoSupremo);
        mapa.agregarUnidad(amoSupremo);
        mapa.agregarAmoSupremo(amoSupremo);
        amoSupremo.avanzarTurno(5);

        Zerling tipoZerling1 = new Zerling(jugadorZerg);
        Unidad zerling1 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling1);
        mapa.agregarUnidad(zerling1);
        zerling1.avanzarTurno(2);

        Zerling tipoZerling2 = new Zerling(jugadorZerg);
        Unidad zerling2 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling2);
        mapa.agregarUnidad(zerling2);
        zerling2.avanzarTurno(2);

        Zerling tipoZerling3 = new Zerling(jugadorZerg);
        Unidad zerling3 = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling3);
        mapa.agregarUnidad(zerling3);
        zerling3.avanzarTurno(2);

        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        mapa.agregarUnidad(zealot);
        zealot.avanzarTurno(4);

        Hidralisco tipoHidralisco = new Hidralisco(jugadorZerg);
        Unidad hidralisco = new Unidad(new Tiempo(CONSTRUCCION_HIDRALISCO), new Ubicacion(0,0), tipoHidralisco);
        mapa.agregarUnidad(hidralisco);
        hidralisco.avanzarTurno(4);

        Hidralisco tipoHidralisco2 = new Hidralisco(jugadorZerg);
        Unidad hidralisco3 = new Unidad(new Tiempo(CONSTRUCCION_HIDRALISCO), new Ubicacion(10,10), tipoHidralisco2);
        mapa.agregarUnidad(hidralisco3);
        hidralisco.avanzarTurno(4);

        for(int i = 0; i < 5; i++) {
            zealot.atacar(zerling1);
            zealot.atacar(zerling2);
            zealot.atacar(zerling3);
        }

        zealot.avanzarTurno();
        mapa.avanzarTurno();

        zealot.avanzarTurno();
        mapa.avanzarTurno();

        // Act
        for(int i = 0; i < 25; i++) {
            hidralisco.atacar(amoSupremo);
        }

        zealot.avanzarTurno();
        mapa.avanzarTurno();

        hidralisco.atacar(zealot);

        // Assert
        assertEquals(60, zealot.escudoRestante());
    }
}