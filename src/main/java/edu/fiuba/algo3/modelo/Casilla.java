package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;

import java.util.ArrayList;

public class Casilla {
    private int x;
    private int y;
    private String tipo;
    private ArrayList<Movible> movibles;
    private Premio premio;
    private Obstaculo obstaculo;

    public Casilla(int unNumeroPosicion) {
        this.x = unNumeroPosicion;
        this.movibles = new ArrayList<Movible>();
    }
    public Casilla(int x, int y, String tipo, Premio premio, Obstaculo obstaculo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.premio = premio;
        this.obstaculo = obstaculo;
        this.movibles = new ArrayList<>();
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

    public void afectarMovible(Movible movible){
        movible.vs(this.obstaculo);
        movible.obtenerPremio(this.premio);
    }

    public boolean tieneMovible(Movible unMovible) {
        return (this.movibles.contains(unMovible));
    }

    public int getPosicion(){
        return this.x;
    }

}
