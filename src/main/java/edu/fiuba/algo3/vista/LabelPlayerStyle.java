package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;

public class LabelPlayerStyle extends Label {

    public LabelPlayerStyle(String texto){


        this.setText(texto);
        this.setStyle("-fx-font: 24 italics; -fx-text-fill: #BAB86C; -fx-alignment: center");
    }

    public LabelPlayerStyle(){

        this.setStyle("-fx-font: 24 italics; -fx-text-fill: #BAB86C; -fx-alignment: center");
    }
}
