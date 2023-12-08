package edu.fiuba.algo3.vista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ContenedorInicial extends VBox{
    Stage stage;

    public ContenedorInicial(Stage stage, Scene proximaEscena){

        this.stage = stage;
        Image fondoPantalla = new Image("file:src/main/java/edu/fiuba/algo3/vista/fondoJuego.jpg");
        BackgroundImage imagenFondoPantalla = new BackgroundImage(fondoPantalla, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.setBackground(new Background(imagenFondoPantalla));
        Label titulo = new Label();
        titulo.setText("AlgoRoma");
        titulo.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");

        Button botonEmpezar = new Button();
        botonEmpezar.setText("Empezar");
        botonEmpezar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");


        this.setSpacing(80);
        this.setAlignment(Pos.CENTER);

        BotonEmpezarEventHandler botonEmpezarEventHandler = new BotonEmpezarEventHandler(stage, proximaEscena);
        botonEmpezar.setOnAction(botonEmpezarEventHandler);

        this.getChildren().addAll(titulo, botonEmpezar);
        stage.setFullScreen(true);

    }
}
