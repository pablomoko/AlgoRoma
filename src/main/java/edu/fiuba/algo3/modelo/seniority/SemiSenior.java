package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;

public class SemiSenior extends Seniority{

    public SemiSenior() {
        super(8);
    }

    public Seniority sumarPaso() {
        this.cantidadPasos++;
        if (cantidadPasos >= 8){
            return new Senior();
        }
        return this;
    }

    public Seniority sumarPasos(int unaCantidad) {
        this.cantidadPasos+= unaCantidad;
        if (cantidadPasos >= 12){
            return new Senior();
        }
        return this;
    }

    public Energia plusDeEnergia(Energia energia){
        return energia.aumentarEnergia(5);
    }

}
