package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.premio.equipamiento.Armadura;
import edu.fiuba.algo3.modelo.Gladiador;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.premio.Comida;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGladiador {

    @Test
    public void test01ElGladiadorSeInicializaConLaEnergiaIndicada() {

        Gladiador gladiador = new Gladiador(20);

        assertEquals(gladiador.calcularEnergia(), 20);

    }

    @Test
    public void test02AlimentarseAumentaLaEnergiaDelGladiador() {

        Gladiador gladiador = new Gladiador(20);
        Comida comida = new Comida(10);

        assertEquals(gladiador.alimentarse(comida), 30);

    }

    @Test
    public void test03EquiparseDevuelveElSiguienteEquipamiento() {

        Gladiador gladiador = new Gladiador(20);
        gladiador.equiparse();
        gladiador.equiparse();

        assertEquals(gladiador.pelearContraFiera(), 10);

    }

    @Test
    public void test04UsarEquipamientoTomaElUltimoEquipamientoAgregado() {

        Gladiador gladiador = new Gladiador(20);
        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.equiparse();
        gladiador.usarEquipamiento();

        assertEquals(gladiador.pelearContraFiera(), 18);

    }

    @Test
    public void test05SiElGladiadorSeMueveUnaCantidadSeLeDescuentaEsaCantidadDeEnergia() {

        Gladiador gladiador = new Gladiador(20);
        gladiador.mover(5);

        assertEquals(gladiador.calcularEnergia(), 15);

    }


}
