package edu.fiuba.algo3.modelo.casilla;

import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Posicion;

public class CasillaLlegada extends Casilla{

    public CasillaLlegada(Posicion posicion, Premio premio, Obstaculo obstaculo){
        super(posicion, premio, obstaculo);
    }
    public void moverMovible(Casilla casillaDestino, Movible unMovible) {
        if (!this.movibles.isEmpty()) {

            casillaDestino.colocarMovible(unMovible);
            this.movibles.remove(unMovible);
        } else {
            throw new IllegalStateException("No hay gladiador en esta casilla");
        }

    }


}
