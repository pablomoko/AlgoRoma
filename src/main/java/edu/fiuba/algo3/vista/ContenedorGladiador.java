package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorTurnos;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ContenedorGladiador extends HBox {

    public ContenedorGladiador(GestorTurnos gestorTurnos){

        this.setPrefWidth(50);
        this.setPrefHeight(50);
        Image imagenGladiador = new Image(String.format("file:src/main/resources/Gladiador%d.jpg", gestorTurnos.obtenerNumeroJugadorActual()));
        BackgroundImage fondoImagenGladiador = new BackgroundImage(imagenGladiador, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.setBackground(new Background(fondoImagenGladiador));
        this.setAlignment(Pos.CENTER);
    }

    public void eliminarFondo(){

    }
}