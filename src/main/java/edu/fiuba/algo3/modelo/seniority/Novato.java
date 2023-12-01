package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;

public class Novato extends Seniority{

    public Novato() {
        super(0);
    }

    public Seniority sumarPaso() {
        this.cantidadPasos++;
        if (cantidadPasos >= 8){
            return new SemiSenior();
        }
        return this;
    }

    public Seniority sumarPasos(int unaCantidad) {
        this.cantidadPasos+= unaCantidad;
        if (cantidadPasos >= 8){
            return new SemiSenior();
        }
        return this;
    }

    public Energia plusDeEnergia(Energia energia){
        return energia.aumentarEnergia(0);
    }

}
