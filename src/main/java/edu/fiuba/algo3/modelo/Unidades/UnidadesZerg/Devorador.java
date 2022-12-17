package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

public class Devorador implements TipoDeUnidad, Atacante, Atacable {

    public static final int CONSTRUCCION_DEVORADOR = -4;
    private static final int VIDA_DEVORADOR = 200;

    private static final int ATAQUE_AIRE_DANIO = 15;
    private static final int ATAQUE_AIRE_RADIO = 5;

    public static final int SUMINISTRO_DEVORADOR = 4;
    private static final int POBLACION = 0;
    private static final int COSTO_MINERAL = 150;
    private static final int COSTO_GAS = 50;

    private Vida vida;
    private Jugador jugador;
    private Unidad unidad;
    private Superficie superficie;
    private ArrayList<Ataque> ataques;

    public Devorador(Jugador unJugador) {
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

        this.vida = new Vida(VIDA_DEVORADOR);
        this.jugador = unJugador;
        this.unidad = null;
        this.superficie = new Superficie("Aire");
        this.ataques = new ArrayList<Ataque>() {{add(new Ataque(ATAQUE_AIRE_DANIO,new Superficie("Aire"),ATAQUE_AIRE_RADIO));}};
    }

    @Override
    public void trabajarEn(NodoMineral nodo) {
        // No entiende este mensaje.
    }

    public void setComportamientoUnidad(Unidad unaUnidad) {
        this.unidad = unaUnidad;
    }

    @Override
    public int obtenerPoblacion() {
        return POBLACION;
    }

    @Override
    public int obtenerSuministro() {
        return SUMINISTRO_DEVORADOR;
    }

    @Override
    public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
        this.vida.recibirDanioPor(unDanio, unidadAtacante, this.unidad, this.jugador);
    }


    @Override
    public void atacar(Atacable unAtacable, Unidad unidadAtacante) {

        for (Ataque ataque : ataques) {
            if(this.estaEnRangoDeAtaque(unAtacable, ataque)) {
                ataque.atacarA(unAtacable, unidadAtacante);
            }
        }
    }

    public boolean estaEnRangoDeAtaque(Atacable unAtacable, Ataque unAtaque) {
        return (this.unidad.ubicacion().distanciaCon(unAtacable.ubicacion()) <= unAtaque.rango());
    }

    public Ubicacion ubicacion() {
        return (this.unidad.ubicacion());
    }

    public int vidaRestante() {
        return (this.vida.restante());
    }

    public int escudoRestante() {
        return 0;
    }

    public void hacerseInvisible() {
        // No entiende este mensaje.
    }

    public void recuperarse() {
        this.vida.recuperarse();
    }

    @Override
    public boolean compararSuperficie(String unTipoDeSuperficie) {
        return this.superficie.compararTipos(unTipoDeSuperficie);
    }

    @Override
    public void avanzarTurno() {
        // ...
    }

    @Override
    public void evolucionarAGuardian(Unidad unaUnidad) {
        // No entiende este mensaje.
    }

    @Override
    public void evolucionarADevorador(Unidad unaUnidad) {
        // No entiende este mensaje.
    }

    @Override
    public void revelar(Revelable unRevelable) {
        // No entiende este mensaje.
    }

    @Override
    public void serRevelado() {
        // No entiende este mensaje.
    }

    @Override
    public void contarBaja() {
        // ...
    }
}
