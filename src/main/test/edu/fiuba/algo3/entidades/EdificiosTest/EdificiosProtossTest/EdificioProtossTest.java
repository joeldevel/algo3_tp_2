package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosProtossTest;

public class EdificioProtossTest {

    /*@Test
    @DisplayName("Acceso cerca de dos pilones funciona con uno de ellos destruído")
    public void edificioProtossConPilonDestruidoTest() {
        Pilon pilon1 = new Pilon();
        pilon1.setUbicacion(3, 3);
        pilon1.setComportamientoUtilizable(new PilonUtilizable(300, 300));
        Pilon pilon2 = new Pilon();
        pilon2.setUbicacion(9, 3);
        pilon2.setComportamientoUtilizable(new PilonUtilizable(300, 300));

        Acceso acceso = new Acceso();
        acceso.setUbicacion(6, 3);
        Assertions.assertTrue(acceso.estaOperativo(pilon1));

        pilon1.recibirAtaque(600);
        Assertions.assertThrows(EdificioNoOperativoException.class, () -> {
            pilon1.energizar();
        });

        Assertions.assertTrue(acceso.estaOperativo(pilon2));
        Assertions.assertFalse(acceso.estaOperativo(pilon1));
    }

    @Test
    @DisplayName("Acceso cerca de dos pilones destruídos no funciona")
    public void edificioProtossConPilonesDestruidosTest() {
        Pilon pilon1 = new Pilon();
        pilon1.setUbicacion(3, 3);
        pilon1.setComportamientoUtilizable(new PilonUtilizable(300, 300));
        Pilon pilon2 = new Pilon();
        pilon2.setUbicacion(9, 3);
        pilon2.setComportamientoUtilizable(new PilonUtilizable(300, 300));

        Acceso acceso = new Acceso();
        acceso.setUbicacion(6, 3);

        Assertions.assertTrue(acceso.estaOperativo(pilon1));

        pilon1.recibirAtaque(600);
        pilon2.recibirAtaque(600);
        Assertions.assertThrows(EdificioNoOperativoException.class, () -> {
            pilon1.energizar();
        });
        Assertions.assertThrows(EdificioNoOperativoException.class, () -> {
            pilon2.energizar();
        });

        Assertions.assertFalse(acceso.estaOperativo(pilon1));
        Assertions.assertFalse(acceso.estaOperativo(pilon2));
    }*/
}