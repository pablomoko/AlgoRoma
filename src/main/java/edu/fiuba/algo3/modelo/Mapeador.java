package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.casilla.Casilla;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Mapeador {
    private List<Casilla> casillas;
    private Map<Movible, Casilla> mapa;

    public List<Casilla> getCasillas(){
        return this.casillas;
    }

    public Mapeador(List<Casilla> casillas){
        this.casillas = casillas;
        this.mapa = new HashMap<>();
    }

    public void inicializarMovible(Movible movible){
        this.mapa.put(movible, this.obtenerCasillaDe(0));
        casillas.get(0).colocarMovible(movible, this);
    }

    public Casilla obtenerCasillaDestino(Casilla casillaActual, int unosPasos){

        ListIterator<Casilla> iterator = casillas.listIterator(casillas.indexOf(casillaActual));
        iterator.next();
        int contador = 0;
        Casilla casillaDestino = casillaActual;
        while (iterator.hasNext() && contador < unosPasos) {
            casillaDestino = iterator.next();
            contador++;
        }

        return casillaDestino;
    }

    public boolean tieneSiguiente(Casilla casilla){
        ListIterator<Casilla> iterator = casillas.listIterator(casillas.indexOf(casilla));
        iterator.next();
        return iterator.hasNext();
    }

    public void ubicarMovible(Movible movible, Casilla casilla){
        mapa.put(movible, casilla);
    }

    public Casilla obtenerCasillaIntermedia(){
        return this.casillas.get((this.casillas.size())/2);
    }
    public Casilla obtenerCasillaDe(Movible movible){
        return (this.mapa.get(movible));
    }

    public Casilla obtenerCasillaDe(int posicion){
        return this.casillas.get(posicion);
    }
}
