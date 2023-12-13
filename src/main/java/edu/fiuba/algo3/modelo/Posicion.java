package edu.fiuba.algo3.modelo;

public class Posicion {

    private int x;
    private int y;

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean esIgualA(int x, int y){
        return (this.x == x && this.y == y);
    }
}
