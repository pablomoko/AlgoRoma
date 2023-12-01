package edu.fiuba.algo3.modelo.obstaculo;
import edu.fiuba.algo3.modelo.Gladiador;

public class Fiera extends Obstaculo{
    public Fiera(){};

    public void afectarGladiador(Gladiador gladiador){

        gladiador.afectarEnergia(gladiador.usarEquipamiento());
    }
}
