package edu.fiuba.algo3.modelo.Pilon;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;

public class Pilon implements Atacable, RequisitoDeConstruccion {
    private EstadoOperativoPilon estadoOperativo;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;
    private int radio = 3;

    public Pilon() {
        this.tiempoDeConstruccion = -5;
        this.costoMineral = 100;
        this.costoGas = 0;
        this.estadoOperativo = new PilonNoUtilizable();
    }

    public void setComportamientoUtilizable(PilonUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if (tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if (tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new PilonUtilizable(300, 300));
        }
    }

    public boolean energizar() {
        return this.estadoOperativo.energizar();
    }

    private int x, y;

    public void setUbicacion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x;}
    public int getY() { return y;}


    @Override
    public void recibirAtaque(int cantidad) {
        if(this.estadoOperativo.recibirAtaque(cantidad) == 0) {
            this.estadoOperativo = new PilonNoUtilizable();
        }

    }

	@Override
	public boolean esIgualA(RequisitoDeConstruccion otroRequisito) {
		return (otroRequisito instanceof Pilon);
	}
}