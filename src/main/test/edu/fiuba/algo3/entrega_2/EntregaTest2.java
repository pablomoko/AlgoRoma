package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    public void test15(){

    }
}
