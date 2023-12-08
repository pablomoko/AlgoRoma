package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

public class ContenedorJugadores extends VBox{

    Stage stage;

    public ContenedorJugadores(Stage stage){
        this.stage = stage;

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre del jugador");

        Button botonAgregar = new Button();
        botonAgregar.setText("Agregar Jugador");
        botonAgregar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");

        this.getChildren().addAll(texto, botonAgregar);

        this.setSpacing(80);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: DarkRed;");
    }
}
