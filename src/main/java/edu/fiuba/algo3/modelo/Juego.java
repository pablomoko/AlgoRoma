package edu.fiuba.algo3.modelo;
import java.util.Random;
import java.util.ArrayList;

public class Juego implements Dado {

    private int turnos;
    private ArrayList<Jugador> jugadores;

    private boolean terminado;

    private Tablero tablero;

    public Juego(ArrayList<Jugador> jugadores, int tamanio){
        this.turnos = 0;
        this.jugadores = jugadores;
        this.terminado = false;
        this.tablero = new Tablero(tamanio);
        for (Jugador jugador : jugadores) {
            jugador.inicializarMovible(this.tablero);
        }
    }

    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }

    public void jugarTurno() {
        for (Jugador jugador : this.jugadores) {
            jugador.moverMovible(tablero);
        }
        this.turnos++;
        if (this.turnos == 30) {
            this.terminado = true;
        }
    }

    @Override
    public int tirarDado() {
        return new Random().nextInt(6 - 1 + 1) + 1;
    }

    public boolean terminado() {
        return this.terminado;
    }
}