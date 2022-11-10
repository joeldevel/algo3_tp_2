package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Pilon.Pilon;

public class Acceso {

    private int x, y;

    public void setUbicacion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean estaOperativo(Pilon pilon) {
        try {
            pilon.energizar();
        } catch (Exception e) {
            return false;
        }
//        umber (xp−xc)2+(yp−yc)2 with r2.
        // ver tambien las otras condiciones
        return ( Math.pow((this.x - pilon.getX()), 2) + Math.pow((this.y - pilon.getY()), 2) <= 9);
    }
}
