package edu.fiuba.algo3.modelo.nivelEquipamiento;

import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.premio.equipamiento.EscYEsp;

public class NivelEquipamiento3 extends NivelEquipamiento{
    private Equipamiento equipamiento;

    public NivelEquipamiento3(){
        this.equipamiento = new EscYEsp();
    }
    public int usarEquipamiento(){
        return equipamiento.usar();
    }

    public NivelEquipamiento siguienteNivel(){
        return new NivelEquipamiento4();
    }

    public String getNombre(){
        return equipamiento.getClass().getSimpleName();
    }
}
