package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.seniority.Novato;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;


public class GestorFlujoDeJuego {
    private Dado dado;
    private Tablero tablero;
    private GestorTurnos<Jugador> jugadores;


    public GestorFlujoDeJuego(){ //ESTO DEBERIA LLAMARSE AL INICIALIZAR LA VISTA 1 (PRESENTACION DEL JUEGO)
        dado = new Dado();
        jugadores = new GestorTurnos<Jugador>();
        String stringJson = "{\"mapa\":{\"ancho\":10,\"largo\":18},\"camino\":{\"celdas\":[{\"x\":1,\"y\":7,\"tipo\":\"Salida\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":2,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":2,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":2,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":3,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":4,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":5,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":6,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":7,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":8,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":9,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":10,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":11,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":12,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":12,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Comida\"},{\"x\":12,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":12,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":13,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"Comida\"},{\"x\":14,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":15,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":16,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":17,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":1,\"tipo\":\"Llegada\",\"obstaculo\":\"\",\"premio\":\"\"}]}}";
        LinkedList <Casilla> casillas = GestorArchivos.generarListaDeCasillasDesdeJSON(stringJson);
        tablero = new Tablero(casillas);
    }
    public void agregarJugador(String nombre){ //EN LA VISTA 2 SE VAN AGREGANDO JUGADORES (BOTON LADO IZQ) |AGREGAR JUGADOR| |NOMBRE|
        if (jugadores.cantidadTurnos() > 6){
            throw new IllegalArgumentException("La cantidad de jugadores debe ser menor a 6");
        }
        Jugador jugador = new Jugador(nombre,new Gladiador(20, new Novato()));
        jugadores.agregarTurno(jugador);
        jugador.inicializarMovible(tablero);

    };
    public void iniciarJuego(){//EN LA VISTA 2  (BOTON LADO DER) |INICIAR JUEGO|  --- si no hay 2 jugadores, se tienen que cargar mas
        if (jugadores.cantidadTurnos() < 2){
            throw new IllegalArgumentException("La cantidad de jugadores debe ser mayor a 2");
        }
    };
    public Jugador jugadorInicial() { // EN LA VISTA 3 AGREGAR BOTON TIRAR DADO PARA VER QUE JUGADOR EMPIEZA (BOTON) | TIRAR DADO |
        int numeroJugadorInicial = dado.tirarDado(jugadores.cantidadTurnos());
        for (int i = 0 ; i< numeroJugadorInicial ;i++){
            jugadores.avanzarTurno();
        }
        return jugadores.obtenerTurnoActual();
    }
    public void jugarTurno(Jugador unJugador, int unosPasos){ // LOGICA PARA JUGAR UN TURNO

        unJugador.moverMovible(tablero,unosPasos);
//se muestran todos los mensajes obstaculos premios etc
        jugadores.avanzarTurno();


    }


    public int tirarDado(){ //ESTE BOTON APARECE SIEMPRE EN TODAS LAS PANTALLAS DURANTE EL JUEGO, LUEGO SE LE PASA LO QUE DEVUELVE A jugarTurno O PRENDAS
        return dado.tirarDado();
    }

    public int tirarDado(int numeroCaras){
        return dado.tirarDado(numeroCaras);
    }


    private void saltarTurno(){

    }

    private Tablero inicialiarTablero(String stringJson){
        LinkedList <Casilla> casillas = GestorArchivos.generarListaDeCasillasDesdeJSON(stringJson);

        return new Tablero(casillas);
    };

}
