package edu.fiuba.algo3.modelo.nivelEquipamiento;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;

public class NivelEquipamiento0 extends NivelEquipamiento{

    public int usarEquipamiento(){
        return 20;
    }

    public NivelEquipamiento siguienteNivel(){
        return new NivelEquipamiento1();
    }
}
