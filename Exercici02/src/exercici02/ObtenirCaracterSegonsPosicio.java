
package exercici02;

import java.util.Scanner;

public class ObtenirCaracterSegonsPosicio {

    public static void main(String[] args){
        
        Scanner input;
        String cadena;
        int posicio;
        
        System.out.println("INTRODUEIX CADENA: ");
        input = new Scanner(System.in);
        cadena = input.nextLine();
        
        System.out.println("INTRODUEIX POSICIO (màxim = "+cadena.length()+" ): ");
        input = new Scanner(System.in);
        posicio = input.nextInt();
        
        System.out.println("");
        System.out.println(cadena);
        System.out.println("Caracter en la posició ("+posicio+"): "+cadena.substring((posicio-1), posicio));
        System.out.println("Caracter UNICODE en la posició: "+cadena.codePointAt(posicio));
        System.out.println("Caracter UNICODE en la posició anterior: "+cadena.codePointBefore(posicio));
        
    }
    
}
