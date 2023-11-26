package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.obstaculo.Lesion;
import edu.fiuba.algo3.modelo.obstaculo.Fiera;
import edu.fiuba.algo3.modelo.obstaculo.Bacanal;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.premio.Comida;
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

    public Tablero(String json) {
        this.mapa = new HashMap<>();
        this.casillas = new ArrayList<>();

        JSONObject rootObject = new JSONObject(json);

        JSONObject mapaObject = rootObject.getJSONObject("mapa");
        int ancho = mapaObject.getInt("ancho");
        int largo = mapaObject.getInt("largo");

        JSONArray celdasArray = rootObject.getJSONObject("camino").getJSONArray("celdas");

        for (int i = 0; i < celdasArray.length(); i++) {
            JSONObject celdaObject = celdasArray.getJSONObject(i);

            int x = celdaObject.getInt("x");
            int y = celdaObject.getInt("y");
            String tipo = celdaObject.getString("tipo");

            Ubicable ubicable = crearUbicable(celdaObject);

            Casilla casilla = new Casilla(x, y, tipo, ubicable);
            this.casillas.add(casilla);
        }
    }

    private Ubicable crearUbicable(JSONObject celdaObject) {
        if (celdaObject.has("obstaculo")) {
            String tipoObstaculo = celdaObject.getString("obstaculo");
            return crearObstaculo(tipoObstaculo);
        } else if (celdaObject.has("premio")) {
            String tipoPremio = celdaObject.getString("premio");
            return crearPremio(tipoPremio);
        } else {
            return null;
        }
    }

    private Obstaculo crearObstaculo(String tipoObstaculo) {
        switch (tipoObstaculo) {
            case "Fiera":
                return new Fiera();
            case "Lesion":
                return new Lesion();
            case "Bacanal":
                return new Bacanal();
            default:
                return null;
        }
    }

    private Premio crearPremio(String tipoPremio) {
        switch (tipoPremio) {
            case "Comida":
                return new Comida(15);
    //        case "Equipamiento":
    //            return new Equipamiento(tipoPremio);
            //VER COMO SOLUCIONAR LA PARTE DEL EQUIPAMIENTO
            default:
                return null;
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

