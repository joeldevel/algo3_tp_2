package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ubicacion {

    private int posX;
    private int posY;
    private ArrayList<RequisitoDeConstruccion> requisitos;
    private Edificio edificio;

    public Ubicacion() {
        this.posX = 0;
        this.posY = 0;
        this.requisitos = new ArrayList<RequisitoDeConstruccion>();
        this.requisitos.add(new SinRequisitoDeConstruccion());
        this.edificio = new SinEdificio();
    }

    /*la idea seria que un edificio cualquiera le da los requisitos a la ubicacion, entonces
     * se le pregunte a cada requisito si esta dentro de los requisitos que hay en esta ubicacion*/

    public boolean sePuedeConstruir(Edificio unEdificio) {
        ArrayList<RequisitoDeConstruccion> necesarios = unEdificio.requisitos();
        return (this.losRequisitosEstanEnEstaUbicacion(necesarios));
    }

    public boolean losRequisitosEstanEnEstaUbicacion(ArrayList<RequisitoDeConstruccion> necesarios) {
        boolean losRequisitosEstan = true;
        for(RequisitoDeConstruccion unRequisito: necesarios) {
            if(! this.unRequisitoEstaEnEstaUbicacion(unRequisito)) {
                losRequisitosEstan = false;
            }
        }
        return losRequisitosEstan;
    }

    public boolean unRequisitoEstaEnEstaUbicacion(RequisitoDeConstruccion unRequisito) {
        boolean elRequisitoEsta = false;
        for(RequisitoDeConstruccion requisitoEnEstaUbicacion: this.requisitos) {
            if(unRequisito.esIgualA(requisitoEnEstaUbicacion)) {
                elRequisitoEsta = true;
            }
        }
        return elRequisitoEsta;
    }

    public void agregarRequisito(RequisitoDeConstruccion nuevoRequisito) {
        this.requisitos.add(nuevoRequisito);
    }

    public boolean tieneEdificio() {
        return (! (this.edificio instanceof SinEdificio));
    }

    public void construir(Edificio unEdificio) {
        if(this.sePuedeConstruir(unEdificio)) {
            this.edificio = unEdificio;
        }
    }

    public void destruirEdificio() {
    	Moho mohoDelEdificio = this.edificio.moho();
    	if(! this.unRequisitoEstaEnEstaUbicacion(mohoDelEdificio) && mohoDelEdificio != null) {
    		this.requisitos.add(mohoDelEdificio);
    	}
    }

    /* la idea es que si el edificio es un criadero de el moho a los requisitos de la ubicacion
     * el metodo deberia usarse tanto cuando en la ubicacion se crea un edificio como cuando se destruye
     * pues cuando avance el tiempo el radio del moho puede crecer y donde antes no se podia quizas
     * ahora si se puede construir un edificio*/

}