package edu.fiuba.algo3.modelo;
import java.util.List;

public class Gladiador {
    private Energia energia;
    private List<Equipamiento> equipamiento;

    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = null;
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



}
