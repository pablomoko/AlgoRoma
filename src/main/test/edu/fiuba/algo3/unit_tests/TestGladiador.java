package edu.fiuba.algo3.unit_tests;

import edu.fiuba.algo3.modelo.premio.equipamiento.Armadura;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.Senior;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.premio.Comida;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestGladiador {

    @Test
    public void test01ElGladiadorSeInicializaConLaEnergiaIndicada() {

        Gladiador gladiador = new Gladiador(20);

        assertEquals(gladiador.calcularEnergia(), 20);

    }

    @Test
    public void test02ElGladiadorSeInicializaSinLesion() {
        Novato n = new Novato();
        Gladiador gladiador = new Gladiador(20, n);

        assertFalse(gladiador.estaLesionado());

    }

    @Test
    public void test03ElGladiadorSeLesionaYSuEstadoLesionEsTrue() {
        Novato n = new Novato();
        Gladiador gladiador = new Gladiador(20, n);
        gladiador.lesionarse();

        assertTrue(gladiador.estaLesionado());

    }

    @Test
    public void test04ElGladiadorSeLesionaYEnElProximoTurnoSeRecupera() {
        Novato n = new Novato();
        Gladiador gladiador = new Gladiador(20, n);
        gladiador.lesionarse();

        assertTrue(gladiador.estaLesionado());

        gladiador.habilitarMovimiento();

        assertFalse(gladiador.estaLesionado());

    }

    @Test
    public void test05ElGladiadorSeInicializaComoNoGanador() {
        Novato n = new Novato();
        Gladiador gladiador = new Gladiador(20, n);

        assertFalse(gladiador.sosGanador());

    }

    @Test
    public void test06AlimentarseAumentaLaEnergiaDelGladiador() {

        Gladiador gladiador = new Gladiador(20);
        Comida comida = new Comida(10);

        assertEquals(gladiador.alimentarse(comida), 30);

    }

    @Test
    public void test07EquiparseEquipaAlGladiadorConNuevoEquipamiento() {

        Gladiador gladiador = new Gladiador(20);
        gladiador.equiparse();

        assertEquals(gladiador.usarEquipamiento(), 15);

        gladiador.equiparse();

        assertEquals(gladiador.usarEquipamiento(), 10);

    }

    @Test
    public void test08SiElGladiadorSeMueveSeLeDescuentaEnergia() {

        Gladiador gladiador = new Gladiador(20);
        gladiador.mover(5);

        assertEquals(gladiador.calcularEnergia(), 19);

    }

    @Test
    public void test09SiElGladiadorTieneTodoElEquipamientoEntoncesEstaCompleto() {

        Gladiador gladiador = new Gladiador(20);
        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();

        assertTrue(gladiador.estaCompleto());

    }

    @Test
    public void test10SiElGladiadorNoTieneTodoElEquipamientoEntoncesNoEstaCompleto() {

        Gladiador gladiador = new Gladiador(20);
        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();

        assertFalse(gladiador.estaCompleto());

    }




}
