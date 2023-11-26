package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
public class Tablero {

    private ArrayList<Casilla> casillas;
    private Map<Movible, Integer> mapa;

    public Tablero(int tamanio){
        this.mapa = new HashMap<>();
        this.casillas = new ArrayList<Casilla>();
        for (int i=0; i<tamanio; i++) {
            this.casillas.add(new Casilla(i));
        }
    }


    public ArrayList<Casilla> getCasillas(){
        return this.casillas;
    }

    public void inicializarMovible(Movible movible){
        this.mapa.put(movible,0);
        casillas.get(0).colocarMovible(movible);
    }

    public void ubicarMovible(Movible movible, int unosPasos){

        int nuevaPosicion = unosPasos + this.mapa.get(movible);
        Casilla casillaDestino;


        if (!(nuevaPosicion > (this.casillas.size()-1))) {
            int ultimaPosicion = this.casillas.size() - 1;
            if (nuevaPosicion == ultimaPosicion && !movible.estaCompleto()){
                casillaDestino = this.casillas.get(ultimaPosicion / 2);
                this.mapa.put(movible, ultimaPosicion/2);
            } else {
                casillaDestino = this.casillas.get(nuevaPosicion);
                this.mapa.put(movible, nuevaPosicion);
            }

            casillaDestino.colocarMovible(movible);
            movible.mover(unosPasos);

        }

    }


    public Casilla obtenerCasillaDe(Movible movible){
        return this.casillas.get(this.mapa.get(movible));
    }

    public Casilla obtenerCasillaDe(int posicion){
        return this.casillas.get(posicion);
    }




}

