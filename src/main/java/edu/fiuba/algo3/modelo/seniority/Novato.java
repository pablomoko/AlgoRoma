package edu.fiuba.algo3.modelo.seniority;

public class Novato extends Seniority{

    public Novato() {
        super(0);
    }

    public Seniority sumarPaso() {
        this.cantidadPasos++;
        if (cantidadPasos == 8){
            return new SemiSenior();
        }
        return this;
    }

}
