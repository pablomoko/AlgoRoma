package edu.fiuba.algo3.modelo.premio;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.premio.Premio;

public class Comida extends Premio {
    private int valorEnergetico;
    public Comida(int unValorEnergetico ){
        valorEnergetico = unValorEnergetico;
    }
    public int caclularValorEnergetico(){
        return valorEnergetico;
    }

    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.alimentarse(this);
    }
}
