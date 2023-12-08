package edu.fiuba.algo3.unit_tests;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.casilla.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCasilla {
    @Test
    public void test01() {

        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(1,1);
        CasillaSalida casillaSalida = new CasillaSalida(posicion2, null, null);
        CasillaCamino casillaDestino = new CasillaCamino(posicion1, null, null);
        assertEquals(1, 1);

    }
}
