
package prog03a;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Prog03A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        byte nivell = 10;
        Jugador jugador1;
        jugador1 = new Jugador("Gabriel",52,nivell);
        System.out.println("Nom: "+jugador1.getNombre());
        System.out.println("Edat: "+jugador1.getEdad());
        System.out.println("Nivell: "+jugador1.getNivel());
        
        Scanner input;
        input = new Scanner(System.in);
        Jugador jugador2;
        jugador2 = new Jugador();
        
        
        System.out.println("");
        System.out.println("Introdueix NOM: ");
        String nom=input.nextLine();
        
        jugador2.setNombre(nom);
        
        System.out.println("");
        System.out.println("Introdueix EDAT: ");
        int edat = input.nextInt();
        
        jugador2.setEdad(edat);
        
        System.out.println("");
        System.out.println("Introdueix NIVELL: ");
        byte niv = input.nextByte();
        
        jugador2.setNivel(niv);
        
        System.out.println("");
        System.out.println("Nom: "+jugador2.getNombre());
        System.out.println("Edat: "+jugador2.getEdad());
        System.out.println("Nivell: "+jugador2.getNivel());
        
    }
    
}
