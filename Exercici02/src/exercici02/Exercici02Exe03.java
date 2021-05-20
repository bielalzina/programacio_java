/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici02;

/**
 *
 * @author gabriel
 */
public class Exercici02Exe03 {
     public static void main(String[] Args){
        int[] vector;
        vector = new int[10];
        int i;
        int max=10;
        int min=1;
        
        for (i=0; i<vector.length;i++){
            vector[i]=min+(int)(Math.random()*((max-min)+1));
           //System.out.println("Vector["+i+"] = "+vector[i]);
        }
         System.out.println("VALORS ARRAY:");
        mostraArray(vector);
         System.out.println("");
         System.out.println("SUMA ARRAY: "+sumaArray(vector));
    
        
        
    }
     
     
     public static void mostraArray(int[] array){
         int i;
         for (i=0; i<array.length;i++){
             System.out.print(array[i]+"\t");
         }
         System.out.println("");
     }
     
     public static int sumaArray(int[] array){
         int i;
         int suma=0;
         for (i=0; i<array.length;i++){
             suma=suma +array[i];
         }
         return suma;
     }
}
