package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.GestorArchivos;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.casilla.CasillaSalida;
import edu.fiuba.algo3.modelo.casilla.CasillaLlegada;
import edu.fiuba.algo3.modelo.casilla.CasillaCamino;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.obstaculo.ObstaculoSinEfecto;
import edu.fiuba.algo3.modelo.premio.PremioSinEfecto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTest2 {
    @Test
    public void test13VerificoFormatoDelMapaJSON(){
        try {
            String rutaArchivo = "src/main/resources/mapa.json";

            String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

            JSONObject jsonObject = new JSONObject(contenido);

            assertTrue(jsonObject.has("mapa"));
            JSONObject mapaObject = jsonObject.getJSONObject("mapa");

            assertTrue(mapaObject.has("ancho"));
            assertTrue(mapaObject.has("largo"));
        }catch (IOException e) {
            fail("Error de lectura del archivo: " + e.getMessage());
        }
    }

    @Test
    public void test14VerificoFormatoValidoDeObstaculosYPremiosJSON() {
        try {
            String rutaArchivo = "src/main/resources/mapa.json";

            String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

            JSONObject jsonObject = new JSONObject(contenido);

            assertTrue(jsonObject.has("camino"));
            JSONObject caminoObject = jsonObject.getJSONObject("camino");

            assertTrue(caminoObject.has("celdas"));
            JSONArray celdasArray = caminoObject.getJSONArray("celdas");

            for (int i = 0; i < celdasArray.length(); i++) {
                JSONObject celda = celdasArray.getJSONObject(i);
                assertTrue(celda.has("x"));
                assertTrue(celda.has("y"));
                assertTrue(celda.has("tipo"));
                assertTrue(celda.has("obstaculo"));
                assertTrue(celda.has("premio"));
            }
        }catch (IOException e) {
            fail("Error de lectura del archivo: " + e.getMessage());
        }
    }

    @Test
    public void test15ElJuegoSeCreaAcordeAlJSON() throws IOException {

        Posicion posicion = new Posicion(1,7);
        Casilla casillaSalida = new CasillaSalida(posicion, new PremioSinEfecto(), new ObstaculoSinEfecto());

        //String celda = "{[{\"x\": 1,\"y\": 7,\"tipo\": \"Salida\",\"obstaculo\": \"\", \"premio\":\"\"}]}}";
        String rutaArchivo = "src/main/resources/mapa.json";

        String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

        JSONObject rootObject = new JSONObject(contenido);
        JSONArray celdasArray = rootObject.getJSONObject("camino").getJSONArray("celdas");

        JSONObject celdaSalida = celdasArray.getJSONObject(0);

        assertEquals(casillaSalida.getClass(), GestorArchivos.crearCasilla(celdaSalida).getClass());

        Casilla casillaLlegada = new CasillaLlegada(new Posicion(17, 1), new PremioSinEfecto(), new ObstaculoSinEfecto());
        JSONObject celdaLlegada = celdasArray.getJSONObject(38);

        assertEquals(casillaLlegada.getClass(), GestorArchivos.crearCasilla(celdaLlegada).getClass());

        Casilla casillaCamino = new CasillaCamino(new Posicion(2, 7), new PremioSinEfecto(), new ObstaculoSinEfecto());
        JSONObject celdaCamino = celdasArray.getJSONObject(1);

        assertEquals(casillaCamino.getClass(), GestorArchivos.crearCasilla(celdaCamino).getClass());

    }
}
