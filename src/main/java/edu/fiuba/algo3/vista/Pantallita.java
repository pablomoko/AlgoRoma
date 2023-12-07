package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pantallita extends Application {

    public void start(Stage stage) {

        stage.setTitle("Pantallita");

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage);
        Scene escenaJugadores = new Scene(contenedorJugadores, 800, 700);

        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaJugadores);
        Scene escenaInicial = new Scene(contenedorInicial, 800, 700);

        stage.setScene(escenaInicial);
        stage.show();
    }
}
