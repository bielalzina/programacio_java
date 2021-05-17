/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_01;

/**
 *
 * @author gabriel
 */
public class Exercici01_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num=10;
        int fact=1;
        for (int i=1;i<=num;i++){
            fact=fact*i;
        }
        System.out.println("FACTORIAL = "+fact);
    }
    
}
