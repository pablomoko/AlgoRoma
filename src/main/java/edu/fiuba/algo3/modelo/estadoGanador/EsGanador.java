package edu.fiuba.algo3.modelo.estadoGanador;

import edu.fiuba.algo3.modelo.estadoGanador.EstadoGanador;

public class EsGanador implements EstadoGanador {
    private boolean esGanador;

    public EsGanador(){
        this.esGanador = true;
    }

    public boolean estado(){
        return this.esGanador;
    }

}
