package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.seniority.Novato;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Mapa;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMapa {

    @Test
    public void test01SeInicializaElMapaoConSusAtributosCorrectos() {

        Mapa mapa = new Mapa(50);

        assertEquals(mapa.getCasillas().size(), 50);

    }


    @Test
    public void test02MapaInicializaElMovibleIndicadoEnLaPosicionCero() {

        Movible gladiador = new Gladiador(20, new Novato());
        Mapa mapa = new Mapa(50);
        mapa.inicializarMovible(gladiador);

        assertEquals(mapa.obtenerCasillaDe(gladiador), mapa.obtenerCasillaDe(0));

    }
    @Test
    public void test03UbicarMovibleUbicaAlMovibleIndicado() {

        Movible gladiador = new Gladiador(20, new Novato());
        Mapa mapa = new Mapa(50);
        mapa.inicializarMovible(gladiador);
        mapa.ubicarMovible(gladiador, 4);

        assertEquals(mapa.obtenerCasillaDe(gladiador), mapa.obtenerCasillaDe(4));

    }

}
