/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_07;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Exercici01_07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        Scanner input = new Scanner (System.in);
        System.out.println("Introdueix el primer numero: ");
        Double num1 = input.nextDouble();
               
        System.out.println("Introdueix el segon numero: ");
        Double num2 = input.nextDouble();
               
        System.out.println("Introdueix el tercer numero: ");
        Double num3 = input.nextDouble();
        
        if (num1 > num2){
            if (num1 > num3){
                System.out.println("NUMERO MAJOR = "+num1);
            }
        }
        
        if (num2 > num1){
            if (num2 > num3){
                System.out.println("NUMERO MAJOR = "+num2);
            }
        }
        
        if (num3 > num2){
            if (num3 > num1){
                System.out.println("NUMERO MAJOR = "+num3);
            }
        }
        
        
    }
    
}
