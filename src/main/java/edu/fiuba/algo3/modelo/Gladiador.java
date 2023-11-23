package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamiento.*;
import edu.fiuba.algo3.modelo.seniority.*;

import java.util.Stack;

public class Gladiador implements Movible{
    private Energia energia;
    private Stack<Equipamiento> equipamiento;

    //private int pasos;

    private Seniority seniority;

    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = new Stack<>();
        //this.pasos = 0;
        this.seniority = new Novato();
    }

    public Gladiador(int energia){
        this.energia = new Energia(energia);
        this.equipamiento = new Stack<>();
        //this.pasos = 0;
        this.seniority = new Novato();
    }

    public Gladiador(int energia, Seniority seniority){
        this.energia = new Energia(energia);
        this.equipamiento = new Stack<>();
        //this.pasos = 0;
        this.seniority = seniority;
    }

    public int caclularEnergia(){
        return (this.energia.calcularEnergia());
    }

    public int alimentarse(Comida unaComida){
        return energia.aumentarEnergiaComiendo(unaComida);
    }

    public Stack<Equipamiento> verEquipamiento(){
        return (this.equipamiento);
    }

    public Equipamiento verSiguienteEquipamiento(){
        return (this.equipamiento.peek().siguienteEquipamiento());
    }

    public Equipamiento equiparse(){
        Equipamiento nuevo;
        if (equipamiento.isEmpty()){
            nuevo = new Casco();
            equipamiento.push(nuevo);
        }else{
            nuevo = equipamiento.peek().equiparProximo(equipamiento);
        }
        return nuevo;
    }

    public int usarEquipamiento() {return equipamiento.peek().usar();}
    public int pelearContraFiera(){ return energia.gastarEnergiaPeleando(this);}

    /*public int verPasos(){
        return (this.pasos);
    }*/

    public void mover(int unaCantidad){
        if(energia.calcularEnergia() > 0) {
            this.seniority.sumarPasos(unaCantidad);
            //this.pasos = (pasos + unaCantidad);
            energia.disminuirEnergia(1);
        }

    }

    public void aumentarTurno(){
        this.seniority = this.seniority.sumarPaso();
    }

    public Seniority verSeniority(){
        return this.seniority;
    }

    public boolean estaCompleto() {
        return (this.equipamiento.size() == 4);
    }


}
