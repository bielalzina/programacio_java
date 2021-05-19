/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_03;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Exercici01_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        boolean inputOk=false;
        double fact=1;
        System.out.println("Introdueix un numero sencer: ");
        
        
        do {
            try {
                int num = input.nextInt();
                for (int i = 1; i <= num; i++) {
                    fact = fact * i;
                }
                System.out.println("FACTORIAL = " + fact);
                inputOk=true;

            } catch (Exception e) {
                System.out.println("Ha de ser un numero sencer. Introdueix un nou numero: ");
                input.next();
            }

        } while (!inputOk);

    }

}
