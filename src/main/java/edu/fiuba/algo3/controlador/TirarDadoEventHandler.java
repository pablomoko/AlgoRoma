package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.GestorFlujoDeJuego;

public class TirarDadoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    private Button botonDado;

    private Dado dado;

    private GestorTurnos<Jugador> jugadores;

    private Tablero tablero;

    public TirarDadoEventHandler(Stage stage, Button botonDado, GestorTurnos<Jugador> jugadores, Tablero tablero) {
        this.stage = stage;
        this.botonDado = botonDado;
        this.dado = new Dado();
        this.jugadores = jugadores;
        this.tablero = tablero;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if(!jugadores.obtenerTurnoActual().movibleLesionado()){
            int unosPasos = this.dado.tirarDado();
            jugadores.obtenerTurnoActual().moverMovible(this.tablero, unosPasos);
        }else{
            jugadores.avanzarTurno();
            //mensaje lesionado
        }
        jugadores.obtenerTurnoActual().notifyObservers();
        jugadores.avanzarTurno();
    }
}
