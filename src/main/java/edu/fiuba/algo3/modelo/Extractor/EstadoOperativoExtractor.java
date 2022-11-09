package edu.fiuba.algo3.modelo.Extractor;

import edu.fiuba.algo3.modelo.Zangano;

public interface EstadoOperativoExtractor {
    void guardarZangano(Zangano unZangano);
    int extraerGas();
}
