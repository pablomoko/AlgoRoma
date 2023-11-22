package edu.fiuba.algo3.modelo.equipamiento;

import java.util.Stack;

public interface Equipamiento {
    int usar();
    Equipamiento siguienteEquipamiento();

    Equipamiento equiparProximo(Stack<Equipamiento> equipamiento);
}

