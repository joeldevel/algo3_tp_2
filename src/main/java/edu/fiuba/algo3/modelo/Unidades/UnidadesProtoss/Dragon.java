package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

public class Dragon implements TipoDeUnidad, Atacante, Atacable {
	
	private Vida vida;
	private Escudo escudo;
	private Ubicacion ubicacion;
	private Superficie superficie;
	private ArrayList<Ataque> ataques;
	
	public Dragon(Ubicacion unaUbicacion) {
		this.vida = new Vida(100);
		this.escudo = new Escudo(80);
		this.ubicacion = unaUbicacion;
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(20,new Superficie("Tierra"),4));
												 add(new Ataque(20,new Superficie("Aire"),4));}};
	}
	
	public Dragon() {
		this.vida = new Vida(100);
		this.escudo = new Escudo(80);
		this.ubicacion = new Ubicacion();
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{add(new Ataque(20,new Superficie("Tierra"),4));
		 										 add(new Ataque(20,new Superficie("Aire"),4));}};
	}

	@Override
	public void recibirAtaque(int unDanio) {
		if(unDanio > this.escudo.restante()) {
			int danioRestante = this.escudo.restante() - unDanio;
			this.vida.recibirDanioPor(danioRestante);
		}
		this.escudo.recibirDanioPor(unDanio);
		
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
	
	@Override
	public Ubicacion ubicacion() {
		return (this.ubicacion);
	}
	
	public int vidaRestante() {
		return (this.vida.restante());
	}
	
	public int escudoRestante() {
		return (this.escudo.restante());
	}

	// ¿Borrar?
	@Override
	public Superficie obtenerSuperficie() {
		return (this.superficie);
	}

	@Override
	public void recuperarse() {
		this.escudo.recuperarse();
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
