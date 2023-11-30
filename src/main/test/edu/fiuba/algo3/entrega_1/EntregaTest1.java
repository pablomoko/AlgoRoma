package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.casilla.CasillaCamino;
import edu.fiuba.algo3.modelo.obstaculo.ObstaculoSinEfecto;
import edu.fiuba.algo3.modelo.obstaculo.Fiera;
import edu.fiuba.algo3.modelo.premio.PremioSinEfecto;
import edu.fiuba.algo3.modelo.premio.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.premio.equipamiento.Armadura;
import edu.fiuba.algo3.modelo.premio.equipamiento.Llave;
import edu.fiuba.algo3.modelo.seniority.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTest1 {
    @Test
    public void test01VerificarQUeJugadorEmpiezaConEnergiaYEquipamientoCorrespondiente() {

        Gladiador gladiador = new Gladiador();

        assertEquals(20,gladiador.calcularEnergia());
        assertTrue(gladiador.verEquipamiento().empty());

    }
    @Test
    public void test02VerificarQeeJugadorSalgaDeLaCasillaInicial(){

        Seniority seniority = new Novato();
        Gladiador gladiador = new Gladiador(20, seniority);

        assertEquals(0, seniority.verPasos());

    }


    @Test
    public void test03VerificarQueJugadorSinEnergiaNoPuedaJugarElTurno() {

        Seniority seniority = new Novato();
        Gladiador gladiador = new Gladiador(0, seniority);

        gladiador.mover(1);

        assertEquals(0, seniority.verPasos());

    }
    @Test
    public void test04VerificarQueSiRecibeComidaIncremenetaEnergiaEn10() {

        Gladiador gladiador = new Gladiador();

        Comida milanesaConPure = new Comida(10) ;

        gladiador.alimentarse(milanesaConPure);

        assertEquals(20+10,gladiador.calcularEnergia());

    }
    @Test
    public void test05VerificarQueSiRecibeEquipamientoPorPrimeraVezObtieneCasco() {

        Gladiador gladiador = new Gladiador();

        Equipamiento actual = gladiador.equiparse(); //aca recibe el casco, entonces el proximo que deberia recibir es la armadura

        assertEquals(Armadura.class,actual.siguienteEquipamiento().getClass());

    }

    @Test
    public void test06VerificarQueSiTresEquipamientoObtieneEscudoYEspada() {

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

        Movible gladiador = new Gladiador(20, new Novato());
        Jugador jugador = new Jugador(gladiador);
        String rutaArchivo = "src/main/resources/mapa.json";
        Tablero mapa = new Tablero(rutaArchivo);
        mapa.inicializarMovible(gladiador);

        mapa.ubicarMovible(gladiador, 37);
        mapa.ubicarMovible(gladiador, 1);

        assertEquals(mapa.obtenerCasillaDe(gladiador), mapa.obtenerCasillaDe(19));
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
        Equipamiento actual = gladiador.equiparse();

        assertEquals(Llave.class,actual.getClass());

        actual = gladiador.equiparse();
        assertEquals(Llave.class,actual.getClass());
    }

    @Test
    public void test12SiPasanTreintaTurnosYNadieLlegoALaMetaSeTerminaElJuego() {
        Jugador jugador1 = new Jugador(new Gladiador(20, new Novato()));
        Jugador jugador2 = new Jugador(new Gladiador(20, new Novato()));
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        String rutaArchivo = "src/main/resources/mapa.json";
        Juego juego = new Juego(jugadores, rutaArchivo);
        for (int i=0; i<30; i++)  {
            juego.jugarTurno();
        }
        assertTrue(juego.terminado());
    }

}