

package metodes_04;

import java.util.Scanner;


public class Metodes_04 {

    public static void main(String[] args) {
        String cadena;
        Scanner input;
        
        
        System.out.println("Introdueix cadena: ");
        input = new Scanner(System.in);
        cadena = input.nextLine();
        
        System.out.println("Cadena: "+cadena);
        System.out.println("Llarg cadena: "+cadena.length() );
        System.out.println("Numero Vocals: "+contaVocals(cadena));
               
        
    }
        
    
    
    public static int contaVocals(String cadena){
        int i;
        int numVocals;
        numVocals =0;
        for (i=0;i<cadena.length();i++){
            if (cadena.charAt(i)=='a' 
                    || cadena.charAt(i)=='e'
                    || cadena.charAt(i)=='i'
                    || cadena.charAt(i)=='o'
                    || cadena.charAt(i)=='u'
                    || cadena.charAt(i)=='A'
                    || cadena.charAt(i)=='E'
                    || cadena.charAt(i)=='I'
                    || cadena.charAt(i)=='O'
                    || cadena.charAt(i)=='U'){
                
                numVocals++;
            }
        }
        return numVocals;
    
    }
}
