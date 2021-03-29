/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog09joc;

/**
 *
 * @author gabriel
 */
public class Casella {

    // atributs
    private int fila;
    private int columna;

    // constructor
    public Casella() {
    }

    public Casella(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    //metodes
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

}
