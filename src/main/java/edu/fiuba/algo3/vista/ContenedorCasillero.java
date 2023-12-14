package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorCasillero extends HBox{

    public ContenedorCasillero(Stage stage, int alto){

        BorderStroke borde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
        this.setMinWidth(stage.getWidth() / alto);
        this.setMinHeight(stage.getHeight() / (alto/1.4));
        this.setPadding(new Insets(10));
        this.setBorder(new Border(borde));
    }
}