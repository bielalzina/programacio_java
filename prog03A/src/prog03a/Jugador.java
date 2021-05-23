/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog03a;

/**
 *
 * @author gabriel
 */
public class Jugador {
    private String nombre;
    private int edad;
    private byte nivel;

    public Jugador() {
    }

    public Jugador(String nombre, int edad, byte nivel) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(byte nivel) {
        this.nivel = nivel;
    }

}
