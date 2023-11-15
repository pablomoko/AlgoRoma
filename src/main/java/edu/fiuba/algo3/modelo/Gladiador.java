package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.List;

public class Gladiador {
    private Energia energia;
    private List<Equipamiento> equipamiento;

    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = new ArrayList<>();
    }

    public Gladiador(int valorEnergia){
        this.energia = new Energia(valorEnergia);
        this.equipamiento = null;
    }

    public int caclularEnergia(){
        return (this.energia.caclularEnergia());
    }

    public int alimentarse(Comida unaComida){
        return energia.aumentarEnergiaComiendo(unaComida);
    }

    public List<Equipamiento> verEquipamiento(){
        return (this.equipamiento);
    }

    public void equiparse(){
        if (equipamiento.size() == 0){
            Casco casco = new Casco();
            equipamiento.add(casco);
        }
    }

    public int usarEquipamiento() {return equipamiento.get(equipamiento.size() - 1).usar();}
    public int pelearContraFiera(){ return energia.gastarEnergiaPeleando(this);}



}
