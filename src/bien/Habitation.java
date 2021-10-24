package bien;

import enchere.IBien;

public class Habitation extends ABien {

    private String ville; // ville où est localisee l'habitation

    private int taille; // nombre de pieces

    public Habitation(IBien nature, String description, double montantD,
                      int dateD, int dateF, String ville, int taille) {
        super(nature, description, montantD, dateD, dateF);
        this.ville = ville;
        this.taille = taille;
    }

    @Override
    public IBien consulterBien() {
        return this;
    }

    @Override
    public void surencherir(String nom, double montant, int dateActuelle) {
        if (montant * 1.1 > getMontantD())
            System.out.println("enchère valide -habitation");
    }
}
