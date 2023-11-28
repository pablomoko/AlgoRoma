package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Gladiador;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.premio.Comida;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGladiador {

    @Test
    public void test01ElGladiadorSeInicializaConLaEnergiaIndicada() {

        Gladiador gladiador = new Gladiador(20);

        assertEquals(gladiador.caclularEnergia(), 20);

    }

    @Test
    public void test02AlimentarseAumentaLaEnergiaDelGladiador() {

        Gladiador gladiador = new Gladiador(20);
        Comida comida = new Comida(10);

        assertEquals(gladiador.alimentarse(comida), 30);

    }

}
