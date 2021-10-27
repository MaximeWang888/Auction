package bien;

import enchere.IBien;

import java.util.Date;

public class Vehicule extends ABien {
    private String marque;
    private int anneeFabrication;

    public Vehicule(String description, double montantD, Date dateD, Date dateF, String marque, int anneeFabrication) {
        super(description, montantD, dateD, dateF);
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
    }

    @Override
    public boolean surencherir(String nom, double montant, Date dateActuelle) {
        return dateActuelle.after(getDateD()) && dateActuelle.before(getDateF()) && montant > this.getMontant();
    }
}
