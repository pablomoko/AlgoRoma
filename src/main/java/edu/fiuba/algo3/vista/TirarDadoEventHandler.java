package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.GestorFlujoDeJuego;

public class TirarDadoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    private Button botonDado;

    public TirarDadoEventHandler(Stage stage, Button botonDado) {
        this.stage = stage;
        this.botonDado = botonDado;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        int resultado = new GestorFlujoDeJuego().tirarDado();

    }
}
