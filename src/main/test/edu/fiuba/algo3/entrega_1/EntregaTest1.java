package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaTest1 {
    @Test
    public void test01VerificarQUeJugadorEmpiezaConEnergiaYEquipamientoCorrespondiente() {

        Gladiador gladiador = new Gladiador();

        assertEquals(20,gladiador.caclularEnergia());
        assertTrue(gladiador.verEquipamiento().empty());

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
    @Test
    public void test05VerificarQueSiRecibeEquipamientoPorPrimeraVezObtieneCasco() {

        Gladiador gladiador = new Gladiador();

        gladiador.equiparse(); //aca recibe el casco, entonces el proximo que deberia recibir es la armadura

        assertEquals((new Armadura()).getClass(),gladiador.verEquipamiento().peek().siguienteEquipamiento().getClass());

    }

    @Test
    public void test06VerificarQueSiTresEquipamientoObtieneEscudoYEspada() {

        Gladiador gladiador = new Gladiador();

        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse(); //aca recibe el escudo y espada, entonces el proximo quedeberia recibir es la llave

        assertEquals((new Llave()).getClass(),gladiador.verEquipamiento().peek().siguienteEquipamiento().getClass());

    }

    @Test
    public void test07PeleaConFieraYTieneCascoPierde15DeEnergiaSeQuedaCon5() {

        Gladiador gladiador = new Gladiador();

        gladiador.equiparse();

        assertEquals(5,gladiador.pelearContraFiera());

    }


}
