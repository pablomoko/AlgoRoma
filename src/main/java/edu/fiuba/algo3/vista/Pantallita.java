package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Pantallita extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Pantallita");
        Label label = new Label();

        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, 0, label);
        Scene escenaJugadores = new Scene(contenedorJugadores, 800, 700);

        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaJugadores);
        Scene escenaInicial = new Scene(contenedorInicial, 800, 700);

        stage.setScene(escenaInicial);
        stage.show();
    }
}
