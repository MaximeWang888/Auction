package bien;

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
    protected boolean isMontantSup(double montant) {
        return montant > this.getMontant() * 1.1;
    }

}
