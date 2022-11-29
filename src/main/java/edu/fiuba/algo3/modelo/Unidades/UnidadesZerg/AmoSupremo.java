package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Excepciones.RevelableFueraDeRangoError;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Revelo;
import edu.fiuba.algo3.modelo.Revelador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;


public class AmoSupremo implements TipoDeUnidad, Atacable, Revelador  {

    private Vida vida;
    private Ubicacion ubicacion;
    private Superficie superficie;

    private Revelo revelo;

    public AmoSupremo(Ubicacion unaUbicacion) {
        this.vida = new Vida(200);
        this.ubicacion = unaUbicacion;
        this.superficie = new Superficie("Aire");
    }

    public AmoSupremo() {
        this.vida = new Vida(200);
        this.ubicacion = new Ubicacion();
        this.superficie = new Superficie("Aire");
        this.revelo = new Revelo(new Superficie("Aire"), 4);
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

    @Override
    public void revelar(Revelable unRevelable) {
        if (!(this.estaEnRangoDeRevelo(unRevelable, revelo))) {
            throw new RevelableFueraDeRangoError();
        }

        revelo.revelarA(unRevelable);
    }

    public boolean estaEnRangoDeRevelo(Revelable unRevelable, Revelo unRevelo) {
        return (this.ubicacion.distanciaCon(unRevelable.ubicacion()) <= unRevelo.rango());
    }

    public void recuperarse() {
        this.vida.recuperarse();
    }

    @Override
    public boolean compararSuperficie(String unTipoDeSuperficie) {
        return this.superficie.compararTipos(unTipoDeSuperficie);
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