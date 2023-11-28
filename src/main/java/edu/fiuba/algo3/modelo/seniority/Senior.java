package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;

public class Senior extends Seniority{
    public Senior() {
        super(12);
    }

    public Energia plusDeEnergia(Energia energia){
        return energia.aumentarEnergia(10);
    }
}
