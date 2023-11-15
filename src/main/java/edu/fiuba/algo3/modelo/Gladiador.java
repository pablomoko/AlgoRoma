package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Gladiador {
    private Energia energia;
    private Stack<Equipamiento> equipamiento;

    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = new Stack<>();
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

    public Stack<Equipamiento> verEquipamiento(){
        return (this.equipamiento);
    }

    public void equiparse(){
        if (equipamiento.size() == 0){
            Casco casco = new Casco();
            equipamiento.push(casco);
        }
    }

    public int usarEquipamiento() {return equipamiento.peek().usar();}
    public int pelearContraFiera(){ return energia.gastarEnergiaPeleando(this);}



}
