package edu.fiuba.algo3.modelo;

public class SinRequisitoDeConstruccion implements RequisitoDeConstruccion {

    @Override
    public boolean esIgualA(RequisitoDeConstruccion otroRequisito) {
        return true;
    }

}
