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
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }
}
