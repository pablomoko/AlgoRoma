package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.GestorFlujoDeJuego;

public class TirarDadoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    private Button botonDado;

    private Dado dado;

    private GestorTurnos jugadores;

    private Tablero tablero;

    public TirarDadoEventHandler(Stage stage, Button botonDado, GestorTurnos jugadores, Tablero tablero) {
        this.stage = stage;
        this.botonDado = botonDado;
        this.dado = new Dado();
        this.jugadores = jugadores;
        this.tablero = tablero;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        int unosPasos = this.dado.tirarDado();
        Image dado = new Image(String.format("file:src/main/resources/dado_%x.jpg", unosPasos));
        BackgroundImage imagenFondoBoton = new BackgroundImage(dado, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.botonDado.setBackground(new Background(imagenFondoBoton));
        if(!jugadores.obtenerTurnoActual().movibleLesionado()){
            jugadores.obtenerTurnoActual().moverMovible(this.tablero, unosPasos);
            jugadores.obtenerTurnoActual().notifyObservers();
        }else{
            //mensaje lesionado
        }
        jugadores.obtenerTurnoActual().obtenerMovible().habilitarMovimiento(); //habilita el movimiento para el proximo turno (saca lesion)
    }
}
