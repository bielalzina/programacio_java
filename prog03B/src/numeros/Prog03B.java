
package numeros;

import java.util.Scanner;


public class Prog03B {

    public static void main(String[] args) {
        Complejo com1;
        com1 = new Complejo();
        
        System.out.println("");
        System.out.println("PART REAL: "+com1.getReal());
        System.out.println("");
        System.out.println("PART IMAGINARIA: "+com1.getImag()+"i");
        System.out.println("");
        
        Scanner input;
        input = new Scanner(System.in);
        
        System.out.println("Introdueix part REAL: ");
        double real = input.nextDouble();
        
        com1.setReal(real);
        
        System.out.println("Introdueix part IMAGINARIA: ");
        double imag = input.nextDouble();
        
        com1.setImag(imag);
        
        System.out.println("");
        System.out.println("PART REAL: "+com1.getReal());
        System.out.println("");
        System.out.println("PART IMAGINARIA: "+com1.getImag()+"i");
        
        System.out.println("");
        System.out.println("NUMERO COMPLEX: "+com1.toString());
        System.out.println("");
        
        Complejo com2 = new Complejo();
        
        System.out.println("");
        System.out.println("Introdueix part REAL complexe 2: ");
        real = input.nextDouble();
        
        com2.setReal(real);
        
        System.out.println("Introdueix part IMAGINARIA complexe 2: ");
        imag = input.nextDouble();
        
        com2.setImag(imag);
        
        com1.sumar(com2);
        
        System.out.println("");
        System.out.println("NUMERO COMPLEX: "+com1.toString());
        System.out.println("");
        
        
    }
    
}
