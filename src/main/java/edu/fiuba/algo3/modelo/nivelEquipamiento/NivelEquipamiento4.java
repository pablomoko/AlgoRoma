package edu.fiuba.algo3.modelo.nivelEquipamiento;

import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.premio.equipamiento.Llave;

public class NivelEquipamiento4 extends NivelEquipamiento{
    private Equipamiento equipamiento;

    public NivelEquipamiento4(){
        this.equipamiento = new Llave();
    }
    public int usarEquipamiento(){
        return equipamiento.usar();
    }

    public NivelEquipamiento siguienteNivel(){
        return new NivelEquipamiento4();
    }
}
