package edu.fiuba.algo3.modelo;
import java.util.Random;
import java.util.ArrayList;

public class Juego implements Dado {

    private int turnos;
    private ArrayList<Gladiador> gladiadores;

    private boolean terminado;

    private Tablero tablero;

    public Juego(ArrayList<Gladiador> gladiadores, int cantidadDeCasillas){
        this.turnos = 0;
        this.gladiadores = gladiadores;
        this.terminado = false;
        this.tablero = new Tablero(cantidadDeCasillas);
        for (Gladiador gladiador : gladiadores) {
            tablero.colocarMovibleEnCasilla(gladiador, 0);
        }
    }

    public void jugarTurno() {
        for (Gladiador gladiador : this.gladiadores) {
            this.tablero.moverGladiador(gladiador, this.tirarDado());
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