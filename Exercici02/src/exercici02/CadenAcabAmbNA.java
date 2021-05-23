
package exercici02;

import java.util.Scanner;

public class CadenAcabAmbNA {

    public static void main(String[] args) {

        Scanner input;
        String cadena;

        System.out.println("INTRODUEIX CADENA: ");
        input = new Scanner(System.in);
        cadena = input.nextLine();
        
        System.out.println("La cadena introduida acaba amb (NA): "+acabAmbNA(cadena));

    }

    public static boolean acabAmbNA(String str) {
        String caractersFinals = "NA";
        str = str.toUpperCase();


        if (str.length() < 2) {
            return false;
        } else if (caractersFinals.equals(str.substring((str.length() - 2), str.length()))) {
            return true;
        } else {
            return false;
        }

    }
}
