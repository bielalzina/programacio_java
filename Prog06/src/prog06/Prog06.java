package prog06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Prog06 {

    public static void main(String[] args) {

        //CREACIO FITXER I ESCRIPTURA
        String nomFitxer = "clientes.dat";

        // Cream objecte File 
        File f = new File(nomFitxer);

        // Comprovam si el fitxer existeix
        if (f.exists()) {
            System.out.println("Ja existeix un fitxer de CLIENTS creat previament, OPERACIÓ NO REALITZADA");

        } else {

            // Cream fitxer
            // Demanam informació a l'usuari validant mitjançant expressions regulars
            FileOutputStream fos = null;
            ObjectOutputStream sortida = null;
            Cliente c1;
            Cliente c2;
            Cliente c3;

            try {
                fos = new FileOutputStream(nomFitxer);
                System.out.println("S'ha creat el fitxer de CLIENTS, OPERACIÓ REALITZADA");
                sortida = new ObjectOutputStream(fos);

                // Passam informació al fitxer
                c1 = new Cliente("78207737D", "gabriel", "669668705", "mail1@Client", "25/01/71");
                c2 = new Cliente("dni2", "nom2", "telef2", "mail2@Client", "25/01/72");
                c3 = new Cliente("dni3", "nom3", "telef3", "mail3@Client", "25/01/73");

                sortida.writeObject(c1);
                sortida.writeObject(c2);
                sortida.writeObject(c3);

                System.out.println("REGISTRES AFEGITS EN FITXER CLIENTS, OPERACIÓ REALITZADA");

            } catch (FileNotFoundException ex) {
                System.out.println("No s'ha pogut crear el fitxer de CLIENTS, OPERACIÓ NO REALITZADA");
            } catch (IOException ex) {
                System.out.println("No s'han pogut crear el clients, OPERACIÓ NO REALITZADA");
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                    if (sortida != null) {
                        sortida.close();
                    }
                } catch (IOException ex) {
                    System.out.println("No s'ha pogut tancar el fitxer de CLIENTS, OPERACIÓ NO REALITZADA");
                }
            }

        }

        //ELIMINACIO FITXER
        Scanner input;
        System.out.println("VOLS ELIMINAR EL FITXER (S/N): ");
        input = new Scanner(System.in);
        String elimina = input.nextLine();
        elimina = elimina.toUpperCase();

        if (elimina.equals("S")) {
            if (f.exists()) {

                // Eliminam fitxer
                f.delete();
                System.out.println("S'ha eliminat el fitxer de CLIENTS, OPERACIÓ REALITZADA");
            } else {
                System.out.println("No existeix cap fitxer de CLIENTS per a eliminar, OPERACIÓ NO REALITZADA");
            }

        }

        //LECTURA FITXER
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Cliente c;

        try {
            fis = new FileInputStream(nomFitxer);
            entrada = new ObjectInputStream(fis);
            String dadesClients;

            dadesClients = "******************************************\n";

            for (int i = 1; i < 4; i++) {
                c = (Cliente) entrada.readObject();
                dadesClients = dadesClients
                        + "NIF: " + c.getNIF() + "\n"
                        + "NOM: " + c.getNom() + "\n"
                        + "TELEFON: " + c.getTelefon() + "\n"
                        + "MAIL: " + c.getMail() + "\n"
                        + "DATA NEIXEMENT: " + c.getDataNeixement() + "\n"
                        + "******************************************\n";
            }

            System.out.println("LLISTAT CLIENTS\n" + dadesClients);

        } catch (FileNotFoundException ex) {
            System.out.println("El fitxer de CLIENTS no existeix, OPERACIÓ NO REALITZADA");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("No s'han pogut llegir les dades dels CLIENTS, OPERACIÓ NO REALITZADA");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println("No s'ha pogut tancar el fitxer de CLIENTS, OPERACIÓ NO REALITZADA");
            }
        }

        // CERCAR CLIENT PER NIF
        if (f.exists()) {
            // Si existeix
            FileInputStream fis2 = null;
            ObjectInputStream entrada2 = null;
            Cliente c2;

            Scanner input2;
            System.out.println("DNI A CERCAR): ");
            input2 = new Scanner(System.in);
            String nif = input.nextLine();

            /*Protegim l'aplicació en el cas que l'usuari tanqui la finestra 
            o cancel·li l'operació*/
            if (nif != null) {

                try {
                    fis2 = new FileInputStream(nomFitxer);
                    entrada2 = new ObjectInputStream(fis2);
                    String dadesClient;
                    Boolean clientTrobat = false;

                    dadesClient = "******************************************\n";

                    for (int i = 1; i < 4; i++) {

                        // Llegim objectes
                        c2 = (Cliente) entrada2.readObject();

                        // comprovam coincidencia
                        if (nif.equals(c2.getNIF())) {

                            dadesClient = dadesClient
                                    + "NIF: " + c2.getNIF() + "\n"
                                    + "NOM: " + c2.getNom() + "\n"
                                    + "TELEFON: " + c2.getTelefon() + "\n"
                                    + "MAIL: " + c2.getMail() + "\n"
                                    + "DATA NEIXEMENT: " + c2.getDataNeixement() + "\n"
                                    + "******************************************\n";
                            clientTrobat = true;

                            // Sortim, el NIF es individual
                            break;

                        }
                    }

                    if (clientTrobat) {
                        // Mostram dades
                        System.out.println("LES DADES DEL CLIENT AMB NIF " + nif
                                + " SON: \n" + dadesClient);
                    } else {
                        System.out.println("NO EXISTEIX NINGUN CLIENT AMB EL NIF: " + nif);
                    }

                } catch (FileNotFoundException ex) {
                    System.out.println("El fitxer de CLIENTS no existeix, OPERACIÓ NO REALITZADA");
                } catch (ClassNotFoundException | IOException ex) {
                    System.out.println("No s'han pogut llegir les dades dels CLIENTS, OPERACIÓ NO REALITZADA");
                } finally {
                    try {
                        if (fis != null) {
                            fis.close();
                        }
                        if (entrada != null) {
                            entrada.close();
                        }
                    } catch (IOException e) {
                        System.out.println("No s'ha pogut tancar el fitxer de CLIENTS, OPERACIÓ NO REALITZADA");
                    }
                }
            } else {
                // Usuari ha cancel·lat operació o ha tancat finestra
                System.out.println("Operació cancel·lada, CANCEL·LACIÓ");
            }

        } else {
            System.out.println("El fitxer de CLIENTS no existeix, OPERACIÓ NO REALITZADA");
        }

    }

}
