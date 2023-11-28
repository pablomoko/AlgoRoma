package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.premio.equipamiento.Casco;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.seniority.*;

import java.util.Stack;

public class Gladiador implements Movible{
    private Energia energia;
    private Stack<Equipamiento> equipamiento;

    private Seniority seniority;

    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = new Stack<>();
        this.seniority = new Novato();
    }

    public Gladiador(int energia){
        this.energia = new Energia(energia);
        this.equipamiento = new Stack<>();
        this.seniority = new Novato();
    }

    public Gladiador(int energia, Seniority seniority){
        this.energia = new Energia(energia);
        this.equipamiento = new Stack<>();
        this.seniority = seniority;
    }

    public void vs(Obstaculo obstaculo){
        obstaculo.afectarGladiador(this);
    }

    public void obtenerPremio(Premio premio){
        premio.afectarGladiador(this);
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

    public int usarEquipamiento() {
        if(equipamiento.isEmpty()){
            return 20;
        }else{
            return equipamiento.peek().usar();
        }
    }
    public int pelearContraFiera(){ return energia.gastarEnergiaPeleando(this);}

    public void afectarEnergia(int energia){
        this.energia.disminuirEnergia(energia);
    }


    public void mover(int unaCantidad){
        if(energia.calcularEnergia() > 0) {
            this.seniority.sumarPasos(unaCantidad);
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
