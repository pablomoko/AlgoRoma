package edu.fiuba.algo3.modelo.premio;

import edu.fiuba.algo3.modelo.Ubicable;
import edu.fiuba.algo3.modelo.Gladiador;

public abstract class Premio implements Ubicable {
    abstract public void afectarGladiador(Gladiador gladiador);
}
