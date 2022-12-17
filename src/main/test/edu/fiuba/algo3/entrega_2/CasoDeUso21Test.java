package edu.fiuba.algo3.entrega_2;

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
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CONSTRUCCION_DRAGON;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.CONSTRUCCION_MUTALISCO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso21Test {

    Mapa mapa = new Mapa();
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000, 1000), mapa);

    @Test
    void test01SeCreaUnaUnidadConTipoGuardianYSeEncuentraEnConstruccion(){
        // Arrange
        Recursos recursos = new Recursos(100,50);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act & Assert
        assertThrows(UnidadEnConstruccionException.class,()->{
            dragon.atacar(unidad);
        });
    }

    @Test
    void test02SeCreaUnaUnidadConTipoGuardianYLuegoDeCuatroTurnosRecibeUnAtaqueYSuVidaEsLaIndicada(){
        // Arrange
        Recursos recursos = new Recursos(100,50);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(unidad);

        // Assert
        assertEquals(80, unidad.vidaRestante());
    }

    @Test
    void test03SeCreaUnaUnidadConTipoMutaliscoSeLaHaceEvolucionarAUnaUnidadConTipoGuardianYLuegoDeCuatroTurnosRecibeUnAtaqueYSuVidaEsLaIndicada(){
        // Arrange
        Recursos recursos = new Recursos(100 + 100,100 + 50); // El primer termino corresponde al precio del Mutalisco y el segundo termino corresponde al precio del Guardian.
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        unidad.avanzarTurno(7);
        unidad.evolucionarAGuardian();
        unidad.avanzarTurno(4);

        Dragon tipoDragon = new Dragon(jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(unidad);

        // Assert
        assertEquals(80, unidad.vidaRestante());
    }

    @Test
    void test04SeCreaUnaUnidadConTipoMutaliscoSeLaIntentaEvolucionarAUnaUnidadConTipoGuardianYNoEsPosibleYaQueElJugadorNoTieneRecursosSuficientes(){
        // Arrange
        Recursos recursos = new Recursos(100 + 99,100 + 49); // El primer termino corresponde al precio del Mutalisco y el segundo termino corresponde al precio del Guardian (insuficiente).
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", recursos, mapa);
        Mutalisco tipoMutalisco = new Mutalisco(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_MUTALISCO), new Ubicacion(0,0), tipoMutalisco);
        unidad.avanzarTurno(7);

        // Act & Assert
        assertThrows(SinRecursosSuficientesException.class, () -> unidad.evolucionarAGuardian());
    }
}
