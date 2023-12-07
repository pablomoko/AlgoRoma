package edu.fiuba.algo3.modelo.obstaculo;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Tirador;

public class Bacanal extends Obstaculo   {
    private Tirador dado;
    public Bacanal(Tirador dado){
        this.dado = dado;
    }
    public void afectarGladiador(Gladiador gladiador){
        gladiador.afectarEnergia(dado.tirarDado() * 4);
    }
}
