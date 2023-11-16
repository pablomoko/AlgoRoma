package edu.fiuba.algo3.modelo;

public class Casco implements Equipamiento {

    public int usar() {
        return (15);
    }
    public Equipamiento siguienteEquipamiento(){
        return (new Armadura());
    }
}
