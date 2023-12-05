package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;

public class Senior extends Seniority{
    public Senior(int pasos) {
        super(12, pasos);
    }

    public Seniority sumarTurno(){
        cantidadTurnos++;
        return this;
    }

    public Energia plusDeEnergia(Energia energia){
        return energia.aumentarEnergia(10);
    }
}
