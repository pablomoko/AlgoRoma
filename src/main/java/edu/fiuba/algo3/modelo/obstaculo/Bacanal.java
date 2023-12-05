package edu.fiuba.algo3.modelo.obstaculo;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Dado;

public class Bacanal extends Obstaculo   {
    public Bacanal(){}
    public void afectarGladiador(Gladiador gladiador){
        Dado dado = new Dado();
        gladiador.afectarEnergia(dado.tirarDado() * 4);
    }
}
