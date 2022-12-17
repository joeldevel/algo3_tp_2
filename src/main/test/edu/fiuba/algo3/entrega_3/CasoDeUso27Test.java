package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Excepciones.UnidadEnConstruccionException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Devorador;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CONSTRUCCION_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Devorador.CONSTRUCCION_DEVORADOR;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso27Test {

    Mapa mapa = new Mapa();
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000, 1000), mapa);

    @Test
    void test01SeCreaUnaUnidadConTipoDevoradorYSeEncuentraEnConstruccion(){
        // Arrange
        Recursos recursos = new Recursos(50,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Devorador tipoDevorador = new Devorador(jugadorZerg);
        Unidad devorador = new Unidad(new Tiempo(CONSTRUCCION_DEVORADOR), new Ubicacion(0,0), tipoDevorador);

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            dragon.atacar(devorador);
        });
    }

    @Test
    void test02SeCreaUnaUnidadConTipoDevoradorYLuegoDeCuatroTurnosRecibeUnAtaqueYSuVidaEsLaIndicada(){
        // Arrange
        Recursos recursos = new Recursos(50,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Devorador tipoDevorador = new Devorador(jugadorZerg);
        Unidad devorador = new Unidad(new Tiempo(CONSTRUCCION_DEVORADOR), new Ubicacion(0,0), tipoDevorador);
        devorador.avanzarTurno(4);

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(devorador);

        // Assert
        assertEquals(180, devorador.vidaRestante());
    }

    @Test
    void test03SeCreaUnaUnidadConTipoMutaliscoSeLaHaceEvolucionarAUnaUnidadConTipoDevoradorYLuegoDeCuatroTurnosRecibeUnAtaqueYSuVidaEsLaIndicada(){
        // Arrange
        Recursos recursos = new Recursos(100 + 50,100 + 150); // El primer termino corresponde al precio del Mutalisco y el segundo termino corresponde al precio del Devorador.
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        unidad.avanzarTurno(7);
        unidad.evolucionarADevorador();
        unidad.avanzarTurno(4);

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(unidad);

        // Assert
        assertEquals(180, unidad.vidaRestante());
    }

    @Test
    void test04SeCreaUnaUnidadConTipoMutaliscoSeLaIntentaEvolucionarAUnaUnidadConTipoDevoradorYNoEsPosibleYaQueElJugadorNoTieneRecursosSuficientes(){
        // Arrange
        Recursos recursos = new Recursos(100 + 49,100 + 149); // El primer termino corresponde al precio del Mutalisco y el segundo termino corresponde al precio del Devorador (insuficiente).
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        unidad.avanzarTurno(7);

        // Act & Assert
        assertThrows(SinRecursosSuficientesException.class, () -> unidad.evolucionarADevorador());
    }
}