package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.estadoLesion.NoEstaLesionado;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.seniority.Seniority;

public interface Movible {

    public int mover(int unaCantidad);
    public boolean estaCompleto();

    public void vs(Obstaculo obstaculo);
    public void obtenerPremio(Premio premio);

    public Gladiador ganador();

    public boolean sosGanador();

    public boolean estaLesionado();

    public void habilitarMovimiento();

    public int calcularEnergia();

    public NivelEquipamiento getEquipamiento();

    public Seniority verSeniority();

    public void verificarEnergiaValida();

}
