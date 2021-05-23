
package exercici02;

import java.util.Arrays;


public class Tenim0o1 {
    
    public static void main(String[] args){
        int[] numeros = new int[10];
        
        int i;
        int max=6;
        int min=-6;
                
        for (i=0; i<numeros.length;i++){
           numeros[i] = min+(int)(Math.random()*((max-min)+1));
           
        }
        
        System.out.println("NUMEROS: "+Arrays.toString(numeros));
        
        System.out.println("HI HA 0 o -1 EN ARRAY: "+cerca(numeros));
        
        
 
    }
    
    public static boolean cerca(int[] numeros){
        
        for (int numero : numeros){
            if(numero==0 || numero==-1){
                return true;
            }
        }
        
        return false;

    }
 
}
