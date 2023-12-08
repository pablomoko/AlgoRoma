package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorFlujoDeJuego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class ContenedorJugadores extends VBox {

    public ContenedorJugadores(Stage stage, int cantidadJugadores, Label label, GestorFlujoDeJuego gestorFlujoDeJuego){

        Label titulo = new Label();
        titulo.setText("Inicializar Jugadores");
        titulo.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");

        Image fondoPantalla = new Image("file:src/main/resources/fondoJuego.jpg");
        BackgroundImage imagenFondoPantalla = new BackgroundImage(fondoPantalla, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.setBackground(new Background(imagenFondoPantalla));

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

        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");

        this.setSpacing(80);
        this.setAlignment(Pos.CENTER);

        AgregarJugadorEventHandler agregarJugadorEventHandler = new AgregarJugadorEventHandler(stage, cantidadJugadores, label, texto, gestorFlujoDeJuego);
        botonAgregar.setOnAction(agregarJugadorEventHandler);

        ContenedorDefinirTurno contenedorDefinirTurno = new ContenedorDefinirTurno(stage, cantidadJugadores, gestorFlujoDeJuego);

        Scene escenaDefinirTurno = new Scene(contenedorDefinirTurno, 800, 700);
        ContinuarEventHandler continuarEventHandler = new ContinuarEventHandler(stage, escenaDefinirTurno, cantidadJugadores, label);
        botonContinuar.setOnAction(continuarEventHandler);

        this.getChildren().addAll(titulo, contenedorHorizontal, label, botonContinuar);
        stage.setFullScreen(true);

    }
}
