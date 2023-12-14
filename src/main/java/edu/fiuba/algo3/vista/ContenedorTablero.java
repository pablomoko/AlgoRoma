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
                ContenedorCasillero casillero = new ContenedorCasillero(this.stage, this.alto);
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

            ContenedorCasillero casillero = new ContenedorCasillero(this.stage, this.alto);
            casillero.setStyle("-fx-background-color: DarkGreen");

            String nombrePremio = casilla.getPremio().getClass().getSimpleName();
            String nombreObstaculo =casilla.getObstaculo().getClass().getSimpleName();

            HBox contenedorPremio = new HBox();
            contenedorPremio.setPrefWidth(50);
            contenedorPremio.setPrefHeight(50);

            HBox contenedorObstaculo = new HBox();
            contenedorObstaculo.setPrefWidth(50);
            contenedorObstaculo.setPrefHeight(50);

            if (nombrePremio.equals("Comida")){
                Image imagenPancho = new Image("file:src/main/resources/superpancho.jpg");
                BackgroundImage fondoImagenPancho = new BackgroundImage(imagenPancho, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
                contenedorPremio.setBackground(new Background(fondoImagenPancho));

            }

            if (nombrePremio.equals("Equipamiento")){
                Image imagenLoot = new Image("file:src/main/resources/loot.jpg");
                BackgroundImage fondoImagenLoot = new BackgroundImage(imagenLoot, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
                contenedorPremio.setBackground(new Background(fondoImagenLoot));
            }

            if (nombreObstaculo.equals("Fiera")){
                Image imagenFiera = new Image("file:src/main/resources/fiera.jpg");
                BackgroundImage fondoImagenFiera = new BackgroundImage(imagenFiera, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
                contenedorObstaculo.setBackground(new Background(fondoImagenFiera));
            }

            if (nombreObstaculo.equals("Bacanal")){
                Image imagenVino = new Image("file:src/main/resources/vino.jpg");
                BackgroundImage fondoImagenVino = new BackgroundImage(imagenVino, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
                contenedorObstaculo.setBackground(new Background(fondoImagenVino));
            }

            if (nombreObstaculo.equals("Lesion")){
                Image imagenLesion = new Image("file:src/main/resources/lesion.jpg");
                BackgroundImage fondoImagenLesion = new BackgroundImage(imagenLesion, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
                contenedorObstaculo.setBackground(new Background(fondoImagenLesion));
            }


            contenedorPremio.setAlignment(Pos.CENTER_LEFT);
            contenedorObstaculo.setAlignment(Pos.CENTER_RIGHT);
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

            ContenedorCasillero casillero = new ContenedorCasillero(this.stage, this.alto);
            casillero.setStyle("-fx-background-color: DarkGreen");

            ContenedorGladiador contenedorGladiador = new ContenedorGladiador(this.gestorTurnos);

            casillero.getChildren().add(contenedorGladiador);

            this.mapa.add(casillero, casillaJugador.getPosicion().getX(), casillaJugador.getPosicion().getY());
        }
    }
}
