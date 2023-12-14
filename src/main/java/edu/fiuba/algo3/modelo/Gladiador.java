package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.estadoGanador.EsGanador;
import edu.fiuba.algo3.modelo.estadoGanador.NoEsGanador;
import edu.fiuba.algo3.modelo.estadoLesion.EstaLesionado;
import edu.fiuba.algo3.modelo.estadoLesion.NoEstaLesionado;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento;
import edu.fiuba.algo3.modelo.nivelEquipamiento.NivelEquipamiento0;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.premio.Comida;
import edu.fiuba.algo3.modelo.seniority.*;
import edu.fiuba.algo3.modelo.estadoGanador.EstadoGanador;
import edu.fiuba.algo3.modelo.estadoLesion.EstadoLesion;

public class Gladiador implements Movible{
    private Energia energia;
    private NivelEquipamiento equipamiento;
    private Seniority seniority;
    private EstadoGanador estadoGanador;
    private EstadoLesion estadoLesion;


    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = new NivelEquipamiento0();
        this.seniority = new Novato();
    }

    public Gladiador(int energia){
        this.energia = new Energia(energia);
        this.equipamiento = new NivelEquipamiento0();
        this.seniority = new Novato();
    }

    public Gladiador(int energia, Seniority seniority){
        this.energia = new Energia(energia);
        this.equipamiento = new NivelEquipamiento0();
        this.seniority = seniority;
        this.estadoGanador = new NoEsGanador();
        this.estadoLesion = new NoEstaLesionado();
    }

    public void vs(Obstaculo obstaculo){
        obstaculo.afectarGladiador(this);
    }

    public void obtenerPremio(Premio premio){
        premio.afectarGladiador(this);
    }

    public int calcularEnergia(){
        return (this.energia.calcularEnergia());
    }

    public int alimentarse(Comida unaComida){
        afectarEnergia(-unaComida.caclularValorEnergetico());
        return energia.calcularEnergia();
    }

    public NivelEquipamiento equiparse(){
        equipamiento = equipamiento.siguienteNivel();
        return equipamiento;
    }

    public int usarEquipamiento() {
        return equipamiento.usarEquipamiento();
    }

    public void afectarEnergia(int unaCantidad){
        this.energia.disminuirEnergia(unaCantidad);
        //this.verificarEnergiaValida();

    }

    public int mover(int unaCantidad){
        this.aumentarTurno();
        if(energia.calcularEnergia() > 0) {
            this.seniority.sumarPasos(unaCantidad);
            energia.disminuirEnergia(1);
            return unaCantidad;
        }else{
            return 0;
        }
    }

    public void verificarEnergiaValida(){
        if(energia.calcularEnergia() <= 0){
            this.lesionarse();
            this.energia.aumentarEnergia(5);
        }
    }

    public void aumentarTurno(){
        this.seniority = this.seniority.sumarTurno();
        this.energia = this.seniority.plusDeEnergia(this.energia);
    }

    public Seniority verSeniority(){
        return this.seniority;
    }

    public boolean estaCompleto() {
        return (this.equipamiento.usarEquipamiento() == 0);
    }

    public NivelEquipamiento getEquipamiento() {
        return equipamiento;
    }

    public Gladiador ganador(){
        estadoGanador = new EsGanador();
        return this;
    }
    public Gladiador perdedor(){
        estadoGanador = new NoEsGanador();
        return this;
    }
    public boolean sosGanador(){
        return (estadoGanador.estado());
    }

    public boolean estaLesionado(){
        return (estadoLesion.estado());
    }

    public void lesionarse(){
        estadoLesion = new EstaLesionado();
    }

    public void habilitarMovimiento(){
        estadoLesion = new NoEstaLesionado();
    }

}
