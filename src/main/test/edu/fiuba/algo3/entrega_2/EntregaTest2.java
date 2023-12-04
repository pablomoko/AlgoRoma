package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Controlador.GestorArchivos;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento0;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento1;
import edu.fiuba.algo3.modelo.premio.equipamiento.Casco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTest2 {
    @Test
    public void test13VerificoFormatoDelMapaJSON(){
        String jsonString = "{\"mapa\": {\"ancho\": 10, \"largo\": 18}}";

        JSONObject jsonObject = new JSONObject(jsonString);

        assertTrue(jsonObject.has("mapa"));
        JSONObject mapaObject = jsonObject.getJSONObject("mapa");

        assertTrue(mapaObject.has("ancho"));
        assertTrue(mapaObject.has("largo"));
    }

    @Test
    public void test14VerificoFormatoValidoDeObstaculosYPremiosJSON() {
        String jsonStirng = "{\"camino\": {\"celdas\": [{\"x\": 1,\"y\": 7,\"tipo\": \"Salida\",\"obstaculo\": \"\", \"premio\":\"\"}]}}";

        JSONObject jsonObject = new JSONObject(jsonStirng);

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
    }

    @Test
    public void test15ElJuegoSeCreaAcordeAlJSON() {
        String stringJson = "{\"mapa\":{\"ancho\":10,\"largo\":18},\"camino\":{\"celdas\":[{\"x\":1,\"y\":7,\"tipo\":\"Salida\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":2,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":2,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":2,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":3,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":4,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":5,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":6,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":7,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":8,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":9,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":10,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":11,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":12,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":12,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Comida\"},{\"x\":12,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":12,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":13,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"Comida\"},{\"x\":14,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":15,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":16,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":17,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":1,\"tipo\":\"Llegada\",\"obstaculo\":\"\",\"premio\":\"\"}]}}";

        LinkedList <Casilla> casillas = GestorArchivos.generarListaDeCasillasDesdeJSON(stringJson);

        assertEquals(casillas.get(0).getPosicion().getX(), 1);
        assertEquals(casillas.get(0).getPosicion().getY(), 7);

        Gladiador gladiador = new Gladiador(20);
        Tablero tablero = new Tablero(casillas);
        tablero.inicializarMovible(gladiador);

        assertEquals(gladiador.getEquipamiento().getClass(), NivelEquipamiento0.class);
        tablero.moverMovible(gladiador, 1);
        assertEquals(NivelEquipamiento1.class,gladiador.getEquipamiento().getClass());
    }

    @Test
    public void test16VerificacionLogger(){

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        logger.info("comiendo un panchito");

        System.setOut(originalOut);

        assertEquals(true, outContent.toString().contains("comiendo un panchito"));
    }
}
