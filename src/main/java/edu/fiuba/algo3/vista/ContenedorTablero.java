package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ContenedorTablero extends VBox implements Observer {

    private Stage stage;
    private int alto;

    private int ancho;

    private List<Casilla> casillas;

    public ContenedorTablero(Stage stage, int ancho, int alto, List<Casilla> casillas) {
        this.stage = stage;
        this.alto = alto;
        this.ancho = ancho;
        this.casillas = casillas;

        GridPane tablero = new GridPane();

        BorderStroke borde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);

        for (int i=1; i<=alto; i++) {
            for (int j=1; j <= ancho; j++) {
                HBox casillero = new HBox();
                casillero.setMinWidth(stage.getWidth() / alto);
                casillero.setMinHeight(stage.getHeight() / (alto/1.4));
                casillero.setPadding(new Insets(10));
                casillero.setBorder(new Border(borde));
                casillero.setStyle("-fx-background-color: DarkRed");
                tablero.add(casillero, i, j);
            }
        }

        for (Casilla casilla: casillas) {

            HBox casillero = new HBox();
            casillero.setMinWidth(stage.getWidth() / alto);
            casillero.setMinHeight(stage.getHeight() / (alto/1.4));
            casillero.setPadding(new Insets(10));
            casillero.setBorder(new Border(borde));
            casillero.setStyle("-fx-background-color: DarkGreen");

            tablero.add(casillero, casilla.getPosicion().getX(), casilla.getPosicion().getY());

        }

        tablero.setAlignment(Pos.TOP_CENTER);
       /* Image fondoPantalla = new Image("file:src/main/resources/campoDeBatalla.jpg");
        BackgroundImage imagenFondoPantalla = new BackgroundImage(
                fondoPantalla,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tablero.getWidth(), tablero.getHeight(), true, true, true, false));
        tablero.setBackground(new Background(imagenFondoPantalla));*/

        HBox contenedorEstado = new HBox();
        contenedorEstado.setMinWidth(stage.getWidth() - (stage.getWidth() / alto));
        contenedorEstado.setMinHeight(stage.getHeight() - (stage.getHeight() / (alto/1.4)));
        contenedorEstado.setAlignment(Pos.BOTTOM_CENTER);
        contenedorEstado.setStyle("-fx-background-color: GoldenRod");
        this.getChildren().addAll(tablero, contenedorEstado);
        stage.setFullScreen(true);
    }

    @Override
    public void update(Observable o, Object arg) {


    }
}
