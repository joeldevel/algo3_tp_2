package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Excepciones.UnidadEnConstruccionException;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Devorador;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Devorador.CONSTRUCCION_DEVORADOR;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso27Test {

    @Test
    void test01SeCreaUnaUnidadConTipoDevoradorYSeEncuentraEnConstruccion(){
        // Arrange
        Recursos recursos = new Recursos(50,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        Devorador tipoDevorador = new Devorador(jugadorZerg);
        Unidad devorador = new Unidad(new Tiempo(CONSTRUCCION_DEVORADOR), new Ubicacion(0,0), tipoDevorador);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            devorador.recibirAtaque(10);
        });
    }

    @Test
    void test02SeCreaUnaUnidadConTipoDevoradorYLuegoDeCuatroTurnosRecibeUnAtaqueYSuVidaEsLaIndicada(){
        // Arrange
        Recursos recursos = new Recursos(50,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        Devorador tipoDevorador = new Devorador(jugadorZerg);
        Unidad devorador = new Unidad(new Tiempo(CONSTRUCCION_DEVORADOR), new Ubicacion(0,0), tipoDevorador);
        devorador.avanzarTurno(4);

        // Act
        devorador.recibirAtaque(10);

        // Assert
        assertEquals(190, devorador.obtenerVida());
    }

    @Test
    void test03SeCreaUnaUnidadConTipoMutaliscoSeLaHaceEvolucionarAUnaUnidadConTipoDevoradorYLuegoDeCuatroTurnosRecibeUnAtaqueYSuVidaEsLaIndicada(){
        // Arrange
        Recursos recursos = new Recursos(100 + 50,100 + 150); // El primer termino corresponde al precio del Mutalisco y el segundo termino corresponde al precio del Devorador.
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        unidad.avanzarTurno(7);
        unidad.evolucionarADevorador();
        unidad.avanzarTurno(4);

        // Act
        unidad.recibirAtaque(10);

        // Assert
        assertEquals(190, unidad.obtenerVida());
    }

    @Test
    void test04SeCreaUnaUnidadConTipoMutaliscoSeLaIntentaEvolucionarAUnaUnidadConTipoDevoradorYNoEsPosibleYaQueElJugadorNoTieneRecursosSuficientes(){
        // Arrange
        Recursos recursos = new Recursos(100 + 49,100 + 149); // El primer termino corresponde al precio del Mutalisco y el segundo termino corresponde al precio del Devorador (insuficiente).
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos);
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        unidad.avanzarTurno(7);

        // Act & Assert
        assertThrows(SinRecursosSuficientesException.class, () -> unidad.evolucionarADevorador());
    }
}