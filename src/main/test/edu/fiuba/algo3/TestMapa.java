package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.seniority.Novato;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Tablero;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMapa {

    @Test
    public void test01SeInicializaElMapaoConSusAtributosCorrectos() {

        Tablero tablero = new Tablero(50);

        assertEquals(tablero.getCasillas().size(), 50);

    }


    @Test
    public void test02MapaInicializaElMovibleIndicadoEnLaPosicionCero() {

        Movible gladiador = new Gladiador(20, new Novato());
        Tablero tablero = new Tablero(50);
        tablero.inicializarMovible(gladiador);

        assertEquals(tablero.obtenerCasillaDe(gladiador), tablero.obtenerCasillaDe(0));

    }
    @Test
    public void test03UbicarMovibleUbicaAlMovibleIndicado() {

        Movible gladiador = new Gladiador(20, new Novato());
        Tablero tablero = new Tablero(50);
        tablero.inicializarMovible(gladiador);
        tablero.ubicarMovible(gladiador, 4);

        assertEquals(tablero.obtenerCasillaDe(gladiador), tablero.obtenerCasillaDe(4));

    }

}
