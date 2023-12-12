package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorTurnos;
import edu.fiuba.algo3.controlador.SiguienteTurnoEventHandler;
import edu.fiuba.algo3.controlador.TirarDadoEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class ContenedorEstado extends VBox implements Observer {

    private Stage stage;

    private ContenedorTitulo contenedorTitulo;

    private VBox contenedorEstadoJugador;

    private GestorTurnos gestorTurnos;


    public ContenedorEstado(Stage stage, int alto, GestorTurnos gestorTurnos, Tablero tablero) {
        this.setPrefWidth(stage.getWidth());
        this.setPrefHeight(stage.getHeight() - (stage.getHeight() / (alto/1.4)) * 200);
        this.setStyle("-fx-background-color: GoldenRod");
        this.gestorTurnos = gestorTurnos;

        Button botonDado = new BotonDado();
        botonDado.setOnAction(new TirarDadoEventHandler(stage, botonDado, gestorTurnos, tablero));

        Label energia = new Label();
        energia.setText("Energia");
        energia.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");
        Label equipamiento = new Label();
        equipamiento.setText("Equipamiento");
        equipamiento.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");
        Label seniority = new Label();
        seniority.setText("Seniority");
        seniority.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        Button botonContinuar = new Button();
        SiguienteTurnoEventHandler siguienteTurnoEventHandler = new SiguienteTurnoEventHandler(gestorTurnos);
        botonContinuar.setOnAction(siguienteTurnoEventHandler);

        this.contenedorEstadoJugador = new VBox(energia, equipamiento, seniority);
        contenedorEstadoJugador.setAlignment(Pos.CENTER);

        HBox contenedorDadoYJugador = new HBox(botonDado, contenedorEstadoJugador, botonContinuar);
        contenedorDadoYJugador.setAlignment(Pos.BASELINE_LEFT);
        contenedorDadoYJugador.setPadding(new Insets(40));
        contenedorDadoYJugador.setSpacing(500);

        this.contenedorTitulo = new ContenedorTitulo();
        contenedorTitulo.setAlignment(Pos.CENTER);

        this.getChildren().addAll(contenedorTitulo, contenedorDadoYJugador);
        this.setAlignment(Pos.TOP_CENTER);
    }
    @Override
    public void update(Observable o, Object arg) {
        Jugador jugador = (Jugador) o;
        this.contenedorTitulo.setNombreJugador(jugador.obtenerNombre());
        this.contenedorTitulo.setNumeroRonda(this.gestorTurnos.obtenerRondaActual());
        System.out.println(jugador.obtenerNombre());
    }
}
