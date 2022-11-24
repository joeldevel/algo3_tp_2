package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;


public class AmoSupremo implements TipoDeUnidad, Atacable  {

    private Vida vida;
    private Ubicacion ubicacion;
    private Superficie superficie;

    public AmoSupremo(Ubicacion unaUbicacion) {
        this.vida = new Vida(200);
        this.ubicacion = unaUbicacion;
        this.superficie = new Superficie("Aire");
    }

    public AmoSupremo() {
        this.vida = new Vida(200);
        this.ubicacion = new Ubicacion();
        this.superficie = new Superficie("Aire");
    }

    @Override
    public void recibirAtaque(int unAtaque) {
        this.vida.recibirDanioPor(unAtaque);
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

    @Override
    public void atacar(Atacable unAtacable) {
        // Amo Supremo no entiende este mensaje.
    }

    public void recuperarse() {
        this.vida.recuperarse();
    }

    @Override
    public boolean compararSuperficie(String unTipoDeSuperficie) {
        return this.superficie.compararTipos(unTipoDeSuperficie);
    }
}