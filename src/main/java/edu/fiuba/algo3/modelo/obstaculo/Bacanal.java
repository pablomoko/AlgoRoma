package edu.fiuba.algo3.modelo.obstaculo;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Dado;

import java.util.Random;

public class Bacanal extends Obstaculo implements Dado {
    public Bacanal(){};

    public int tirarDado() {
        return new Random().nextInt(6 - 1 + 1) + 1;
    }
    public void afectarGladiador(Gladiador gladiador){
        gladiador.afectarEnergia(tirarDado() * 4);
    }
}
