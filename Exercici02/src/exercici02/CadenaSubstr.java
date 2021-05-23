
package exercici02;



public class CadenaSubstr {
    public static void main(String[] args) {

       
        String cadena = "CARACOLA";

        System.out.println("CADENA: "+cadena);
        System.out.println("LONGITUD: "+cadena.length());
        System.out.println("");
        
        for (int i=0; i<cadena.length();i++){
            System.out.println(i+")\t"+cadena.charAt(i));
        }
        
        System.out.println("CADENA A PARTIR DE 4: "+cadena.substring(4));
        System.out.println("CADENA ENTRE 3 i 6: "+cadena.substring(3,6));
        

    }

}
