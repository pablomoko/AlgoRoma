package edu.fiuba.algo3.modelo;

public class Armadura implements Equipamiento{
    public int usar(){
        return (10);
    }

    public Equipamiento siguienteEquipamiento() {
        return (new EscYEsp());
    }
}
