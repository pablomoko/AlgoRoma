package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;

    public Tablero(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public void colocarMovibleEnCasilla(Movible movible, int numeroCasilla) {
        if (numeroCasilla >= 0 && numeroCasilla < casillas.size()) {
            casillas.get(numeroCasilla).colocarMovible(movible);
        } else {
            throw new IllegalArgumentException("Número de casilla fuera de rango");
        }
    }

    public void moverGladiador(Gladiador gladiador, int unosPasos) {
        Casilla casillaActual = null;
        for (Casilla casilla : casillas) {
            if (casilla.obtenerMovible().equals(gladiador)) {
                casillaActual = casilla;
                break;
            }
        }
        if (casillaActual != null) {
            int nuevaPosicion = (casillas.indexOf(casillaActual) + unosPasos) % casillas.size();
            Casilla casillaDestino = casillas.get(nuevaPosicion);
            casillaActual.moverMovible(casillaDestino);
        } else {
            throw new IllegalStateException("El gladiador no está en el tablero");
        }
    }




}
