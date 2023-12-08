package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorFlujoDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class AgregarJugadorEventHandler implements EventHandler<ActionEvent> {

    private int cantidadJugadores;

    private Stage stage;

    private Label label;

    private TextField nombreJugador;

    private GestorFlujoDeJuego gestorFlujoDeJuego;


    public AgregarJugadorEventHandler(Stage stage, int cantidadJugadores, Label label, TextField nombreJugador, GestorFlujoDeJuego gestorFlujoDeJuego) {
        this.stage = stage;
        this.cantidadJugadores = cantidadJugadores;
        this.label = label;
        this.nombreJugador = nombreJugador;
        this.gestorFlujoDeJuego = gestorFlujoDeJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.nombreJugador.getText().length() < 4) {
            label.setText("El nombre debe contener como minimo 4 caracteres");
            label.setTextFill(Color.DARKBLUE);
        }else {
            if (cantidadJugadores < 6) {
                ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, this.cantidadJugadores + 1, this.label, this.gestorFlujoDeJuego);
                label.setText("Se ha agregado correctamente el jugador ingresado");
                label.setTextFill(Color.DARKGREEN);
                Scene proximaEscena = new Scene(contenedorJugadores, 800, 700);
                stage.setScene(proximaEscena);
                stage.setFullScreen(true);
            } else {
                label.setText("Se ha llegado al limite de jugadores");
                label.setTextFill(Color.DARKBLUE);
            }
        }
    }
}
