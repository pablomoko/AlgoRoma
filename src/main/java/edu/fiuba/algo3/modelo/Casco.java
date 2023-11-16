package edu.fiuba.algo3.modelo;

import java.util.Stack;

public class Casco implements Equipamiento {

    public int usar() {
        return (15);
    }
    public Equipamiento siguienteEquipamiento(){
        return (new Armadura());
    }

    public void equiparProximo(Stack<Equipamiento> equipamiento){
        Equipamiento nuevo = equipamiento.peek().siguienteEquipamiento();
        equipamiento.push(nuevo);
    }
}
