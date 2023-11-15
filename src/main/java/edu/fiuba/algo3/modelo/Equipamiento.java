package edu.fiuba.algo3.modelo;

public interface Equipamiento {
    int usar();
}

class Casco implements Equipamiento{

    int usar(){
        return (15);
    }
}
