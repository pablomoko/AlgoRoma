package edu.fiuba.algo3.modelo.casilla;

import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.ArrayList;

public abstract class Casilla {

    private Posicion posicion;
    private ArrayList<Movible> movibles;
    private Premio premio;
    private Obstaculo obstaculo;

    public Casilla(Posicion posicion, Premio premio, Obstaculo obstaculo) {
        this.posicion = posicion;
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
        movible.obtenerPremio(this.premio);
        movible.vs(this.obstaculo);

    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public boolean tieneMovible(Movible unMovible) {
        return (this.movibles.contains(unMovible));
    }
/*
    public int getPosicion(){
        return this.posicion;
    }*/


}
