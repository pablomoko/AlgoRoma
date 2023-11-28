package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.premio.equipamiento.Llave;
import edu.fiuba.algo3.modelo.premio.equipamiento.Casco;
import edu.fiuba.algo3.modelo.premio.equipamiento.Armadura;
import edu.fiuba.algo3.modelo.premio.equipamiento.EscYEsp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEquipamiento {

    @Test
    public void test01SeUsaUnCascoYSeDevuelveQuince() {

        Casco casco = new Casco();

        assertEquals(casco.usar(),15);


    }

    @Test
    public void test02SiguienteEquipamientoDeLaCascoEsLaArmadura() {

        Casco casco = new Casco();

        assertEquals(casco.siguienteEquipamiento().getClass(), new Armadura().getClass());

    }

    @Test
    public void test03SeUsaUnaArmaduraYSeDevuelveDiez() {

        Armadura armadura = new Armadura();

        assertEquals(armadura.usar(),10);


    }

    @Test
    public void test04SiguienteEquipamientoDeLaArmaduraEsElEscudoYLaEspada() {

        Armadura armadura = new Armadura();

        assertEquals(armadura.siguienteEquipamiento().getClass(), new EscYEsp().getClass());

    }

    @Test
    public void test05SeUsaUnEscudoYEspadaYSeDevuelveDos() {

        EscYEsp escYEsp = new EscYEsp();

        assertEquals(escYEsp.usar(),2);


    }

    @Test
    public void test06SiguienteEquipamientoDelEscudoYLaEspadaEsLaLLave() {

        EscYEsp escYEsp = new EscYEsp();

        assertEquals(escYEsp.siguienteEquipamiento().getClass(), new Llave().getClass());

    }

    @Test
    public void test07SeUsaUnaLlaveYSeDevuelveCero() {

        Llave llave = new Llave();

        assertEquals(llave.usar(),0);


    }

}
