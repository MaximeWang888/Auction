package biens;

import encheres.interfaces.IFraisGestion;

import java.util.Calendar;

/**
 * Modélise une habitation.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class Habitation extends ABien {

    /**
     * La ville de l'habitation
     */
    private String ville;

    /**
     * Le nombre de piece de l'habitation
     */
    private int nbPiece;

    /**
     * Constructeur d'une habitation
     * @param description la description de l'habitation
     * @param montantD le montant depart de l'habitation
     * @param dateD la date de debut de l'habitation
     * @param dateF la date de fin de l'habitation
     * @param fraisGestion les frais de gestion de l'habitation
     * @param ville la ville de l'habitation
     * @param nbPiece le nombre de piece de l'habitation
     */
    public Habitation(String description, double montantD, Calendar dateD, Calendar dateF, IFraisGestion fraisGestion,
                      String ville, int nbPiece) {
        super(description, montantD, dateD, dateF, fraisGestion);
        this.ville = ville;
        this.nbPiece = nbPiece;
    }

    @Override
    public boolean isMontantEnchereValid(double montantEnchere) {
        if (this.getSurencheresEnregistrees().isEmpty())
            return montantEnchere >= getMontantD();
        else
            return montantEnchere >= getMontant() * 1.1;
    }

}
