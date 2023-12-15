package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.BotonDado;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class SiguienteTurnoEventHandler implements EventHandler<ActionEvent> {

    private GestorTurnos gestorTurnos;

    private ContenedorPrincipal contenedorPrincipal;

    private Button botonContinuar;

    private BotonDado botonDado;

    public SiguienteTurnoEventHandler(GestorTurnos gestorTurnos, ContenedorPrincipal contenedorPrincipal, Button botonContinuar, BotonDado botonDado) {
        this.gestorTurnos = gestorTurnos;
        this.contenedorPrincipal = contenedorPrincipal;
        this.botonContinuar = botonContinuar;
        this.botonDado = botonDado;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.gestorTurnos.avanzarTurno();
        this.contenedorPrincipal.getChildren().remove(1);
        this.gestorTurnos.obtenerTurnoActual().notifyObservers();

        this.botonDado.setDisable(false);
        this.botonContinuar.setDisable(true);


    }
}
