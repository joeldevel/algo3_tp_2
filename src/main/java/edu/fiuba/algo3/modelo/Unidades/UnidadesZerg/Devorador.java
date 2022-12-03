package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

public class Devorador implements TipoDeUnidad, Atacante, Atacable {

    public static final int SUMINISTRO_DEVORADOR = 4;
    private final int POBLACION = 0;
    private final int COSTO_MINERAL = 150;
    private final int COSTO_GAS = 50;
    public static final int CONSTRUCCION_DEVORADOR = -4;

    private Vida vida;
    private Jugador jugador;
    private Unidad unidad;
    private Ubicacion ubicacion;
    private Superficie superficie;
    private ArrayList<Ataque> ataques;

    public Devorador(Ubicacion unaUbicacion, Jugador unJugador) {
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

        this.vida = new Vida(200);
        this.jugador = unJugador;
        this.unidad = null;
        this.ubicacion = unaUbicacion;
        this.superficie = new Superficie("Aire");
        this.ataques = new ArrayList<Ataque>() {{add(new Ataque(15,new Superficie("Aire"),5));}};
    }

    public Devorador(Jugador unJugador) {
        unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

        this.vida = new Vida(200);
        this.jugador = unJugador;
        this.unidad = null;
        this.ubicacion = new Ubicacion();
        this.superficie = new Superficie("Aire");
        this.ataques = new ArrayList<Ataque>() {{add(new Ataque(15,new Superficie("Aire"),5));}};
    }

    @Override
    public void conNodo(NodoMineral nodo) {
        // Devorador no entiende este mensaje.
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
            if(! (this.estaEnRangoDeAtaque(unAtacable, ataque))) {
                throw new AtacableFueraDeRangoError();
            }

            ataque.atacarA(unAtacable, unidadAtacante);
        }
    }

    public boolean estaEnRangoDeAtaque(Atacable unAtacable, Ataque unAtaque) {
        return (this.ubicacion.distanciaCon(unAtacable.ubicacion()) <= unAtaque.rango());
    }

    public Ubicacion ubicacion() {
        return (this.ubicacion);
    }

    public int vidaRestante() {
        return (this.vida.restante());
    }

    @Override
    public Superficie obtenerSuperficie() {
        return this.superficie;
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
        // No hace nada.
    }

    @Override
    public void evolucionarAGuardian(Unidad unaUnidad) {
        // No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
    }

    @Override
    public void evolucionarADevorador(Unidad unaUnidad) {
        // No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
    }
}
