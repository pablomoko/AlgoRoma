package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.ContenedorDefinirTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContinuarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;


    private GestorTurnos<Jugador> jugadores;

    private Label label;

    public ContinuarEventHandler(Stage stage, GestorTurnos<Jugador> jugadores, Label label){
        this.stage = stage;
        this.jugadores = jugadores;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.jugadores.cantidadTurnos() >= 2) {
            ContenedorDefinirTurno contenedorDefinirTurno = new ContenedorDefinirTurno(stage, jugadores);
            Scene escenaDefinirTurno = new Scene(contenedorDefinirTurno, 800, 700);
            stage.setScene(escenaDefinirTurno);
            stage.setFullScreen(true);
        } else {
            this.label.setText("El minimo son 2 jugadores");
            this.label.setTextFill(Color.DARKBLUE);
        }
    }
}
