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
                AlzinaAlomarGabrielPROG10 aagp10=new AlzinaAlomarGabrielPROG10();

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
        connexio=null;
        
        
        try {
            connexio = DriverManager.getConnection("jdbc:oracle:thin:@//172.16.1.51:1521/XEPDB1","HR","admin");
            return connexio;
        
        } catch (SQLException ex) {
            System.out.println("SQLException: "+ex.getMessage());
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
        String equipLocal;
        System.out.print("\nINTRODUEIX NOM EQUIP LOCAL: ");
        equipLocal = entradaEquipLocal.nextLine();

        Scanner entradaGolsLocal = new Scanner(System.in);
        int golsLocal;
        System.out.print("\nINTRODUEIX ELS GOLS MARCATS PER L'EQUIP LOCAL (0 si no ha marcat cap gol): ");
        golsLocal = entradaGolsLocal.nextInt();

        Scanner entradaEquipVisitant = new Scanner(System.in);
        String equipVisitant;
        System.out.print("\nINTRODUEIX NOM EQUIP VISITANT: ");
        equipVisitant = entradaEquipVisitant.nextLine();

        Scanner entradaGolsVisitant = new Scanner(System.in);
        int golsVisitant;
        System.out.print("\nINTRODUEIX ELS GOLS MARCATS PER L'EQUIP LOCAL (0 si no ha marcat cap gol): ");
        golsVisitant = entradaGolsVisitant.nextInt();

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
                    
                    // Identificam equip guanyador / pederdor / empat i quantificam partits guanyats / perduts /empatats
                    
                    String equip1=null;
                    String equip2=null;
                    int guanyatsEquip1=0;
                    int perdutsEquip1=0;
                    int empatatsEquip1=0;
                    int guanyatsEquip2=0;
                    int perdutsEquip2=0;
                    int empatatsEquip2=0;
                                        
                    if (partit.getGolsLocal() > partit.getGolsVisitant()){
                        equip1=partit.getEquipLocal();
                        equip2=partit.getEquipVisitant();
                        guanyatsEquip1=1;
                        perdutsEquip2=1;
                    } else if (partit.getGolsLocal() < partit.getGolsVisitant()){
                        equip1=partit.getEquipVisitant();
                        equip2=partit.getEquipLocal();
                        guanyatsEquip1=1;
                        perdutsEquip2=1;
                    } else {
                        equip1=partit.getEquipLocal();
                        equip2=partit.getEquipVisitant();
                        empatatsEquip1=1;
                        empatatsEquip2=1;
                    }
                    
                    Statement stmt1;
                    stmt1 = conn.createStatement();
                    
                    //Crear una sentencia amb l'SQL que volem executar
                    String cadena1 = "INSERT ALL "
                            + "INTO classificacio (equip,guanyats,empatats,perduts) "
                            + "VALUES ('"+equip1+"',"+guanyatsEquip1+","+empatatsEquip1+","+perdutsEquip1+") "
                            + "INTO classificacio (equip,guanyats,empatats,perduts)"
                            + "VALUES ('"+equip2+"',"+guanyatsEquip2+","+empatatsEquip2+","+perdutsEquip2+")"
                            + "SELECT * FROM dual";
                    //System.out.println(cadena1);
                    // Executam consulta
                    stmt1.executeUpdate(cadena1);

                    stmt1.close();

                    System.out.println("\u001B[34m\nCLLASIFICACIÓ ACTUALITZADA\u001B[0m" + "\n");

                    
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
        ResultSet rs=null;

        conn = estableixConnexio();
        if (conn != null) {

            try {

                stmt = conn.createStatement();
                // Crear una sentencia amb l'SQL que volem executar
                String cadena = "SELECT equipLocal, equipVisitant, golsLocal, golsVisitant, p.equip_guanyador() FROM PARTITS_Alzina p";

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
                
                int posicio=1;
                
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
                while (rs.next()){
                    System.out.println("|  "+String.format("%-3d",posicio)+"| "
                            +String.format("%-15s", rs.getString(1))+"|    "
                            +String.format("%-3d", rs.getInt(2))+"    |     "
                            +String.format("%-3d", rs.getInt(3))+"   |     "
                            +String.format("%-3d", rs.getInt(4))+"   |    "
                            +String.format("%-4d", rs.getInt(5))+"   |");
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
    
    
    
}
