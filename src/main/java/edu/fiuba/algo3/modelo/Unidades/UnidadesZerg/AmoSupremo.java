package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Revelo;
import edu.fiuba.algo3.modelo.Revelador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;


public class AmoSupremo implements TipoDeUnidad, Atacable, Revelador  {

    public static final int CONSTRUCCION_AMO = -5;
    private static final int VIDA_AMO = 200;

    private static final int REVELO_RADIO = 4;

    public static final int SUMINISTRO_AMO = 0;
    private static final int POBLACION = 5;
    private static final int COSTO_MINERAL = 50;
    private static final int COSTO_GAS = 0;

    private Vida vida;
    private Jugador jugador;
    private Unidad unidad;
    private Superficie superficie;
    private ArrayList<Revelo> revelos;

    public AmoSupremo(Jugador unJugador) {
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

        this.vida = new Vida(VIDA_AMO);
        this.jugador = unJugador;
        this.unidad = null;
        this.superficie = new Superficie("Aire");
        this.revelos = new ArrayList<Revelo>() {{
            add(new Revelo(new Superficie("Tierra"), REVELO_RADIO));
            add(new Revelo(new Superficie("Aire"), REVELO_RADIO));
        }};
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
        return SUMINISTRO_AMO;
    }

    @Override
    public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
        this.vida.recibirDanioPor(unDanio, unidadAtacante, this.unidad, this.jugador);
    }

    @Override
    public Ubicacion ubicacion() {
        return this.unidad.ubicacion();
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

    @Override
    public void atacar(Atacable unAtacable, Unidad unidadAtacante) {
        // No entiende este mensaje.
    }

    @Override
    public void revelar(Revelable unRevelable) {

        for (Revelo revelo : revelos) {
            if((this.estaEnRangoDeRevelo(unRevelable, revelo))) {
                revelo.revelarA(unRevelable);
            }
        }
    }

    public boolean estaEnRangoDeRevelo(Revelable unRevelable, Revelo unRevelo) {
        return (this.unidad.ubicacion().distanciaCon(unRevelable.ubicacion()) <= unRevelo.rango());
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
    public void serRevelado() {
        // No entiende este mensaje.
    }

    @Override
    public void contarBaja() {
        // ...
    }
}