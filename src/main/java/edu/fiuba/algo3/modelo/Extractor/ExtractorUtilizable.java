package edu.fiuba.algo3.modelo.Extractor;

import edu.fiuba.algo3.modelo.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Zangano;

import java.util.ArrayList;

public class ExtractorUtilizable implements EstadoOperativoExtractor {

    private int cantidadExtraible;
    private int cantidadMaximaDeZanganos;
    private ArrayList<Zangano> zanganos;

    public ExtractorUtilizable(int unaCantidadExtraible) {
        this.zanganos = new ArrayList<>();
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
    }
}