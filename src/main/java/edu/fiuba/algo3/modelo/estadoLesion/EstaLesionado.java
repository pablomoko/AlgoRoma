package edu.fiuba.algo3.modelo.estadoLesion;

import edu.fiuba.algo3.modelo.estadoLesion.EstadoLesion;

public class EstaLesionado implements EstadoLesion {
    private boolean estaLesionado;

    public EstaLesionado(){
        this.estaLesionado = true;
    }

    public boolean estado(){
        return this.estaLesionado;
    }

}
