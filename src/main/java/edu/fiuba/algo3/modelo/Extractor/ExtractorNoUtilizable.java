package edu.fiuba.algo3.modelo.Extractor;

import edu.fiuba.algo3.modelo.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Zangano;

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