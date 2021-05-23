package exercici3parta;

public class Assignatura {

    private String nom;
    private int horesSetmanals;

    public Assignatura() {
    }

    public Assignatura(String nom, int horesSetmanals) throws Exception {
        if (nom == null || nom.length() <= 0) {
            throw new Exception("NOM INCORRECTE!!");
        }
        if (horesSetmanals < 0) {
            throw new Exception("NUMERO HORES SETMANALS INCORRECTE!!");
        }

        this.nom = nom;
        this.horesSetmanals = horesSetmanals;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if (nom == null || nom.length() <= 0) {
            throw new Exception("NOM INCORRECTE!!");
        }
        this.nom = nom;
    }

    public int getHoresSetmanals() {
        return horesSetmanals;
    }

    public void setHoresSetmanals(int horesSetmanals) throws Exception {
        if (horesSetmanals < 0) {
            throw new Exception("NUMERO HORES SETMANALS INCORRECTE!!");
        }
        this.horesSetmanals = horesSetmanals;
    }

    //SOBREESCRIURE METODE TO STRING
    @Override
    public String toString() {
        return "ASSIGNATURA{" + "NOM = " + nom + ", HORES SETMANALS = " + horesSetmanals + "}";
    }

    public int cacularHoresAnuals() {
        return horesSetmanals * 32;
    }
}
