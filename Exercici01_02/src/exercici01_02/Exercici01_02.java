/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_02;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Exercici01_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Introdueix un numero sencer: ");
        int num = input.nextInt();
        double fact=1;
        for (int i=1;i<=num;i++){
            fact=fact*i;
        }
        System.out.println("FACTORIAL = "+fact);
        
        
        
    }
    
}
