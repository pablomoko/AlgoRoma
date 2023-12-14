package edu.fiuba.algo3.modelo.obstaculo;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.Tirador;

public class Bacanal extends Obstaculo   {
    private Tirador dado;

    private int resultadoDado;
    public Bacanal(Tirador dado){
        this.dado = dado;
    }
    public void afectarGladiador(Gladiador gladiador){
        int resultadoDado = dado.tirarDado();
        this.resultadoDado = resultadoDado;
        gladiador.afectarEnergia(resultadoDado * 4);
    }

    public int getResultadoDado() {
        return this.resultadoDado;
    }
}
