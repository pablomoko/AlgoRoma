package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SiguienteTurnoEventHandler implements EventHandler<ActionEvent> {

    private GestorTurnos gestorTurnos;

    private ContenedorPrincipal contenedorPrincipal;

    public SiguienteTurnoEventHandler(GestorTurnos gestorTurnos, ContenedorPrincipal contenedorPrincipal) {
        this.gestorTurnos = gestorTurnos;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.gestorTurnos.avanzarTurno();
        this.contenedorPrincipal.getChildren().remove(1);
        this.gestorTurnos.obtenerTurnoActual().notifyObservers();

    }
}
