package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.controlador.GestorTurnos;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casilla.*;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento;
import edu.fiuba.algo3.modelo.obstaculo.ObstaculoSinEfecto;
import edu.fiuba.algo3.modelo.obstaculo.Fiera;
import edu.fiuba.algo3.modelo.premio.PremioSinEfecto;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.seniority.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.controlador.GestorArchivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTest1 {
    @Test
    public void test01VerificaQueJugadorEmpiezaConEnergiaYEquipamientoCorrespondiente() {

        Gladiador gladiador = new Gladiador();

        assertEquals(20,gladiador.calcularEnergia());
        assertEquals(20,gladiador.usarEquipamiento());

    }
    @Test
    public void test02VerificaQueJugadorSalgaDeLaCasillaInicial(){

        Seniority seniority = new Novato();
        Gladiador gladiador = new Gladiador(20, seniority);

        assertEquals(0, seniority.verPasos());

    }


    @Test
    public void test03VerificaQueJugadorSinEnergiaNoPuedaJugarElTurno() {

        Seniority seniority = new Novato();
        Gladiador gladiador = new Gladiador(0, seniority);

        gladiador.mover(1);

        assertEquals(0, seniority.verPasos());

    }
    @Test
    public void test04VerificaQueSiRecibeComidaIncremenetaEnergiaEn10() {

        Gladiador gladiador = new Gladiador();

        Comida milanesaConPure = new Comida(10) ;

        gladiador.alimentarse(milanesaConPure);

        assertEquals(20+10,gladiador.calcularEnergia());

    }
    @Test
    public void test05VerificaQueSiRecibeEquipamientoPorPrimeraVezObtieneCasco() {

        Gladiador gladiador = new Gladiador();

        NivelEquipamiento actual = gladiador.equiparse();

        assertEquals(actual.usarEquipamiento(),15);

    }

    @Test
    public void test06VerificaQueSiTresEquipamientoObtieneEscudoYEspada() {

        Gladiador gladiador = new Gladiador();
        Posicion pos = new Posicion(1,1);
        CasillaCamino casillaFiera = new CasillaCamino(pos, new PremioSinEfecto(), new Fiera());
        CasillaCamino casillaEquipamiento = new CasillaCamino(pos, new Equipamiento(), new ObstaculoSinEfecto());
        casillaEquipamiento.afectarMovible(gladiador);
        casillaEquipamiento.afectarMovible(gladiador);
        casillaEquipamiento.afectarMovible(gladiador);

        casillaFiera.afectarMovible(gladiador);

        assertEquals(18,gladiador.calcularEnergia());

    }

    @Test
    public void test07PeleaConFieraYTieneCascoPierde15DeEnergiaSeQuedaCon5() {

        Gladiador gladiador = new Gladiador();
        Posicion pos = new Posicion(1,1);
        CasillaCamino casillaFiera = new CasillaCamino(pos, new Equipamiento(), new Fiera());
        casillaFiera.afectarMovible(gladiador);

        assertEquals(5,gladiador.calcularEnergia());

    }
    @Test
    public void test08SiPasan8TurnosElSeniorityDelGladiadorPasaDeNovatoASemiSeniorYVeSuEnergíaIncrementadaAlPróximoTurno() {
        Gladiador gladiador = new Gladiador(20, new Novato());

        for (int i=0; i<8; i++){
            gladiador.aumentarTurno();
        }

        assertEquals(gladiador.calcularEnergia(), 25);
    }

    @Test
    public void test09SiLlegaALaMetaSinLaLLaveEnElEquipamientoRetrocedMitadDeLasCasillas(){

        Movible gladiador = new Gladiador(50, new Novato());

        String stringJson = "{\"mapa\":{\"ancho\":10,\"largo\":18},\"camino\":{\"celdas\":[{\"x\":1,\"y\":7,\"tipo\":\"Salida\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":2,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":2,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":2,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":3,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":4,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":5,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":6,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":7,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":8,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":9,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":10,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":11,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":12,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":12,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Comida\"},{\"x\":12,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":12,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":13,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"Comida\"},{\"x\":14,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":15,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":16,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":17,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":1,\"tipo\":\"Llegada\",\"obstaculo\":\"\",\"premio\":\"\"}]}}";
        LinkedList < Casilla> casillas = GestorArchivos.generarListaDeCasillasDesdeJSON(stringJson);
        Tablero tablero = new Tablero(casillas);

        tablero.inicializarMovible(gladiador);

        tablero.moverMovible(gladiador, 37);
        tablero.moverMovible(gladiador, 1);

        assertFalse(gladiador.estaCompleto());
        assertEquals(tablero.obtenerCasillaDe(gladiador), tablero.obtenerCasillaDe(19));
    }

    @Test
    public void test10PeleaConFieraYTieneTodoElEquipamentoNoPierdeEnergia(){
        Gladiador gladiador = new Gladiador();
        Posicion pos = new Posicion(1,1);
        CasillaCamino casillaEquipamiento = new CasillaCamino(pos, new Equipamiento(), new ObstaculoSinEfecto());
        CasillaCamino casillaFiera = new CasillaCamino(pos, new PremioSinEfecto(), new Fiera());
        casillaEquipamiento.afectarMovible(gladiador);
        casillaEquipamiento.afectarMovible(gladiador);
        casillaEquipamiento.afectarMovible(gladiador);
        casillaEquipamiento.afectarMovible(gladiador);

        casillaFiera.afectarMovible(gladiador);
        assertEquals(20,gladiador.calcularEnergia());
    }

    @Test
    public void test11PeleaObtienePremioPeroYaTieneTodoEntoncesNoRecibeNada(){
        Gladiador gladiador = new Gladiador();

        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();
        NivelEquipamiento actual = gladiador.equiparse();

        assertEquals(actual.usarEquipamiento(),0);

        actual = gladiador.equiparse();
        assertEquals(actual.usarEquipamiento(),0);
    }

    @Test
    public void test12SiPasanTreintaTurnosYNadieLlegoALaMetaSeTerminaElJuego() throws IOException {

        GestorTurnos gestorTurnos = new GestorTurnos(30);

        Jugador jugador1 = new Jugador("jugador1",new Gladiador(20, new Novato()));
        Jugador jugador2 = new Jugador("jugador2",new Gladiador(20, new Novato()));

        String stringJson = "{\"mapa\":{\"ancho\":10,\"largo\":18},\"camino\":{\"celdas\":[{\"x\":1,\"y\":7,\"tipo\":\"Salida\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":2,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":2,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":2,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":2,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":2,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":3,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"\"},{\"x\":4,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":5,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"Equipamiento\"},{\"x\":6,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":7,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":8,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":9,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":10,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":11,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":1,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":12,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":12,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Comida\"},{\"x\":12,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"Equipamiento\"},{\"x\":12,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":12,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":13,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"Comida\"},{\"x\":14,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Fiera\",\"premio\":\"\"},{\"x\":15,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":16,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":9,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":8,\"tipo\":\"Camino\",\"obstaculo\":\"Lesion\",\"premio\":\"\"},{\"x\":17,\"y\":7,\"tipo\":\"Camino\",\"obstaculo\":\"Bacanal\",\"premio\":\"\"},{\"x\":17,\"y\":6,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":5,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":4,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Comida\"},{\"x\":17,\"y\":3,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":2,\"tipo\":\"Camino\",\"obstaculo\":\"\",\"premio\":\"Equipamiento\"},{\"x\":17,\"y\":1,\"tipo\":\"Llegada\",\"obstaculo\":\"\",\"premio\":\"\"}]}}";
        LinkedList <Casilla> casillas = GestorArchivos.generarListaDeCasillasDesdeJSON(stringJson);
        Tablero tablero = new Tablero(casillas);

        jugador1.inicializarMovible(tablero);
        jugador2.inicializarMovible(tablero);

        gestorTurnos.agregarTurno(jugador1);
        gestorTurnos.agregarTurno(jugador2);
        gestorTurnos.rondaCero(0);
        gestorTurnos.avanzarTurnos(60); //30 * 2 (cantidad turnos max por jugador)

        assertThrows(IllegalArgumentException.class, gestorTurnos::avanzarTurno, "Ya se superó la cantidad de rondas máximas");
        assertNotEquals(tablero.obtenerCasillaDe(jugador1.obtenerMovible()).getClass(), CasillaLlegada.class);
        assertNotEquals(tablero.obtenerCasillaDe(jugador2.obtenerMovible()).getClass(), CasillaLlegada.class);

    }

}