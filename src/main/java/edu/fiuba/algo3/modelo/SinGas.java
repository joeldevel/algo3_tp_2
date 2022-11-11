package edu.fiuba.algo3.modelo;

public class SinGas implements RequisitoDeConstruccion {

	@Override
	public boolean esIgualA(RequisitoDeConstruccion otroRequisito) {
		return (otroRequisito instanceof SinGas);
	}

}
