package exercici3parta;

public class Assignatura2 {

    private String nom;
    private int horesSetmanals;
    private Curs curs;

    public Assignatura2() {
    }

    public Assignatura2(String nom, int horesSetmanals, Curs curs) throws Exception {
        if (nom == null || nom.length() <= 0) {
            throw new Exception("NOM INCORRECTE!!");
        }
        if (horesSetmanals < 0) {
            throw new Exception("NUMERO HORES SETMANALS INCORRECTE!!");
        }

        this.nom = nom;
        this.horesSetmanals = horesSetmanals;
        this.curs = new Curs(curs.getNom(), curs.getNumAlumnes());
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

    public Curs getCurs() {
        return new Curs(curs.getNom(), curs.getNumAlumnes());
    }

    public void setCurs(Curs curs) {
        this.curs = new Curs(curs.getNom(), curs.getNumAlumnes());
    }

    //SOBREESCRIURE METODE TO STRING
    @Override
    public String toString() {
        return "ASSIGNATURA{" + "NOM = " + nom + ", HORES SETMANALS = " + horesSetmanals + ", CURS = " + curs + "}";
    }

    public int cacularHoresAnuals() {
        return horesSetmanals * 32;
    }
}
