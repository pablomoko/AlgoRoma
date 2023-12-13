package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorTurnos;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class ContenedorPrincipal extends VBox implements Observer {

    private Stage stage;

    private ContenedorTablero contenedorTablero;

    private ContenedorEstado contenedorEstado;

    public ContenedorPrincipal(Stage stage, int ancho, int alto, GestorTurnos gestorTurnos, Tablero tablero) {
        stage.setFullScreen(true);
        this.setPrefWidth(stage.getWidth());
        this.setPrefHeight(stage.getHeight());
        this.contenedorTablero = new ContenedorTablero(stage, ancho, alto, tablero);
        this.contenedorEstado = new ContenedorEstado(stage, alto, gestorTurnos, tablero);
        this.getChildren().addAll(contenedorTablero, contenedorEstado);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("PANCHO");
        if (o.getClass() == Jugador.class) {
            this.contenedorTablero.update(o, arg);
            this.contenedorEstado.update(o, arg);
        }
    }
}
