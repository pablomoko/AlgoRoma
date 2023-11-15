package edu.fiuba.algo3.modelo;
import java.util.List;

public class Gladiador implements Movible{
    private Energia energia;
    private List<Equipamiento> equipamiento;
    private int pasos;

    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = null;
        this.pasos = 0;
    }

    public Gladiador(int valorEnergia){
        this.energia = new Energia(valorEnergia);
        this.equipamiento = null;
        this.pasos = 0;
    }

    public int caclularEnergia(){
        return (this.energia.calcularEnergia());
    }

    public int alimentarse(Comida unaComida){
        return energia.aumentarEnergiaComiendo(unaComida);
    }

    public List<Equipamiento> verEquipamiento(){
        return (this.equipamiento);
    }

    public int verPasos(){
        return (this.pasos);
    }

    public void mover(int unaCantidad){
        if(energia.calcularEnergia() > 0) {
            this.pasos = (pasos + unaCantidad);
        }

    }



}
