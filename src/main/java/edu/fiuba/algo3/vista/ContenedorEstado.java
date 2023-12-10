package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class ContenedorEstado extends BorderPane implements Observer {

    private Stage stage;


    public ContenedorEstado(Stage stage, int alto) {
        this.setPrefWidth(stage.getWidth());
        this.setPrefHeight(stage.getHeight() - (stage.getHeight() / (alto/1.4)) * 10);
        this.setStyle("-fx-background-color: GoldenRod");
        //this.setAlignment(Pos.BOTTOM_CENTER)
        Button botonDado = new BotonDado();
        Label titulo = new Label();
        titulo.setText("ASDASDS");
        titulo.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");
        this.getChildren().addAll(botonDado, titulo);
        botonDado.setAlignment(Pos.CENTER_LEFT);
        titulo.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
