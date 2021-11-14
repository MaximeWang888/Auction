package biens;

import encheres.Enchere;
import encheres.EncherirNotPossibleException;
import encheres.interfaces.IBien;
import encheres.interfaces.IFraisGestion;
import encheres.interfaces.IUtilisateur;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public abstract class ABien implements IBien {
    private final String description;
    private final double montantD;
    private double montant;
    private final Calendar dateD;
    private final Calendar dateF;
    private IFraisGestion fraisGestion;
    private final HashMap<IUtilisateur, Double> surencheresEnregistrees;


    public ABien(String description, double montantD, Calendar dateD, Calendar dateF, IFraisGestion fraisGestion) {
        this.description = description;
        this.montantD = montantD;
        this.montant = montantD;
        this.dateD = dateD;
        this.dateF = dateF;
        this.fraisGestion = fraisGestion;
        this.surencheresEnregistrees = new HashMap<>();
    }


    // Getters

    @Override
    public double getMontant() {
        return montant;
    }

    @Override
    public IBien getBien() {
        return this;
    }

    public double getMontantD() {
        return montantD;
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

    public HashMap<IUtilisateur, Double> getSurencheresEnregistrees() {
        return surencheresEnregistrees;
    }

    public void setFraisGestion(IFraisGestion fraisGestion) {
        this.fraisGestion = fraisGestion;
    }

    public void setSurencheresEnregistrees(IUtilisateur utilisateur, double montant) {
        this.surencheresEnregistrees.put(utilisateur, montant);
    }

    // Methods

    public void encherir(double montant, IUtilisateur encherisseur) throws EncherirNotPossibleException {
        new Enchere(this, montant, encherisseur);
    }

    public double consulterFraisGestion() {
        return fraisGestion.fraisGestionActuel(this);
    }
}
