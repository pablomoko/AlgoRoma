package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorTurnos;
import edu.fiuba.algo3.controlador.TirarDadoBacanalEventHandler;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.casilla.CasillaCamino;
import edu.fiuba.algo3.modelo.obstaculo.*;
import edu.fiuba.algo3.modelo.premio.Premio;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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

    public ContenedorMensaje(int unosPasos, GestorTurnos gestorTurnos) {
        this.unosPasos = unosPasos;
        this.gestorTurnos = gestorTurnos;

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
        this.setMaxWidth(600);
        this.setStyle("-fx-background-color: GoldenRod");
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(this.mensajeObstaculo, this.mensajeEnergiaPerdida, this.mensajeEnergiaGanada,this.mensajePremio);

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(unosPasos);
        System.out.println(o.getClass());
        if (o.getClass() == CasillaCamino.class && unosPasos != 0) {
            Casilla casilla = (Casilla) o;
            Obstaculo obstaculo = casilla.getObstaculo();
            System.out.println(casilla.getObstaculo().getClass().getSimpleName());
            switch (casilla.getObstaculo().getClass().getSimpleName()) {
                case "Bacanal":
                    this.mensajeObstaculo.setText("Fuiste a un Bacanal, estas en pedo. Tira el dado para saber cuantas copas tomaste.");
                    this.getChildren().add(this.botonDado);
                    Bacanal bacanal = (Bacanal) obstaculo;
                    TirarDadoBacanalEventHandler tirarDadoBacanalEventHandler = new TirarDadoBacanalEventHandler(botonDado, bacanal.getResultadoDado(), this);
                    this.botonDado.setOnAction(tirarDadoBacanalEventHandler);
                case "Fiera":
                    this.mensajeObstaculo.setText("Te encontraste a una Fiera. Te cagó a palos.");
                    int energiaPerdida = this.gestorTurnos.obtenerTurnoActual().obtenerMovible().getEquipamiento().usarEquipamiento() + this.unosPasos;
                    this.mensajeEnergiaPerdida.setText(String.format("Perdiste %d puntos de energia.", energiaPerdida));
                case "Lesion":
                    this.mensajeObstaculo.setText("Te rompiste todo pibe, la proxima no jugas.");
                    this.mensajeEnergiaPerdida.setText(String.format("Perdiste %d puntos de energia.", this.unosPasos));
                default:
                    this.mensajeEnergiaPerdida.setText(String.format("Perdiste %d puntos de energia.", this.unosPasos));
            }

            Premio premio = casilla.getPremio();

            switch (casilla.getPremio().getClass().getSimpleName()) {
                case "Comida":
                    this.mensajePremio.setText("Te encontraste un super panchito!!");
                    this.mensajeEnergiaGanada.setText("Ganaste 15 puntos de energia");
                case "Equipamiento":

                    this.mensajePremio.setText(String.format("Encontraste un loot. Subis tu nivel de equipamiento"));

                default:
                    this.mensajeEnergiaPerdida.setText(String.format("Perdiste %d puntos de energia.", this.unosPasos));
            }
        }else {
            this.mensajeEnergiaGanada.setText("No te podias mover. Ganaste 5 de energia");
        }
    }

    public void setMensajeEnergiaPerdida(String mensaje) {
        this.mensajeEnergiaPerdida.setText(mensaje);
    }

    public int getUnosPasos() {
        return this.unosPasos;
    }
}
