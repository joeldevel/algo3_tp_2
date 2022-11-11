package edu.fiuba.algo3.modelo;

public class Moho implements RequisitoDeConstruccion {

	private int radio;
	private Tiempo tiempo;
	
	public Moho() {
		this.radio = 5;
		this.tiempo = new Tiempo(0);
	}
	
	public Moho(Tiempo unTiempo) {
		this.radio = 5;
		this.tiempo = unTiempo;
	}

	public Moho(int unRadio, Tiempo unTiempo) {
		this.radio = unRadio;
		this.tiempo = unTiempo;
	}

	public int radio() {
		return this.radio;
	}
	
	public void avanzarTurno() {
		this.tiempo.pasarTiempo();
		this.expandirRadio();
	}

	public void expandirRadio() {
		if((this.tiempo.transcurrido() > 0) && (this.tiempo.transcurrido() % 2) == 0) {
			this.radio++;
		}
	}

	@Override
	public boolean esIgualA(RequisitoDeConstruccion otroRequisito) {
		return (otroRequisito instanceof Moho);
	}

}