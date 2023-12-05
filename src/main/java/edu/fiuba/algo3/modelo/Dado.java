package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado implements Tirador{
    public int tirarDado(){
        return new Random().nextInt(6 - 1 + 1) + 1;
    }
}
