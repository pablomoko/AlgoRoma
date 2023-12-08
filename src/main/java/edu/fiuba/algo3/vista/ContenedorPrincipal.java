package edu.fiuba.algo3.vista;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public abstract class ContenedorPrincipal extends VBox implements Observer {
    private ContenedorPrincipal(Stage stage ) {


    }

    @Override
    public abstract void update(Observable o, Object arg);
}
