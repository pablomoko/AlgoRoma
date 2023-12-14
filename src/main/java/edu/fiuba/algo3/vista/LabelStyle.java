package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LabelStyle extends StackPane{

    public LabelStyle(String texto){

        Label fondo = new Label(texto);
        fondo.setStyle("-fx-font: 50 italics; -fx-text-fill: Transparent; " +
                "-fx-background-color: DarkRed; -fx-opacity: 0.7; -fx-background-radius: 0.5; -fx-font-weight: BOLD");

        Label titulo = new Label(texto);
        titulo.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod; -fx-font-weight: BOLD");

        this.getChildren().addAll(fondo, titulo);

    }
}
