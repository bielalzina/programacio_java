
package exercici02;

import java.util.Arrays;
import java.util.Scanner;

public class CercaBinaria {

    public static void main(String[] args) {

        int[] vector = new int[]{12, 3, 5, 21, 4, 85, 6, 9, 2, 1, 99};
        System.out.println("ELEMENTS VECTOR: " + Arrays.toString(vector));
        System.out.println("");

        //ORDENAM VECTOR
        vector = Arrays.stream(vector).sorted().toArray();
        System.out.println("ELEMENTS VECTOR: " + Arrays.toString(vector));
        System.out.println("");

        Scanner input;
        int numero;
        System.out.println("DE QUIN NUMERO VOLS TROBAR LA SEVA POSICIÓ: ");
        input = new Scanner(System.in);
        numero = input.nextInt();

        int n = vector.length;
        int inf = 0;
        int centro = 0;
        int sup = n - 1;
        boolean bandera = false;

        while (inf <= sup) {
            centro = (sup + inf) / 2;

            if (vector[centro] == numero) {

                bandera = true;
                break;
            } else if (numero < vector[centro]) {
                sup = centro - 1;
            } else {
                inf = centro + 1;
            }

        }

        if (bandera) {
            System.out.println("El numero " + numero + " es troba en la posició: " + (centro + 1));
        } else {
            System.out.println("El numero " + numero + " NO existeix en l'array");
        }

    }

}
