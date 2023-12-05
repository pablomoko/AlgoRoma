package edu.fiuba.algo3.unit_tests;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.SemiSenior;
import edu.fiuba.algo3.modelo.seniority.Senior;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSeniority {

    @Test
    public void test01DeNovatoSeAsciendeASemiSeniorSiSeLlegaAOchoPasos() {

        Seniority seniority = new Novato();
        Energia energia = new Energia(20);

        seniority = seniority.sumarTurnos(9);
        energia = seniority.plusDeEnergia(energia);

        assertEquals(energia.calcularEnergia(), 25);

    }

    @Test
    public void test02DeSemiSeniorSeAsciendeASeniorSiSeLlegaA12Pasos() {

        Seniority seniority = new SemiSenior(1);
        Energia energia = new Energia(20);

        seniority = seniority.sumarTurnos(4);
        energia = seniority.plusDeEnergia(energia);

        assertEquals(energia.calcularEnergia(), 30);

    }

    @Test
    public void test03SeniorNoAsciende() {

        Seniority seniority = new Senior(1);
        Energia energia = new Energia(20);

        seniority = seniority.sumarTurnos(10);
        energia = seniority.plusDeEnergia(energia);

        assertEquals(energia.calcularEnergia(), 30);

    }
}
