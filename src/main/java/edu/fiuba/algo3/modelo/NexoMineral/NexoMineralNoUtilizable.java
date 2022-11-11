package edu.fiuba.algo3.modelo.NexoMineral;

import edu.fiuba.algo3.modelo.EdificioNoOperativoException;

public class NexoMineralNoUtilizable implements EstadoOperativoNexoMineral {

    public NexoMineralNoUtilizable() {

    }

    public int recolectarMineral() {
        throw new EdificioNoOperativoException();
    }
}
