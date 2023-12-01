package edu.fiuba.algo3.modelo.casilla;

import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Posicion;

public class CasillaCamino extends Casilla{

    public CasillaCamino(Posicion posicion, Premio premio, Obstaculo obstaculo){
        super(posicion, premio, obstaculo);
    }
}
