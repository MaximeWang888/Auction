package biens;

import encheres.interfaces.IBien;
import encheres.interfaces.IFraisGestion;
import encheres.interfaces.IUtilisateur;
import encheres.Enchere;
import encheres.EncherirNotPossibleException;

import java.util.Calendar;
import java.util.Date;

public abstract class ABien implements IBien {
    private String description;
    private double montantD;
    private double montant;
    private IUtilisateur dernierEncherisseur;
    private Calendar dateD;
    private Calendar dateF;
    private IFraisGestion fraisGestion;

    public ABien(String description, double montantD, Calendar dateD, Calendar dateF, IFraisGestion fraisGestion) {
        this.description = description;
        this.montantD = montantD;
        this.montant = montantD;
        this.dernierEncherisseur = null;
        this.dateD = dateD;
        this.dateF = dateF;
        this.fraisGestion = fraisGestion;
    }

    // Getters

    @Override
    public IBien getBien() {
        return this;
    }

    public double getMontantD() {
        return montantD;
    }

    public double getMontant() {
        return montant;
    }

    public IUtilisateur getDernierEncherisseur() {
        return dernierEncherisseur;
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

    public void setDernierEncherisseur(IUtilisateur dernierEncherisseur) {
        this.dernierEncherisseur = dernierEncherisseur;
    }

    public void setFraisGestion(IFraisGestion fraisGestion) {
        this.fraisGestion = fraisGestion;
    }

    // Methods

    public void encherir(double montant, IUtilisateur encherisseur) throws EncherirNotPossibleException {
        new Enchere(this, montant, encherisseur);
    }

    public double consulterFraisGestion() {
        return fraisGestion.fraisGestionActuel(this);
    }
}
