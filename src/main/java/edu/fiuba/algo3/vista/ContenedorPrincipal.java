package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorTurnos;
import edu.fiuba.algo3.controlador.TirarDadoEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class ContenedorPrincipal extends StackPane implements Observer {

    private ContenedorTableroYEstado contenedorTableroYEstado;

    private GestorTurnos gestorTurnos;

    private Tablero tablero;

    private Stage stage;

    public ContenedorPrincipal(Stage stage, int ancho, int alto, GestorTurnos gestorTurnos, Tablero tablero) {
        this.gestorTurnos = gestorTurnos;
        this.tablero = tablero;
        this.stage = stage;
        stage.setFullScreen(true);
        this.setPrefWidth(stage.getWidth());
        this.setPrefHeight(stage.getHeight());

        BotonDado botonDado = new BotonDado();
        botonDado.setOnAction(new TirarDadoEventHandler(botonDado, this));

        ContenedorTablero contenedorTablero = new ContenedorTablero(stage, ancho, alto, tablero, gestorTurnos);
        ContenedorEstado contenedorEstado = new ContenedorEstado(stage, alto, gestorTurnos, tablero, botonDado, this);

        this.contenedorTableroYEstado = new ContenedorTableroYEstado(contenedorTablero, contenedorEstado);
        this.contenedorTableroYEstado.setPrefWidth(stage.getWidth());
        this.contenedorTableroYEstado.setPrefHeight(stage.getHeight());

        this.getChildren().add(this.contenedorTableroYEstado);
    }

    public GestorTurnos getGestorTurnos() {
        return this.gestorTurnos;
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public ContenedorTableroYEstado getContenedorTableroYEstado() {
        return this.contenedorTableroYEstado;
    }

    public Stage getStage(){
        return this.stage;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o.getClass() == Jugador.class) {
            if(this.gestorTurnos.hayEmpate()){
                ContenedorEmpate contenedorEmpate = new ContenedorEmpate();
                Scene escenaGanador = new Scene(contenedorEmpate, 800, 700);
                stage.setScene(escenaGanador);
                stage.setFullScreen(true);
            }
            this.contenedorTableroYEstado.update(o, arg);
        }
    }

}
