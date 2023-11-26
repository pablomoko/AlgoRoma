package edu.fiuba.algo3.modelo.premio.equipamiento;

import java.util.Stack;

public class Casco extends Equipamiento {

    public int usar() {
        return (15);
    }
    public Equipamiento siguienteEquipamiento(){
        return (new Armadura());
    }

    public Equipamiento equiparProximo(Stack<Equipamiento> equipamiento){
        Equipamiento nuevo = equipamiento.peek().siguienteEquipamiento();
        equipamiento.push(nuevo);
        return nuevo;
    }
}
