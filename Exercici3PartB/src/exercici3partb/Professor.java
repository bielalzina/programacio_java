package exercici3partb;

public class Professor extends Persona {

    private String especialitat;
    private double salari;

    public Professor(String nif, String nom, String especialitat, double salari) {
        super(nif, nom);
        this.especialitat = especialitat;
        this.salari = salari;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }

    public double getSalari() {
        return salari;
    }

    public void setSalari(double salari) {
        this.salari = salari;
    }

    @Override
    public String mostraHorari() {
        return "L’horari es pot consultar al GESTIB";
    }

    @Override
    public String toString() {
        return "Professor{" + "NOM=" + nom + ", NIF=" + nif + ", especialitat=" + especialitat + ", salari=" + salari + '}';
    }

}
