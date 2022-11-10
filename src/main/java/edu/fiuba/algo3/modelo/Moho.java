package edu.fiuba.algo3.modelo;

public class Moho implements RequisitoDeConstruccion {

	private int radio;

	public Moho() {
		this.radio = 5;
	}

	public int radio() {
		return this.radio;
	}

	public void expandirRadio(Tiempo unTiempo) {
		if(unTiempo.contador() == 2) {
			this.radio++;
		}
	}

	@Override
	public boolean esIgualA(RequisitoDeConstruccion otroRequisito) {
		return (otroRequisito instanceof Moho);
	}

}