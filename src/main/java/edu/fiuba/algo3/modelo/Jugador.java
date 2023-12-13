package edu.fiuba.algo3.modelo;

import java.util.Observable;
import java.util.Random;

public class Jugador extends Observable {

    private Movible movible;
    private String nombre;

    public Jugador(String nombre,Movible movible){
        this.movible = movible;
        this.nombre = nombre;
    }

    public void inicializarMovible(Tablero tablero){
        tablero.inicializarMovible(this.movible);
        this.setChanged();
    }

    public void moverMovible(Tablero tablero, int pasos){

        tablero.moverMovible(this.movible, pasos);
        this.setChanged();
   }

   public Movible obtenerMovible(){
        setChanged();
        return movible;
   }

   public boolean sosGanador(){
        return (movible.sosGanador());
   }

   public boolean movibleLesionado(){
        return (movible.estaLesionado());
   }

   public String obtenerNombre() {return this.nombre;}

}
