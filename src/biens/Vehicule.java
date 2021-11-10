package biens;

import encheres.interfaces.IFraisGestion;

import java.util.Calendar;

public class Vehicule extends ABien {
    private String marque;
    private int anneeFabrication;

    public Vehicule(String description, double montantD, Calendar dateD, Calendar dateF, IFraisGestion fraisGestion,
                    String marque, int anneeFabrication) {
        super(description, montantD, dateD, dateF, fraisGestion);
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
    }

    @Override
    public boolean isMontantEnchereValid(double montantEnchere) {
        if (getDernierEncherisseur() == null)
            return montantEnchere >= getMontantD();
        else
            return montantEnchere > getMontant();
    }

}
