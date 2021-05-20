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
public class Exercici02Exe02 {
    public static void main(String[] args){
     
        int[][] vector;
        vector = new int[4][4];
        int i;
        int j;
        
        for (i=0;i<vector.length;i++){
            for(j=0;j<vector[i].length;j++){
                vector[i][j]=i+j;
                System.out.print(vector[i][j]+"\t");
            }
            System.out.println("");
        }
        
        System.out.println("DIAGONAL PRINCIPAL");
        for (i=0;i<vector.length;i++){
            for(j=0;j<vector[i].length;j++){
                if (i==j){
                    System.out.print(vector[i][j]+"\t");
                } else {
                    System.out.print("\t");
                }
                
            }
            System.out.println("");
        }
        
        System.out.println("DIAGONAL SECUNDARIA");
        for (i=0;i<vector.length;i++){
            for(j=0;j<vector[i].length;j++){
                if ((i+j)==(vector.length-1)){
                    System.out.print(vector[i][j]+"\t");
                } else {
                    System.out.print("\t");
                }
                
            }
            System.out.println("");
        }
        
        System.out.println("DIAGONAL SECUNDARIA");
        for (i=0, j=vector.length-1;i<vector.length;i++,j--){
            System.out.print(vector[i][j]+"\t");
        }
        
        
        
    }
    
}
