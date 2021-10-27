package bien;

import enchere.IBien;

import java.util.Date;

public abstract class ABien implements IBien {
    private String description;
    private double montantD;
    private double montant;
    private Date dateD;
    private Date dateF;

    public ABien(String description, double montantD, Date dateD, Date dateF) {
        this.description = description;
        this.montantD = montantD;
        this.montant = montantD;
        this.dateD = dateD;
        this.dateF = dateF;
    }

    @Override
    public IBien consulterBien() {
        return this;
    }

    // Getters

    public String getDescription() {
        return description;
    }

    public double getMontant() {
        return montant;
    }

    public double getMontantD() {
        return montantD;
    }

    public Date getDateD() {
        return dateD;
    }

    public Date getDateF() {
        return dateF;
    }

    // Setters

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
