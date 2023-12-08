package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorPrincipal extends GridPane {

    private Stage stage;
    private int alto;

    private int ancho;

    public ContenedorPrincipal(Stage stage, int ancho, int alto) {
        this.stage = stage;
        this.alto = alto;
        this.ancho = ancho;

        //Pane[][] panes = new Pane[alto][ancho];

        BorderStroke borde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);

        for (int i=0; i<alto; i++) {
            for (int j = 0; j <ancho; j++) {
                HBox casillero = new HBox();
                casillero.setMinWidth(107);
                casillero.setMinHeight(80);
                casillero.setPadding(new Insets(10));
                casillero.setBorder(new Border(borde));
                casillero.setStyle("-fx-background-color: DarkRed");
                //panes[i][j] = casillero;
                //this.add(casillero, i, j);
                this.add(casillero, i, j);
            }
        }
        this.setAlignment(Pos.TOP_CENTER);
        stage.setFullScreen(true);
    }
}
