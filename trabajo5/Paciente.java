/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo5;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author david
 */
public class Paciente implements Serializable {

    private String nombre, edad;
    //riesgo para enfermedades previas
    private boolean reisgo;

    public Paciente(String nombre, String edad, boolean reisgo) {
        this.nombre = nombre;
        this.edad = edad;
        this.reisgo = reisgo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public boolean isReisgo() {
        return reisgo;
    }

    public void setReisgo(boolean reisgo) {
        this.reisgo = reisgo;
    }

    public int getPresion() {
        return new Random().nextInt(100);
    }

    public int getTemperatura() {
        return new Random().nextInt(100);
    }

    public int getRitmoCardiaco() {
        return new Random().nextInt(100);
    }
}
