package edu.fiuba.algo3.unit_tests;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.premio.Comida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnergia {

    @Test
    public void test01EnergiaSeCreaCorrectamenteConEnergia() {

        Energia energia = new Energia(20);

        assertEquals(energia.calcularEnergia(), 20);

    }

    @Test
    public void test02SeDisminuyeLaEnergiaSegunElValorIndicado() {

        Energia energia = new Energia(20);

        assertEquals(energia.disminuirEnergia(6), 14);

    }

    @Test
    public void test03SeAumentaLaEnergiaSegunElValorIndicado() {

        Energia energia = new Energia(20);

        assertEquals(energia.aumentarEnergia(6).calcularEnergia(), 26);

    }
}
