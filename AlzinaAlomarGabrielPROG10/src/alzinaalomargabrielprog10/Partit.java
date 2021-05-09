/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alzinaalomargabrielprog10;

/**
 *
 * @author gabriel
 */
public class Partit {
    
    String equipLocal;
    String equipVisitant;
    int golsLocal;
    int golsVisitant;

    public Partit(String equipLocal, String equipVisitant, int golsLocal, int golsVisitant) {
        this.equipLocal = equipLocal;
        this.equipVisitant = equipVisitant;
        this.golsLocal = golsLocal;
        this.golsVisitant = golsVisitant;
    }

    public String getEquipLocal() {
        return equipLocal;
    }

    public void setEquipLocal(String equipLocal) {
        this.equipLocal = equipLocal;
    }

    public String getEquipVisitant() {
        return equipVisitant;
    }

    public void setEquipVisitant(String equipVisitant) {
        this.equipVisitant = equipVisitant;
    }

    public int getGolsLocal() {
        return golsLocal;
    }

    public void setGolsLocal(int golsLocal) {
        this.golsLocal = golsLocal;
    }

    public int getGolsVisitant() {
        return golsVisitant;
    }

    public void setGolsVisitant(int golsVisitant) {
        this.golsVisitant = golsVisitant;
    }
    
    
    
    
}
