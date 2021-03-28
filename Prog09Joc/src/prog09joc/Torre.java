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
public class Torre extends Fitxa{
    // atributs
    protected int vides;
    
    //constructor

    public Torre() {
    }
    
    
    
    //metodes

    public int getVides() {
        return vides;
    }

    public void setVides(int vides) {
        this.vides = vides;
    }

    
    // Metode moureA()
    @Override
    public boolean moureA(Casella c) {
        int filaFutura=c.getFila();
        int columnaFutura=c.getColumna();
        int filaActual=this.getPosicio().getFila();
        int columnaActual=this.getPosicio().getColumna();
        if (filaFutura==filaActual && columnaFutura==columnaActual){
            // LA FITXA NO ES MOU, LA NOVA POSICIÓ COINCIDEIX AMB L'ACTUAL
            System.out.println("\u001B[31mES OBLIGATORI MOURE LA FITXA!!!\u001B[0m");
            return false;
        } else if (filaFutura==filaActual || columnaFutura==columnaActual){
            // LA TORRE ES POT MOURE EN VERTICAL O HORITZONTAL, EL MOVIMENT SERA VALID
            // SI ES MOU EN LA MATEIXA FILA (filaFutura==filaActual)
            // O
            // SI ES MOU EN LA MATEIXA COLUMNA (columnaFutura==columnaActual)
            return true;
        }else{
            //MOVIMENT NO PERMÉS PER LA TORRE
            System.out.println("\u001B[31mLA TORRE NOMÉS ES POT MOURE HORITZONTALMENT O VERTICAMENT!!!\u001B[0m");
            return false;
        }
    }
    
}
