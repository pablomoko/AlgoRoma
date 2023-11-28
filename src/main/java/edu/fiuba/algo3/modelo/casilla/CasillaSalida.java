package edu.fiuba.algo3.modelo.casilla;

import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Posicion;

public class CasillaSalida extends Casilla{

    public CasillaSalida(Posicion posicion, Premio premio, Obstaculo obstaculo){
        super(posicion, premio, obstaculo);
    }
}
