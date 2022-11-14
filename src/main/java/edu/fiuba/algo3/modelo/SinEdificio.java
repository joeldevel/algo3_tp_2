package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class SinEdificio extends Edificio {
	
	public SinEdificio() {
		super(null,null,null,null);
	}

    @Override
    public ArrayList<RequisitoDeConstruccion> requisitos() {
        return null;
    }

	@Override
	public Moho moho() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void avanzarTurno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirDanio(int unDanio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recuperarse() {
		// TODO Auto-generated method stub
		
	}

}
