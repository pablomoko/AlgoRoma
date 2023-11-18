package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {

    private int turnos;
    private ArrayList<Gladiador> jugadores;

    public Juego(int cantidadDeJugadores){
        this.turnos = 0;
        this.jugadores = new ArrayList<Gladiador>();

    }
}