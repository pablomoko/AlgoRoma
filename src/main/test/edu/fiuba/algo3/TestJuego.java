package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.seniority.Novato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJuego {

    @Test
    public void test01SeInicializaElJuegoConSusAtributosCorrectos() {

        Jugador jugador1 = new Jugador(new Gladiador(20, new Novato()));
        Jugador jugador2 = new Jugador(new Gladiador(20, new Novato()));
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        String rutaArchivo = "src/main/resources/mapa.json";
        Juego juego = new Juego(jugadores, rutaArchivo);

        assertEquals(juego.getJugadores(),jugadores);

    }



}
