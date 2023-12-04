package edu.fiuba.algo3.modelo.premio.equipamiento;

import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.Gladiador;

import java.util.Stack;

public class Equipamiento extends Premio {
    public Equipamiento(){

    };
    public  int usar(){
        return 0;
    };

    public void afectarGladiador(Gladiador gladiador){
        gladiador.equiparse();
    }
}

