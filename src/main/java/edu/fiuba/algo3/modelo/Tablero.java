package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Tablero {
    private ArrayList<Casilla> casillas;

    public Tablero(int cantidadDeCasillas) {
        this.casillas = new ArrayList<Casilla>();
        for (int i=0; i<cantidadDeCasillas; i++) {
            this.casillas.add(new Casilla(i));
        }
    }

    public void colocarMovibleEnCasilla(Movible movible, int numeroCasilla) {
        if (numeroCasilla >= 0 && numeroCasilla < casillas.size()) {
            casillas.get(numeroCasilla).colocarMovible(movible);
        } else {
            throw new IllegalArgumentException("Número de casilla fuera de rango");
        }
    }

    public Casilla obtenerCasilla(Gladiador gladiador) {
        for (Casilla casilla : casillas) {
            if (casilla.tieneMovible(gladiador)) {
                return casilla;
            }
        }
        return null;
    }

    public void moverGladiador(Gladiador gladiador, int unosPasos) {
        Casilla casillaActual = obtenerCasilla(gladiador);

        if (casillaActual != null) {
            int nuevaPosicion = (casillas.indexOf(casillaActual) + unosPasos);
            if (!(nuevaPosicion > (casillas.size()-1))) {
                Casilla casillaDestino;
                int ultimaPosicion = this.casillas.size() - 1;
                if (nuevaPosicion == ultimaPosicion && !gladiador.estaCompleto()) {
                    casillaDestino = casillas.get(ultimaPosicion / 2);
                } else {
                    casillaDestino = casillas.get(nuevaPosicion);
                }
                casillaActual.moverMovible(casillaDestino, gladiador);
                gladiador.mover(unosPasos);
            }
        } else {
            throw new IllegalStateException("El gladiador no está en el tablero");
        }
    }




}
