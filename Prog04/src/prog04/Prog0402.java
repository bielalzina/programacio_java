

package prog04;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Prog0402 {

    public static void main(String[] args) {

        Scanner inputNom;
        Scanner inputEdat;

        String nom;
        int edat;
        boolean edatOK = false;

        System.out.println("NOM: ");
        inputNom = new Scanner(System.in);
        nom = inputNom.nextLine();

        do {
            try {
                System.out.println("EDAT");
                inputEdat = new Scanner(System.in);
                edat = inputEdat.nextInt();
                if (edat > 0) {
                    edatOK = true;
                    String blocEdat;
                    int edatFutura = edat + 10;

                    if (edatFutura <= 25) {
                        blocEdat = "A[0-25]";
                    } else if (edatFutura <= 50) {
                        blocEdat = "B[26-50]";
                    } else {
                        blocEdat = "C[51-...]";
                    }
                    System.out.println(nom + ", d'aqui 10 anys tendras " + edatFutura + " anys, i estaras en el bloc: " + blocEdat);

                } else {
                    System.out.println("HAS INTRODUÏT UNA EDAT NEGATIVA!!!");

                }

            } catch (Exception e) {
                System.out.println("HAS INTRODUÏT UNA EDAT INCORRECTE!!");
            }

        } while (!edatOK);

    }

}
