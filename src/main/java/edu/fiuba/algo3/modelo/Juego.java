package edu.fiuba.algo3.modelo;
import java.util.Random;
import java.util.ArrayList;

public class Juego implements Dado {

    private int turnos;
    private ArrayList<Jugador> jugadores;

    private boolean terminado;

    private Mapa mapa;

    public Juego(ArrayList<Jugador> jugadores, int tamanio){
        this.turnos = 0;
        this.jugadores = jugadores;
        this.terminado = false;
        this.mapa = new Mapa(tamanio);
        for (Jugador jugador : jugadores) {
            jugador.inicializarMovible(this.mapa);
        }
    }

    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }

    public void jugarTurno() {
        for (Jugador jugador : this.jugadores) {
            jugador.moverMovible(mapa);
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