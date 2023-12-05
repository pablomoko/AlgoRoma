package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;

public class SemiSenior extends Seniority{

    public SemiSenior(int pasos) {
        super(8,pasos);
    }

    public Seniority sumarTurno() {
        this.cantidadTurnos++;
        if (cantidadTurnos >= 12){
            return new Senior(pasos);
        }
        return this;
    }

    public Seniority sumarTurnos(int unaCantidad) {
        this.cantidadTurnos+= unaCantidad;
        if (cantidadTurnos >= 12){
            return new Senior(pasos);
        }
        return this;
    }

    public Energia plusDeEnergia(Energia energia){
        return energia.aumentarEnergia(5);
    }

}
