package edu.fiuba.algo3.interfazGrafica;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class IncrementarJugadoresEventHandler implements EventHandler<ActionEvent> {

    private Label cantidadJugadores;

    public IncrementarJugadoresEventHandler(Label cantidadJugadores) { this.cantidadJugadores = cantidadJugadores; }

    @Override
    public void handle(ActionEvent actionEvent) {
        int cantidad = Integer.parseInt(this.cantidadJugadores.getText().replaceAll("[^0-9]", ""));
        if (cantidad < 8) {
            this.cantidadJugadores.setText(String.format("%s jugadores", cantidad + 1));
        }
    }
}
