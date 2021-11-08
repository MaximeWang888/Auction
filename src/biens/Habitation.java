package biens;

import java.util.Calendar;

public class Habitation extends ABien {
    private String ville;
    private int nbPiece;

    public Habitation(String description, double montantD, Calendar dateD, Calendar dateF, String ville, int nbPiece) {
        super(description, montantD, dateD, dateF);
        this.ville = ville;
        this.nbPiece = nbPiece;
    }

    @Override
    public boolean isMontantEnchereValid(double montantEnchere) {
        if (getDernierEncherisseur() == null)
            return montantEnchere >= getMontantD();
        else
            return montantEnchere >= getMontant() * 1.1;
    }
}
