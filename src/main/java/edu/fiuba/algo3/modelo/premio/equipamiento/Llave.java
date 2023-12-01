package edu.fiuba.algo3.modelo.premio.equipamiento;

import java.util.Stack;

public class Llave extends Equipamiento {
    public int usar(){
        return (0);
    }

    public Equipamiento siguienteEquipamiento() {
        return null;
    }

    public Equipamiento equiparProximo(Stack<Equipamiento> equipamiento){
        return this;
    }
}
