package edu.fiuba.algo3.modelo;

public class EsGanador {
    private boolean esGanador;

    public EsGanador(boolean estado){
        this.esGanador = estado;
    }

    public void setEsGanador(){
        this.esGanador = true;
    }

    public boolean estado(){
        return this.esGanador;
    }

}
