package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.vista.ContenedorTablero;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;


public class GestorFlujoDeJuego {
    private GestorTurnos<Jugador> jugadores;

    public static final int RONDAS_MAXIMAS = 30;


    public GestorFlujoDeJuego(ContenedorTablero vista){ //ESTO DEBERIA LLAMARSE AL INICIALIZAR LA VISTA 1 (PRESENTACION DEL JUEGO)
        jugadores = new GestorTurnos<Jugador>(RONDAS_MAXIMAS);
    }
    public void iniciarJuego(){//EN LA VISTA 2  (BOTON LADO DER) |INICIAR JUEGO|  --- si no hay 2 jugadores, se tienen que cargar mas
        if (jugadores.cantidadTurnos() < 2){
            throw new IllegalArgumentException("La cantidad de jugadores debe ser mayor a 2");
        }
    };

    //tirar dado para ver que jugador es en inicial
    //usar metodo tirarDado(cantidadJugadores)

    public Jugador jugadorInicial(int numeroJugadorInicial) { // EN LA VISTA 3 AGREGAR BOTON TIRAR DADO PARA VER QUE JUGADOR EMPIEZA (BOTON) | TIRAR DADO |
        jugadores.rondaCero(numeroJugadorInicial);
        for (int i = 0 ; i< numeroJugadorInicial ;i++){
            jugadores.avanzarTurno();
        }
        jugadores.rondaCero(numeroJugadorInicial);
        return jugadores.obtenerTurnoActual();
    }
    //tirar dado de 6 caras |BOTON| para que el primer jugador(el que sale del metodo anterior) camine unos pasos
    //pasarle el jugador y los pasos al metodo de abajo

//luego de jugar el primer turno se presiona el boton |AVANZAR TURNO| y se le pide al nuevo jugador que
    //tire el dado nuevamente
    public Jugador avanzarTurno(){
        jugadores.avanzarTurno();
        return jugadores.obtenerTurnoActual();
    }

    //aca se tira el dado y se entra en loop constante hasta las 30 rondas



}
