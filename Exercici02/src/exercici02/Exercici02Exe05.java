/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici02;

/**
 *
 * @author gabriel
 */
public class Exercici02Exe05 {
    
    public static int comptaA(String paraula){
        int i;
        int contadorA=0;
        paraula=paraula.toUpperCase();
        for (i=0; i<paraula.length();i++){
            if (paraula.charAt(i)=='A' || paraula.charAt(i)=='À'){
                contadorA++;
            }
        }
        return contadorA;
    }
    
    
    public static void main(String[] args){
        String[] paraules = {"paraula", "abecedari", "Anastàsia", "Cicle", "Formatiu", "Grau", "Àgora"};
        int i;
        System.out.println("Recompte Vocals A");
        for (i=0;i<paraules.length;i++){
            System.out.println("La paraula "+paraules[i]+" te "+comptaA(paraules[i])+" As");
        }

    }
    
}
