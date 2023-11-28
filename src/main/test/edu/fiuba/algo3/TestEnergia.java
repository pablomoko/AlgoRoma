package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.premio.Comida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnergia {

    @Test
    public void test01AumentarEnergiaComiendoAumentaSuValorDependiendoLaComida() {

        Energia energia = new Energia(20);
        Comida comida = new Comida(10);

        assertEquals(energia.aumentarEnergiaComiendo(comida), 30);

    }

    @Test
    public void test02SeDisminuyeLaEnergiaSegunElValorIndicado() {

        Energia energia = new Energia(20);

        assertEquals(energia.disminuirEnergia(6), 14);

    }
}
