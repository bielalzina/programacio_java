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
public abstract class Fitxa {
    
    //atributs
    protected Casella posicio;
    protected String color;
    
    //Constructors

    public Fitxa() {
    }
    
    
    // Metodes

    public Casella getPosicio() {
        return posicio;
    }

    public void setPosicio(Casella posicio) {
        this.posicio = posicio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // metode moureA
    public abstract boolean moureA(Casella c);

    
    
    
}
