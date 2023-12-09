package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Dado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TirarDadoOrdenadorEventHandler implements EventHandler<ActionEvent> {

    private Dado dado;
    private VBox vBox;

    private int cantidadJugadores;

    private Button botonDado;

    private Button botonJugar;


    public TirarDadoOrdenadorEventHandler(VBox vBox, Button botonJugar, int cantidadJugadores, Button botonDado) {
        this.vBox = vBox;
        this.botonJugar = botonJugar;
        this.cantidadJugadores = cantidadJugadores;
        this.botonDado = botonDado;
        this.dado = new Dado();
    }
    @Override
    public void handle(ActionEvent actionEvent){

        int resultado = this.tirarDado(this.cantidadJugadores);
        Image dado = new Image(String.format("file:src/main/resources/dado_%x.jpg", resultado));
        BackgroundImage imagenFondoBoton = new BackgroundImage(dado, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.botonDado.setBackground(new Background(imagenFondoBoton));
        this.vBox.getChildren().add(botonJugar);
    }

    public int tirarDado(int numeroCaras){
        return dado.tirarDado(numeroCaras);
    }
}
