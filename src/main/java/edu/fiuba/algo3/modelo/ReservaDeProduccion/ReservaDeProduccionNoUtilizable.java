package edu.fiuba.algo3.modelo.ReservaDeProduccion;

import edu.fiuba.algo3.modelo.EdificioNoOperativoException;

public class ReservaDeProduccionNoUtilizable implements EstadoOperativoReservaDeProduccion {

    public ReservaDeProduccionNoUtilizable() {
    }

    public boolean evolucionarLarva() {
        throw new EdificioNoOperativoException();
    }
}
