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
public class Alfil extends Fitxa{
    // atributs
    protected Casella bloc;
    
    
    //constructor

    public Alfil() {
    }

    //metodes

    public Casella getBloc() {
        return bloc;
    }

    public void setBloc(Casella bloc) {
        this.bloc = bloc;
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
        } else if (Math.abs(filaFutura-filaActual)==Math.abs(columnaFutura-columnaActual)){
            // LA ALFIL ES POT MOURE EN DIAGONAL, EL MOVIMENT SERA VALID
            // SI LA DIFERENCIA ABSOLUTA ENTRE LES POSICIONS ACTUAL I FUTURA DE LES FILES ES IGUAL A
            // LA DIFERENCIA ABSOLUTA ENTRE LES POSICIONS ACTUAL I FUTURA DE LES FILES
            // 
            return true;
        }else{
            //MOVIMENT NO PERMÉS PER L'ALFIL
            System.out.println("\u001B[31mL'ALFIL NOMÉS ES POT MOURE DIAGONALMENT!!!\u001B[0m");
            return false;
        }
    }

    
            
    
}
