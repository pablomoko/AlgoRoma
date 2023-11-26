package edu.fiuba.algo3.modelo.premio;

import edu.fiuba.algo3.modelo.premio.Premio;

public class Comida implements Premio {
    private int valorEnergetico;
    public Comida(int unValorEnergetico ){
        valorEnergetico = unValorEnergetico;
    }
    public int caclularValorEnergetico(){
        return valorEnergetico;
    }
}
