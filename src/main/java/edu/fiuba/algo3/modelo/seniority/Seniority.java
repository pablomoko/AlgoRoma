package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;
public abstract class Seniority {

    int cantidadPasos = 0;

    public Seniority(int pasos) {
        this.cantidadPasos = pasos;
    }

    public Seniority sumarPaso(){
        return this;
    };

    public Seniority sumarPasos(int unaCantidad){
        this.cantidadPasos = this.cantidadPasos + unaCantidad;
        return this;
    };

    public Energia plusDeEnergia(Energia energia){
        return energia;
    }

    public int verPasos(){
        return (this.cantidadPasos);
    }
}
