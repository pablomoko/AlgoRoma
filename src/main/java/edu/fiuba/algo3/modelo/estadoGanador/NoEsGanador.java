package edu.fiuba.algo3.modelo.estadoGanador;

public class NoEsGanador implements EstadoGanador{
    private boolean noEsGanador;

    public NoEsGanador(){
        this.noEsGanador = false;
    }

    public boolean estado(){
        return this.noEsGanador;
    }
}
