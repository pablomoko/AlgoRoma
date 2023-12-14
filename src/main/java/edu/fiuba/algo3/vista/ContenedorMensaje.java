package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorTurnos;
import edu.fiuba.algo3.controlador.TirarDadoBacanalEventHandler;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.casilla.CasillaCamino;
import edu.fiuba.algo3.modelo.casilla.CasillaLlegada;
import edu.fiuba.algo3.modelo.obstaculo.*;
import edu.fiuba.algo3.modelo.premio.Premio;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class ContenedorMensaje extends VBox implements Observer {
    private Label mensajeObstaculo;
    private Label mensajePremio;
    private Label mensajeEnergiaPerdida;

    private Label mensajeEnergiaGanada;
    private BotonDado botonDado;

    private int unosPasos;

    private GestorTurnos gestorTurnos;

    private Stage stage;

    public ContenedorMensaje(int unosPasos, GestorTurnos gestorTurnos, Stage stage) {
        this.unosPasos = unosPasos;
        this.gestorTurnos = gestorTurnos;
        this.stage = stage;

        this.mensajeObstaculo = new Label();
        this.mensajeObstaculo.setText("Obstaculo: -");
        this.mensajeObstaculo.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        this.mensajePremio = new Label();
        this.mensajePremio.setText("Premio: -");
        this.mensajePremio.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        this.mensajeEnergiaPerdida = new Label();
        this.mensajeEnergiaPerdida.setText("Energia Perdida: -");
        this.mensajeEnergiaPerdida.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        this.mensajeEnergiaGanada = new Label();
        this.mensajeEnergiaGanada.setText("Energia Ganada: -");
        this.mensajeEnergiaGanada.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        this.botonDado = new BotonDado();

        this.setMaxHeight(400);
        this.setMaxWidth(650);
        this.setStyle("-fx-background-color: GoldenRod");
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(this.mensajeObstaculo, this.mensajeEnergiaPerdida, this.mensajeEnergiaGanada,this.mensajePremio);

    }

    @Override
    public void update(Observable o, Object arg) {

        if (o.getClass() == CasillaCamino.class) {
            if(unosPasos != 0) {
                Casilla casilla = (Casilla) o;
                Obstaculo obstaculo = casilla.getObstaculo();

                String nombreObstaculo = casilla.getObstaculo().getClass().getSimpleName();

                if (nombreObstaculo.equals("Fiera")) {
                    this.mensajeObstaculo.setText("Te encontraste a una Fiera. Te cagó a palos.");

                    int energiaPerdida = this.gestorTurnos.obtenerTurnoActual().obtenerMovible().getEquipamiento().usarEquipamiento() + 1;
                    this.mensajeEnergiaPerdida.setText(String.format("Perdiste %d puntos de energia.", energiaPerdida));
                } else if (nombreObstaculo.equals("Lesion")) {
                    this.mensajeObstaculo.setText("Te rompiste todo pibe, la proxima no jugas.");
                    this.mensajeEnergiaPerdida.setText(String.format("Perdiste 1 puntos de energia."));
                } else if (nombreObstaculo.equals("Bacanal")) {
                    this.mensajeObstaculo.setText("Fuiste a un Bacanal, estas en pedo. Cuantas copas tomaste?.");
                    this.getChildren().add(this.botonDado);
                    Bacanal bacanal = (Bacanal) obstaculo;
                    TirarDadoBacanalEventHandler tirarDadoBacanalEventHandler = new TirarDadoBacanalEventHandler(botonDado, bacanal.getResultadoDado(), this);
                    this.botonDado.setOnAction(tirarDadoBacanalEventHandler);
                } else {
                    this.mensajeEnergiaPerdida.setText(String.format("Perdiste 1 puntos de energia."));

                }


                Premio premio = casilla.getPremio();
                String nombrePremio = casilla.getPremio().getClass().getSimpleName();

                if (nombrePremio.equals("Comida")) {
                    this.mensajePremio.setText("Te encontraste un super panchito!!");
                    this.mensajeEnergiaGanada.setText("Ganaste 15 puntos de energia");
                } else if (nombrePremio.equals("Equipamiento")) {
                    this.mensajePremio.setText(String.format("Encontraste un loot. Subis tu nivel de equipamiento"));
                }
            }else {
                this.mensajeEnergiaGanada.setText("No te podias mover.");
            }

        }else if(o.getClass() == CasillaLlegada.class){
            ContenedorJugadorGanador contenedorJugadorGanador = new ContenedorJugadorGanador(this.gestorTurnos.obtenerTurnoActual());
            Scene escenaGanador = new Scene(contenedorJugadorGanador, 800, 700);
            stage.setScene(escenaGanador);
            stage.setFullScreen(true);
        }
    }

    public void setMensajeEnergiaPerdida(String mensaje) {
        this.mensajeEnergiaPerdida.setText(mensaje);
    }

    public int getUnosPasos() {
        return this.unosPasos;
    }
}
