package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.Ubicable;
import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Obstaculo implements Ubicable {
    public abstract void afectarGladiador(Gladiador gladiador);
}
