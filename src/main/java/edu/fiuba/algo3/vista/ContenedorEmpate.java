package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ContenedorEmpate extends VBox{

    private Label mansajeEmpate;

    public ContenedorEmpate(){

        this.mansajeEmpate = new Label("Empate, Murieron Todos");
        this.mansajeEmpate.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");

        Image fondoPantalla = new Image("file:src/main/resources/Empate.jpg");
        BackgroundImage imagenFondoPantalla = new BackgroundImage(
                fondoPantalla,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(), this.getHeight(), true, true, true, false));
        this.setBackground(new Background(imagenFondoPantalla));

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(mansajeEmpate);
    }
}
