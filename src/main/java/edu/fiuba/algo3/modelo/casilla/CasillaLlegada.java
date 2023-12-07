package edu.fiuba.algo3.modelo.casilla;

import edu.fiuba.algo3.modelo.Mapeador;
import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Posicion;

public class CasillaLlegada extends Casilla{

    public CasillaLlegada(Posicion posicion, Premio premio, Obstaculo obstaculo){
        super(posicion, premio, obstaculo);
    }

    public void colocarMovible(Movible unMovible, Mapeador mapeador) {
        if (unMovible.estaCompleto()) {
            this.movibles.add(unMovible);
        }
        else{
            mapeador.obtenerCasillaIntermedia().movibles.add(unMovible);
        }
    }

    public void moverMovible(Casilla casillaDestino, Movible unMovible,  Mapeador mapeador) {
        if (!this.movibles.isEmpty()) {
            casillaDestino.colocarMovible(unMovible, mapeador);
            this.movibles.remove(unMovible);
            mapeador.ubicarMovible(unMovible, casillaDestino);
        } else {
            throw new IllegalStateException("No hay gladiador en esta casilla");
        }
    }

    }

