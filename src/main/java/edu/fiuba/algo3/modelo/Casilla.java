package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Casilla {
    private int posicion;
    private ArrayList<Movible> movibles;
    private Ubicable ubicable;

    public Casilla(int unNumeroPosicion) {
        this.posicion = unNumeroPosicion;
        this.movibles = new ArrayList<Movible>();
    }


    public void colocarMovible(Movible unMovible) {
        this.movibles.add(unMovible);
    }

    public void moverMovible(Casilla casillaDestino, Movible unMovible) {
        if (!this.movibles.isEmpty()) {
            casillaDestino.colocarMovible(unMovible);
            this.movibles.remove(unMovible);
        } else {
            throw new IllegalStateException("No hay gladiador en esta casilla");
        }

    }

    public boolean tieneMovible(Movible unMovible) {
        return (this.movibles.contains(unMovible));
    }

    public int getPosicion(){
        return this.posicion;
    }

}
