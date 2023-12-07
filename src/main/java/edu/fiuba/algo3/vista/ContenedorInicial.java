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

        Button botonEmpezar = new Button();
        botonEmpezar.setText("Jugar");
        botonEmpezar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");


        this.setSpacing(80);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: DarkRed;");

        BotonEmpezarEventHandler botonEmpezarEventHandler = new BotonEmpezarEventHandler(stage, proximaEscena);
        botonEmpezar.setOnAction(botonEmpezarEventHandler);

        this.getChildren().addAll(titulo, botonEmpezar);

    }
}
