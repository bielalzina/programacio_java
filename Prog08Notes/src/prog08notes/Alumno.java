/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog08notes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author GABRIEL ALZINA ALOMAR
 */
public class Alumno {

    private String codi;
    private float[] notes;

    //CONSTRUCTOR POR DEFECTO QUE CREA EL ARRAY DE DIMENSIÓN 4
    public Alumno() {
        this.notes = new float[4];
    }

    //MÉTODO ESTÁTICO DE CLASE USADO PARA VALIDAR UN CÓDIGO, SE LLAMA 
    //DIRECTAMENTE DESDE CLASE
    public static boolean validaCodi(String codiAlumne) {

        // EXPRESSIÓ REGULAR CODI ALUMNE
        String codiRegex = "^[A-Z]{3}[0-9]{2}$";
        Pattern patro = Pattern.compile(codiRegex);
        Matcher validacio = patro.matcher(codiAlumne);
        return validacio.matches();

    }

    //MÉTODO SETTER DEL CÓDIGO
    //ANTES DE ESTABLECER UN CÓDIGO SIEMPRE VALIDAREMOS EL PATRÓN 
    //LLAMANDO AL MÉTODO DE CLASE validaCodi()
    public void setCodi(String codiAlumne) throws Exception {

        if (validaCodi(codiAlumne)) {
            this.codi = codiAlumne;
        } else {
            throw new Exception("\n" + "\u001B[31mCODI D'ALUMNE NO PERMÈS!!!\u001B[0m" + "\n");
        }

    }

    //SETTER DE UNA NOTA DEL ARRAY DE NOTES, RECIBE EL ÍNDICE DEL ARRAY Y LA NOTA
    //LA NOTA DEBE SER VALIDADA, UN VALOR ENTRE 0 Y 10
    public void setNota(int i, float nota) throws Exception {

        if (nota >= 0 && nota <= 10) {
            this.notes[i] = nota;
        } else {
            throw new Exception();
        }
    }

    //SETTER DEL ARRAY DE NOTES, RECIBE EL ARRAY COMPLETO
    //CADA UNA DE LAS NOTAS DEBE SER VALIDADA, UN VALOR ENTRE 0 Y 10
    //Atención: el array es un puntero!!!
    public void setNotes(float[] notesAlumne) throws Exception {

    }

    //GETTER DEL CÓDIGO
    public String getCodi() {

        return codi;

    }

    //GETTER DE UNA NOTA DEL ARRAY, RECIBE EL ÍNDICE POR PARÁMETRO
    public float getNota(int i) {

        return notes[i];

    }

    //GETTER DEL ARRAY DE NOTAS
    //Atención: el array es un puntero!!!
    /*public float[] getNotes () {
       
    }*/
    //MÉTODO QUE DEVUELVE EL CÁLCULO DE LA MEDIA DE LAS NOTAS DEL ARRAY DE NOTAS
    public float mitjanaNotes() {

        Float suma = 0f;

        for (int i = 0; i < notes.length; i++) {
            suma = suma + getNota(i);
        }

        return (suma / notes.length);

    }

}
