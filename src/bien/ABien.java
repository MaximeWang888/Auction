package bien;

import enchere.IBien;
import utilisateurs.Client;
import utilisateurs.IUtilisateur;

import java.util.Calendar;
import java.util.Date;

public abstract class ABien implements IBien {
    private String description;
    private double montantD;
    private double montant;
    private IUtilisateur dernierEncherisseur;
    private Calendar dateD;
    private Calendar dateF;

    public ABien(String description, double montantD, Calendar dateD, Calendar dateF) {
        this.description = description;
        this.montantD = montantD;
        this.montant = montantD;
        this.dernierEncherisseur = null;
        this.dateD = dateD;
        this.dateF = dateF;
    }

    // Getters

    @Override
    public IBien consulterBien() {
        return this;
    }

    public double getMontant() {
        return montant;
    }

    public IUtilisateur getDernierEncherisseur() {
        return dernierEncherisseur;
    }

    // Methods

    @Override
    public void surencherir(IUtilisateur encherisseur, double montant) throws EnchereNotPossibleException {
        try {
            isSurencherirPossible(montant);
            this.montant = montant;
            this.dernierEncherisseur = encherisseur;
        } catch (Exception e) {
            throw new EnchereNotPossibleException("L'enchère n'est pas possible.");
        }
    }

    public boolean isSurencherirPossible(double montant) {
        return isPeriodeOK() && isMontantOK(montant);
    }

    public boolean isPeriodeOK() {
        return this.dateD.before(Calendar.getInstance().getTime()) && this.dateF.after(Calendar.getInstance().getTime());
    }

}
