package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContinuarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;

    private int cantidadDeJugadores;

    private Label label;

    public ContinuarEventHandler(Stage stage, Scene proximaEscena, int cantidadDeJugadores, Label label){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.cantidadDeJugadores >= 2) {
            stage.setScene(proximaEscena);
            stage.setFullScreen(true);
        } else {
            this.label.setText("El minimo son 2 jugadores");
            this.label.setTextFill(Color.DARKBLUE);
        }
    }
}
