package exercici3parta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Escola {

    public static void main(String[] args) {

        Curs ifcp33;
        Assignatura prog;
        Assignatura bbdd;

        System.out.println("\n********3A********\n");
        ifcp33 = new Curs("IFC33-P", 60);
        System.out.println("NOM: " + ifcp33.getNom());
        System.out.println("NUMERO ALUMES: " + ifcp33.getNumAlumnes());
        System.out.println(ifcp33.toString());
        System.out.println("");

        try {

            System.out.println("\n********3B********\n");
            prog = new Assignatura();
            prog.setNom("PROGRAMACIÓ");
            prog.setHoresSetmanals(7);

            System.out.println("\n********3C********\n");
            bbdd = new Assignatura("BASE DE DADES", 8);

            System.out.println(prog);
            System.out.println(bbdd.toString());
            System.out.println("HORES ANUALS " + prog.getNom() + ": " + prog.cacularHoresAnuals());
            System.out.println("HORES ANUALS " + bbdd.getNom() + ": " + bbdd.cacularHoresAnuals());
            System.out.println("HORES SETMANALS (" + prog.getNom() + " + " + bbdd.getNom() + "): " + (prog.getHoresSetmanals() + bbdd.getHoresSetmanals()));

            System.out.println("\n********3E********\n");
            Scanner input = new Scanner(System.in);
            System.out.println("NUMERO D'HORES SETAMANALS DEL MÒDUL " + bbdd.getNom() + ": ");
            bbdd.setHoresSetmanals(input.nextInt());
            System.out.println(bbdd.toString());

            System.out.println("\n********4********\n");
            Assignatura2 iso = new Assignatura2("IMPLANTACIÓ DE SISTEMES OPERATIUS", 3, ifcp33);
            System.out.println(iso);

        } catch (InputMismatchException e) {
            //missatge de les excepcions del mètode nextInt()
            System.out.println("S'ha d'introduir un número sencer tipus int");
        } catch (Exception ex) {
            //missatge de les excepcions dels mètodes de Assignatura
            System.out.println(ex.getMessage());
        }

    }

}
