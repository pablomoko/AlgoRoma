package edu.fiuba.algo3.modelo;

import java.util.Stack;

public class Armadura implements Equipamiento{
    public int usar(){
        return (10);
    }

    public Equipamiento siguienteEquipamiento() {
        return (new EscYEsp());
    }

    public void equiparProximo(Stack<Equipamiento> equipamiento){
        Equipamiento nuevo = equipamiento.peek().siguienteEquipamiento();
        equipamiento.push(nuevo);
    }
}
