package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.vista.ContenedorTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class JugarEventHandler implements EventHandler<ActionEvent> {

    private Scene proximaEscena;

    private Stage stage;

    private Tablero tablero;

    private ContenedorTablero contenedorTablero;

    private ArrayList<Jugador> jugadores;

    public JugarEventHandler(Stage stage, ArrayList<Jugador> jugadores) {
        this.stage = stage;

        String stringJson = "{\"mapa\":{\"ancho\":10,\"largo\":18},\"camino\":{\"celdas\":[{\"x\":1,\"y\":7,\"tipo\":\"Salida\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":2,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":2,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":2,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":3,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":4,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":5,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":6,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":7,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":8,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":9,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":10,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":11,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":12,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":12,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Comida\"},{\"x\":12,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":12,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":13,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"Comida\"},{\"x\":14,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":15,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":16,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":17,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":1,\"tipo\":\"Llegada\",\"obstaculo\":\"\",\"premio\":\"\"}]}}";
        LinkedList<Casilla> casillas = GestorArchivos.generarListaDeCasillasDesdeJSON(stringJson);
        this.tablero = new Tablero(casillas);

        for (Jugador jugador: jugadores) {
            jugador.inicializarMovible(this.tablero);
        }

        Map<String,Integer> dimensiones = GestorArchivos.generarDimesiones(stringJson);
        this.contenedorTablero = new ContenedorTablero(stage, dimensiones.get("ancho"), dimensiones.get("largo"), tablero.getCasillas());
        this.proximaEscena = new Scene(this.contenedorTablero, 800, 700);

        this.tablero.notifyObservers(contenedorTablero);
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        this.stage.setScene(proximaEscena);
        this.stage.setFullScreen(true);

    }
}
