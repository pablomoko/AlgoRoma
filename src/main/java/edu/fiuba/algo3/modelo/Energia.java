package edu.fiuba.algo3.modelo;

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
    public int gastarEnergiaPeleando(Gladiador gladiador){
        valor = valor - gladiador.usarEquipamiento();
        return valor;
    }

}
