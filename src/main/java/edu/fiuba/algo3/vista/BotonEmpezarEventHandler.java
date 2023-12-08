package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class BotonEmpezarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonEmpezarEventHandler(Stage stage, Scene proximaEscena){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
    }
}
