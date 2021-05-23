
package exercici02;

import java.util.Arrays;


public class InvertirArray {
    
    public static void main(String[] args){
        
        int[] numeros = {10,20,30,40,50,60,70,80,90,100};
        int i;
        
        System.out.println("ARRAY ORIGINAL: "+Arrays.toString(numeros));
        
        //for (i=0; i<numeros.length;i++){
        //    System.out.print(numeros[i]+"\t");
        //}
        
        // INVERTIM ARRAY
        
        int transportador;
        for (i=0; i<numeros.length/2;i++){
            transportador=numeros[i];
            numeros[i]=numeros[numeros.length-i-1];
            numeros[numeros.length-i-1]=transportador;
        }
        
        System.out.println("");
        
        System.out.println("ARRAY INVERTIT: "+Arrays.toString(numeros));
        
        //for (i=0; i<numeros.length;i++){
        //    System.out.print(numeros[i]+"\t");
        //}
        
        System.out.println("");
    }
}
