package edu.fiuba.algo3.modelo.seniority;

import edu.fiuba.algo3.modelo.Energia;
public abstract class Seniority {

    int cantidadTurnos;

    int pasos;

    public Seniority(int cantTurnos, int pasos) {
        this.cantidadTurnos = cantTurnos;
        this.pasos = pasos;
    }

    public abstract Seniority sumarTurno();

    public Seniority sumarTurnos(int unaCantidad){
        this.cantidadTurnos = this.cantidadTurnos + unaCantidad;
        return this;
    };

    public Energia plusDeEnergia(Energia energia){
        return energia;
    }

    public int verPasos(){
        return (this.pasos);
    }
}
