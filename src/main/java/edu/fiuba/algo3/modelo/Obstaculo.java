package edu.fiuba.algo3.modelo;

public abstract class Obstaculo {
    public abstract void obstaculizar(Gladiador gladiador);
}

class FieraSalvajeHambrienta extends Obstaculo{
    public void obstaculizar(Gladiador gladiador){
        gladiador.pelearContraFiera();
    }
}
