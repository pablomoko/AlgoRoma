package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEventHandler implements EventHandler<KeyEvent> {

    private Button botonAgregar;

    public TextoEventHandler(Button botonAgregar) {
        this.botonAgregar = botonAgregar;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(botonAgregar, new ActionEvent());
        }

    }
}