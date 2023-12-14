package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.AgregarJugadorEventHandler;
import edu.fiuba.algo3.controlador.ContinuarEventHandler;
import edu.fiuba.algo3.controlador.TextoEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class ContenedorJugadores extends VBox {

    public ContenedorJugadores(Stage stage, Label label){

        LabelStyle titulo = new LabelStyle("Inicializar Jugadores");

        Image fondoPantalla = new Image("file:src/main/resources/fondoJuego.jpg");
        BackgroundImage imagenFondoPantalla = new BackgroundImage(fondoPantalla, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.setBackground(new Background(imagenFondoPantalla));

        TextField texto = new TextField();
        texto.setPromptText("Ingrese nombre");
        texto.setPrefSize(250, 50);
        texto.setStyle("-fx-font: 24 arial; -fx-background-color: GoldenRod; -fx-text-fill: DarkRed");

        Button botonAgregar = new Button();
        botonAgregar.setText("Agregar");
        botonAgregar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");

        TextoEventHandler textoEventHandler = new TextoEventHandler(botonAgregar);
        texto.setOnKeyPressed(textoEventHandler);

        HBox contenedorHorizontal = new HBox(texto, botonAgregar);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.setSpacing(10);

        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");

        this.setSpacing(80);
        this.setAlignment(Pos.CENTER);

        AgregarJugadorEventHandler agregarJugadorEventHandler = new AgregarJugadorEventHandler(label, texto);
        botonAgregar.setOnAction(agregarJugadorEventHandler);

        ContinuarEventHandler continuarEventHandler = new ContinuarEventHandler(stage, agregarJugadorEventHandler.getGestorTurnos(), label);
        botonContinuar.setOnAction(continuarEventHandler);

        this.getChildren().addAll(titulo, contenedorHorizontal, label, botonContinuar);
        stage.setFullScreen(true);

    }
}
