package bien;

import enchere.Encherir;
import enchere.EncherirNotPossibleException;
import enchere.IBien;

import java.util.Calendar;

public abstract class ABien implements IBien {
    private String description;
    private double montantD;
    private double montant;
    private Calendar dateD;
    private Calendar dateF;

    public ABien(String description, double montantD, Calendar dateD, Calendar dateF) {
        this.description = description;
        this.montantD = montantD;
        this.montant = montantD;
        this.dateD = dateD;
        this.dateF = dateF;
    }

    // Getters

    @Override
    public IBien consulterBien() {
        return this;
    }

    public double getMontantD() {
        return montantD;
    }

    public double getMontant() {
        return montant;
    }

    public Calendar getDateD() {
        return dateD;
    }

    public Calendar getDateF() {
        return dateF;
    }

    // Setters

    public void setMontant(double montant) {
        this.montant = montant;
    }

    // Methods

    public void encherir(double montant, Calendar dateActuelle) throws EncherirNotPossibleException {
        new Encherir(this, montant, dateActuelle);
    }
}
