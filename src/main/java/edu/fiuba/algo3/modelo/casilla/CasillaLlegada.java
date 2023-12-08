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
        if (!unMovible.estaCompleto()){
            mapeador.obtenerCasillaIntermedia().movibles.add(unMovible);
            mapeador.ubicarMovible(unMovible, mapeador.obtenerCasillaIntermedia());
        }
        else{
            this.movibles.add(unMovible);
            mapeador.ubicarMovible(unMovible.ganador(), this);

        }
    }
}

