package bien;

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
    protected boolean isMontantSup(double montant) {
        return montant > this.getMontant();
    }

}
