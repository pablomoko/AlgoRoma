package edu.fiuba.algo3.modelo.casilla;

import edu.fiuba.algo3.modelo.Mapeador;
import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.ArrayList;
import java.util.Observable;

public abstract class Casilla extends Observable {

    protected Posicion posicion;
    protected ArrayList<Movible> movibles;
    protected Premio premio;
    protected Obstaculo obstaculo;

    public Casilla(Posicion posicion, Premio premio, Obstaculo obstaculo) {
        this.posicion = posicion;
        this.premio = premio;
        this.obstaculo = obstaculo;
        this.movibles = new ArrayList<>();
    }


    public void colocarMovible(Movible unMovible, Mapeador mapeador) {
        this.movibles.add(unMovible);
        mapeador.ubicarMovible(unMovible, this);
        this.setChanged();
    }

    public void moverMovible(Casilla casillaDestino, Movible unMovible, Mapeador mapeador) {
        if (!this.movibles.isEmpty()) {
            this.movibles.remove(unMovible);
            casillaDestino.colocarMovible(unMovible, mapeador);
        } else {
            throw new IllegalStateException("No hay gladiador en esta casilla");
        }
        this.setChanged();

    }

    public void afectarMovible(Movible movible){

        movible.obtenerPremio(this.premio);
        movible.vs(this.obstaculo);
        this.setChanged();

    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public Premio getPremio() {
        this.setChanged();
        return this.premio;
    }

    public Obstaculo getObstaculo() {
        this.setChanged();
        return this.obstaculo;
    }

}
