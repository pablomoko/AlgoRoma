package edu.fiuba.algo3.modelo.nivelEquipamiento;

import edu.fiuba.algo3.modelo.premio.equipamiento.Armadura;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;

public class NivelEquipamiento2 extends NivelEquipamiento{
    private Equipamiento equipamiento;

    public NivelEquipamiento2(){
        this.equipamiento = new Armadura();
    }
    public int usarEquipamiento(){
        return equipamiento.usar();
    }

    public NivelEquipamiento siguienteNivel(){
        return new NivelEquipamiento3();
    }
}
