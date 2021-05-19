
package metodes_11;

import java.util.Scanner;


public class Metodes_11 {


    public static void main(String[] args) {
        System.out.println("Regles de contrasenya:\n" +
            "Una contrasenya ha de tenir com a mínim vuit caràcters.\n" +
            "Una contrasenya només consta de lletres i dígits.\n" +
            "La contrasenya ha de contenir almenys dos dígits.");
    
        Scanner input;
        String password;
        password = null;
        
        System.out.println("Introdueix password: ");
        input = new Scanner(System.in);
        password = input.nextLine();
        
        System.out.println("\nTe com a minim 8 caracters: "+comprova_Num_Caracters(password)+" ("+password.length()+")");
        System.out.println("Numero de digits: "+conta_Digits(password));
        System.out.println("Numero de lletres: "+conta_Lletres(password));
        
        
    }
    
    
    public static boolean comprova_Num_Caracters(String password){
        if (password.length()>=8){
            return true;
        }
        return false;
    }
    
    public static int conta_Digits(String password){
        
        int i;
        int contadorDigits;
        contadorDigits=0;
        
        for (i=0; i<password.length();i++){
            if(password.charAt(i)>='0' && password.charAt(i)<='9'){
                contadorDigits++;
            }
        }
        return contadorDigits;
        
        
    }
    
    public static int conta_Lletres(String password){
        
        int i;
        int contadorLletres;
        contadorLletres=0;
        password = password.toUpperCase();
        
        for (i=0; i<password.length();i++){
            if(password.charAt(i)>='A' && password.charAt(i)<='Z'){
                contadorLletres++;
            }
        }
        return contadorLletres;
        
        
    }
    
}
