package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ExtractorUtilizable implements EstadoOperativoExtractor {

    private int vida;
    private int cantidadExtraible;
    private int cantidadMaximaDeZanganos;
    private ArrayList<Zangano> zanganos;

    public ExtractorUtilizable(int unaVida, int unaCantidadExtraible) {
        this.zanganos = new ArrayList<>();
        this.vida = unaVida;
        this.cantidadMaximaDeZanganos = 3;
        this.cantidadExtraible = unaCantidadExtraible;
    }

    @Override
    public int extraerGas(){
        return this.zanganos.size() * this.cantidadExtraible;
    }

    @Override
    public void guardarZangano(Zangano unZangano) {

        if(zanganos.size() == cantidadMaximaDeZanganos) {
            throw new CantidadMaximaDeZanganosEnExtractorException();
        }

        this.zanganos.add(unZangano);
        //System.out.println(this.zanganos.size());
    }
}
