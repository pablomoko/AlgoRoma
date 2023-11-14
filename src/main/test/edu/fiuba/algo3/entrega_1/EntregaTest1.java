package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregaTest1 {
    @Test
    public void test01VerificarQUeJugadorEmpiezaConEnergiaCorrespondiente() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, "messi");

        int energia = jugador.EnergiaGladiador();

        assertEquals(20,energia);
    }

    @Test
    public void test02VerificarQUeJugadorEmpiezaConEquipamientoCorrespondiente() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, "messi");

        List<Equipamiento> equipamiento = jugador.EquipamientoGladiador();

        assertEquals(null,equipamiento);
    }

    @Test
    public void test03VerificarQueunJugadorsinEnergíaNoPuedaJugarelTurno() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, "messi");

        jugador.setEnergia(0);

        assertEquals(false, jugador.sePuedeMover());
    }
    @Test
    public void test04VerificarSiRecibeComidaIncrementaEn10Energia() {
        Gladiador gladiador = new Gladiador();
        Jugador jugador = new Jugador(gladiador, "messi");

        int energia = jugador.EnergiaGladiador();
        jugador.alimentarGladiador();

        assertEquals((energia + 10),jugador.EnergiaGladiador());
    }

}
