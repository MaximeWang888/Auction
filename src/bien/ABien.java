package bien;

import enchere.IBien;

import java.util.Date;

public abstract class ABien implements IBien {
    private String description;
    private double montant;
    private Date dateD;
    private Date dateF;

    public ABien(String description, double montant, Date dateD, Date dateF) {
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
        return dateD;
    }

    public Date getDateF() {
        return dateF;
    }

    // Setters

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public boolean surencherir(IBien bien, double montant, Date dateActuelle) {
        boolean isPeriodeEnchere = dateActuelle.after(getDateD()) && dateActuelle.before(getDateF());
        boolean isMontantConforme = isMontantSup(montant);

        return isPeriodeEnchere && isMontantConforme;
    }

    protected abstract boolean isMontantSup(double montant);

}
