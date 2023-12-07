package edu.fiuba.algo3.modelo.casilla;

import edu.fiuba.algo3.modelo.Mapeador;
import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.ArrayList;

public abstract class Casilla {

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
    }

    public void moverMovible(Casilla casillaDestino, Movible unMovible, Mapeador mapeador) {
        if (!this.movibles.isEmpty()) {
            this.movibles.remove(unMovible);
            casillaDestino.colocarMovible(unMovible, mapeador);
            mapeador.ubicarMovible(unMovible, casillaDestino);
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

}
