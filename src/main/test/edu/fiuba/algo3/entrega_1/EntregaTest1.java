package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipamiento.Armadura;
import edu.fiuba.algo3.modelo.equipamiento.Llave;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.SemiSenior;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import org.junit.jupiter.api.Test;

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

        assertEquals(20+10,gladiador.caclularEnergia());

    }
    @Test
    public void test05VerificarQueSiRecibeEquipamientoPorPrimeraVezObtieneCasco() {

        Gladiador gladiador = new Gladiador();

        gladiador.equiparse(); //aca recibe el casco, entonces el proximo que deberia recibir es la armadura

        assertEquals(Armadura.class,gladiador.verSiguienteEquipamiento().getClass());

    }

    @Test
    public void test06VerificarQueSiTresEquipamientoObtieneEscudoYEspada() {

        Gladiador gladiador = new Gladiador();

        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse(); //aca recibe el escudo y espada, entonces el proximo quedeberia recibir es la llave

        assertEquals(Llave.class,gladiador.verSiguienteEquipamiento().getClass());

    }

    @Test
    public void test07PeleaConFieraYTieneCascoPierde15DeEnergiaSeQuedaCon5() {

        Gladiador gladiador = new Gladiador();

        gladiador.equiparse();

        assertEquals(5,gladiador.pelearContraFiera());

    }
    @Test
    public void test08SiPasan8TurnosElSeniorityDelGladiadorPasaDeNovatoASeniorYVeSuEnergíaIncrementadaAlPróximoTurno() {
        Gladiador gladiador = new Gladiador(20, new Novato());

        for (int i=0; i<8; i++){
            gladiador.aumentarTurno();
        }

        assertEquals(SemiSenior.class,gladiador.verSeniority().getClass());
    }

    @Test
    public void test10PeleaConFieraYTieneTodoElEquipamentoNoPierdeEnergia(){
        Gladiador gladiador = new Gladiador();

        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();

        assertEquals(20,gladiador.pelearContraFiera());
    }

    @Test
    public void test11PeleaObtienePremioPeroYaTieneTodoEntoncesNoRecibeNada(){
        Gladiador gladiador = new Gladiador();

        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();

        assertEquals(Llave.class,gladiador.verEquipamiento().peek().getClass());

        gladiador.equiparse();
        assertEquals(Llave.class,gladiador.verEquipamiento().peek().getClass());
    }




}
