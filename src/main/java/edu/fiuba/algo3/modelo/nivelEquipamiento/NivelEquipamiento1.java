package edu.fiuba.algo3.modelo.nivelEquipamiento;

import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.premio.equipamiento.Casco;

public class NivelEquipamiento1 extends NivelEquipamiento{
    private Equipamiento equipamiento;

    public NivelEquipamiento1(){
        this.equipamiento = new Casco();
    }
    public int usarEquipamiento(){
        return equipamiento.usar();
    }

    public NivelEquipamiento siguienteNivel(){
        return new NivelEquipamiento2();
    }

    public String getNombre(){
        return equipamiento.getClass().getSimpleName();
    }
}
