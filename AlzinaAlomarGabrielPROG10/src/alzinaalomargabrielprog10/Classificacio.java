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
public class Classificacio {

    private String equip;
    private int guanyats;
    private int empatats;
    private int perduts;

    public Classificacio(String equip, int guanyats, int empatats, int perduts) {
        this.equip = equip;
        this.guanyats = guanyats;
        this.empatats = empatats;
        this.perduts = perduts;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public int getGuanyats() {
        return guanyats;
    }

    public void setGuanyats(int guanyats) {
        this.guanyats = guanyats;
    }

    public int getEmpatats() {
        return empatats;
    }

    public void setEmpatats(int empatats) {
        this.empatats = empatats;
    }

    public int getPerduts() {
        return perduts;
    }

    public void setPerduts(int perduts) {
        this.perduts = perduts;
    }

}
