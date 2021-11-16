package biens;

import encheres.interfaces.IFraisGestion;

import java.util.Calendar;

/**
 * Modélise un vehicule.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class Vehicule extends ABien {

    /**
     * La marque du vehicule
     */
    private String marque;

    /**
     * l'annee de fabrication du vehicule
     */
    private int anneeFabrication;

    /**
     * Constructeur du vehicule
     * @param description la description du vehicule
     * @param montantD le montant depart du vehicule
     * @param dateD la date de debut du vehicule
     * @param dateF la date de fin du vehicule
     * @param fraisGestion les frais gestion du vehicule
     * @param marque la marque du vehicule
     * @param anneeFabrication l'annee de fabrication du vehicule
     */
    public Vehicule(String description, double montantD, Calendar dateD, Calendar dateF, IFraisGestion fraisGestion,
                    String marque, int anneeFabrication) {
        super(description, montantD, dateD, dateF, fraisGestion);
        this.marque = marque;
        this.anneeFabrication = anneeFabrication;
    }

    @Override
    public boolean isMontantEnchereValid(double montantEnchere) {
        if (this.getSurencheresEnregistrees().isEmpty())
            return montantEnchere >= getMontantD();
        else
            return montantEnchere > getMontant();
    }

}
