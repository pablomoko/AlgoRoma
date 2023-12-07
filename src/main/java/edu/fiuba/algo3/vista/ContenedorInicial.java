package edu.fiuba.algo3.vista;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ContenedorInicial extends VBox{
    Stage stage;

    public ContenedorInicial(Stage stage, Scene proximaEscena){

        this.stage = stage;

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

        this.getChildren().addAll(titulo, contenedorHorizontal, botonJugar);

        this.setSpacing(80);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: DarkRed;");

        BotonEmpezarEventHandler botonEmpezarEventHandler = new BotonEmpezarEventHandler(stage, proximaEscena);

    }
}
