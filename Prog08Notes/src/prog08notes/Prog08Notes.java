/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog08notes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author GABRIEL ALZINA ALOMAR
 */
public class Prog08Notes {

    // Declaramos la constante de los nombres obligatorios de los módulos    
    private static final String[] moduls = {"SiPROG", "SiMSO", "SiWEB", "SiXAR"};
    private ArrayList <Alumno> alumnes;
    private float[][] totesNotes;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Instanciamos la clase Prog08notes para usar sus atributos
        Prog08Notes pn = new Prog08Notes(); 
        byte opcio = 0;
        do {
            opcio = menuOpcions();
            switch (opcio) {
                case 1 -> pn.inserirAlumne();
                case 2 -> pn.mitjanesAlumnes();
                case 3 -> pn.mitjanaModul();
                case 4 -> pn.matriuNotes();    
                case 5 -> pn.notaAlumneModul();     
                case 0 -> System.out.println("\n"+"\u001B[32mPROGRAMA FINALITZAT.\u001B[0m"+"\n");
                default -> System.out.println("\n"+"\u001B[31mAQUESTA OPCIÓ NO EXISTEIX.\u001B[0m"+"\n");
                
            } 
        } while (opcio != (byte) 0); 
    }
    
    //Definición de los métodos 
    
    //CONSTRUCTOR POR DEFECTO DE LA CLASE Prog08Notes QUE CREA EL ARRAYLIST
    public Prog08Notes() {
       this.alumnes = new ArrayList<Alumno>();
    }

    //MÉTODO PARA AÑADIR UN ALUMNO A LA LISTA alumnes
    public void inserirAlumne() {
    
        Scanner entradaCodi = new Scanner(System.in);
        String codiA;
        boolean codiAOK=false;
        
        Alumno codiAlumne = new Alumno();
        
        do {

            System.out.println("\nINTRODUEIX EL CODI DE L'ALUMNE (LLLNN): ");
            codiA = entradaCodi.nextLine();
            boolean alumneRepetit=false;
            
            // COMPROVAM SI ALUMNE JA ESTÀ INSERIT
            
            for (Alumno codi : alumnes) {
               
                if (codiA.equals(codi.getCodi())) {
                    
                    alumneRepetit=true;
                    System.out.println("+++ dins BUCLE ++++ "+alumneRepetit);
                    break;
                }
            }
           
            
            // SI ALUMNE NO ESTÀ INSERIT, INTENTAM INSERIR-LO
            if (alumneRepetit!=true) {
                try {
                    codiAlumne.setCodi(codiA);
                    codiAOK = true;
                    alumnes.add(codiAlumne);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("\n"+"\u001B[31mALUMNE REPETIT.\u001B[0m"+"\n");
            }

        } while (codiAOK == false);
        
        // obtenim index del nou element en arraylist Alumnes
        //int index;
        //index = alumnes.indexOf(codiAlumne);
        
        for (int i=0; i<4;i++){
            
            Scanner entradaNota = new Scanner(System.in);
            String notaInserida;
            boolean notaInseridaOK=false;
            Float notaParseada;
            
            do{
                System.out.println("\nINTRODUEIX LA NOTA DE "+moduls[i]+":");
                             
                notaInserida = entradaNota.nextLine();
                
                try {
                    notaInserida=notaInserida.replace(",", ".");
                    notaParseada=Float.valueOf(notaInserida);
                    // Inserim nota en objecte
                    codiAlumne.setNota(i, notaParseada);
                    // Inserim nota en ARRAY BIDIMENSIONAL totesNotes
                    // totesNotes[index][i]=notaParseada;
                    notaInseridaOK=true;
                    
                }
                catch (Exception e){
                   
                    System.out.println("\n"+"\u001B[31mNOTA INCORRECTA!!!\u001B[0m"+"\n");
                }
              
            }while (notaInseridaOK==false);
           
        }
    
    }   

    //MÉTODO PARA MOSTRAR LA NOTA MEDIA DE CADA ALUMNO
    public void mitjanesAlumnes() {
        
        float mitjana=0;
        System.out.println("\nMITJANES DEL ALUMNES");
        System.out.println("--------------------\n");
        
        for (Alumno codi:alumnes){
            mitjana = codi.mitjanaNotes();
            String sortidaMitjana = String.format("%.2f", mitjana);
            System.out.println(codi.getCodi()+": \u001B[34m"+sortidaMitjana+"\u001B[0m");
        }
        
        System.out.println("\n--------------------\n");

    }

    //MÉTODO PARA CALCULAR Y MOSTRAR LA NOTA MEDIA DE UN MÓDULO PEDIDO POR TECLADO
    public void mitjanaModul() {

        Scanner entrada = new Scanner(System.in);
        byte op;

        System.out.println("\nLLISTAT DE MÒDULS DISPONIBLES");
        System.out.println("-----------------------------\n");
        for (int i = 0; i < moduls.length; i++) {
            System.out.println((i + 1) + ". " + moduls[i]);
        }

        System.out.print("\nSELECCIONA MÒDUL: ");

        try {
            op = entrada.nextByte();
        } catch (InputMismatchException e) {

            // SI USUARI NO INTRODUEIX VALOR TIPUS BYTE, ASSIGNAM A OP EL VALOR 0
            op = 0;
        }

        if (op >= 1 && op <= moduls.length) {

            float suma = 0;

            for (Alumno codi : alumnes) {
                suma = suma + codi.getNota(op - 1);
            }
            
            System.out.println("\nMITJANA MÒDUL \u001B[34m"+moduls[op-1]+"\u001B[0m = \u001B[34m"
                    +String.format("%.2f",(suma/alumnes.size()))+"\u001B[0m"+"\n\n");

        } else {
             System.out.println("\n"+"\u001B[31mAQUESTA OPCIÓ NO CORRESPON A CAP MODUL.\u001B[0m");
             System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m"+"\n");
        }

    }

    //MÉTODO PARA MOSTRAR PARA CADA ALUMNO TODAS SUS NOTAS USANDO
    //EL ARRAY DE DOS DIMENSIONES totesNotes[][]
    public void matriuNotes() {
        
        // DECLARAM DIMENSIONS ARRAY BIDIMENSIONAL
        totesNotes = new float[alumnes.size()][moduls.length];
        // CARREGAM VALORS EN ARRAY BIDIMENSIONAL
        for (int i = 0; i < alumnes.size(); i++) {
                for (int j = 0; j < moduls.length; j++) {
                    float nota = alumnes.get(i).getNota(j);
                    totesNotes[i][j]=nota;
                }
        }
        
        System.out.print("\n");
        System.out.println("+--------+---------+---------+---------+---------+");
        System.out.print("| AL\\MOD | ");
        for (int m1=0; m1<moduls.length;m1++){
            String modul=String.format("%7s", moduls[m1]);
            System.out.print("\u001B[35m"+modul+"\u001B[0m"+" | ");
            
        }
        System.out.print("\n");
        System.out.println("+--------+---------+---------+---------+---------+");
        
        
        for (int i = 0; i < totesNotes.length; i++) {
            String alumne=String.format("%6s", alumnes.get(i).getCodi());
            System.out.print("| "+"\u001B[32m"+alumne+"\u001B[0m"+" | ");
       
                for (int j = 0; j < totesNotes[i].length; j++) {
                    
                    float nota = totesNotes[i][j];
                    String sortidaNota = String.format("%.2f", nota);
                    sortidaNota = String.format("%7s", sortidaNota);
                    System.out.print("\u001B[34m" + sortidaNota + "\u001B[0m"+" | ");
                    
                }
                System.out.print("\n");
                System.out.println("+--------+---------+---------+---------+---------+");
               
        }
        
        
        }
        
        
            
        

    

    //MÉTODO PARA PEDIR POR TECLADO UN ALUMNO Y UN MÓDULO,
    //BUSCARLO EN LA LISTA Y MOSTRAR SU NOTA
    public void notaAlumneModul() {
        
        Scanner entradaAl = new Scanner(System.in);
        byte idAl;

        System.out.println("\nLLISTAT D'ALUMNES");
        System.out.println("-----------------------------\n");
        for (int i = 0; i < alumnes.size(); i++) {
            System.out.println((i + 1) + ". " + alumnes.get(i).getCodi());
        }

        System.out.print("\nSELECCIONA ALUMNE: ");

        try {
            idAl = entradaAl.nextByte();
        } catch (InputMismatchException e) {

            // SI USUARI NO INTRODUEIX VALOR TIPUS BYTE, ASSIGNAM A OP EL VALOR 0
            idAl = 0;
        }

        if (idAl >= 1 && idAl <= alumnes.size()) {

            Scanner entradaMo = new Scanner(System.in);
            byte idMo;

            System.out.println("\nLLISTAT DE MÒDULS DISPONIBLES");
            System.out.println("-----------------------------\n");
            for (int i = 0; i < moduls.length; i++) {
                System.out.println((i + 1) + ". " + moduls[i]);
            }

            System.out.print("\nSELECCIONA MÒDUL: ");

            try {
                idMo = entradaAl.nextByte();
            } catch (InputMismatchException e) {

            // SI USUARI NO INTRODUEIX VALOR TIPUS BYTE, ASSIGNAM A OP EL VALOR 0
            idMo = 0;
            }
            
            if (idMo >= 1 && idMo <= moduls.length) {

                System.out.print("\nALUMNE: ");
                System.out.println("\u001B[34m"+alumnes.get(idAl-1).getCodi()+"\u001B[0m");
                System.out.print("MODUL: ");
                System.out.println("\u001B[34m"+moduls[idMo-1]+"\u001B[0m");
                System.out.print("NOTA: ");
                float nota = alumnes.get(idAl-1).getNota(idMo-1);
                String sortidaNota = String.format("%.2f", nota);
                System.out.println("\u001B[34m"+sortidaNota+"\u001B[0m"+"\n");
                

            } else {
                
                System.out.println("\n"+"\u001B[31mAQUESTA OPCIÓ NO CORRESPON A CAP MODUL.\u001B[0m");
                System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m"+"\n");
                
            }
             
             
         } else {
            System.out.println("\n"+"\u001B[31mAQUESTA OPCIÓ NO CORRESPON A CAP ALUMNE.\u001B[0m");
            System.out.println("\u001B[34mTORNANT CARREGAR MENU INCIAL.\u001B[0m"+"\n");
        }        
    }
    
    //MENÚ DE OPCIONES
    private static byte menuOpcions ()  {
        
        Scanner entrada = new Scanner(System.in);
        byte op;
        
        System.out.println("PROG08 NOTES");
        System.out.println("------------\n");
        
        System.out.println("\n1. INSERIR ALUMNE i NOTES A LA LLISTA");
        System.out.println("2. MOSTRAR MITJANA DE NOTES DELS ALUMNES DE LA LLISTA");
        System.out.println("3. MOSTRAR MITJANA D'UN DETERMINAT MODUL");
        System.out.println("4. INFORME GLOBAL. MATRIU NOTES ALUMNES-MÒDULS");
        System.out.println("5. NOTA ALUMNE-MÒDUL");
        System.out.println("0. SORTIR DEL PROGRAMA");
        
        System.out.print ("\nINTRODUEIX L'OPCIÓ: ");
        
        try{
            op = entrada.nextByte();
        }
        catch (InputMismatchException e){
            
            // SI USUARI NO INTRODUEIX VALOR TIPUS BYTE, ASSIGNAM A OP EL VALOR -1
            // EL QUAL MAI EXISTIRÀ EN LA LLISTA D'OPCIONS. EL CASE APLICA DEFAULT
            // QUE ENS TORNA ENVIAR A AQUEST METODE
            
            op = -1;
        }
                
        return op;
        

    } 
    
}
