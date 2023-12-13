package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorEstadoJugador extends VBox {

    private Label valorEnergia;

    private Label valorEquipamiento;

    private Label valorSeniority;

    public ContenedorEstadoJugador(){

        Label energia = new Label();
        energia.setText("Energia: ");
        energia.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        this.valorEnergia = new Label();
        this.valorEnergia.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        HBox contenedorEnergia = new HBox(energia, this.valorEnergia);
        contenedorEnergia.setSpacing(20);

        Label equipamiento = new Label();
        equipamiento.setText("Equipamiento: ");
        equipamiento.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        this.valorEquipamiento = new Label();
        this.valorEquipamiento.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        HBox contenedorEquipamiento = new HBox(equipamiento, this.valorEquipamiento);
        contenedorEquipamiento.setSpacing(20);

        Label seniority = new Label();
        seniority.setText("Seniority: ");
        seniority.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        this.valorSeniority = new Label();
        this.valorSeniority.setStyle("-fx-font: 24 italics; -fx-text-fill: DarkRed; -fx-alignment: center");

        HBox contenedorSeniority = new HBox(seniority, this.valorSeniority);
        contenedorSeniority.setSpacing(20);

        this.getChildren().addAll(contenedorEnergia, contenedorEquipamiento, contenedorSeniority);
    }

    public void setValorEnergia(int valorEnergia) {
        this.valorEnergia.setText(String.format("%d", valorEnergia));
    }

    public void setValorEquipamiento(String nombreEquipamiento) {
        this.valorEquipamiento.setText(nombreEquipamiento);
    }

    public void setValorSeniority(String seniority) {
        this.valorSeniority.setText(seniority);
    }
}
