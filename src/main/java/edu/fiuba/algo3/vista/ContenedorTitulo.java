package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ContenedorTitulo extends HBox {

    private Label nombreJugador;

    private Label numeroRonda;

    public ContenedorTitulo() {
        this.nombreJugador = new Label();
        this.nombreJugador.setText("Jugador");
        this.nombreJugador.setStyle("-fx-font: 24 italics; -fx-text-fill: #FFB347; -fx-alignment: center");
        this.numeroRonda = new Label();
        this.numeroRonda.setText("(Ronda)");
        this.numeroRonda.setStyle("-fx-font: 24 italics; -fx-text-fill: #FFB347; -fx-alignment: center");
        this.setSpacing(5);
        this.getChildren().addAll(this.nombreJugador, this.numeroRonda);
    }

    public void setNombreJugador(String nombre) {
        this.nombreJugador.setText(String.format("Jugador %s", nombre));
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda.setText(String.format("(Ronda %d)", numeroRonda));
    }
}
