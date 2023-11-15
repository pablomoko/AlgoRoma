package edu.fiuba.algo3.modelo;

public interface Equipamiento {
    public int usar();
}

class Casco implements Equipamiento{

    public int usar(){
        return (15);
    }
}
