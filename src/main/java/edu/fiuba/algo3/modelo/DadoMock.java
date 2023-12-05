package edu.fiuba.algo3.modelo;

import java.util.Random;

public class DadoMock implements Tirador{
    int tirada;

    public DadoMock(int numero){
        this.tirada = numero;
    }
    public int tirarDado(){
        return tirada;
    }
}
