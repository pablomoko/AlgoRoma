package edu.fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonDado extends Button {

    public BotonDado() {
        this.setPrefSize(100, 100);
        Image dado = new Image("file:src/main/resources/dado_1.jpg");
        BackgroundImage imagenFondoBoton = new BackgroundImage(dado, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        this.setBackground(new Background(imagenFondoBoton));
    }
}
