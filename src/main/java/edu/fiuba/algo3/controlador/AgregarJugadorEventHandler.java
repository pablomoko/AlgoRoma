package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.GestorFlujoDeJuego;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.vista.ContenedorJugadores;
import edu.fiuba.algo3.vista.ContenedorTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class AgregarJugadorEventHandler implements EventHandler<ActionEvent> {

    private Label label;

    private TextField nombreJugador;

    private GestorTurnos<Jugador> jugadores;

    public static final int RONDAS_MAXIMAS = 30;

    public AgregarJugadorEventHandler(Label label, TextField nombreJugador) {
        this.label = label;
        this.nombreJugador = nombreJugador;
        jugadores = new GestorTurnos<Jugador>(RONDAS_MAXIMAS);

    }

    public GestorTurnos<Jugador> getGestorTurnos(){
        return this.jugadores;
    }

    public void agregarJugador(String nombre){ //EN LA VISTA 2 SE VAN AGREGANDO JUGADORES (BOTON LADO IZQ) |AGREGAR JUGADOR| |NOMBRE|
        if (jugadores.cantidadTurnos() > 6){
            throw new IllegalArgumentException("La cantidad de jugadores debe ser menor a 6");
        }
        Jugador jugador = new Jugador(nombre,new Gladiador(20, new Novato()));
        jugadores.agregarTurno(jugador);

    };

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.nombreJugador.getText().length() < 4) {
            label.setText("El nombre debe contener como minimo 4 caracteres");
            label.setTextFill(Color.DARKBLUE);
        }else {
            if (this.jugadores.cantidadTurnos() < 6) {
                //ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, this.jugadores.cantidadTurnos() + 1, this.label);
                label.setText("Se ha agregado correctamente el jugador ingresado");
                label.setTextFill(Color.DARKGREEN);
                this.agregarJugador(nombreJugador.getText());
                this.nombreJugador.clear();

            } else {
                label.setText("Se ha llegado al limite de jugadores");
                label.setTextFill(Color.DARKBLUE);
            }
        }
    }
}
