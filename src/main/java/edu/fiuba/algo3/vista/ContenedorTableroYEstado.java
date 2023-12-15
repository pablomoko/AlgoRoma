package edu.fiuba.algo3.vista;

import javafx.scene.layout.VBox;

import java.util.Observable;
import java.util.Observer;

public class ContenedorTableroYEstado extends VBox implements Observer {

    private ContenedorTablero contenedorTablero;

    private ContenedorEstado contenedorEstado;

    public ContenedorTableroYEstado(ContenedorTablero contenedorTablero, ContenedorEstado contenedorEstado) {
        this.contenedorEstado = contenedorEstado;
        this.contenedorTablero = contenedorTablero;
        this.getChildren().addAll(contenedorTablero, contenedorEstado);
    }

    public ContenedorEstado getContenedorEstado(){
        return this.contenedorEstado;
    }



    @Override
    public void update(Observable o, Object arg) {
        this.contenedorEstado.update(o, arg);
        this.contenedorTablero.update(o, arg);
    }
}
