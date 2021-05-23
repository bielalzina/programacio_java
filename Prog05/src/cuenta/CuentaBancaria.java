/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;

/**
 *
 * @author gabriel
 */
public class CuentaBancaria {

    private String nom;
    private String cc;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String nom, String cc, double saldo) {
        this.nom = nom;
        this.cc = cc;
        this.saldo = saldo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if (nom.length() < 3 || nom.length() > 15) {
            throw new Exception("El nom introduit no compleix amb num. digits establert");
        }
        this.nom = nom.toUpperCase();
    }

    public String getCc() {
        return cc.substring(0, 4) + "-" + cc.substring(4, 8) + "-" + cc.substring(8, 10) + "-" + cc.substring(10);
    }

    public String getEntitat() {
        return cc.substring(0, 4);
    }

    public String getOficina() {
        return cc.substring(4, 8);
    }

    public String getNumCC() {
        return cc.substring(10);
    }

    public String getDC() {
        return cc.substring(8, 10);
    }

    public void setCc(String cc) throws Exception {

        if (!this.validaCC(cc)) {
            throw new Exception("COMPTE CORRENT INCORRECTE!!!");
        }

        this.cc = cc;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingressar(String quantitat) throws Exception {

        if (!this.stringToDouble(quantitat)) {
            throw new Exception("IMPORT INCORRECTE!!!");
        }

        this.setSaldo(this.getSaldo() + Double.parseDouble(quantitat));
    }

    public void retirar(String quantitat) throws Exception {

        if (!this.stringToDouble(quantitat)) {
            throw new Exception("IMPORT INCORRECTE!!!");
        }

        double cantidad;
        cantidad = Double.parseDouble(quantitat);

        if (!this.saldoSuficient(cantidad)) {
            throw new Exception("SALDO INSUFICIENT!!!");
        }

        this.setSaldo(this.getSaldo() - cantidad);
    }

    private boolean saldoSuficient(double importe) {

        if (this.getSaldo() >= importe) {
            return true;
        } else {
            return false;
        }

    }

    private boolean stringToDouble(String importe) {

        double cantidad;

        try {
            cantidad = Double.parseDouble(importe);
            if (cantidad <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            //System.out.println("IMPORT INCORRECTE!!!");
            return false;
        }

    }

    private boolean validaCC(String cc) {
        if (cc.length() != 20) {
            return false;
        }

        String entOf = cc.substring(0, 8);
        String dc1 = cc.substring(8, 9);
        String dc2 = cc.substring(9, 10);
        String numCC = cc.substring(10);

        // Afegim 00 al entOf
        entOf = "00" + entOf;

        int suma = 0;

        /* Multiplicam cadascuna de les xifres 00EEEEOOOO
        per 1,2,4,8,5,10,9,7,3,6 respectivament i es sumen els resultats*/
        int[] index1 = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};

        for (int i = 0; i < index1.length; i++) {
            suma = suma + Integer.parseInt(entOf.substring(i, i + 1)) * index1[i];
        }

        // Restam 11 al modul de 11 de la suma anterior 
        int digitControl1 = 11 - (suma % 11);

        if (digitControl1 == 10) {
            // Si val 10 el 1r digit de control = 1
            digitControl1 = 1;
        } else if (digitControl1 == 11) {
            // Si val 11 el 1r digit de control = 0
            digitControl1 = 0;
        }

        // Comprovam si coincideix el 1r DC
        int digitControlEntitatOficina = Integer.parseInt(dc1);

        if (digitControl1 != digitControlEntitatOficina) {
            return false;
        }

        suma = 0;

        /* Multiplicam cadascuna de les xifres del NUM COMPTE
        per 1,2,4,8,5,10,9,7,3,6 respectivament i es sumen els resultats */
        for (int i = 0; i < index1.length; i++) {
            suma = suma + Integer.parseInt(numCC.substring(i, i + 1)) * index1[i];
        }

        // Restam 11 al modul de 11 de la suma anterior 
        int digitControl2 = 11 - (suma % 11);

        if (digitControl2 == 10) {
            // Si val 10 el 2n digit de control = 1
            digitControl2 = 1;
        } else if (digitControl2 == 11) {
            // Si val 11 el 2n digit de control = 1
            digitControl2 = 0;
        }

        // Comprovam si coincideix el 2n DC
        int digitControlNumCompte = Integer.parseInt(dc2);

        if (digitControl2 != digitControlNumCompte) {
            return false;
        }

        return true;

    }

}
