package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.controlador.EmpezarEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ContenedorInicial extends VBox{

        public ContenedorInicial(Stage stage, Scene proximaEscena){

                Image fondoPantalla = new Image("file:src/main/resources/fondoJuego.jpg");
                BackgroundImage imagenFondoPantalla = new BackgroundImage(fondoPantalla, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
                this.setBackground(new Background(imagenFondoPantalla));

                LabelStyle titulo = new LabelStyle("AlgoRoma");

                Button botonEmpezar = new Button();
                botonEmpezar.setText("Empezar");
                botonEmpezar.setStyle("-fx-font: 36 arial; -fx-background-color: DarkRed; -fx-text-fill: GoldenRod");


                this.setSpacing(80);
                this.setAlignment(Pos.CENTER);

                EmpezarEventHandler botonEmpezarEventHandler = new EmpezarEventHandler(stage, proximaEscena);
                botonEmpezar.setOnAction(botonEmpezarEventHandler);

                this.getChildren().addAll(titulo, botonEmpezar);
                stage.setFullScreen(true);

        }
}
