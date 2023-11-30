package edu.fiuba.algo3.modelo;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.obstaculo.Lesion;
import edu.fiuba.algo3.modelo.obstaculo.Fiera;
import edu.fiuba.algo3.modelo.obstaculo.Bacanal;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.obstaculo.ObstaculoSinEfecto;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.premio.PremioSinEfecto;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.casilla.CasillaSalida;
import edu.fiuba.algo3.modelo.casilla.CasillaCamino;
import edu.fiuba.algo3.modelo.casilla.CasillaLlegada;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
public class Tablero {

    private List<Casilla> casillas;
    private Map<Movible, Casilla> mapa;

   /* public Tablero(int tamanio){
        this.mapa = new HashMap<>();
        this.casillas = new ArrayList<Casilla>();
        for (int i=0; i<tamanio; i++) {
            this.casillas.add();
        }
    }*/

    public Tablero(String json) {
        this.mapa = new HashMap<>();
        this.casillas = new LinkedList<>();

        try{
            String contenido = new String(Files.readAllBytes(Paths.get(json)));
            JSONObject rootObject = new JSONObject(contenido);

            JSONObject mapaObject = rootObject.getJSONObject("mapa");
            int ancho = mapaObject.getInt("ancho");
            int largo = mapaObject.getInt("largo");

            JSONArray celdasArray = rootObject.getJSONObject("camino").getJSONArray("celdas");

            for (int i = 0; i < celdasArray.length(); i++) {
                JSONObject celdaObject = celdasArray.getJSONObject(i);

                int x = celdaObject.getInt("x");
                int y = celdaObject.getInt("y");
                Posicion posicion = new Posicion(x, y);
                String tipo = celdaObject.getString("tipo");


                Obstaculo obstaculo = crearObstaculo(celdaObject);
                Premio premio = crearPremio(celdaObject);


                Casilla casilla = this.crearTipo(tipo, posicion, premio, obstaculo);
                this.casillas.add(casilla);
            }
        }catch(IOException e) {
            System.out.println("ERROR");
        }

    }

    private Obstaculo crearObstaculo(JSONObject celdaObject) {
        if (celdaObject.has("obstaculo")) {
            String tipoObstaculo = celdaObject.getString("obstaculo");
            return crearObstaculo(tipoObstaculo);
        }else {
            return new ObstaculoSinEfecto();
        }
    }

    private Premio crearPremio(JSONObject celdaObject) {
        if (celdaObject.has("premio")) {
            String tipoPremio = celdaObject.getString("premio");
            return crearPremio(tipoPremio);
        }else {
            return new PremioSinEfecto();
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
                return new ObstaculoSinEfecto();
        }
    }

    private Premio crearPremio(String tipoPremio) {
        switch (tipoPremio) {
            case "Comida":
                return new Comida(15);
            case "Equipamiento":
                return new Equipamiento();
            default:
                return new PremioSinEfecto();
        }
    }
    public List<Casilla> getCasillas(){
        return this.casillas;
    }

    public void inicializarMovible(Movible movible){
        this.mapa.put(movible, this.obtenerCasillaDe(0));
        casillas.get(0).colocarMovible(movible);
    }

    public void ubicarMovible(Movible movible, int unosPasos){

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

    private Casilla crearTipo(String tipoCasilla,Posicion posicion, Premio premio, Obstaculo obstaculo) {
        switch (tipoCasilla) {
            case "Salida":
                return new CasillaSalida(posicion, premio, obstaculo);
            case "Camino":
                return new CasillaCamino(posicion, premio, obstaculo);
            case "Llegada":
                return new CasillaLlegada(posicion, premio, obstaculo);
            default:
                return null;
        }
    }



    public Casilla obtenerCasillaDe(Movible movible){
        return (this.mapa.get(movible));
    }

    public Casilla obtenerCasillaDe(int posicion){
        return this.casillas.get(posicion);
    }




}

