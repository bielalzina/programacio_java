package cuenta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AplicacionCuentaBancaria {

    public static void main(String[] args) {

        AplicacionCuentaBancaria aplicacio = new AplicacionCuentaBancaria();

        CuentaBancaria ccA;
        ccA = new CuentaBancaria();
        CuentaBancaria ccB;
        ccB = new CuentaBancaria();

        // TITULAR COMPTE A
        aplicacio.afegeixNom(ccA, "A");

        // NUM COMPTE A
        aplicacio.afegeixNum(ccA, "A");

        // TITULAR COMPTE B
        aplicacio.afegeixNom(ccB, "B");

        // NUM COMPTE B
        aplicacio.afegeixNum(ccB, "B");

        System.out.println("\nNOM TITULAR A: " + ccA.getNom());
        System.out.println("NUM COMPTE CORRENT A: " + ccA.getCc() + "\n");
        System.out.println("\nNOM TITULAR B: " + ccB.getNom());
        System.out.println("NUM COMPTE CORRENT B: " + ccB.getCc() + "\n");

        byte opcio = 0;
        do {
            opcio = aplicacio.menuOpcions();
            switch (opcio) {
                case 1 ->
                    System.out.println("\nNUMERO COMPTE CORRENT COMPLET: " + ccA.getCc());
                case 2 ->
                    System.out.println("\nNOM TITULAR: " + ccA.getNom());
                case 3 ->
                    System.out.println("\nENTITAT: " + ccA.getEntitat());
                case 4 ->
                    System.out.println("\nOFICINA: " + ccA.getOficina());
                case 5 ->
                    System.out.println("\nNUMERO COMPTE CORRENT: " + ccA.getNumCC());
                case 6 ->
                    System.out.println("\nDIGITS CONTROL: " + ccA.getDC());
                case 7 ->
                    aplicacio.ingresarEnCompte(ccA);
                case 8 ->
                    aplicacio.retirarDeCompte(ccA);
                case 9 ->
                    aplicacio.transferirAtoB(ccA, ccB);
                case 10 ->
                    System.out.println("\nSALDO: " + ccA.getSaldo());
                case 0 ->
                    System.out.println("\n" + "\u001B[32mPROGRAMA FINALITZAT.\u001B[0m" + "\n");
                default ->
                    System.out.println("\n" + "\u001B[31mAQUESTA OPCIÓ NO EXISTEIX.\u001B[0m" + "\n");

            }
        } while (opcio != (byte) 0);

    }

    public void afegeixNom(CuentaBancaria obj, String AoB) {

        Scanner input;
        boolean dadesOK = false;

        do {
            System.out.println("NOM TITULAR COMPTE CORRENT " + AoB + " (minim 3 caracters i màxim de 15 caracters): ");
            input = new Scanner(System.in);
            String nom = input.nextLine();

            try {
                obj.setNom(nom);
                dadesOK = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (!dadesOK);

    }

    public void afegeixNum(CuentaBancaria obj, String AoB) {

        Scanner input;
        boolean dadesOK = false;

        do {
            System.out.println("NUMERO COMPTE CORRENT " + AoB + " (20 DIGITS): ");
            input = new Scanner(System.in);
            String num = input.nextLine();

            try {
                obj.setCc(num);
                dadesOK = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (!dadesOK);

        System.out.println("NUMERO COMPTE CORRENT " + AoB + ": " + obj.getCc());
    }

    //MENU OPCIONS
    private byte menuOpcions() {

        Scanner entrada = new Scanner(System.in);
        byte op;

        System.out.println("\nOPCIONS");
        System.out.println("----------------\n");

        System.out.println("\n1. Ver el número de cuenta completo (CCC - Código Cuenta Cliente)");
        System.out.println("2. Ver el titular de la cuenta.");
        System.out.println("3. Ver el código de la entidad.");
        System.out.println("4. Ver el código de la oficina.");
        System.out.println("5. Ver el número de la cuenta (solamente el número de cuenta, sin entidad, oficina ni dígitos de control).");
        System.out.println("6. Ver los dígitos de control de la cuenta.");
        System.out.println("7. Realizar un ingreso. Habrá que solicitar por teclado la cantidad que se desea ingresar. Siempre se mostrará el saldo final.");
        System.out.println("8. Retirar efectivo. Una vez mostrado el saldo inicial, habrá que solicitar por teclado la cantidad que se desea retirar. Siempre se mostrará el saldo final.");
        System.out.println("9. Transferencia entre cuentas.  Se transferirá la cantidad deseada a la cuenta B. Siempre se mostrará el saldo final de las dos cuentas.");
        System.out.println("10. Mostra el saldo.");
        System.out.println("0. SORTIR DEL PROGRAMA");

        System.out.print("\nINTRODUEIX L'OPCIÓ: ");

        try {
            op = entrada.nextByte();
        } catch (InputMismatchException e) {

            // SI USUARI NO INTRODUEIX VALOR TIPUS BYTE, ASSIGNAM A OP EL VALOR -1
            // EL QUAL MAI EXISTIRÀ EN LA LLISTA D'OPCIONS. EL CASE APLICA DEFAULT
            // QUE ENS TORNA ENVIAR A AQUEST METODE
            op = -1;
        }

        return op;

    }

    public void ingresarEnCompte(CuentaBancaria obj) {

        Scanner input;
        boolean dadesOK = false;
        String quantitat = null;

        do {
            System.out.println("IMPORT A INGRESSAR: ");
            input = new Scanner(System.in);
            quantitat = input.nextLine();

            try {
                obj.ingressar(quantitat);
                System.out.println("INGRES REALITZAT CORRECTAMENT");
                System.out.println("\nSALDO FINAL: " + obj.getSaldo());
                dadesOK = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (!dadesOK);

    }

    public void retirarDeCompte(CuentaBancaria obj) {

        Scanner input;
        boolean dadesOK = false;
        String quantitat = null;

        do {
            System.out.println("IMPORT A RETIRAR: ");
            input = new Scanner(System.in);
            quantitat = input.nextLine();

            try {
                obj.retirar(quantitat);
                System.out.println("CÀRREC REALITZAT CORRECTAMENT");
                System.out.println("\nSALDO FINAL: " + obj.getSaldo());
                dadesOK = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (!dadesOK);

    }

    public void transferirAtoB(CuentaBancaria obj1, CuentaBancaria obj2) {

        Scanner input;
        boolean dadesOK = false;
        String quantitat = null;

        do {
            System.out.println("IMPORT A TRANSFERIR: ");
            input = new Scanner(System.in);
            quantitat = input.nextLine();

            try {
                obj1.retirar(quantitat);
                System.out.println("TRANSFERENCIA REALITZADA CORRECTAMENT");
                System.out.println("\nSALDO FINAL COMPTE A: " + obj1.getSaldo());
                obj2.ingressar(quantitat);
                System.out.println("\nSALDO FINAL COMPTE B: " + obj2.getSaldo());
                dadesOK = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (!dadesOK);

    }
}
