
package exercici01_03;

import java.util.Scanner;

public class Exercici01_03 {

    public static void main(String[] args) {
        
        Scanner input;
        boolean inputOk;
        double fact;
        int num;
        int i;
        

        do {

            try {

                System.out.println("Introdueix un numero sencer: ");
                input = new Scanner(System.in);
                num = input.nextInt();
                fact=1;

                for (i = 1; i <= num; i++) {
                    fact = fact * i;
                }

                System.out.println("FACTORIAL = " + fact);
                inputOk=true;

            } catch (Exception e) {
                System.out.println("Ha de ser un numero sencer. "
                        + "Introdueix un nou numero: ");
                inputOk=false;
            }

        } while (!inputOk);
    }
}
