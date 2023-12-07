package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Jugador  {

    private Movible movible;
    private Tirador dado;

    public Jugador(Movible movible, Tirador dado){
        this.movible = movible;
        this.dado = dado;
    }

    public void inicializarMovible(Tablero tablero){
        tablero.inicializarMovible(this.movible);
    }

    public void moverMovible(Tablero tablero){

        tablero.moverMovible(this.movible, dado.tirarDado());
   }

}
