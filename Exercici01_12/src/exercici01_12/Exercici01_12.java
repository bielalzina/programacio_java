/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici01_12;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Exercici01_12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        double num1=0, num2=0, num3=0, num4=0, num5=0, mitjana=0;
        boolean entradaNum1OK=false;
        boolean entradaNum2OK=false;
        boolean entradaNum3OK=false;
        boolean entradaNum4OK=false;
        boolean entradaNum5OK=false;
        
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
        
        System.out.println("Introdueix el quart numero: ");
        
        do {
            try {
                num4 = input.nextDouble();
                entradaNum4OK = true;
            } catch (Exception e) {
                System.out.println("No has introduit un nombre correcte. Torna a provar-ho: ");
                input.next();
            }
        } while (!entradaNum4OK);
        
        System.out.println("Introdueix el tercer numero: ");
        
        do {
            try {
                num5 = input.nextDouble();
                entradaNum5OK = true;
            } catch (Exception e) {
                System.out.println("No has introduit un nombre correcte. Torna a provar-ho: ");
                input.next();
            }
        } while (!entradaNum5OK);
        
        mitjana = (num1+num2+num3+num4+num5)/5;
        System.out.println("MITJANA = "+mitjana);
        
                
    
    }
    
}
