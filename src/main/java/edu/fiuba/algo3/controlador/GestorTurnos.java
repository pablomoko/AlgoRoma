package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class GestorTurnos {
    private ArrayList<Jugador> listaDeTurnos;
    private int indiceTurnoActual;
    private int rondasMaximas;
    private int jugadorQueIniciaRonda;

    private int rondaActual;

    public GestorTurnos(int rondasMaximas) {
        this.listaDeTurnos = new ArrayList<>();
        this.indiceTurnoActual = 0;
        this.rondasMaximas = rondasMaximas;
        this.rondaActual = 1;
        this.jugadorQueIniciaRonda = 0;
    }

    public void agregarTurno(Jugador turno) {
        listaDeTurnos.add(turno);
    }
    public int cantidadTurnos() {
        return listaDeTurnos.size();
    }

    public Jugador obtenerTurnoActual() {
        if (listaDeTurnos.isEmpty()) {
            return null;
        }
        return listaDeTurnos.get(indiceTurnoActual);
    }
    public void rondaCero(int numeroJugadorInicial){
        jugadorQueIniciaRonda = numeroJugadorInicial;
    }

    public void avanzarTurno() {

        if (!listaDeTurnos.isEmpty() && rondaActual!=rondasMaximas) {
            indiceTurnoActual = (indiceTurnoActual + 1) % listaDeTurnos.size();
        }
        if (indiceTurnoActual == jugadorQueIniciaRonda) {
            if (rondaActual == rondasMaximas + 1){
                throw new IllegalArgumentException("Ya se supero la cantidad de rondas maximas");
            }
            rondaActual++;
        }
    }

    public void avanzarTurnos(int numeroDeTurnos) {

        for (int i=0; i< numeroDeTurnos; i++){
            this.avanzarTurno();
        }
    }

    public ArrayList<Jugador> getListaDeTurnos(){
        return this.listaDeTurnos;
    }

    public int obtenerRondaActual() {
        return this.rondaActual;
    }

    public void jugadorInicial(int numeroJugadorInicial) { // EN LA VISTA 3 AGREGAR BOTON TIRAR DADO PARA VER QUE JUGADOR EMPIEZA (BOTON) | TIRAR DADO |
        for (int i = 0 ; i< numeroJugadorInicial ;i++){
            this.avanzarTurno();
        }
        this.rondaCero(numeroJugadorInicial);
    }

}
