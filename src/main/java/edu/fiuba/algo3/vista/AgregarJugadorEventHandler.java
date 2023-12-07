package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class AgregarJugadorEventHandler implements EventHandler<ActionEvent> {

    private int cantidadJugadores;

    private Stage stage;

    private Label label;


    public AgregarJugadorEventHandler(Stage stage, int cantidadJugadores, Label label) {
        this.stage = stage;
        this.cantidadJugadores = cantidadJugadores;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (cantidadJugadores < 6 ) {
            ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, this.cantidadJugadores+1, this.label);
            label.setText("Se ha agregado correctamente el jugador ingresado");
            label.setTextFill(Color.DARKGREEN);
            Scene proximaEscena = new Scene(contenedorJugadores, 800, 700);
            stage.setScene(proximaEscena);
        }else{
            label.setText("Se ha llegado al limite de jugadores");
            label.setTextFill(Color.DARKBLUE);
        }
    }
}
