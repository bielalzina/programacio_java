
package exercici02;

import static exercici02.CadenAcabAmbNA.acabAmbNA;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CalculaEdat {

    public static void main(String[] args) {

        Scanner input;
        int any, mes, dia;

        System.out.println("INTRODUEIX DIA: ");
        input = new Scanner(System.in);
        dia = input.nextInt();

        System.out.println("INTRODUEIX MES: ");
        input = new Scanner(System.in);
        mes = input.nextInt();

        System.out.println("INTRODUEIX ANY: ");
        input = new Scanner(System.in);
        any = input.nextInt();

        LocalDate neixement = LocalDate.of(any, mes, dia);
        LocalDate avui = LocalDate.now();

        Period diff = Period.between(neixement, avui);

        System.out.printf("\nTenc %d anys, %d mesos i %d dies.\n",
                diff.getYears(), diff.getMonths(), diff.getDays());
    }
}
