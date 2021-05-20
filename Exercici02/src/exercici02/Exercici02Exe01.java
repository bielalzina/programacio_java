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
public class Exercici02Exe01 {
    
    public static void main(String[] Args){
        int[] vector;
        vector = new int[10];
        int i;
        int max=150;
        int min=100;
        
        for (i=0; i<vector.length;i++){
            vector[i]=min+(int)(Math.random()*((max-min)+1));
           System.out.println("Vector["+i+"] = "+vector[i]);
        }
        
        
    }
    
}
