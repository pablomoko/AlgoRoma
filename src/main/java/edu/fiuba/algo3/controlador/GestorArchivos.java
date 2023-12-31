package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Movible;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.casilla.CasillaCamino;
import edu.fiuba.algo3.modelo.casilla.CasillaLlegada;
import edu.fiuba.algo3.modelo.casilla.CasillaSalida;
import edu.fiuba.algo3.modelo.obstaculo.*;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.premio.PremioSinEfecto;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class GestorArchivos {

    public static LinkedList <Casilla> generarListaDeCasillasDesdeJSON(String contenido){
        LinkedList <Casilla> casillas = new LinkedList<>();

        JSONObject rootObject = new JSONObject(contenido);

        JSONArray celdasArray = rootObject.getJSONObject("camino").getJSONArray("celdas");

        for (int i = 0; i < celdasArray.length(); i++) {
            JSONObject celdaObject = celdasArray.getJSONObject(i);

            Casilla casilla = crearCasilla(celdaObject);
            casillas.add(casilla);
        }

        return casillas;
    }
    public static Map <String,Integer> generarDimesiones(String contenido){
        JSONObject rootObject = new JSONObject(contenido);

        JSONObject mapaObject = rootObject.getJSONObject("mapa");
        int ancho = mapaObject.getInt("ancho");
        int largo = mapaObject.getInt("largo");

        Map <String,Integer> dimensiones = new HashMap<>();
        dimensiones.put("ancho",ancho);
        dimensiones.put("largo",largo);

        return dimensiones;
    }

    public static Casilla crearCasilla(JSONObject celdaObject){

        int x = celdaObject.getInt("x");
        int y = celdaObject.getInt("y");
        Posicion posicion = new Posicion(x, y);
        String tipo = celdaObject.getString("tipo");


        Obstaculo obstaculo = crearObstaculo(celdaObject);
        Premio premio = crearPremio(celdaObject);


        Casilla casilla = crearTipo(tipo, posicion, premio, obstaculo);

        return casilla;
    }



    private static Obstaculo crearObstaculo(JSONObject celdaObject) {
        if (celdaObject.has("obstaculo")) {
            String tipoObstaculo = celdaObject.getString("obstaculo");
            return crearObstaculo(tipoObstaculo);
        }else {
            return new ObstaculoSinEfecto();
        }
    }

    private static Premio crearPremio(JSONObject celdaObject) {
        if (celdaObject.has("premio")) {
            String tipoPremio = celdaObject.getString("premio");
            return crearPremio(tipoPremio);
        }else {
            return new PremioSinEfecto();
        }
    }

    private static Obstaculo crearObstaculo(String tipoObstaculo) {
        switch (tipoObstaculo) {
            case "Fiera":
                return new Fiera();
            case "Lesion":
                return new Lesion();
            case "Bacanal":
                return new Bacanal(new Dado());
            default:
                return new ObstaculoSinEfecto();
        }
    }

    private static Premio crearPremio(String tipoPremio) {
        switch (tipoPremio) {
            case "Comida":
                return new Comida(15);
            case "Equipamiento":
                return new Equipamiento();
            default:
                return new PremioSinEfecto();
        }
    }
    private static Casilla crearTipo(String tipoCasilla, Posicion posicion, Premio premio, Obstaculo obstaculo) {
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

}
