package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class GestorTurnos<T> {
    private ArrayList<T> listaDeTurnos;
    private int indiceTurnoActual;
    private int rondasMaximas;
    private int jugadorQueIniciaRonda;

    public GestorTurnos(int rondasMaximas) {
        this.listaDeTurnos = new ArrayList<>();
        this.indiceTurnoActual = 0;
        this.rondasMaximas = rondasMaximas;
        this.jugadorQueIniciaRonda = 0;
    }

    public void agregarTurno(T turno) {
        listaDeTurnos.add(turno);
    }
    public int cantidadTurnos() {
        return listaDeTurnos.size();
    }

    public T obtenerTurnoActual() {
        if (listaDeTurnos.isEmpty()) {
            return null;
        }
        return listaDeTurnos.get(indiceTurnoActual);
    }
    public void rondaCero(int numeroJugadorInicial){
        jugadorQueIniciaRonda = numeroJugadorInicial;
    }

    public void avanzarTurno() {

        if (!listaDeTurnos.isEmpty() && rondasMaximas!=0) {
            indiceTurnoActual = (indiceTurnoActual + 1) % listaDeTurnos.size();
        }
        if (indiceTurnoActual == jugadorQueIniciaRonda) {
            if (rondasMaximas == 0){
                throw new IllegalArgumentException("Ya se supero la cantidad de rondas maximas");
            }
            rondasMaximas--;
        }
    }

    public void avanzarTurnos(int numeroDeTurnos) {

        for (int i=0; i< numeroDeTurnos; i++){
            this.avanzarTurno();
        }
    }

    public ArrayList<T> getListaDeTurnos(){
        return this.listaDeTurnos;
    }

}
