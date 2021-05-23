package exercici3partb;

import java.util.ArrayList;

public class Operativa {

    public static void main(String[] args) {
        System.out.println("EXERCICI 1");
        Alumne alumne = new Alumne("43060943K", "VICTORIA AMER AMER", "DAW", 7.8);
        System.out.println(alumne.getNif());
        System.out.println(alumne.getNom());
        System.out.println(alumne.getCurs());
        System.out.println(alumne.getNotaMitjana());
        System.out.println(alumne);
        System.out.println(alumne.mostraHorari());

        System.out.println("\nEXERCICI 2");
        Professor professor = new Professor("78207737D", "GABRIEL ALZINA ALOMAR", "ADMINISTRACIÓ EMPRESES", 2500);
        System.out.println(professor.getNif());
        System.out.println(professor.getNom());
        System.out.println(professor.getEspecialitat());
        System.out.println(professor.getSalari());
        System.out.println(professor);
        System.out.println(professor.mostraHorari());

        System.out.println("\nEXERCICI 3");
        Persona persona1 = new Alumne("73656048C", "Persona 1 Objecte Alumne", "DAM", 7);
        Persona persona2 = new Professor("70727640H", "Persona 2 Objecte Professor", "Informàtica", 1500);
        System.out.println(persona1.getNif());
        System.out.println(persona1.getNom());
        System.out.println(((Alumne) persona1).getCurs());
        System.out.println(((Alumne) persona1).getNotaMitjana());
        System.out.println(persona1.mostraHorari());

        System.out.println("");
        System.out.println(persona2.getNif());
        System.out.println(persona2.getNom());
        System.out.println(((Professor) persona2).getEspecialitat());
        System.out.println(((Professor) persona2).getSalari());
        System.out.println(persona2.mostraHorari());

        System.out.println("\nEXERCICI 4");
        ArrayList<Persona> ciutadans = new ArrayList<>();
        ciutadans.add(persona1);
        ciutadans.add(persona2);
        for (Persona p : ciutadans) {
            System.out.println(p.getNif());
            System.out.println(p.getNom());
            System.out.println(p.mostraHorari());
            System.out.println("");
        }

    }

}
