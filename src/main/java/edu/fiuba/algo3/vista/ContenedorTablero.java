package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorTablero extends VBox {

    private Stage stage;
    private int alto;

    private int ancho;

    public ContenedorTablero(Stage stage, int ancho, int alto) {
        this.stage = stage;
        this.alto = alto;
        this.ancho = ancho;

        GridPane tablero = new GridPane();

        BorderStroke borde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);

        for (int i=0; i<alto; i++) {
            for (int j = 0; j <ancho; j++) {
                HBox casillero = new HBox();
                casillero.setMinWidth(stage.getWidth() / alto);
                casillero.setMinHeight(stage.getHeight() / (alto/1.4));
                casillero.setPadding(new Insets(10));
                casillero.setBorder(new Border(borde));
                casillero.setStyle("-fx-background-color: DarkRed");
                tablero.add(casillero, i, j);
            }
        }
        tablero.setAlignment(Pos.TOP_CENTER);
        HBox contenedorEstado = new HBox();
        contenedorEstado.setMinWidth(stage.getWidth() - (stage.getWidth() / alto));
        contenedorEstado.setMinHeight(stage.getHeight() - (stage.getHeight() / (alto/1.4)));
        contenedorEstado.setAlignment(Pos.BOTTOM_CENTER);
        contenedorEstado.setStyle("-fx-background-color: GoldenRod");
        this.getChildren().addAll(tablero, contenedorEstado);
        stage.setFullScreen(true);
    }
}
