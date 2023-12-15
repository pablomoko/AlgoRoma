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

    private ContenedorCasillero casilleroGladiador;

    private GestorTurnos gestorTurnos;

    public ContenedorTablero(Stage stage, int ancho, int alto, Tablero tablero, GestorTurnos gestorTurnos) {
        this.stage = stage;
        this.alto = alto;
        this.ancho = ancho;
        this.tablero = tablero;
        this.mapa = new GridPane();
        this.gestorTurnos = gestorTurnos;


        for (int i=1; i<=this.alto; i++) {
            for (int j=1; j <= this.ancho; j++) {
                ContenedorCasillero casillero = new ContenedorCasillero(this.stage, this.alto);
                casillero.setStyle("-fx-background-color: #318607");
                this.mapa.add(casillero, i, j);
            }
        }

        this.dibujarCasillasVacias();

        this.mapa.setAlignment(Pos.TOP_CENTER);

        this.getChildren().add(mapa);
    }



    public void dibujarCasillasVacias() {
        BorderStroke borde = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
        for (Casilla casilla: this.tablero.getCasillas()) {

            ContenedorCasillero casillero = new ContenedorCasillero(this.stage, this.alto);
            casillero.setStyle("-fx-background-color: #67350b");

            this.mapa.add(casillero, casilla.getPosicion().getX(), casilla.getPosicion().getY());
        }
    }


    public void dibujasPremiosYObstaculos(){

        for (Casilla casilla: this.tablero.getCasillas()) {
            ContenedorCasillero casillero = new ContenedorCasillero(this.stage, this.alto);
            String nombrePremio = casilla.getPremio().getClass().getSimpleName();
            String nombreObstaculo =casilla.getObstaculo().getClass().getSimpleName();

            HBox contenedorPremio = new HBox();
            contenedorPremio.setPrefWidth(100);
            contenedorPremio.setPrefHeight(65);

            HBox contenedorObstaculo = new HBox();
            contenedorObstaculo.setPrefWidth(100);
            contenedorObstaculo.setPrefHeight(65);

            if (nombrePremio.equals("Comida")){
                Label label = new Label("Pancho");
                label.setStyle("-fx-text-fill: LightBlue; -fx-font-weight: BOLD");
                contenedorPremio.getChildren().add(label);

            }

            if (nombrePremio.equals("Equipamiento")){
                Label label = new Label("Loot");
                label.setStyle("-fx-text-fill: LightBlue; -fx-font-weight: BOLD");
                contenedorPremio.getChildren().add(label);
            }

            if (nombreObstaculo.equals("Fiera")){
                Label label = new Label("Fiera");
                label.setStyle("-fx-text-fill: Red; -fx-font-weight: BOLD");
                contenedorObstaculo.getChildren().add(label);
            }

            if (nombreObstaculo.equals("Bacanal")){
                Label label = new Label("Vino");
                label.setStyle("-fx-text-fill: Red; -fx-font-weight: BOLD");
                contenedorObstaculo.getChildren().add(label);
            }

            if (nombreObstaculo.equals("Lesion")){
                Label label = new Label("Lesion");
                label.setStyle("-fx-text-fill: Red; -fx-font-weight: BOLD");
                contenedorObstaculo.getChildren().add(label);
        }

        contenedorPremio.setAlignment(Pos.TOP_CENTER);
        contenedorObstaculo.setAlignment(Pos.BOTTOM_CENTER);
        casillero.getChildren().addAll(contenedorPremio, contenedorObstaculo);

        this.mapa.add(casillero, casilla.getPosicion().getX(), casilla.getPosicion().getY());
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o.getClass() == Jugador.class) {
            Jugador jugador = (Jugador) o;
            Casilla casillaJugador = tablero.obtenerCasillaDe(jugador.obtenerMovible());

            this.dibujarCasillasVacias();
            this.dibujasPremiosYObstaculos();

            ContenedorCasillero casillero = new ContenedorCasillero(this.stage, this.alto);
            this.casilleroGladiador = casillero;
            casilleroGladiador.setStyle("-fx-background-color: #67350b");

            ContenedorGladiador contenedorGladiador = new ContenedorGladiador(this.gestorTurnos);

            casilleroGladiador.getChildren().add(contenedorGladiador);

            this.mapa.add(casillero, casillaJugador.getPosicion().getX(), casillaJugador.getPosicion().getY());
        }
    }
}
