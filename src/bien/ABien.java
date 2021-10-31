package bien;

import enchere.IBien;

import java.util.Calendar;
import java.util.Date;

public abstract class ABien implements IBien {
    private String description;
    private double montant;
    private Calendar dateD;
    private Calendar dateF;

    public ABien(String description, double montant, Calendar dateD, Calendar dateF) {
        this.description = description;
        this.montant = montant;
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

    public Date getDateD() {
        return dateD.getTime();
    }

    public Date getDateF() {
        return dateF.getTime();
    }

    // Setters

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public boolean surencherir(IBien bien, double montant, Calendar dateActuelle) {
        boolean isPeriodeEnchere = this.getDateD().before(dateActuelle.getTime()) &&
                this.getDateF().after(dateActuelle.getTime());
        boolean isMontantConforme = isMontantSup(montant);

        return isPeriodeEnchere && isMontantConforme;
    }

    protected abstract boolean isMontantSup(double montant);

}
