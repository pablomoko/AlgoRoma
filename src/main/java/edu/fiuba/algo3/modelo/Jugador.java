package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Jugador  {

    private Movible movible;

    public Jugador(Movible movible){
        this.movible = movible;
    }

    public void inicializarMovible(Tablero tablero){
        tablero.inicializarMovible(this.movible);
    }

    public void moverMovible(Tablero tablero,Dado dado){

        tablero.moverMovible(this.movible, dado.tirarDado());
   }

}
