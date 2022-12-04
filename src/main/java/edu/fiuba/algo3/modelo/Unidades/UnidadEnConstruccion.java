package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Excepciones.UnidadEnConstruccionException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;

public class UnidadEnConstruccion implements TipoDeUnidad, Atacante, Atacable {

    public UnidadEnConstruccion() {
    }

    @Override
    public Ubicacion ubicacion() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public boolean compararSuperficie(String otraSuperficie) {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void avanzarTurno() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void conNodo(NodoMineral nodo) {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void setComportamientoUnidad(Unidad unaUnidad) {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public int obtenerPoblacion() {
        return 0;
    }

    @Override
    public int obtenerSuministro() {
        return 0;
    }

    @Override
    public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public Superficie obtenerSuperficie() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void atacar(Atacable unAtacable, Unidad unidadAtacante) {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void recuperarse() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void evolucionarAGuardian(Unidad unaUnidad) {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void evolucionarADevorador(Unidad unaUnidad) {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public int vidaRestante() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public int escudoRestante() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void hacerseInvisible() {
        throw new UnidadEnConstruccionException();
    }
}