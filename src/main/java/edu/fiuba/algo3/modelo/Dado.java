package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado implements Tirador{
    public int tirarDado(){
        return new Random().nextInt(6 - 1 + 1) + 1;
    }
    public int tirarDado(int numeroCaras){
        return new Random().nextInt(numeroCaras - 1 + 1) + 1;
    }
}
