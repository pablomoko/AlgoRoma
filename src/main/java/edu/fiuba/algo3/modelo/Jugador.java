package edu.fiuba.algo3.modelo;
import java.util.List;

public class Jugador {
    private Gladiador gladiador;
    private String nombre;

    public Jugador(Gladiador gladiador, String nombre){
        this.gladiador = gladiador;
        this.nombre = nombre;
    }

    public int EnergiaGladiador(){
        return (gladiador.verEnergia());
    }

    public List<Equipamiento> EquipamientoGladiador(){
        return (gladiador.verEquipamiento());
    }
}
