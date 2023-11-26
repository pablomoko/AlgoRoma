package edu.fiuba.algo3.modelo.premio.equipamiento;

import java.util.Stack;

public class EscYEsp extends Equipamiento {
    public int usar(){
        return (2);
    }

    public Equipamiento siguienteEquipamiento() {
        return (new Llave());
    }

    public Equipamiento equiparProximo(Stack<Equipamiento> equipamiento){
        Equipamiento nuevo = equipamiento.peek().siguienteEquipamiento();
        equipamiento.push(nuevo);
        return nuevo;
    }
}
