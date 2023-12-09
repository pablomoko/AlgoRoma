package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Dado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.GestorFlujoDeJuego;

public class TirarDadoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    private Button botonDado;

    private Dado dado;

    public TirarDadoEventHandler(Stage stage, Button botonDado) {
        this.stage = stage;
        this.botonDado = botonDado;
        this.dado = new Dado();
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        int resultado = this.dado.tirarDado();

    }
    public int tirarDado(){ //ESTE BOTON APARECE SIEMPRE EN TODAS LAS PANTALLAS DURANTE EL JUEGO, LUEGO SE LE PASA LO QUE DEVUELVE A jugarTurno O PRENDAS
        return dado.tirarDado();
    }
}
