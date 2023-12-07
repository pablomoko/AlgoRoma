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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Pantallita");

        Label titulo = new Label();
        titulo.setText("AlgoRoma");
        titulo.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");

        Label cantidadJugadores = new Label();
        cantidadJugadores.setText("2 jugadores");
        cantidadJugadores.setStyle("-fx-font: 36 arial; -fx-text-fill: GoldenRod");


        Button botonDerecha = new Button();
        botonDerecha.setText(">");
        botonDerecha.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");
        botonDerecha.setOnAction(new IncrementarJugadoresEventHandler(cantidadJugadores));

        Button botonIzquierda = new Button();
        botonIzquierda.setText("<");
        botonIzquierda.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");
        botonIzquierda.setOnAction(new DisminuirJugadoresEventHandler(cantidadJugadores));

        HBox contenedorHorizontal = new HBox(botonIzquierda, cantidadJugadores, botonDerecha);
        contenedorHorizontal.setSpacing(0);
        contenedorHorizontal.setAlignment(Pos.CENTER);

        VBox contenedorPrincipal = new VBox(titulo, contenedorHorizontal, botonJugar);
        contenedorPrincipal.setSpacing(80);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setStyle("-fx-background-color: DarkRed;");

        Scene scene = new Scene(contenedorPrincipal, 800, 700);
        stage.setScene(scene);
        stage.show();
    }
}
