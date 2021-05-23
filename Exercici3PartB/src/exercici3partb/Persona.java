
package exercici3partb;

public abstract class Persona {
    protected String nif;
    protected String nom;

    public Persona(String nif, String nom) {
        this.nif = nif;
        this.nom = nom;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public abstract String mostraHorari();
    
}
