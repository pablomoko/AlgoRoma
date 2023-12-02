package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class GestorTurnos {

    public static void jugarTurnos(ArrayList<Jugador> jugadores, Tablero tablero) {

        for (Jugador jugador : jugadores) {
            jugador.moverMovible(tablero);
        }
    }

}
