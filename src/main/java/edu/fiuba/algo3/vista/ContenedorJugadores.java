package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

public class ContenedorJugadores extends VBox{

    Stage stage;

    Label label;

    public ContenedorJugadores(Stage stage, int cantidadJugadores, Label label){
        this.stage = stage;
        this.label = label;

        Label titulo = new Label();
        titulo.setText("Inicializar Jugadores");
        titulo.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre del jugador");
        texto.setPrefSize(200, 50);
        texto.setStyle("-fx-font: 24 arial; -fx-background-color: RED");

        Button botonAgregar = new Button();
        botonAgregar.setText("Agregar");
        botonAgregar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");

        HBox contenedorHorizontal = new HBox(texto, botonAgregar);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.setSpacing(10);

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");

        this.setSpacing(80);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: DarkRed;");

        AgregarJugadorEventHandler agregarJugadorEventHandler = new AgregarJugadorEventHandler(stage, cantidadJugadores, label);
        botonAgregar.setOnAction(agregarJugadorEventHandler);

        this.getChildren().addAll(titulo, contenedorHorizontal, label, botonJugar);

    }
}
