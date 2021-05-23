package prog04;

import java.util.Scanner;

public class Prog0403 {

    public static void main(String[] args) {
        Scanner input;
        String nom;
        int min = 0;
        int max = 0;
        boolean minOK = false;
        boolean maxOK = false;

        System.out.println("NOM");
        input = new Scanner(System.in);
        nom = input.nextLine();

        do {
            try {
                System.out.println("Introdueix MINIM: ");
                input = new Scanner(System.in);
                min = input.nextInt();
                if (min >= 0) {
                    minOK = true;
                } else {
                    System.out.println("Has introduït un numero negatiu!!");
                }

            } catch (Exception e) {
                System.out.println("Has introduït un numero incorrecte");
            }

        } while (!minOK);

        do {
            try {
                System.out.println("Introdueix MAXIM: ");
                input = new Scanner(System.in);
                max = input.nextInt();
                if (min < max) {
                    maxOK = true;
                } else {
                    System.out.println("Has introduït un numero < MINIM!!");
                }

            } catch (Exception e) {
                System.out.println("Has introduït un numero incorrecte");
            }

        } while (!maxOK);

        int numero = min + (int) (Math.random() * (max - min + 1));
        //System.out.println(numero);

        int intents = 10;
        int numIntro = 0;
        boolean numIntrOK = false;
        boolean encert = false;

        for (int i = 1; i < 11; i++) {
            do {
                try {

                    System.out.println(nom + ", introduce tu intento " + i + " para adivinar el número del intervalo [" + min + ".." + max + "]: ");
                    input = new Scanner(System.in);
                    numIntro = input.nextInt();
                    numIntrOK = true;
                    intents--;

                } catch (Exception e) {
                    System.out.println("Has introduït un numero incorrecte");
                }

            } while (!numIntrOK);

            if (numIntro == numero) {
                System.out.println("Felicitats!!");
                encert = true;
                break;
            } else if (numIntro < numero) {
                System.out.println("MES ALT!!");
            } else {
                System.out.println("MES BAIX");
            }

        }

        System.out.println("Has fet servir: " + (10 - intents) + " intents");
        System.out.println("Numero a CERCAR: " + numero);
        if (encert) {
            System.out.println("Has encertat el numero");
        } else {
            System.out.println("NO as encertat el numero");
        }

    }

}
