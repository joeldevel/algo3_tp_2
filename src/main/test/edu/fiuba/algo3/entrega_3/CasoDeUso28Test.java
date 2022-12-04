package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.RevelableFueraDeRangoError;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
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

    @Test
    void test01UnZerlingAtacaAUnZealotYElEscudoDelZealotNoDisminuyePorqueEstaInvisible(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        zealot.hacerseInvisible(); //Falta implementar lo de matar a tres unidades o edificios.
        zerling.atacar(zealot);

        // Assert
        assertEquals(60, zealot.escudoRestante());
    }

    @Test
    void test02UnAmoSupremoRevelaAUnZealotYAlAtacarloUnZerlingElEscudoDelZealotDisminuye(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0,0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);
        Zerling tipoZerling = new Zerling(jugadorZerg);
        Unidad zerling = new Unidad(new Tiempo(CONSTRUCCION_ZERLING), new Ubicacion(0,0), tipoZerling);
        zerling.avanzarTurno(2);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        amoSupremo.revelar(zealot);
        zerling.atacar(zealot);

        // Assert
        assertEquals(56, zealot.escudoRestante());
    }

    @Test
    void test03UnAmoSupremoRevelaAUnZealotYAlAtacarloUnMutaliscoElEscudoDelZealotDisminuye(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0,0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad mutalisco = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        mutalisco.avanzarTurno(7);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        amoSupremo.revelar(zealot);
        mutalisco.atacar(zealot);

        // Assert
        assertEquals(51, zealot.escudoRestante());
    }

    @Test
    void test04UnAmoSupremoRevelaAUnZealotYAlAtacarloUnHidraliscoElEscudoDelZealotDisminuye(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0,0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);
        Hidralisco tipoHidralisco = new Hidralisco(jugadorZerg);
        Unidad hidralisco = new Unidad(new Tiempo(CONSTRUCCION_HIDRALISCO), new Ubicacion(0,0), tipoHidralisco);
        hidralisco.avanzarTurno(4);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(0,0), tipoZealot);
        zealot.avanzarTurno(4);

        // Act
        amoSupremo.revelar(zealot);
        hidralisco.atacar(zealot);

        // Assert
        assertEquals(50, zealot.escudoRestante());
    }

    @Test
    void test05UnAmoSupremoIntentaRevelarAUnZealotPeroEstaFueraDeRangoYTiraUnError(){
        // Arrange
        Recursos recursos = new Recursos(1000,1000);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        AmoSupremo tipoAmoSupremo = new AmoSupremo(jugadorZerg);
        Unidad amoSupremo = new Unidad(new Tiempo(CONSTRUCCION_AMO), new Ubicacion(0,0), tipoAmoSupremo);
        amoSupremo.avanzarTurno(5);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", recursos);
        Zealot tipoZealot = new Zealot(jugadorProtoss);
        Unidad zealot = new Unidad(new Tiempo(CONSTRUCCION_ZEALOT), new Ubicacion(10,10), tipoZealot);
        zealot.avanzarTurno(4);

        // Act and Assert
        assertThrows(RevelableFueraDeRangoError.class,()->{
            amoSupremo.revelar(zealot);
        });
    }

    /*@Test
    void test06UnZealotReveladoPorUnAmoSupremoVuelveASerInvisibleCuandoEsteUltimoEsDestruido() {
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        AmoSupremo amoSupremo = new AmoSupremo(new Ubicacion(0,0), jugadorZerg);
        Zerling zerling = new Zerling(new Ubicacion(0,0), jugadorZerg); // Ataque de tierra
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Zealot zealot = new Zealot(new Ubicacion(0,0), jugadorProtoss); // Unidad de tierra

        // Act
        amoSupremo.revelar(zealot);
        amoSupremo.recibirAtaque(300);
        zealot.hacerseInvisible();
        zerling.atacar(zealot);

        // Assert
        assertEquals(60, zealot.escudoRestante());
    }*/
}
