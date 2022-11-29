package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

import java.util.ArrayList;

public class Devorador implements TipoDeUnidad, Atacante, Atacable {

    private Vida vida;
    private Ubicacion ubicacion;
    private Superficie superficie;
    private ArrayList<Ataque> ataques;

    public Devorador(Ubicacion unaUbicacion) {
        this.vida = new Vida(200);
        this.ubicacion = unaUbicacion;
        this.superficie = new Superficie("Aire");
        this.ataques = new ArrayList<Ataque>() {{add(new Ataque(15,new Superficie("Aire"),5));}};
    }

    public Devorador() {
        this.vida = new Vida(200);
        this.ubicacion = new Ubicacion();
        this.superficie = new Superficie("Aire");
        this.ataques = new ArrayList<Ataque>() {{add(new Ataque(15,new Superficie("Aire"),5));}};
    }

    @Override
    public void recibirAtaque(int unAtaque) {
        this.vida.recibirDanioPor(unAtaque);
    }

    @Override
    public void atacar(Atacable unAtacable) {

        for (Ataque ataque : ataques) {
            if(! (this.estaEnRangoDeAtaque(unAtacable, ataque))) {
                throw new AtacableFueraDeRangoError();
            }

            ataque.atacarA(unAtacable);
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
    public void evolucionarAGuardian(Unidad unaUnidad) {
        // No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
    }

    @Override
    public void evolucionarADevorador(Unidad unaUnidad) {
        // No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
    }
}
