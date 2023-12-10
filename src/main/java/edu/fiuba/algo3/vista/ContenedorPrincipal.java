package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class ContenedorPrincipal extends VBox implements Observer {

    private Stage stage;

    private ContenedorTablero contenedorTablero;

    private ContenedorEstado contenedorEstado;

    public ContenedorPrincipal(Stage stage, int ancho, int alto, Tablero tablero) {
        stage.setFullScreen(true);
        this.contenedorTablero = new ContenedorTablero(stage, ancho, alto, tablero);
        this.contenedorEstado = new ContenedorEstado(stage, alto);
        this.getChildren().addAll(contenedorTablero, contenedorEstado);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o.getClass() == Jugador.class) {
            this.contenedorTablero.update(o, arg);
            this.contenedorEstado.update(o, arg);
        }
    }
}
