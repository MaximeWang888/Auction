package bien;

import java.util.Calendar;

public class Vehicule extends ABien {

    private String marque;

    private int anneeFabrication;

    public Vehicule(String description, double montantD, Calendar dateD, Calendar dateF, String marque, int anneeFabrication) {
        super(description, montantD, dateD, dateF);
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
    }

    @Override
    public boolean isMontantOK(double montant) {
        if (this.getDernierEncherisseur() == null)
            return montant >= this.getMontant();
        else
            return montant > this.getMontant();
    }

}
