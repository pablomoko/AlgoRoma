package edu.fiuba.algo3.modelo.premio.equipamiento;

import edu.fiuba.algo3.modelo.premio.Premio;

import java.util.Stack;

public interface Equipamiento extends Premio {
    int usar();
    Equipamiento siguienteEquipamiento();

    Equipamiento equiparProximo(Stack<Equipamiento> equipamiento);
}

