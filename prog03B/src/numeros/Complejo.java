/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeros;

/**
 *
 * @author gabriel
 */
public class Complejo {
    private double real;
    private double imag;

    public Complejo(){
        
    }
    public Complejo(double real, double imag) {
        this.real=real;
        this.imag=imag;
    }
    
    public double getReal(){
        return real;
    }
    
    public double getImag(){
        return imag;
    }
    
    public void setReal(double real){
        this.real=real;
    }
    
    public void setImag(double imag){
        this.imag=imag;
    }
    
    public String toString(){
        String cadena;
        String signe ="+";
        if (this.imag<0){
            signe ="";
        }
        cadena = this.real+signe+ this.imag + "i";
        return cadena;
    }
    
    public void sumar(Complejo b){
        
        this.real=this.getReal()+b.getReal();
        this.imag=this.getImag()+b.getImag();
    }

    
}
