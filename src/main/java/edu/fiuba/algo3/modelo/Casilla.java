package edu.fiuba.algo3.modelo;

public class Casilla implements Ubicable {
    private int posicion;
    private Movible movible;
    private Ubicable ubicable;

    public Casilla(int unNumeroPosicion, Movible unMovible, Ubicable unUbicable) {
        this.posicion = unNumeroPosicion;
        this.movible = unMovible;
        this.ubicable = unUbicable;
    }


    public void colocarMovible(Movible unMovible) {
        this.movible = movible;
    }

    public void moverMovible(Casilla casillaDestino) {
        if (this.movible != null) {
            casillaDestino.colocarMovible(movible);
            this.movible = null;
        } else {
            throw new IllegalStateException("No hay gladiador en esta casilla");
        }

    }

    public Movible obtenerMovible() {
        return movible;
    }
}
