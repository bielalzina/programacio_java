
package exercici02;

import java.util.ArrayList;

public class LlistaArray {
    
    // ATRIBUT
    private ArrayList<Integer> aList;
    
    //CONSTRUCTOR
    public LlistaArray(){
        aList = new ArrayList<>();
    }
    
    public void afegirNumero(int numero){
        aList.add(numero);
    }
    
    public long mostrar(){
        System.out.println("ELEMENTS:");
        long producte=1;
        for(Integer i:aList){
            System.out.print(i+"\t");
            producte=producte*i;
        }
        return producte;
    }
    
    public void mostrarPosicionsMultiples5(){
        System.out.println("Els element multiples de 5 son;");
        for (int i=0; i<aList.size(); i++){
            if((i+1)%5==0){
                System.out.println(aList.get(i));
            }
        }
    }

    public static void main(String[] args){
        
        //CREAM OBJECTE
        LlistaArray meuAL = new LlistaArray();
        
        int i;
        int max=1;
        int min=100;
        int element=0;
        
        for (i=0; i<8;i++){
           element = min+(int)(Math.random()*((max-min)+1));
           meuAL.afegirNumero(element);
        }
        
        meuAL.mostrar();
        meuAL.afegirNumero(75);
        meuAL.afegirNumero(99);
        System.out.println("");
        System.out.println("");
        long producte= meuAL.mostrar();
        System.out.println("");
        System.out.println("PRODUCTE: "+producte);
        System.out.println("");
        System.out.println("");
        meuAL.mostrarPosicionsMultiples5();
        
    }

}
