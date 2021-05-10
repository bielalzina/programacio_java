/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alzinaalomargabrielprog10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class AlzinaAlomarGabrielPROG10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlzinaAlomarGabrielPROG10 aagp10 = new AlzinaAlomarGabrielPROG10();

        byte opcio = 0;
        do {
            opcio = menuOpcions();
            switch (opcio) {
                case 1 ->
                    aagp10.afegeixPartit();
                case 2 ->
                    aagp10.mostraPartits();
                case 3 ->
                    aagp10.mostraClassificacio();
                case 4 ->
                    aagp10.eliminaDades();
                case 0 ->
                    System.out.println("\n" + "\u001B[32mPROGRAMA FINALITZAT.\u001B[0m" + "\n");
                default ->
                    System.out.println("\n" + "\u001B[31mAQUESTA OPCIÓ NO EXISTEIX.\u001B[0m" + "\n");

            }
        } while (opcio != (byte) 0);
    }

    //MENU OPCIONS
    private static byte menuOpcions() {

        Scanner entrada = new Scanner(System.in);
        byte op;

        System.out.println("\u001B[34m\nMENÚ D'OPCIONS\u001B[0m");
        System.out.println("----------------");

        System.out.println("\n1. AFEGEIX PARTIT JUGAT");
        System.out.println("2. MOSTRA PARTITS JUGATS");
        System.out.println("3. MOSTRA LA CLASSIFICACIO");
        System.out.println("4. ELIMINA TOTES LES DADES (PARTITS i CLASSIFICACIO)");
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

    //METODE ESTABLEIX CONNEXIÓ AMB MYSQL
    private static Connection estableixConnexio() {

        Connection connexio;
        connexio = null;

        try {
            connexio = DriverManager.getConnection("jdbc:oracle:thin:@//172.16.1.51:1521/XEPDB1", "HR", "admin");
            return connexio;

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return connexio;
        }
    }

    //METODE TANCA CONNEXIÓ AMB MYSQL
    private void tancaConnexio(Connection connexio) {
        try {
            connexio.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlzinaAlomarGabrielPROG10.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //METODE AFEGIR PARTIT JUGAT
    public void afegeixPartit() {

        Scanner entradaEquipLocal = new Scanner(System.in);
        String equipLocal = null;
        boolean entradaEquipLocalOK = false;

        do {

            System.out.print("\nINTRODUEIX NOM EQUIP LOCAL (mínim 3 caracters): ");
            equipLocal = entradaEquipLocal.nextLine();

            // Comprovam que la cadena introduida tengui 3 caracters o mes
            if (equipLocal.length() < 3) {
                System.out.println("\n" + "\u001B[31mEL NOM DE L'EQUIP LOCAL ES MASSA CURT (mínim 3 caracters)!!\u001B[0m");

            } else {
                entradaEquipLocalOK = true;
            }

        } while (entradaEquipLocalOK == false);

        Scanner entradaGolsLocal = new Scanner(System.in);
        int golsLocal = 0;
        boolean entradaGolsLocalOK = false;

        do {

            // davant la possibilitat que l'usuari no introdueixi un numero sencer
            // establim un try - catch per tractar l'execpció
            try {

                System.out.print("\nINTRODUEIX ELS GOLS MARCATS PER L'EQUIP LOCAL (0 si no ha marcat cap gol): ");
                golsLocal = entradaGolsLocal.nextInt();

                //Comprovam que el num. introduït no sigui negatiu
                if (golsLocal < 0) {
                    System.out.println("\n" + "\u001B[31mHAS INTRODUÏT UN NUMERO NEGATIU!!\u001B[0m");
                } else {
                    entradaGolsLocalOK = true;
                }

            } catch (InputMismatchException e) {

                System.out.println("\n" + "\u001B[31mNO HAS INTRODUÏT UN NUMERO SENCER!!\u001B[0m");

                // Obligam que es torni a capturar el valor per teclat
                entradaGolsLocal.next();
            }

        } while (entradaGolsLocalOK == false);

        Scanner entradaEquipVisitant = new Scanner(System.in);
        String equipVisitant = null;
        boolean entradaEquipVisitantOK = false;

        do {

            System.out.print("\nINTRODUEIX NOM EQUIP VISITANT (mínim 3 caracters): ");
            equipVisitant = entradaEquipVisitant.nextLine();

            // Comprovam que la cadena introduida tengui 3 caracters o mes
            if (equipVisitant.length() < 3) {
                System.out.println("\n" + "\u001B[31mEL NOM DE L'EQUIP VISITANT ES MASSA CURT (mínim 3 caracters)!!\u001B[0m");

            } else {
                entradaEquipVisitantOK = true;
            }

        } while (entradaEquipVisitantOK == false);

        Scanner entradaGolsVisitant = new Scanner(System.in);
        int golsVisitant = 0;
        boolean entradaGolsVisitantOK = false;

        do {

            // davant la possibilitat que l'usuari no introdueixi un numero sencer
            // establim un try - catch per tractar l'execpció
            try {

                System.out.print("\nINTRODUEIX ELS GOLS MARCATS PER L'EQUIP VISITANT (0 si no ha marcat cap gol): ");
                golsVisitant = entradaGolsVisitant.nextInt();

                //Comprovam que el num. introduït no sigui negatiu
                if (golsVisitant < 0) {
                    System.out.println("\n" + "\u001B[31mHAS INTRODUÏT UN NUMERO NEGATIU!!\u001B[0m");
                } else {
                    entradaGolsVisitantOK = true;
                }

            } catch (InputMismatchException e) {

                System.out.println("\n" + "\u001B[31mNO HAS INTRODUÏT UN NUMERO SENCER!!\u001B[0m");

                // Obligam que es torni a capturar el valor per teclat
                entradaGolsVisitant.next();
            }

        } while (entradaGolsVisitantOK == false);

        Connection conn;
        Statement stmt;
        Partit partit;

        conn = estableixConnexio();
        if (conn != null) {

            try {

                stmt = conn.createStatement();
                //Cream objecte
                partit = new Partit(equipLocal.toUpperCase(), equipVisitant.toUpperCase(), golsLocal, golsVisitant);
                // Crear una sentencia amb l'SQL que volem executar
                String cadena = "INSERT INTO PARTITS_Alzina "
                        + "VALUES ('" + partit.getEquipLocal() + "', '" + partit.getEquipVisitant() + "', " + partit.getGolsLocal() + "," + partit.getGolsVisitant() + ")";

                // Executam consulta
                stmt.executeUpdate(cadena);

                stmt.close();

                System.out.println("\u001B[34m\nPARTIT AFEGIT A BBDD\u001B[0m" + "\n");

                // Per obtenir la classificació he creat en ORACLE una BDOO amb l'objecte tipus_classificacció i taula classificacio
                // En aquesta taula vaig insertant els punts obtinguts pels equips
                try {

                    // Quantificam partits guanyats / perduts /empatats
                    int guanyatsEquipLocal = 0;
                    int empatatsEquipLocal = 0;
                    int perdutsEquipLocal = 0;
                    int guanyatsEquipVisitant = 0;
                    int empatatsEquipVisitant = 0;
                    int perdutsEquipVisitant = 0;

                    Classificacio classificacioLocal;
                    Classificacio classificacioVisitant;

                    if (partit.getGolsLocal() > partit.getGolsVisitant()) {
                        guanyatsEquipLocal = 1;
                        perdutsEquipVisitant = 1;
                    } else if (partit.getGolsLocal() < partit.getGolsVisitant()) {
                        perdutsEquipLocal = 1;
                        guanyatsEquipVisitant = 1;
                    } else {
                        empatatsEquipLocal = 1;
                        empatatsEquipVisitant = 1;
                    }

                    // Declaram objectes classificació
                    classificacioLocal = new Classificacio(partit.getEquipLocal(), guanyatsEquipLocal, empatatsEquipLocal, perdutsEquipLocal);
                    classificacioVisitant = new Classificacio(partit.getEquipVisitant(), guanyatsEquipVisitant, empatatsEquipVisitant, perdutsEquipVisitant);

                    // Preparam connexió
                    Statement stmt1;
                    stmt1 = conn.createStatement();

                    //Crear una sentencia amb l'SQL que volem executar
                    String cadena1 = "INSERT ALL "
                            + "INTO classificacio (equip,guanyats,empatats,perduts) "
                            + "VALUES ('" + classificacioLocal.getEquip() + "'," + classificacioLocal.getGuanyats() + "," + classificacioLocal.getEmpatats() + "," + classificacioLocal.getPerduts() + ") "
                            + "INTO classificacio (equip,guanyats,empatats,perduts)"
                            + "VALUES ('" + classificacioVisitant.getEquip() + "'," + classificacioVisitant.getGuanyats() + "," + classificacioVisitant.getEmpatats() + "," + classificacioVisitant.getPerduts() + ")"
                            + "SELECT * FROM dual";

                    //System.out.println(cadena1);
                    // Executam consulta
                    stmt1.executeUpdate(cadena1);

                    stmt1.close();

                    System.out.println("\u001B[34m\nCLASIFICACIÓ ACTUALITZADA\u001B[0m" + "\n");

                } catch (SQLException ex) {
                    System.out.println("\n" + "\u001B[31mNO S'HA POGUT ACTUALITZAR LA CLASSIFICACIÓ\u001B[0m");
                }

            } catch (SQLException ex) {
                System.out.println("\n" + "\u001B[31mNO S'HA POGUT AFEGIR EL PARTIT A LA BBDD\u001B[0m");
            }

            tancaConnexio(conn);
        } else {
            System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR ORACLE\u001B[0m");
        }

    }

    //METODE PER MOSTRAR PARTITS JUGATS
    public void mostraPartits() {

        Connection conn;
        Statement stmt;
        ResultSet rs = null;

        conn = estableixConnexio();
        if (conn != null) {

            try {

                stmt = conn.createStatement();
                // Crear una sentencia amb l'SQL que volem executar
                String cadena = "SELECT equipLocal, equipVisitant, golsLocal, golsVisitant, p.equip_guanyador() FROM PARTITS_Alzina p ORDER BY equipLocal ASC";

                // Executam consulta
                rs = stmt.executeQuery(cadena);
                System.out.println("\u001B[34m\nPARTITS JUGATS\u001B[0m" + "\n");

                System.out.println("+----------------+-----------+----------------+----------------+");
                System.out.println("| \u001B[35mLOCAL\u001B[0m          | \u001B[35mRESULTAT\u001B[0m  | \u001B[35mVISITANT\u001B[0m       | \u001B[35mGUANYADOR\u001B[0m      |");
                System.out.println("+----------------+-----+-----+----------------+----------------+");

                // Mostram resultats
                while (rs.next()) {
                    System.out.println("| " + String.format("%-15s", rs.getString("equipLocal")) + "|  "
                            + String.format("%-3d", rs.getInt("golsLocal")) + "|  "
                            + String.format("%-3d", rs.getInt("golsVisitant")) + "| "
                            + String.format("%-15s", rs.getString("equipVisitant")) + "| "
                            + String.format("%-15s", rs.getString(5)) + "|");
                    System.out.println("+----------------+-----+-----+----------------+----------------+");
                }

                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("\n" + "\u001B[31mNO S'HAN POGUT MOSTRAR ELS PARTITS\u001B[0m");
            }

            tancaConnexio(conn);
        } else {
            System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR ORACLE\u001B[0m");
        }
    }

    //METODE PARA MOSTRAR CLASSIFICACIO
    public void mostraClassificacio() {

        Connection conn;
        Statement stmt;
        ResultSet rs;

        conn = estableixConnexio();
        if (conn != null) {

            try {

                int posicio = 1;

                stmt = conn.createStatement();
                // Crear una sentencia amb l'SQL que volem executar
                String cadena = "SELECT equip, SUM(guanyats), SUM(empatats), SUM(perduts), SUM(p.punts()) "
                        + "FROM classificacio p "
                        + "GROUP BY equip "
                        + "ORDER BY SUM(p.punts()) DESC";

                // Executam consulta
                rs = stmt.executeQuery(cadena);
                System.out.println("\u001B[34m\nCLASSIFICACIÓ\u001B[0m" + "\n");

                System.out.println("+-----+----------------+-----------+-----------+-----------+-----------+");
                System.out.println("| \u001B[35mPOS\u001B[0m | \u001B[35mEQUIP\u001B[0m          | \u001B[35mVICTORIES\u001B[0m |  \u001B[35mEMPATS\u001B[0m   | \u001B[35mDERROTES\u001B[0m  |   \u001B[35mPUNTS\u001B[0m   |");
                System.out.println("+-----+----------------+-----------+-----------+-----------+-----------+");

                // Mostram resultats
                while (rs.next()) {
                    System.out.println("|  " + String.format("%-3d", posicio) + "| "
                            + String.format("%-15s", rs.getString(1)) + "|    "
                            + String.format("%-3d", rs.getInt(2)) + "    |     "
                            + String.format("%-3d", rs.getInt(3)) + "   |     "
                            + String.format("%-3d", rs.getInt(4)) + "   |    "
                            + String.format("%-4d", rs.getInt(5)) + "   |");
                    System.out.println("+-----+----------------+-----------+-----------+-----------+-----------+");
                    posicio++;
                }

                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("\n" + "\u001B[31mNO S'HAN POGUT MOSTRAR ELS PARTITS\u001B[0m");
            }

            tancaConnexio(conn);
        } else {
            System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR ORACLE\u001B[0m");
        }
    }

    //METODE PER A ELIMINAR DADES
    public void eliminaDades() {

        Connection conn;
        Statement stmt;

        conn = estableixConnexio();
        if (conn != null) {

            try {

                stmt = conn.createStatement();

                // Executam instruccions
                int numClassificacions = stmt.executeUpdate("DELETE FROM classificacio");
                int numPartits = stmt.executeUpdate("DELETE FROM PARTITS_Alzina");

                System.out.println("\u001B[34m\nPARTITS ELIMINATS: \u001B[0m\u001B[31m" + numPartits + "\u001B[0m\n");
                System.out.println("\u001B[34m\nREGISTRES CLASSIFICACIÓ ELIMINATS: \u001B[0m\u001B[31m" + numClassificacions + "\u001B[0m\n");

                stmt.close();

            } catch (SQLException ex) {
                System.out.println("\n" + "\u001B[31mNO S'HAN POGUT ELIMINAR LES DADES\u001B[0m");
            }

            tancaConnexio(conn);
        } else {
            System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR ORACLE\u001B[0m");
        }
    }

}
