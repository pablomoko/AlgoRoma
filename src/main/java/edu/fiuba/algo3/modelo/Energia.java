package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.premio.Comida;

public class Energia {
    private int valor;
    public Energia(int valor){
        this.valor = valor;
    }
    public int calcularEnergia(){
        return valor;
    }

    public Energia aumentarEnergia(int unaCantidad){
        this.valor+= unaCantidad;
        return this;
    }

    public int disminuirEnergia(int unaCantidad){
        valor = valor - unaCantidad;
        return valor;
    }

}
