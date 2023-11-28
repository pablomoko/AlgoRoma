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
    public int aumentarEnergiaComiendo(Comida unaComida){
        valor = valor + unaComida.caclularValorEnergetico();
        return valor;
    }

    public Energia aumentarEnergia(int unaCantidad){
        this.valor+= unaCantidad;
        return this;
    }
    public int gastarEnergiaPeleando(Gladiador gladiador){
        valor = valor - gladiador.usarEquipamiento();
        return valor;
    }

    public int disminuirEnergia(int unValor){
        valor = valor - unValor;
        return valor;
    }

}
