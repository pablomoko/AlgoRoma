package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.JugarEventHandler;
import edu.fiuba.algo3.controlador.TirarDadoOrdenadorEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorDefinirTurno extends VBox {

    public ContenedorDefinirTurno(Stage stage, ArrayList<Jugador> jugadores) {

        Image fondoPantalla = new Image("file:src/main/resources/fondoJuego.jpg");
        BackgroundImage imagenFondoPantalla = new BackgroundImage(fondoPantalla, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.setBackground(new Background(imagenFondoPantalla));
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        Button botonDado = new Button();
        botonDado.setPrefSize(100, 100);
        Image dado = new Image("file:src/main/resources/dado_1.jpg");
        BackgroundImage imagenFondoBoton = new BackgroundImage(dado, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        botonDado.setBackground(new Background(imagenFondoBoton));

        Label textoInformativo = new Label();
        textoInformativo.setText("El resultado del dado define que jugador empieza");
        textoInformativo.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");

        Label textoTirarDado = new Label();
        textoTirarDado.setText("Haz click en el dado");
        textoTirarDado.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");

        JugarEventHandler jugarEventHandler = new JugarEventHandler(stage, jugadores);

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");
        botonJugar.setOnAction(jugarEventHandler);

        TirarDadoOrdenadorEventHandler botonTirarDadoOrdenadorEventHandler = new TirarDadoOrdenadorEventHandler(this, botonJugar, jugadores.size(), botonDado);
        botonDado.setOnAction(botonTirarDadoOrdenadorEventHandler);
        this.getChildren().addAll(textoInformativo, textoTirarDado, botonDado);
    }
}
