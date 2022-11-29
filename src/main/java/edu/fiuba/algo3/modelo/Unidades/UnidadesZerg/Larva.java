package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Larva implements TipoDeUnidad {
	
	public Larva() {
		
	}

	@Override
	public void recibirAtaque(int unDanio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Superficie obtenerSuperficie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atacar(Atacable unAtacable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recuperarse() {
		// TODO Auto-generated method stub
		
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
