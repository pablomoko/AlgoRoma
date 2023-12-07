package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento0;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.premio.equipamiento.Casco;
import edu.fiuba.algo3.modelo.seniority.*;

import java.util.Stack;

public class Gladiador implements Movible{
    private Energia energia;
    private NivelEquipamiento equipamiento;

    private Seniority seniority;

    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = new NivelEquipamiento0();
        this.seniority = new Novato();
    }

    public Gladiador(int energia){
        this.energia = new Energia(energia);
        this.equipamiento = new NivelEquipamiento0();
        this.seniority = new Novato();
    }

    public Gladiador(int energia, Seniority seniority){
        this.energia = new Energia(energia);
        this.equipamiento = new NivelEquipamiento0();
        this.seniority = seniority;
    }

    public void vs(Obstaculo obstaculo){
        obstaculo.afectarGladiador(this);
    }

    public void obtenerPremio(Premio premio){
        premio.afectarGladiador(this);
    }
    public int calcularEnergia(){
        return (this.energia.calcularEnergia());
    }

    public int alimentarse(Comida unaComida){
        afectarEnergia(-unaComida.caclularValorEnergetico());
        return energia.calcularEnergia();
    }

    public NivelEquipamiento verEquipamiento(){
        return (this.equipamiento);
    }

    public NivelEquipamiento equiparse(){
        equipamiento = equipamiento.siguienteNivel();
        return equipamiento;
    }

    public int usarEquipamiento() {
        return equipamiento.usarEquipamiento();
    }
    public int pelearContraFiera(){
        afectarEnergia(this.equipamiento.usarEquipamiento());
        return energia.calcularEnergia();
    }

    public void afectarEnergia(int unaCantidad){
        this.energia.disminuirEnergia(unaCantidad);
    }

    public int mover(int unaCantidad){
        this.aumentarTurno();
        if(energia.calcularEnergia() >= unaCantidad) {
            this.seniority.sumarPasos(unaCantidad);
            energia.disminuirEnergia(unaCantidad);
            return unaCantidad;
        }else{
            this.energia.aumentarEnergia(5);
            return 0;
        }
    }

    public void aumentarTurno(){
        this.seniority = this.seniority.sumarTurno();
        this.energia = this.seniority.plusDeEnergia(this.energia);
    }

    public Seniority verSeniority(){
        return this.seniority;
    }

    public boolean estaCompleto() {
        return (this.equipamiento.usarEquipamiento() == 0);
    }

    public NivelEquipamiento getEquipamiento() {
        return equipamiento;
    }


}
