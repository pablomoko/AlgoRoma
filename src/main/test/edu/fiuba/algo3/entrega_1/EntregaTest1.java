package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EntregaTest1 {
    @Test
    public void test01VerificarQUeJugadorEmpiezaConEnergiaYEquipamientoCorrespondiente() {

        Gladiador gladiador = new Gladiador();

        assertEquals(20,gladiador.caclularEnergia());
        assertNull(gladiador.verEquipamiento());

    }
    @Test
    public void test02VerificarQeeJugadorSalgaDeLaCasillaInicial(){

        Gladiador gladiador = new Gladiador();

        assertEquals(0,gladiador.verPasos());

    }


    @Test
    public void test03VerificarQueJugadorSinEnergiaNoPuedaJugarElTurno() {

        Gladiador gladiador = new Gladiador(0);

        gladiador.mover(1);

        assertEquals(0,gladiador.verPasos());

    }
    @Test
    public void test04VerificarQueSiRecibeComidaIncremenetaEnergiaEn10() {

        Gladiador gladiador = new Gladiador();

        Comida milanesaConPure = new Comida(10) ;

        gladiador.alimentarse(milanesaConPure);

        assertEquals(20+10,gladiador.caclularEnergia());

    }
/*
    public void test05VerificarQueSiRecibeUnPremioPorPrimeraVezObtieneUnCasco() {

        Gladiador gladiador = new Gladiador();
        Casco casco = new Casco();

        gladiador.recibirPremio(unPremio);

        assertEquals(20+10,gladiador.caclularEnergia());

    }*/




}
