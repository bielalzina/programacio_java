package exercici02;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Exercici02Exe04 {

    public static void main(String[] Args) {
        
        Exercici02Exe04 nouVector = new Exercici02Exe04();
        
        Exercici02Exe03.mostraArray(nouVector.generArray(10, 1, 20));
        Exercici02Exe03.mostraArray(nouVector.generArray(5, 100, 225));
         Exercici02Exe03.mostraArray(nouVector.generArray(25, 25, 50));

    }
    
    public int[] generArray(int longitud, int min, int max){
        int[] vector;
        vector = new int[longitud];
        int i;
        
        for (i=0; i<vector.length;i++){
            vector[i] = min + (int) (Math.random() * ((max - min) + 1));
        }
        
        return vector;
        
    }

}
