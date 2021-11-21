package interface_enchere;

import encheres.interfaces.IBien;

import java.util.Date;

public class BienController {
    private String description;
    private double montantD;
    private double montant;
    private Date dateD;
    private Date dateF;
    private IBien bien;

    public BienController(IBien bien) {
        this.description = bien.getDescription();
        this.montantD = bien.getMontantD();
        this.montant = bien.getMontant();
        this.dateD = bien.getDateD();
        this.dateF = bien.getDateF();
        this.bien = bien;
    }

    public String getDescription() {
        return description;
    }

    public double getMontantD() {
        return montantD;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDateD() {
        return dateD;
    }

    public Date getDateF() {
        return dateF;
    }

    public IBien getBien() {
        return bien;
    }
}
