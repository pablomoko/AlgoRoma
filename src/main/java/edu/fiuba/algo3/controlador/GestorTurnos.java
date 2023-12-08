package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class GestorTurnos<T> {
    private ArrayList<T> listaDeTurnos;
    private int indiceTurnoActual;
    private int rondaActual;
    private int jugadorQueIniciaRonda;

    public GestorTurnos() {
        this.listaDeTurnos = new ArrayList<>();
        this.indiceTurnoActual = 0;
        this.rondaActual = 0;
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
        if (!listaDeTurnos.isEmpty()) {
            indiceTurnoActual = (indiceTurnoActual + 1) % listaDeTurnos.size();
        }
        if (indiceTurnoActual == jugadorQueIniciaRonda) {
            rondaActual++;
        }
    }



}
