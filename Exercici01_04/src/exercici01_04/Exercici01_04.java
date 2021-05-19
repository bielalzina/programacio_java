/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_04;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Exercici01_04 {

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
        for (int i = 1; i <= num; i++) {
                    fact = fact * i;
        }
        return fact;
    }
    
    
    
}
