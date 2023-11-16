package edu.fiuba.algo3.modelo;

import java.util.Stack;

public interface Equipamiento {
    int usar();
    Equipamiento siguienteEquipamiento();

    void equiparProximo(Stack<Equipamiento> equipamiento);
}

