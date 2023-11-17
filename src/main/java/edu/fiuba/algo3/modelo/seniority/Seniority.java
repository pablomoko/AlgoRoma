package edu.fiuba.algo3.modelo.seniority;

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

    public int verPasos(){
        return (this.cantidadPasos);
    }
}
