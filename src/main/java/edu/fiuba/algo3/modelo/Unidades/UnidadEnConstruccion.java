package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Excepciones.UnidadEnConstruccionException;
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
    public void recibirAtaque(int unDanio) {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public Superficie obtenerSuperficie() {
        throw new UnidadEnConstruccionException();
    }

    @Override
    public void atacar(Atacable unAtacable) {
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
}
