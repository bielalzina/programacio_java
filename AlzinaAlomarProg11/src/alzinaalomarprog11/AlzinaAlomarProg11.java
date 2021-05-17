/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alzinaalomarprog11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gabriel
 */
public class AlzinaAlomarProg11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlzinaAlomarProg11 aap11=new AlzinaAlomarProg11();

        byte opcio = 0;
        do {
            opcio = menuOpcions();
            switch (opcio) {
                case 1 ->
                    aap11.mostraAlumnes();
                case 2 ->
                    aap11.mostraTutors();
                case 3 ->
                    aap11.mostraAlumnesTutor(aap11);
                case 4 ->
                    aap11.afegeixTutor();
                case 5 ->
                    aap11.afegeixAlumne();
                case 6 ->
                    aap11.eliminaAlumne();
                case 7 ->
                    aap11.modificaTutor();
                case 0 ->
                    System.out.println("\n" + "\u001B[32mPROGRAMA FINALITZAT.\u001B[0m" + "\n");
                default ->
                    System.out.println("\n" + "\u001B[31mAQUESTA OPCIÓ NO EXISTEIX.\u001B[0m" + "\n");

            }
        } while (opcio != (byte) 0);

    }
    
    //METODE ESTABLEIX CONNEXIÓ AMB MYSQL
    private static Connection estableixConnexio() {

        Connection connexio;
        connexio=null;
        
        
        try {
            String connexioUrl = "jdbc:mysql://localhost/BD_GABRIEL_ALZINA?" + "user=gabriel&password=serball3112";
            connexio = (Connection) DriverManager.getConnection(connexioUrl);
            return connexio;
        
        } catch (SQLException ex) {
            Logger.getLogger(AlzinaAlomarProg11.class.getName()).log(Level.SEVERE, null, ex);
            return connexio;
        }
    }    
    
    //METODE TANCA CONNEXIÓ AMB MYSQL
    private void tancaConnexio(Connection connexio) {
        try {
            connexio.close();

        } catch (SQLException ex) {
            Logger.getLogger(AlzinaAlomarProg11.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
    
    //METODE MOSTRAR LLISTAT ALUMNES
    public void mostraAlumnes() {

        Connection con;
        Statement stmt;
        ResultSet rs;

        try {

            con = estableixConnexio();
            if (con != null) {
                // Cream una sentencia amb l'SQL que volem executar
                stmt = con.createStatement();

                // Execució de la sentencia 
                rs = stmt.executeQuery("SELECT * FROM Alumno");

                System.out.print("\n");
                System.out.println("+-------+-----------------------------------------+-------+");
                System.out.println("| \u001B[35mcodiA\u001B[0m | \u001B[35mNom i llinatges ALUMNE\u001B[0m                  | \u001B[35mcodiT\u001B[0m |");
                System.out.println("+-------+-----------------------------------------+-------+");

                while (rs.next()) {

                    System.out.println("| " + rs.getString(1) + " | " + String.format("%-40s", rs.getString(2)) + "| " + String.format("%-5d", rs.getInt(3)) + " |");
                    System.out.println("+-------+-----------------------------------------+-------+");
                }

                // Tancam les connexions
                rs.close();
                stmt.close();
             
                tancaConnexio(con);
                
            } else {
                System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR MYSQL\u001B[0m");
            }

        } catch (SQLException ex) {
            System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL\u001B[0m");
        }

    }
    
    //METODE PARA MOSTRAR LLISTAT TUTORS
    public void mostraTutors() {
        
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        try {

            con = estableixConnexio();
            if (con != null) {
                // Cream una sentencia amb l'SQL que volem executar
                stmt = con.createStatement();

                // Execució de la sentencia 
                rs = stmt.executeQuery("SELECT * FROM Tutor");

                System.out.print("\n");
                System.out.println("+-------+-----------------------------------------+");
                System.out.println("| \u001B[35mcodiT\u001B[0m | \u001B[35mNom i llinatges TUTOR\u001B[0m                   |");
                System.out.println("+-------+-----------------------------------------+");

                while (rs.next()) {

                    System.out.println("| " + String.format("%-5d", rs.getInt(1)) + " | " + String.format("%-40s", rs.getString(2)) + "|");
                    System.out.println("+-------+-----------------------------------------+");
                }

                // Tancam les connexions
                rs.close();
                stmt.close();
                tancaConnexio(con);
            } else {
                System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR MYSQL\u001B[0m");
            }

        } catch (SQLException ex) {
            System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL\u001B[0m");
        }
    }
    
    
    //METODE PER MOSTRAR LLISTAT ALUMNES D'UN TUTOR
    public void mostraAlumnesTutor(AlzinaAlomarProg11 aap) {

        Scanner entrada = new Scanner(System.in);
        int op;

        // MOSTRAM LLISTA TUTORS
        aap.mostraTutors();

        System.out.print("\nINTRODUEIX CODI DEL TUTOR: ");

        // USUARI SELECCIONA TUTOR
        Connection con;
        Statement stmt1;
        ResultSet rs1;
        Statement stmt2;
        ResultSet rs2;
        int numRows = 0;

        try {
            op = entrada.nextInt();

            try {
                con = estableixConnexio();
                if (con != null) {

                    // Crear una sentencia amb l'SQL que volem executar
                    stmt1 = con.createStatement();
                    stmt2 = con.createStatement();

                    // execució de la sentencia 
                    rs1 = stmt1.executeQuery("SELECT * FROM Alumno WHERE codiTutorAlumne =" + op + "");
                    rs2 = stmt2.executeQuery("SELECT nomTutor FROM Tutor WHERE codiTutor =" + op + "");

                    if (rs2.next() == false) {
                        System.out.println("\n" + "\u001B[31mEL CODI INTRODUÏT NO CORRESPON A CAP TUTOR.\u001B[0m");
                        System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
                    } else {
                        while (rs2.next()) {
                            System.out.println("\nLLISTAT D'ALUMNES TUTORITZATS PER: \u001B[35m" + rs2.getString(1) + "\u001B[0m");
                        }

                        System.out.print("\n");
                        System.out.println("+-------+-----------------------------------------+-------+");
                        System.out.println("| \u001B[35mcodiA\u001B[0m | \u001B[35mNom i llinatges ALUMNE\u001B[0m                  | \u001B[35mcodiT\u001B[0m |");
                        System.out.println("+-------+-----------------------------------------+-------+");

                        while (rs1.next()) {

                            System.out.println("| " + rs1.getString(1) + " | " + String.format("%-40s", rs1.getString(2)) + "| " + String.format("%-5d", rs1.getInt(3)) + " |");
                            System.out.println("+-------+-----------------------------------------+-------+");
                            numRows = numRows + 1;
                        }

                        System.out.println("\nTOTAL ALUMNES TUTORITZATS: \u001B[35m" + numRows + "\u001B[0m");
                    }

                    // tancar les connexions
                    rs1.close();
                    stmt1.close();
                    rs2.close();
                    stmt2.close();
                    tancaConnexio(con);
                } else {
                    System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR MYSQL\u001B[0m");
                }

            } catch (SQLException ex) {
                System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL\u001B[0m");
            }

        } catch (InputMismatchException e) {

            System.out.println("\n" + "\u001B[31mEL CODI INTRODUÏT NO CORRESPON A CAP TUTOR.\u001B[0m");
            System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
        }

    }
    
    //METODE PARA INSERIR NOU TUTOR
    public void afegeixTutor() {

        Scanner entradaCodi = new Scanner(System.in);
        int codiTutor;
        System.out.print("\nINTRODUEIX EL CODI DEL TUTOR (numero sencer i positiu): ");

        try {
            codiTutor = entradaCodi.nextInt();

            if (codiTutor > 0) {

                Connection con;
                Statement stmt1;
                ResultSet rs1;
                Statement stmt2;

                try {
                    con = estableixConnexio();
                    if (con != null) {

                        // Crear una sentencia amb l'SQL que volem executar
                        stmt1 = con.createStatement();

                        // execució de la sentencia 
                        rs1 = stmt1.executeQuery("SELECT nomTutor FROM Tutor WHERE codiTutor =" + codiTutor + "");

                        if (rs1.next() == false) {

                            Scanner entradaNom = new Scanner(System.in);
                            String nomLlinatgesTutor;
                            System.out.print("\nINTRODUEIX EL NOM I LLINATGES DEL TUTOR: ");
                            nomLlinatgesTutor = entradaNom.nextLine();

                            stmt2 = con.createStatement();

                            // execució de la sentencia 
                            stmt2.executeUpdate("INSERT INTO Tutor (codiTutor, nomTutor) VALUES (" + codiTutor + ",'" + nomLlinatgesTutor + "')");
                            System.out.println("\u001B[34m\nTUTOR (" + nomLlinatgesTutor + ") AFEGIT A BBDD\u001B[0m" + "\n");
                            stmt2.close();

                        } else {
                            System.out.println("\n" + "\u001B[31mEL CODI DE TUTOR INTRODUÏT JA EXISTEIX EN LA BASE DE DADES\u001B[0m");
                            System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
                        }

                        // tancar les connexions
                        rs1.close();
                        stmt1.close();

                        tancaConnexio(con);
                    } else {
                        System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR MYSQL\u001B[0m");
                    }

                } catch (SQLException ex) {
                    System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL\u001B[0m");
                }

            } else {
                System.out.println("\n" + "\u001B[31mHAS INTRODUÏT UN CODI DE TUTOR NEGATIU.\u001B[0m");
                System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
            }

        } catch (InputMismatchException e) {

            System.out.println("\n" + "\u001B[31mHAS INTRODUÏT UN CODI DE TUTOR AMB UN FORMAT INCORRECTE.\u001B[0m");
            System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
        }

    }
    
    //METODE PARA INSERIR NOU ALUMNE
    public void afegeixAlumne() {

        Scanner entradaCodiAlumne = new Scanner(System.in);
        String codiAlumne;
        System.out.print("\nINTRODUEIX EL CODI DE L'ALUMNE (INICIALS + 2 DIGITS): ");
        codiAlumne = entradaCodiAlumne.nextLine();

        if (validaCodiAlumne(codiAlumne)) {

            Connection con;
            Statement stmt0;
            ResultSet rs0;
            Statement stmt1;
            ResultSet rs1;
            Statement stmt2;

            try {
                con = estableixConnexio();
                if (con != null) {

                    // Crear una sentencia amb l'SQL que volem executar
                    stmt0 = con.createStatement();

                    // execució de la sentencia 
                    rs0 = stmt0.executeQuery("SELECT codiAlumne FROM Alumno WHERE codiAlumne ='" + codiAlumne + "'");

                    if (rs0.next() == false) {

                        Scanner entradaCodiTutor = new Scanner(System.in);
                        int codiTutor;
                        System.out.print("\nINTRODUEIX EL CODI DEL TUTOR (numero sencer i positiu): ");

                        try {
                            codiTutor = entradaCodiTutor.nextInt();

                            try {
                                // Crear una sentencia amb l'SQL que volem executar
                                stmt1 = con.createStatement();

                                // execució de la sentencia 
                                rs1 = stmt1.executeQuery("SELECT codiTutor FROM Tutor WHERE codiTutor =" + codiTutor + "");

                                if (rs1.next() == true) {

                                    Scanner entradaNom = new Scanner(System.in);
                                    String nomLlinatgesAlumne;
                                    System.out.print("\nINTRODUEIX EL NOM I LLINATGES DE L'ALUMNE: ");
                                    nomLlinatgesAlumne = entradaNom.nextLine();

                                    try{
                                      
                                        stmt2 = con.createStatement();

                                        // execució de la sentencia 
                                        stmt2.executeUpdate("INSERT INTO  Alumno (codiAlumne, nomAlumne, codiTutorAlumne) VALUES ('" + codiAlumne + "','" + nomLlinatgesAlumne + "'," + codiTutor + ")");
                                        System.out.println("\u001B[34m\nALUMNE (" + nomLlinatgesAlumne + ") AFEGIT A BBDD\u001B[0m" + "\n");
                                        
                                        stmt2.close(); 
                                    
                                    } catch (SQLException ex) {
                                        System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL PER AFEGIR NOU ALUMNE\u001B[0m");
                                    }
                                    

                                } else {
                                    System.out.println("\n" + "\u001B[31mEL CODI DE TUTOR INTRODUÏT NO EXISTEIX EN LA BASE DE DADES\u001B[0m");
                                    System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
                                }

                                rs1.close();
                                stmt1.close();

                            } catch (SQLException ex) {
                                System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL PER CONSTATAR CODI TUTOR EXISTENT\u001B[0m");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("\n" + "\u001B[31mHAS INTRODUÏT UN CODI DE TUTOR AMB UN FORMAT INCORRECTE.\u001B[0m");
                            System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
                        }

                    } else {
                        System.out.println("\n" + "\u001B[31mAQUEST CODI D'ALUMNE JA EXISTEIX EN LA BASE DE DADES\u001B[0m");
                        System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
                    }

                    rs0.close();
                    stmt0.close();
                    tancaConnexio(con);
                } else {
                    System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR MYSQL\u001B[0m");
                }

            } catch (SQLException ex) {
                System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL PER CONSTATAR CODI ALUMNE NO REPETIT\u001B[0m");
            }

        } else {
            System.out.println("\n" + "\u001B[31mHAS INTRODUÏT UN CODI D'ALUMNE AMB UN FORMAT INCORRECTE.\u001B[0m");
            System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
        }

    }
    
    //METODE PER ELIMINAR ALUMNE
    public void eliminaAlumne() {

        Scanner entradaCodiAlumne = new Scanner(System.in);
        String codiAlumne;
        System.out.print("\nINTRODUEIX EL CODI DE L'ALUMNE (INICIALS + 2 DIGITS): ");
        codiAlumne = entradaCodiAlumne.nextLine();
        
        Connection con;
        Statement stmt0;
        ResultSet rs0;
        Statement stmt1;
        ResultSet rs1;
        
        try {
            con = estableixConnexio();
            if (con != null) {

                // Crear una sentencia amb l'SQL que volem executar
                stmt0 = con.createStatement();

                // execució de la sentencia 
                rs0 = stmt0.executeQuery("SELECT codiAlumne FROM Alumno WHERE codiAlumne ='" + codiAlumne + "'");

                if (rs0.next() == true) {
                    try {

                        stmt1 = con.createStatement();

                        // execució de la sentencia 
                        
                        int numReg = stmt1.executeUpdate("DELETE FROM Alumno WHERE codiAlumne='" + codiAlumne + "'");
                        System.out.println("\u001B[34m\nS'HA ELIMINAT (" + numReg + ") ALUMNE AMB EL CODI (" + codiAlumne + ")\u001B[0m" + "\n");

                        stmt1.close();

                    } catch (SQLException ex) {
                        System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL PER AFEGIR NOU ALUMNE\u001B[0m");
                    }
                    

                } else {
                    System.out.println("\n" + "\u001B[31mAQUEST CODI D'ALUMNE NO EXISTEIX EN LA BASE DE DADES\u001B[0m");
                    System.out.println("\u001B[31mNO S'HA ELIMINAT CAP REGISTRE\u001B[0m");
                    System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
                }

                rs0.close();
                stmt0.close();
                tancaConnexio(con);
            } else {
                System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR MYSQL\u001B[0m");
            }

        } catch (SQLException ex) {
            System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL PER CONSTATAR ALUMNE EXISTENT\u001B[0m");
        }

    }  
    
    //METODE PER MODIFICAR TUTOR
    public void modificaTutor() {

        Scanner entradaCodiTutor = new Scanner(System.in);
        int codiTutor;
        System.out.print("\nINTRODUEIX EL CODI DEL TUTOR (numero sencer i positiu) A MODIFICAR: ");

        Connection con;
        Statement stmt0;
        ResultSet rs0;
        Statement stmt1;
        ResultSet rs1;

        try {
            codiTutor = entradaCodiTutor.nextInt();

            con = estableixConnexio();
            if (con != null) {
                
                try {
                    // Crear una sentencia amb l'SQL que volem executar
                    stmt0 = con.createStatement();
                    
                    // execució de la sentencia
                    rs0 = stmt0.executeQuery("SELECT codiTutor FROM Tutor WHERE codiTutor =" + codiTutor + "");
                    
                    if (rs0.next() == true) {
                        
                        Scanner entradaNom = new Scanner(System.in);
                        String nomLlinatgesTutor;
                        System.out.print("\nINTRODUEIX EL NOM I LLINATGES CORRECTES DEL TUTOR: ");
                        nomLlinatgesTutor = entradaNom.nextLine();
                        
                        try {
                            
                            stmt1 = con.createStatement();
                            
                            // execució de la sentencia
                            stmt1.executeUpdate("UPDATE  Tutor  SET nomTutor = '" + nomLlinatgesTutor + "' WHERE codiTutor = " + codiTutor + "");
                            
                            System.out.println("\u001B[34m\nTUTOR (" + nomLlinatgesTutor + ") ACTUALITZAT\u001B[0m" + "\n");
                            
                            stmt1.close();
                            
                        } catch (SQLException ex) {
                            System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL PER ACTUALITZAR EL TUTOR\u001B[0m");
                        }
                        
                    } else {
                        System.out.println("\n" + "\u001B[31mEL CODI DE TUTOR INTRODUÏT NO EXISTEIX EN LA BASE DE DADES\u001B[0m");
                        System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
                    }
                    
                    rs0.close();
                    stmt0.close();
                    tancaConnexio(con);
                    
                } catch (SQLException ex) {
                    System.out.println("\n" + "\u001B[31mNO S'HA POGUT EXECUTAR LA CONSULTA SQL PER CONSTATAR CODI TUTOR EXISTENT\u001B[0m");
                }
            } else {
                System.out.println("\n" + "\u001B[31mNO S'HA POGUT CONNECTAR AMB EL SERVIDOR MYSQL\u001B[0m");
            }

        } catch (InputMismatchException e) {
            System.out.println("\n" + "\u001B[31mHAS INTRODUÏT UN CODI DE TUTOR AMB UN FORMAT INCORRECTE.\u001B[0m");
            System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m" + "\n");
        }

    }
    
    //METODE ESTATIC PER VALIDAR CODI ALUMNE
    public static boolean validaCodiAlumne(String codiAlumne) {

        // EXPRESSIÓ REGULAR CODI ALUMNE
        String codiRegex = "^[A-Z]{3}[0-9]{2}$";
        Pattern patro = Pattern.compile(codiRegex);
        Matcher validacio = patro.matcher(codiAlumne);
        return validacio.matches();

    }

    //MENU OPCIONS
    private static byte menuOpcions() {

        Scanner entrada = new Scanner(System.in);
        byte op;

        System.out.println("\nACCÉS A DATABASE");
        System.out.println("----------------\n");

        System.out.println("\n1. Mostra a tots els alumnes de la base de dades");
        System.out.println("2. Mostra a tots els tutors de la base de dades.");
        System.out.println("3. Mostra el llistat d'alumnes d'un determinat tutor.");
        System.out.println("4. Inserir un nou tutor.");
        System.out.println("5. Inserir un nou alumne.");
        System.out.println("6. Eliminar alumne.");
        System.out.println("7. Modificar el nom d'un tutor.");
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

}
