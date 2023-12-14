package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.vista.BotonDado;
import edu.fiuba.algo3.vista.ContenedorEstado;
import edu.fiuba.algo3.vista.ContenedorMensaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TirarDadoBacanalEventHandler implements EventHandler<ActionEvent> {

    private Button botonDado;

    private int resultadoDado;

    private ContenedorMensaje contenedorMensaje;

    public TirarDadoBacanalEventHandler(BotonDado botonDado, int resultadoDado, ContenedorMensaje contenedorMensaje) {
        this.botonDado = botonDado;
        this.resultadoDado = resultadoDado;
        this.contenedorMensaje = contenedorMensaje;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Image dado = new Image(String.format("file:src/main/resources/dado_%x.jpg", this.resultadoDado));
        BackgroundImage imagenFondoBoton = new BackgroundImage(dado, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.botonDado.setBackground(new Background(imagenFondoBoton));
        this.contenedorMensaje.setMensajeEnergiaPerdida(String.format("Perdiste %d puntos de energia.", resultadoDado * 4 + this.contenedorMensaje.getUnosPasos()));
    }
}
