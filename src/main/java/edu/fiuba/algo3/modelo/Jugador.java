package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Jugador implements Dado{

    private Movible movible;

    public Jugador(Movible movible){
        this.movible = movible;
    }

    public void inicializarMovible(Tablero tablero){
        tablero.inicializarMovible(this.movible);
    }

    public void moverMovible(Tablero tablero){
        tablero.ubicarMovible(this.movible, this.tirarDado());
   }

    @Override
    public int tirarDado() {
        return new Random().nextInt(6 - 1 + 1) + 1;
    }
}
