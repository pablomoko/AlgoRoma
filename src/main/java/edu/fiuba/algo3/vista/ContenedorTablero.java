package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorTurnos;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ContenedorTablero extends HBox implements Observer {

    private Stage stage;
    private int alto;

    private int ancho;

    private Tablero tablero;

    private GridPane mapa;

    private GestorTurnos gestorTurnos;

    public ContenedorTablero(Stage stage, int ancho, int alto, Tablero tablero, GestorTurnos gestorTurnos) {
        this.stage = stage;
        this.alto = alto;
        this.ancho = ancho;
        this.tablero = tablero;
        this.mapa = new GridPane();
        this.gestorTurnos = gestorTurnos;

        BorderStroke borde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);

        for (int i=1; i<=this.alto; i++) {
            for (int j=1; j <= this.ancho; j++) {
                HBox casillero = new HBox();
                casillero.setPrefWidth((stage.getWidth()) / alto);
                casillero.setPrefHeight((stage.getHeight()) / (alto/2.4));
                casillero.setBorder(new Border(borde));
                casillero.setStyle("-fx-background-color: DarkRed");
                this.mapa.add(casillero, i, j);
            }
        }

        this.dibujarCasillasVacias();

        this.mapa.setAlignment(Pos.TOP_CENTER);
       /* Image fondoPantalla = new Image("file:src/main/resources/campoDeBatalla.jpg");
        BackgroundImage imagenFondoPantalla = new BackgroundImage(
                fondoPantalla,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tablero.getWidth(), tablero.getHeight(), true, true, true, false));
        tablero.setBackground(new Background(imagenFondoPantalla));*/

        this.getChildren().add(mapa);
    }

    public void dibujarCasillasVacias() {
        BorderStroke borde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
        for (Casilla casilla: this.tablero.getCasillas()) {

            HBox casillero = new HBox();
            casillero.setMinWidth(this.stage.getWidth() / this.alto);
            casillero.setMinHeight(this.stage.getHeight() / (this.alto/1.4));
            casillero.setPadding(new Insets(10));
            casillero.setBorder(new Border(borde));
            casillero.setStyle("-fx-background-color: DarkGreen");

            String nombrePremio = casilla.getPremio().getClass().getSimpleName();
            if (nombrePremio.equals("Comida")){
                HBox contenedorPancho = new HBox();
                contenedorPancho.setPrefWidth(50);
                contenedorPancho.setPrefHeight(50);
                Image imagenPancho = new Image("file:src/main/resources/superpancho.jpg");
                BackgroundImage fondoImagenPancho = new BackgroundImage(imagenPancho, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
                contenedorPancho.setBackground(new Background(fondoImagenPancho));
                contenedorPancho.setAlignment(Pos.CENTER);
                casillero.getChildren().add(contenedorPancho);
            }


            this.mapa.add(casillero, casilla.getPosicion().getX(), casilla.getPosicion().getY());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        //Jugador jugador = (Jugador) o;
        if (o.getClass() == Jugador.class) {
            Jugador jugador = (Jugador) o;
            Casilla casillaJugador = tablero.obtenerCasillaDe(jugador.obtenerMovible());

            this.dibujarCasillasVacias();

            BorderStroke borde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
            HBox casillero = new HBox();
            casillero.setMinWidth(stage.getWidth() / alto);
            casillero.setMinHeight(stage.getHeight() / (alto/1.4));
            casillero.setPadding(new Insets(10));
            casillero.setBorder(new Border(borde));
            casillero.setStyle("-fx-background-color: DarkGreen");

            HBox contenedorGladiador = new HBox();
            contenedorGladiador.setPrefWidth(50);
            contenedorGladiador.setPrefHeight(50);
            Image imagenGladiador = new Image(String.format("file:src/main/resources/Gladiador%d.jpg", this.gestorTurnos.obtenerNumeroJugadorActual()));
            BackgroundImage fondoImagenGladiador = new BackgroundImage(imagenGladiador, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
            contenedorGladiador.setBackground(new Background(fondoImagenGladiador));
            contenedorGladiador.setAlignment(Pos.CENTER);
            casillero.getChildren().add(contenedorGladiador);

            this.mapa.add(casillero, casillaJugador.getPosicion().getX(), casillaJugador.getPosicion().getY());
        }
    }
}
