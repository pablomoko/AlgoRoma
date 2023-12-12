package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SiguienteTurnoEventHandler implements EventHandler<ActionEvent> {

    private GestorTurnos gestorTurnos;

    public SiguienteTurnoEventHandler(GestorTurnos gestorTurnos) {
        this.gestorTurnos = gestorTurnos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.gestorTurnos.avanzarTurno();
        System.out.println("Se Continua");

    }
}
