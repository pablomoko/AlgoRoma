package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Jugador  {

    private Movible movible;
    private String nombre;

    public Jugador(String nombre,Movible movible){
        this.movible = movible;
        this.nombre = nombre;
    }

    public void inicializarMovible(Tablero tablero){
        tablero.inicializarMovible(this.movible);
    }

    public void moverMovible(Tablero tablero, int pasos){

        tablero.moverMovible(this.movible, pasos);
   }

   public Movible obtenerMovible(){
        return movible;
   }

   public boolean sosGanador(){
        return (movible.sosGanador());
   }

}
