package edu.fiuba.algo3.modelo.estadoLesion;

import edu.fiuba.algo3.modelo.estadoLesion.EstadoLesion;

public class NoEstaLesionado implements EstadoLesion {
    private boolean noEstaLesionado;

    public NoEstaLesionado(){
        this.noEstaLesionado = false;
    }

    public boolean estado(){
        return this.noEstaLesionado;
    }

}