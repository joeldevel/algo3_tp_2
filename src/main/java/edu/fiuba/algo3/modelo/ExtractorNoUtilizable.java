package edu.fiuba.algo3.modelo;

public class ExtractorNoUtilizable implements EstadoOperativoExtractor {

    public ExtractorNoUtilizable() {}
    @Override
     public int extraerGas() {
        throw new EdificioNoOperativoException();
    }
    @Override
    public void guardarZangano(Zangano unZangano) {
        throw new EdificioNoOperativoException();
    }
}
