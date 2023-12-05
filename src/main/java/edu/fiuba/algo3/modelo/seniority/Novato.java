package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;

public class Novato extends Seniority{

    public Novato() {
        super(0,0);
    }

    public Seniority sumarTurno() {
        this.cantidadTurnos++;
        if (cantidadTurnos >= 8){
            return new SemiSenior(pasos);
        }
        return this;
    }

    public Seniority sumarTurnos(int unaCantidad) {
        this.cantidadTurnos+= unaCantidad;
        if (cantidadTurnos >= 8){
            return new SemiSenior(pasos);
        }
        return this;
    }

    public Energia plusDeEnergia(Energia energia){
        return energia.aumentarEnergia(0);
    }

}
