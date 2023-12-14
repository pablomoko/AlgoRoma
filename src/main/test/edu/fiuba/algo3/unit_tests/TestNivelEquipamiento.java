package edu.fiuba.algo3.unit_tests;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento1;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento2;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento3;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento4;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento0;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestNivelEquipamiento {

    @Test
    public void test01SiguienteEquipamientoDelNivel0EsElNivelConCasco() {

        NivelEquipamiento equipamiento = new NivelEquipamiento0();
        equipamiento = equipamiento.siguienteNivel();

        assertEquals(equipamiento.usarEquipamiento(), 15);

    }

    @Test
    public void test02SiguienteEquipamientoDelNivel1EsElNivelConArmadura() {

        NivelEquipamiento equipamiento = new NivelEquipamiento1();
        equipamiento = equipamiento.siguienteNivel();

        assertEquals(equipamiento.usarEquipamiento(), 10);

    }

    @Test
    public void test03SiguienteEquipamientoDelNivel2EsElNivelConEscYEsp() {


        NivelEquipamiento equipamiento = new NivelEquipamiento2();
        equipamiento = equipamiento.siguienteNivel();

        assertEquals(equipamiento.usarEquipamiento(), 2);


    }


    @Test
    public void test04SiguienteEquipamientoDelNivel3EsElNivelConLlave() {

        NivelEquipamiento equipamiento = new NivelEquipamiento3();
        equipamiento = equipamiento.siguienteNivel();

        assertEquals(equipamiento.usarEquipamiento(), 0);

    }
}
