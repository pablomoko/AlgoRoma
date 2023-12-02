package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import java.util.List;

public class Tablero {

    private Mapeador mapeador;
    public Tablero(List<Casilla> casillas){
        this.mapeador = new Mapeador(casillas);
    }

    public List<Casilla> getCasillas(){
        return this.mapeador.getCasillas();
    }

    public void inicializarMovible(Movible movible){
        this.mapeador.inicializarMovible(movible);
    }

    public void moverMovible(Movible movible, int unosPasos){

        Casilla casillaActual = this.obtenerCasillaDe(movible);

        unosPasos = movible.mover(unosPasos);

        Casilla casillaDestino = this.mapeador.obtenerCasillaDestino(casillaActual, unosPasos);

        if(!mapeador.tieneSiguiente(casillaDestino) && !movible.estaCompleto()){
            casillaDestino = mapeador.obtenerCasillaIntermedia();
        }

        casillaActual.moverMovible(casillaDestino, movible);

        this.mapeador.ubicarMovible(movible, casillaDestino);
        casillaDestino.afectarMovible(movible);
    }

    public Casilla obtenerCasillaDe(Movible movible){
        return (this.mapeador.obtenerCasillaDe(movible));
    }

    public Casilla obtenerCasillaDe(int posicion){
        return this.mapeador.obtenerCasillaDe(posicion);
    }




}

