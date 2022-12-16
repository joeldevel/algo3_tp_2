package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Excepciones.UnidadEnConstruccionException;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;

public class UnidadEnConstruccion implements TipoDeUnidad, Atacante, Atacable {

    public UnidadEnConstruccion() {
    }

    @Override
    public Ubicacion ubicacion() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public boolean compararSuperficie(String otraSuperficie) {
        return true;
    }

    @Override
    public void avanzarTurno() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void trabajarEn(NodoMineral nodo) {
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

    @Override
    public void revelar(Revelable unRevelable) {
        // No hace nada
    }

    public void serRevelado() {
        // No hace nada
    }

    public void contarBaja() {
        throw new UnidadEnConstruccionException();
    }
}