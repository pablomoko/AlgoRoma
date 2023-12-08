package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
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

        Image fondoPantalla = new Image("file:src/main/java/edu/fiuba/algo3/vista/fondoJuego.jpg");
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

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");

        this.setSpacing(80);
        this.setAlignment(Pos.CENTER);

        AgregarJugadorEventHandler agregarJugadorEventHandler = new AgregarJugadorEventHandler(stage, cantidadJugadores, label, texto);
        botonAgregar.setOnAction(agregarJugadorEventHandler);

        ContenedorPrincipal pantallaTablero = new ContenedorPrincipal(stage, 10, 18);

        Scene escenaTablero = new Scene(pantallaTablero, 800, 700);
        JugarEventHandler jugarEventHandler = new JugarEventHandler(stage, escenaTablero, cantidadJugadores, label);
        botonJugar.setOnAction(jugarEventHandler);

        this.getChildren().addAll(titulo, contenedorHorizontal, label, botonJugar);
        stage.setFullScreen(true);

    }
}
