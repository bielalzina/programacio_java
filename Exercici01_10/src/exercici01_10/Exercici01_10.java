/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_10;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Exercici01_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        double num1=0, num2=0, num3=0, major=0;
        boolean entradaNum1OK=false;
        boolean entradaNum2OK=false;
        boolean entradaNum3OK=false;
        
        System.out.println("Introdueix el primer numero: ");
        
        do {
            try {
                num1 = input.nextDouble();
                entradaNum1OK = true;
            } catch (Exception e) {
                System.out.println("No has introduit un nombre correcte. Torna a provar-ho: ");
                input.next();
            }
        } while (!entradaNum1OK);
        
        major=num1;
        
        System.out.println("Introdueix el segon numero: ");
        
        do {
            try {
                num2 = input.nextDouble();
                entradaNum2OK = true;
            } catch (Exception e) {
                System.out.println("No has introduit un nombre correcte. Torna a provar-ho: ");
                input.next();
            }
        } while (!entradaNum2OK);
        
        if (num2>major){
            major=num2;
        }

        System.out.println("Introdueix el tercer numero: ");
        
        do {
            try {
                num3 = input.nextDouble();
                entradaNum3OK = true;
            } catch (Exception e) {
                System.out.println("No has introduit un nombre correcte. Torna a provar-ho: ");
                input.next();
            }
        } while (!entradaNum3OK);
        
         if (num3>major){
            major=num3;
        }   
        
        
        
        System.out.println("MAJOR = "+major);
        
    }
    
}
