package edu.fiuba.algo3.modelo.seniority;

public class SemiSenior extends Seniority{

    public SemiSenior() {
        super(8);
    }

    public Seniority sumarPaso() {
        this.cantidadPasos++;
        if (cantidadPasos == 12){
            return new Senior();
        }
        return this;
    }

}
