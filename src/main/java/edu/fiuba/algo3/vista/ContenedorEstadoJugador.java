package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorEstadoJugador extends VBox {

    private LabelPlayerStyle valorEnergia;

    private LabelPlayerStyle valorEquipamiento;

    private LabelPlayerStyle valorSeniority;

    public ContenedorEstadoJugador(){

        LabelPlayerStyle energia = new LabelPlayerStyle("Energia: ");

        this.valorEnergia = new LabelPlayerStyle();

        HBox contenedorEnergia = new HBox(energia, this.valorEnergia);
        contenedorEnergia.setSpacing(20);

        LabelPlayerStyle equipamiento = new LabelPlayerStyle("Equipamiento: ");

        this.valorEquipamiento = new LabelPlayerStyle();

        HBox contenedorEquipamiento = new HBox(equipamiento, this.valorEquipamiento);
        contenedorEquipamiento.setSpacing(20);

        LabelPlayerStyle seniority = new LabelPlayerStyle("Seniority: ");

        this.valorSeniority = new LabelPlayerStyle();

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
