/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteprog10;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author gabriel
 */
public class ProjecteProg10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        Connection conn;
        Statement stmt;
        ResultSet rs;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//172.16.1.51:1521/XEPDB1","HR","admin");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select nombre, edad from conductores");
            while (rs.next()){
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad"));
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex){
            System.out.println("SQLException: "+ex.getMessage());
            
        }
        */
        
        Connection conn;
        Statement stmt;
        ResultSet rs;
        Conductor conductor;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//172.16.1.51:1521/XEPDB1","HR","admin");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select nombre, edad, p.doble_edad() from conductores p");
            while (rs.next()){
                System.out.println(rs.getString("nombre")+" "+rs.getInt("edad")+" "+rs.getInt(3));
            }
            
            conductor = new Conductor ("Pep",25);
            String cadena = "insert into conductores values ('"+ conductor.getNombre() + "', "+ conductor.getEdad()+")";
            System.out.println(cadena);
            stmt.executeUpdate(cadena);
            
            
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex){
            System.out.println("SQLException: "+ex.getMessage());
            
        }
        
        
        
        
    }
    
}
