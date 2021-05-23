package exercici02;

import java.util.Scanner;

public class TrobarPosicioElementArray {

    public static void main(String[] args) {
        int[] numeros = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160};
        Scanner input;
        int numero;
        System.out.println("DE QUIN NUMERO VOLS TROBAR LA SEVA POSICIÓ: ");
        input = new Scanner(System.in);
        numero = input.nextInt();

        if (trobaIndex(numeros, numero) == -1) {
            System.out.println("NO EXISTEIX AQUEST NUMERO EN ARRAY");

        } else {
            System.out.println("EL NUMERO " + numero + " OCUPA LA POSICIO: " + trobaIndex(numeros, numero));
        }

    }

    private static int trobaIndex(int[] vector, int numero) {
        int i;

        for (i = 0; i < vector.length; i++) {
            if (vector[i] == numero) {
                return i;
            }
        }
        return -1;
    }

}
