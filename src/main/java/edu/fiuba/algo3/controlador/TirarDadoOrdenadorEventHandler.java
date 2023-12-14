package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.BotonDado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TirarDadoOrdenadorEventHandler implements EventHandler<ActionEvent> {

    private Dado dado;
    private VBox vBox;

    private int cantidadJugadores;

    private BotonDado botonDado;

    private Button botonJugar;

    private GestorTurnos gestorTurnos;


    public TirarDadoOrdenadorEventHandler(VBox vBox, Button botonJugar, int cantidadJugadores, BotonDado botonDado, GestorTurnos gestorTurnos) {
        this.vBox = vBox;
        this.botonJugar = botonJugar;
        this.cantidadJugadores = cantidadJugadores;
        this.botonDado = botonDado;
        this.gestorTurnos = gestorTurnos;
        this.dado = new Dado();
    }
    @Override
    public void handle(ActionEvent actionEvent){

        int resultado = this.tirarDado(this.cantidadJugadores);
        this.gestorTurnos.jugadorInicial(resultado-1);
        Image dado = new Image(String.format("file:src/main/resources/dado_%x.jpg", resultado));
        BackgroundImage imagenFondoBoton = new BackgroundImage(dado, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.botonDado.setBackground(new Background(imagenFondoBoton));
        this.botonDado.setDisable(true);

        Label textoJugadorInicial = new Label();
        textoJugadorInicial.setText(String.format("Inicia el jugador %d", resultado));
        textoJugadorInicial.setStyle("-fx-font: 48 italics; -fx-text-fill: GoldenRod");
        this.vBox.getChildren().add(textoJugadorInicial);
        this.vBox.getChildren().add(botonJugar);
    }

    public int tirarDado(int numeroCaras){
        return dado.tirarDado(numeroCaras);
    }
}
