package edu.fiuba.algo3.modelo.casilla;

import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Posicion;

public class CasillaLlegada extends Casilla{

    public CasillaLlegada(Posicion posicion, Premio premio, Obstaculo obstaculo){
        super(posicion, premio, obstaculo);
    }
    public Posicion retrocederPosicion(){
        Posicion nuevaPosicion = new Posicion(12,2);
        return nuevaPosicion;
    }
}
