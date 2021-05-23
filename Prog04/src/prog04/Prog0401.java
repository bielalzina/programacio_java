/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog04;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Prog0401 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input;
        

        int numero;

        boolean entradaNumerOK = false;

        do {

            try {
                System.out.println("Introdueix NUMERO SENCER: ");
                input = new Scanner(System.in);
                numero = input.nextInt();

                if (numero % 2 == 0) {

                    if (numero % 3 == 0) {
                        System.out.println(numero + " ES PARELL i MULTIPLE DE 3");
                    } else {
                        System.out.println(numero + " ES PARELL");
                    }

                } else if (numero % 3 == 0) {
                    System.out.println(numero + " ES MULTIPLE DE 3");
                } else {
                    System.out.println(numero + " NO ES PARELL NI MULTIPLE DE 3");
                }
                entradaNumerOK=true;
                
            } catch (Exception e){
                System.out.println("No has introduït un nom SENCER!!!");
            }

        } while (!entradaNumerOK);
    }

}
