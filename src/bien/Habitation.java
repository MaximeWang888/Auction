package bien;

import java.util.Date;

public class Habitation extends ABien {
    private String ville;
    private int nbPiece;

    public Habitation(String description, double montantD, Date dateD, Date dateF, String ville, int nbPiece) {
        super(description, montantD, dateD, dateF);
        this.ville = ville;
        this.nbPiece = nbPiece;
    }

    @Override
    public boolean surencherir(String nom, double montant, Date dateActuelle) {
        // If 1st offer
        if (getMontant() == getMontantD())
            return dateActuelle.after(getDateD()) && dateActuelle.before(getDateF()) && montant > this.getMontant();
        // Else
        else
            return dateActuelle.after(getDateD()) && dateActuelle.before(getDateF()) && montant >= this.getMontant()*1.1;
    }
}
