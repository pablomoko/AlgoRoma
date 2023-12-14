package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ContenedorJugadorGanador extends VBox {

    private Label mensajeGanador;

    public ContenedorJugadorGanador(Jugador jugador){

        this.mensajeGanador = new Label(String.format("Gana el Jugador: %s", jugador.obtenerNombre()));
        this.mensajeGanador.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");

        Image fondoPantalla = new Image("file:src/main/resources/gladiadorGanador.jpg");
        BackgroundImage imagenFondoPantalla = new BackgroundImage(
                fondoPantalla,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(), this.getHeight(), true, true, true, false));
        this.setBackground(new Background(imagenFondoPantalla));

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(mensajeGanador);
    }

}
