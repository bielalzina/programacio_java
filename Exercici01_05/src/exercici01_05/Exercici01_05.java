/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_05;

import java.util.Scanner;

/**
 *
 * @author bielalzina
 */
public class Exercici01_05 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        boolean inputOk=false;
        System.out.println("Introdueix un numero sencer: ");
        
        
        do {
            try {
                int num = input.nextInt();
                double resultat = factorial(num);
                System.out.println("FACTORIAL = " + resultat);
                inputOk=true;

            } catch (Exception e) {
                System.out.println("Ha de ser un numero sencer. Introdueix un nou numero: ");
                input.next();
            }

        } while (!inputOk);
    }
    
    public static double factorial(int num){
        double fact=1;
        int i=1;
        do {
            fact=fact*i;
            i++;
        } while (i<=num);
        
        return fact;
    }
    
    
}
