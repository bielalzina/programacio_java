package exercici3partb;

public class Alumne extends Persona {

    private String curs;
    private double notaMitjana;

    public Alumne(String nif, String nom, String curs, double notaMitjana) {
        super(nif, nom);
        this.curs = curs;
        this.notaMitjana = notaMitjana;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public double getNotaMitjana() {
        return notaMitjana;
    }

    public void setNotaMitjana(double notaMitjana) {
        this.notaMitjana = notaMitjana;
    }

    @Override
    public String mostraHorari() {
        return "L’horari es troba publicat a la web del centre";
    }

    @Override
    public String toString() {
        return "Alumne{" + "NOM=" + nom + ", NIF=" + nif + ", curs=" + curs + ", notaMitjana=" + notaMitjana + '}';
    }

}
