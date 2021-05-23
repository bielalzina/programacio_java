package exercici3parta;

public class Curs {

    private String nom;
    private int numAlumnes;

    public Curs(String nom, int numAlumnes) {
        this.nom = nom;
        this.numAlumnes = numAlumnes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumAlumnes() {
        return numAlumnes;
    }

    public void setNumAlumnes(int numAlumnes) {
        this.numAlumnes = numAlumnes;
    }

    //SOBREESCRIURE METODE TO STRING
    @Override
    public String toString() {
        return "CURS{" + "NOM=" + nom + ", NUMEROS ALUMNES=" + numAlumnes + "}";
    }

}
