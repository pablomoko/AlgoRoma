package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JugarEventHandler implements EventHandler<ActionEvent> {

    private Scene proximaEscena;

    private Stage stage;

    public JugarEventHandler(Scene proximaEscena, Stage stage) {
        this.proximaEscena = proximaEscena;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.setScene(proximaEscena);
        this.stage.setFullScreen(true);
    }
}
