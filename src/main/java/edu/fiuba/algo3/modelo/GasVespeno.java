package edu.fiuba.algo3.modelo;

public class GasVespeno implements RequisitoDeConstruccion {

    @Override
    public boolean esIgualA(RequisitoDeConstruccion otroRequisito) {
        return (otroRequisito instanceof GasVespeno);
    }

}