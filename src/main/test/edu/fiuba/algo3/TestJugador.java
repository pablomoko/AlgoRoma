package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.GestorArchivos;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.seniority.Novato;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {

    @Test
    public void test01SeInicializaUnMovibleAlPrincipioDelTablero() {

        Gladiador gladiador = new Gladiador(20, new Novato());
        Jugador jugador = new Jugador(gladiador);



        String rutaArchivo = "src/main/resources/mapa.json";
        LinkedList<Casilla> casillas = new LinkedList<>();
        casillas = GestorArchivos.generarListaDeCasillasDesdeJSON(rutaArchivo);
        Tablero tablero = new Tablero(casillas);

        jugador.inicializarMovible(tablero);
        assertEquals(tablero.obtenerCasillaDe(gladiador), tablero.obtenerCasillaDe(0));


    }
    /*
    @Test
    public void test02ElJugadorMueveASuGladiadorEnElTableroIndicado(){

        Gladiador gladiador = new Gladiador(20, new Novato());
        Jugador jugador = new Jugador(gladiador);
        Tablero tablero = new Tablero(30);
        jugador.inicializarMovible(tablero);
        jugador.moverMovible(tablero);

        assertEquals(tablero.obtenerCasillaDe(gladiador), tablero.obtenerCasillaDe(0));
    }*/
}