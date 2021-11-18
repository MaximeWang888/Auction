package biens;

import encheres.interfaces.IFraisGestion;

import java.util.Calendar;

public class Habitation extends ABien {
    private String ville;
    private int nbPiece;

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
