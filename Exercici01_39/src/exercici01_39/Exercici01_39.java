/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_39;

/**
 *
 * @author bielalzina
 */
public class Exercici01_39 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,j,k,possibles;
        i=1;
        j=1;
        k=1;
        possibles=0;
        
        
        for (i=1;i<5;i++){
            for (j=1;j<5;j++){
                for (k=1;k<5;k++){
                    if (i!=j && i!=k && j!=k){
                        System.out.println(i+""+j+""+k);
                        possibles++;
                        
                    }
                }
            }
        }
        
        System.out.println("Digits possibles: "+possibles);
    }
    
}
