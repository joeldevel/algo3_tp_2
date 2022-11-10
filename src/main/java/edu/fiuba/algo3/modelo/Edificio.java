package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Edificio {

    public ArrayList<RequisitoDeConstruccion> requisitos();

    public void actualizarRequisitosDeLaUbicacion(ArrayList<RequisitoDeConstruccion> requisitos);

}
