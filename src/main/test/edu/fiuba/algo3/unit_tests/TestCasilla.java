package edu.fiuba.algo3.unit_tests;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.casilla.*;
import edu.fiuba.algo3.modelo.premio.PremioSinEfecto;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.obstaculo.ObstaculoSinEfecto;
import edu.fiuba.algo3.modelo.obstaculo.Lesion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCasilla {
    @Test
    public void test01CasillaSeInicializaCorrectamente() {

        Posicion posicion1 = new Posicion(0,0);
        CasillaSalida c = new CasillaSalida(posicion1, new PremioSinEfecto(), new ObstaculoSinEfecto());
        assertEquals(c.getPosicion(), posicion1);
        assertEquals(c.getPremio().getClass(), PremioSinEfecto.class);
        assertEquals(c.getObstaculo().getClass(), ObstaculoSinEfecto.class);

    }

    @Test
    public void test02CasillaConPremioAfectaAMovible() {
        Gladiador g = new Gladiador(0);
        Posicion posicion1 = new Posicion(0,0);
        CasillaCamino c = new CasillaCamino(posicion1, new Comida(15), new ObstaculoSinEfecto());
        c.afectarMovible(g);

        assertEquals(g.calcularEnergia(), 15);

    }

    @Test
    public void test03CasillaConObstaculoAfectaAMovible() {
        Gladiador g = new Gladiador(0, new Novato());
        Posicion posicion1 = new Posicion(0,0);
        CasillaCamino c = new CasillaCamino(posicion1, new PremioSinEfecto(), new Lesion());
        c.afectarMovible(g);

        assertTrue(g.estaLesionado());

    }
}
