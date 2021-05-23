package prog06;

import java.io.Serializable;


public class Cliente implements Serializable{
    
    private String NIF;
    private String nom;
    private String telefon;
    private String mail;
    private String dataNeixement;

    public Cliente() {
    }

    public Cliente(String NIF, String nom, String telefon, String mail, String dataNeixement) {
        this.NIF = NIF;
        this.nom = nom;
        this.telefon = telefon;
        this.mail = mail;
        this.dataNeixement = dataNeixement;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDataNeixement() {
        return dataNeixement;
    }

    public void setDataNeixement(String dataNeixement) {
        this.dataNeixement = dataNeixement;
    }
    
    
    
    
}
