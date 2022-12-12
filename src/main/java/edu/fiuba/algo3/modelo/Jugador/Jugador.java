package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Excepciones.UbicacionSinEdificioException;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.CONSTRUCCION_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.SUMINISTRO_AMO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco.SUMINISTRO_HIDRALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco.SUMINISTRO_MUTALISCO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.SUMINISTRO_ZANGANO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling.SUMINISTRO_ZERLING;

public interface Jugador {
    String obtenerNombre();
    String obtenerColor();
    String obtenerRaza();
    boolean compararNombres(String otroNombre);
    boolean compararColores(String otroColor);
    boolean compararRazas(String otraRaza);
    void guardar(int costoGas, int costoMineral);
    void utilizar(int costoGas, int costoMineral);
    int obtenerGas();
    int obtenerMineral();
    void eliminarEdificio(Edificio unEdificio);
    void eliminarUnidad(Unidad unaUnidad);
    public boolean tieneEdificioEnUbicacion(Ubicacion unaUbicacion);
    public void agregarUnidad(Unidad unaUnidad);
    public void agregarEdificio(Edificio unEdificio);
    public boolean verificarEdificio(String nombreEdificio);
    public void construir(String edificio,Ubicacion unaUbicacion,Jugador jugador,Mapa mapa);
    public void avanzarTurno();
    int calcularPoblacion();
    ArrayList<Unidad> obtenerLarvas();
    boolean haySuministroDisponible(int unSuministro);

    /* Zerg */
    void crearAmoSupremo(Ubicacion unaUbicacion);
    void crearZangano(Ubicacion unaUbicacion);
     void crearZerling(Ubicacion unaUbicacion);
    void crearHidralisco(Ubicacion unaUbicacion);
    void crearMutalisco(Ubicacion unaUbicacion);
    void evolucionarMutaliscoAGuardian(Ubicacion unaUbicacion);
    void evolucionarMutaliscoADevorador(Ubicacion unaUbicacion);
}

