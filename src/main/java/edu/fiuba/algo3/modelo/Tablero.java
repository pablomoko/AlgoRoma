package edu.fiuba.algo3.modelo;
import java.util.Map;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import java.util.List;
import java.util.ListIterator;
public class Tablero {

    private List<Casilla> casillas;
    private Map<Movible, Casilla> mapa;

    public Tablero(List<Casilla> casillas){
        this.casillas = casillas;
        this.mapa = new HashMap<>();
    }

    public List<Casilla> getCasillas(){
        return this.casillas;
    }

    public void inicializarMovible(Movible movible){
        this.mapa.put(movible, this.obtenerCasillaDe(0));
        casillas.get(0).colocarMovible(movible);
    }

    public void moverMovible(Movible movible, int unosPasos){

        Casilla casillaActual = this.obtenerCasillaDe(movible);
        ListIterator<Casilla> iterator = casillas.listIterator(casillas.indexOf(casillaActual));
        iterator.next();
        int contador = 0;
        Casilla casillaDestino = casillaActual;
        while (iterator.hasNext() && contador < unosPasos) {
            casillaDestino = iterator.next();
            contador++;
        }

        if(!iterator.hasNext() && !movible.estaCompleto()){
            casillaDestino = casillas.listIterator((this.casillas.size())/2).next();
        }

        casillaActual.moverMovible(casillaDestino, movible);
        movible.mover(unosPasos);
        mapa.put(movible, casillaDestino);
        casillaActual.afectarMovible(movible);
    }

    public Casilla obtenerCasillaDe(Movible movible){
        return (this.mapa.get(movible));
    }

    public Casilla obtenerCasillaDe(int posicion){
        return this.casillas.get(posicion);
    }




}

